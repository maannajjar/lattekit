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

class LattePlugin implements Plugin<Project> {

	FileResolver fileResolver
	Project project
	BaseExtension android
	DomainObjectSet<? extends BaseVariant> variants
	var Map<String,File> originalSourceDir = newHashMap()
	
	@Inject
	new(FileResolver fileResolver) {
		this.fileResolver = fileResolver
	}


	override apply(Project project) {
		this.project = project
			
		project.gradle.buildFinished(new Closure(this) {
			def doCall() {
				android.sourceSets.forEach [ sourceSet |
					if (originalSourceDir.containsKey(sourceSet.name)) {
//						sourceSet.java.srcDirs.remove(originalSourceDir.get(sourceSet.name))
					}
				]
			}
		});
		
		project.afterEvaluate [
			try {
				android = project.extensions.getByName("android") as BaseExtension
				variants = switch android {
					AppExtension: android.applicationVariants as DomainObjectSet<? extends BaseVariant>
					LibraryExtension: android.libraryVariants
					default: throw new GradleException('''Unknown packaging type «android.class.simpleName»''')
				}

				android.sourceSets.forEach [ sourceSet |
					var task = new LatteTransform()
					task.javaSrc = sourceSet.java.srcDirs
					var manifestFile = sourceSet.manifest.srcFile;

					if(manifestFile.exists && !sourceSet.java.srcDirs.filter[it.absoluteFile.exists].empty) {
						var files = sourceSet.java.srcDirs.map[it.absoluteFile]
						var target = new File(project.buildDir.absolutePath+File.separator+"latte/"+sourceSet.name+"/")
						target.mkdirs()
						originalSourceDir.put(sourceSet.name, target)
						val Set<File> javaDirs = newHashSet(target);
						sourceSet.java.srcDirs.forEach[ javaDirs += it ]
						sourceSet.java.srcDirs = javaDirs
						println("New source dirs =" +javaDirs);
						task.javaToSrc = target
						task.project = project;
						task.execute
					}
				]
			} catch (Exception ex) {
				// Java mode
                val java = project.convention.findPlugin(JavaPluginConvention)


                java.sourceSets.all [ sourceSet |
                    if (!sourceSet.allJava.empty) {

                        var target = new File(project.buildDir.absolutePath+File.separator+"latte/"+sourceSet.name+"/")
                        val Set<File> javaDirs = newHashSet(target);
                        sourceSet.java.srcDirs.forEach[ javaDirs += it ]
                        sourceSet.java.srcDirs = javaDirs

                        var task = new LatteTransform()
                        task.javaSrc = sourceSet.java.srcDirs
                        println("New source dirs =" +javaDirs);
                        task.javaToSrc = target
                        task.project = project;
                        task.execute

                    }
                ]

			}
		]
	}

}

@Accessors
public class LatteTransform /*extends DefaultTask*/ {
	
	var Set<File> javaSrc;
	var File javaToSrc;

	var Project project;
	
	def copy(Set<File> from, Set<File> to) {
		from.forEach [ file, i |
			project.copy [
				from(file)
				into(to.get(i))
			]
		]
	}

	@TaskAction
	def execute() {
		javaSrc.forEach [ src, i |
			var to = javaToSrc
			if (project.file(src).exists) {
				new Transformer().transform(project.file(src).absolutePath, project.file(to).absolutePath,
					".java", ".xtend","css")			
			}
		]

	}

}
