package io.lattekit.gradle

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.BaseVariant
import groovy.lang.Closure
import io.lattekit.transformer.LatteTransformer
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

class LattePlugin implements Plugin<Project> {

	FileResolver fileResolver
	Project project
	BaseExtension android
	DomainObjectSet<? extends BaseVariant> variants
	var Map<String,Set<File>> originalSourceDir = newHashMap()
	
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
						sourceSet.java.srcDirs = originalSourceDir.get(sourceSet.name)
					}
				]
			}
		});
		
		project.afterEvaluate [
			android = project.extensions.getByName("android") as BaseExtension
			
			variants = switch android {
				AppExtension: android.applicationVariants as DomainObjectSet<? extends BaseVariant>
				LibraryExtension: android.libraryVariants
				default: throw new GradleException('''Unknown packaging type «android.class.simpleName»''')
			}
			android.sourceSets.forEach [ sourceSet |
				var task = new LatteTransform()
				task.javaSrc = sourceSet.java.srcDirs
				var aidlSrc = sourceSet.aidl.srcDirs
				var assetsSrc = sourceSet.assets.srcDirs
				var jniSrc = sourceSet.jniLibs.srcDirs
				var resSrc = sourceSet.res.srcDirs
				var manifestFile = sourceSet.manifest.srcFile;

				if (manifestFile.exists && !sourceSet.java.srcDirs.filter[it.absoluteFile.exists].empty) {
					var files = sourceSet.java.srcDirs.map[it.absoluteFile]
////					sourceSet.root = "build/latte/" + sourceSet.name
//					sourceSet.manifest.srcFile = manifestFile
//					sourceSet.aidl.srcDirs = aidlSrc
//					sourceSet.assets.srcDirs = assetsSrc
//					sourceSet.jniLibs.srcDirs = jniSrc
//					sourceSet.res.srcDirs = resSrc
					originalSourceDir.put(sourceSet.name, sourceSet.java.srcDirs)
					var target = new File(project.buildDir.absolutePath+File.separator+"latte/"+sourceSet.name)
					sourceSet.java.srcDirs = newHashSet(target)
					task.javaToSrc = sourceSet.java.srcDirs
					task.project = project;
					task.execute
				}
			]
		]
	}

}

@Accessors
public class LatteCssCompile extends DefaultTask {
	var List<File> srcDirs;
	var Path srcRoot;
	var File outDir;

	@TaskAction
	def compile() {
		srcDirs.forEach [ src, i |
			new LatteTransformer().transform(project.file(src).absolutePath, project.file(outDir).absolutePath, ".css");
		]

	}

}

@Accessors
public class LatteTransform /*extends DefaultTask*/ {
	
	var Set<File> javaSrc;
	var Set<File> javaToSrc;

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
			var to = javaToSrc.get(0)
			if (project.file(src).exists) {
				new LatteTransformer().transform(project.file(src).absolutePath, project.file(to).absolutePath, 
					".java", ".xtend","css")			
			}
		]

	}

}
