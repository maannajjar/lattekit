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
                android.sourceSets.forEach [ sourceSet |
                    val manifestFile = sourceSet.manifest.srcFile;
                    if(manifestFile.exists && !sourceSet.java.srcDirs.filter[it.absoluteFile.exists].empty) {
                        var files = sourceSet.java.srcDirs.map[it.absoluteFile]
                        val latteTargetRoot = new File(project.buildDir.absolutePath+File.separator+"latte/"+sourceSet.name)
                        val javaTarget = new File(project.buildDir.absolutePath+File.separator+"latte/"+sourceSet.name+"/java/")
                        val resTarget = new File(project.buildDir.absolutePath+File.separator+"latte/"+sourceSet.name+"/res")
                        javaTarget.mkdirs()
                        resTarget.mkdirs()

                        val Set<File> originalJavaSet = newHashSet();
                        val updatedJavaFolderSet = newHashSet(javaTarget)
                        val updatedResFolderSet = newHashSet(resTarget)

                        sourceSet.java.srcDirs.forEach[ originalJavaSet += it; updatedJavaFolderSet += it ]
                        sourceSet.res.srcDirs.forEach[ updatedResFolderSet += it ]
                        sourceSet.java.srcDirs = updatedJavaFolderSet;
                        sourceSet.res.srcDirs = updatedResFolderSet;

                        println("All java sources are "+sourceSet.java.srcDirs)
                        println("All res sources are "+sourceSet.res.srcDirs)
                        var taskName = "latteGenerateSourcesJava"+sourceSet.name.substring(0,1).toUpperCase()+sourceSet.name.substring(1)
                        var actualTask = project.tasks.create(taskName,LatteTransform) [
                            it.from = originalJavaSet
                            it.into = latteTargetRoot
                            it.project = project;
                            it.manifestFile = manifestFile
                        ]
                        project.tasks.findByName("preBuild").dependsOn(actualTask)
                        project.tasks.findByName("clean").finalizedBy(actualTask)

                    }
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
                        task.into = target
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

    var Set<File> from;
    var File into;
    var File manifestFile;

    def copy(Set<File> from, Set<File> to) {
        from.forEach [ file, i |
            project.copy [
                from(file)
                into(to.get(i))
            ]
        ]
    }

    @TaskAction
    def executeTask() {
        var manifestText = FileUtils.readLines(manifestFile).join("\n")
        var matcher = PACKAGE_PATTERN.matcher(manifestText);
        var String packageName = null;
        if (matcher.find) {
            packageName = matcher.group(1)
        }
        val androidPackage = packageName;
        println("Generating source dir" +from);
        from.forEach [ src, i |
            var to = into
            if (project.file(src).exists) {
                new Transformer().transform(androidPackage,project.file(src).absolutePath, project.file(to).absolutePath,
                    ".java",".kt", ".xtend","css")
            }
        ]

    }

}
