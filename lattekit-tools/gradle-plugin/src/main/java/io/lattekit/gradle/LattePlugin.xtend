package io.lattekit.gradle

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.BaseVariant
import groovy.lang.Closure
import io.lattekit.transformer.Transformer
import java.io.File
import java.nio.file.Path
import java.util.List
import java.util.Map
import java.util.Set
import javax.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.gradle.api.DefaultTask
import org.gradle.api.DomainObjectSet
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.file.FileResolver
import org.gradle.api.tasks.TaskAction
import com.android.build.gradle.internal.api.DefaultAndroidSourceSet
import org.gradle.api.plugins.JavaPluginConvention
import org.apache.commons.io.FileUtils
import java.util.regex.Pattern
import java.io.PrintWriter

class LattePlugin implements Plugin<Project> {

    FileResolver fileResolver
    Project project
    BaseExtension android
    DomainObjectSet<? extends BaseVariant> variants
    var Map<String,File> generatedSourceDir = newHashMap()

    @Inject
    new(FileResolver fileResolver) {
        this.fileResolver = fileResolver
    }


    override apply(Project project) {
        this.project = project
        
        project.afterEvaluate [
            try {
                android = project.extensions.getByName("android") as BaseExtension
                variants = switch android {
                    AppExtension: android.applicationVariants as DomainObjectSet<? extends BaseVariant>
                    LibraryExtension: android.libraryVariants
                    default: throw new GradleException('''Unknown packaging type «android.class.simpleName»''')
                }
                io.lattekit.Reflection.loadAndroidSdk(android.getSdkDirectory.absolutePath,android.compileSdkVersion)
                variants.all [ variant |
                    var srcTaskName = "generate"+variant.name.toFirstUpper+"LatteSources"
                    var resTaskName = "generate"+variant.name.toFirstUpper+"LatteResources"
                    val javaDirs = variant.sourceSets.map[javaDirectories].flatten.filter[directory]
                    val sourceDirs = newArrayList
                    sourceDirs += javaDirs
                    sourceDirs += #[
                        variant.aidlCompile.sourceOutputDir,
                        variant.generateBuildConfig.sourceOutputDir,
                        variant.renderscriptCompile.sourceOutputDir
                    ]
                    sourceDirs += variant.outputs.map[processResources.sourceOutputDir]

                    val srcDestination =  new File('''«project.buildDir»/generated/source/latte/«variant.getDirName»''')
                    val resDestination =  new File('''«project.buildDir»/generated/res/latte/«variant.getDirName»''')
                    var srcTask = project.tasks.create(srcTaskName,LatteTransform) [
                        it.taskType = LatteTransform.TaskType.SRC_GENERATOR
                        it.from = sourceDirs.toSet()
                        it.outputSourceDir = srcDestination
                        it.outputResDir = resDestination
                        it.project = project;
                        it.applicationId = variant.applicationId
                    ]
                    var resTask = project.tasks.create(resTaskName,LatteTransform) [
                        it.taskType = LatteTransform.TaskType.RES_GENERATOR
                        it.from = sourceDirs.toSet()
                        it.outputSourceDir = srcDestination
                        it.outputResDir = resDestination
                        it.project = project;
                        it.applicationId = variant.applicationId
                    ]

                    variant.registerJavaGeneratingTask(srcTask, srcDestination)
                    variant.registerResGeneratingTask(resTask, resDestination)
                ]

            } catch (Exception ex) {
                // Java mode
                val java = project.convention.findPlugin(JavaPluginConvention)

                // TODO: Create as gradle task
                java.sourceSets.all [ sourceSet |
                    if (!sourceSet.allJava.empty) {

                        var target = new File(project.buildDir.absolutePath+File.separator+"latte/"+sourceSet.name+"/")
                        val Set<File> javaDirs = newHashSet(target);
                        sourceSet.java.srcDirs.forEach[ javaDirs += it ]
                        sourceSet.java.srcDirs = javaDirs

                        var task = new LatteTransform()
                        task.from = sourceSet.java.srcDirs
                        println("New source dirs =" +javaDirs);
//                        task.into = target
                        task.project = project;
                        task.execute

                    }
                ]

            }
        ]
    }

}

@Accessors
public class LatteTransform extends DefaultTask {

    val PACKAGE_PATTERN = Pattern.compile('''package="([^"]+)"''')
    public enum TaskType {
        RES_GENERATOR, SRC_GENERATOR
    }
    var Set<File> from;
    var File outputSourceDir;
    var File outputResDir;
    var File manifestFile;
    var String applicationId;
    var TaskType taskType;


    def copy(Set<File> from, Set<File> to) {
        from.forEach [ file, i |
            project.copy [
                from(file)
                into(to.get(i))
            ]
        ]
    }

    def getIdsXml(Iterable<String> ids) '''
    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        «FOR res: ids»
        <item name="«res»" type="id" />
        «ENDFOR»
    </resources>
    '''


    @TaskAction
    def executeTask() {
        val androidPackage = applicationId;
        println("Generating source dir" +from+" to "+outputSourceDir);
        val List<String> allIds = newArrayList()
        from.forEach [ src, i |
            if (project.file(src).exists) {
                if (taskType == TaskType.RES_GENERATOR) {
                    allIds += new Transformer().transform(androidPackage,project.file(src).absolutePath, null,
                    ".java",".kt", ".xtend","css")
                } else {
                    new Transformer().transform(androidPackage,project.file(src).absolutePath, project.file(outputSourceDir).absolutePath,
                    ".java",".kt", ".xtend","css")

                }
            }
        ]

        var resOut = project.file(outputResDir).absolutePath;
        if (taskType == TaskType.RES_GENERATOR) {
            var valuesOut = new File(resOut+"/values");
            valuesOut.mkdirs();
            var writer = new PrintWriter(new File(resOut+"/values/latte_ids.xml"), "UTF-8");
            writer.print(getIdsXml(allIds));
            writer.close();
        }


    }

}
