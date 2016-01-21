package io.lattekit.gradle

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.AndroidSourceSet
import com.android.build.gradle.api.BaseVariant
import io.lattekit.transformer.Main
import java.io.File
import java.util.List
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

class LattePlugin implements Plugin<Project> {
	FileResolver fileResolver
	Project project
	List<String> sources;
	BaseExtension android
	DomainObjectSet<? extends BaseVariant> variants

	@Inject
	new(FileResolver fileResolver) {
		this.fileResolver = fileResolver
	}	override apply(Project project) {
		this.project = project

		project.afterEvaluate [
			android = project.extensions.getByName("android") as BaseExtension
			variants = switch android {
				AppExtension: android.applicationVariants as DomainObjectSet<? extends BaseVariant>
				LibraryExtension: android.libraryVariants
				default: throw new GradleException('''Unknown packaging type «android.class.simpleName»''')
			}
			variants.all [ variant |
				if (variant.name == "debug") {
					android.sourceSets.forEach [ sourceSet |
						val compileTaskName = '''transform«variant.name.toFirstUpper»«sourceSet.name»Latte'''
						var transformTask = project.tasks.create(compileTaskName, LatteTransform)
						transformTask.javaSrc = sourceSet.java.srcDirs
						transformTask.aidlSrc = sourceSet.aidl.srcDirs
						transformTask.assetsSrc = sourceSet.assets.srcDirs
						transformTask.jniSrc = sourceSet.jniLibs.srcDirs
						transformTask.resSrc = sourceSet.res.srcDirs
						transformTask.manifestFile = sourceSet.manifest.srcFile
						transformTask.sourceSet = sourceSet;
						sourceSet.root = ".latte/" + sourceSet.name
						variant.preBuild.dependsOn(transformTask)
					
					]
				}
					
			]
		]
	}

}

@Accessors
public class LatteTransform extends DefaultTask {
	var Set<File> javaSrc;
	var Set<File> aidlSrc;
	var Set<File> assetsSrc;
	var Set<File> jniSrc;
	var Set<File> resSrc;
	AndroidSourceSet sourceSet;
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
	def compile() {

		println(javaSrc + " -> " + sourceSet.java.srcDirs);
		println(aidlSrc + " -> " + sourceSet.aidl.srcDirs);
		println(assetsSrc + " -> " + sourceSet.assets.srcDirs);
		println(jniSrc + " -> " + sourceSet.jniLibs.srcDirs);
		println(resSrc + " -> " + sourceSet.res.srcDirs);
		println(manifestFile + " -> " + sourceSet.manifest.srcFile);

		project.copy [
			from(manifestFile)
			into(sourceSet.manifest.srcFile.parentFile)
		]
		copy(aidlSrc, sourceSet.aidl.srcDirs);
		copy(assetsSrc, sourceSet.assets.srcDirs);
		copy(jniSrc, sourceSet.jniLibs.srcDirs);
		copy(resSrc, sourceSet.res.srcDirs);
		javaSrc.forEach [ src, i |
			var to = sourceSet.java.srcDirs.get(0)
			if (project.file(src).exists) {
				println("Transforming this " + project.file(src).absolutePath + " to this " + to)
				Main.main(#[project.file(src).absolutePath, project.file(to).absolutePath])
			}
		]

	

	}

}
