package io.lattekit.gradle

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.BaseVariant
import io.lattekit.transformer.Reflection
import io.lattekit.transformer.TransformerException
import org.gradle.api.*
import org.gradle.api.internal.file.FileResolver
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.io.PrintWriter

/**
 * Created by maan on 4/1/16.
 */
open class LattePlugin: Plugin<Project> {

    var project : Project? = null
    var android : BaseExtension? = null
    var variants : DomainObjectSet<out BaseVariant>? = null


    override open fun apply(project: Project) {
        this.project = project

        project.afterEvaluate {
            android = project.extensions.getByName("android") as BaseExtension
            variants = when (android) {
                is AppExtension -> (android as AppExtension).applicationVariants
                is LibraryExtension -> (android as LibraryExtension).libraryVariants
                else -> throw GradleException("""Unknown packaging type ${android!!.javaClass.simpleName}""")
            }
            Reflection.loadAndroidSdk(android!!.sdkDirectory.absolutePath, android!!.compileSdkVersion)
            variants?.forEach { variant ->
                var srcTaskName = "generate" + variant.name.substring(0,1).toUpperCase()+variant.name.substring(1) + "LatteSources"
                var resTaskName = "generate" + variant.name.substring(0,1).toUpperCase()+variant.name.substring(1) + "LatteResources"
                val javaDirs = variant.sourceSets.map { it.javaDirectories }.flatten().filter {it.isDirectory }
                val sourceDirs = mutableListOf<File>()
                sourceDirs += javaDirs
                sourceDirs += listOf(
                        variant.aidlCompile.sourceOutputDir,
                        variant.generateBuildConfig.sourceOutputDir,
                        variant.renderscriptCompile.sourceOutputDir
                )
                sourceDirs += variant.outputs.map { it.processResources.sourceOutputDir }

                val srcDestination = File("""${project.buildDir}/generated/source/latte/${variant.dirName}""")
                val resDestination =  File("""${project.buildDir}/generated/res/latte/${variant.dirName}""")
                var srcTask = project.tasks.create(srcTaskName, LatteTransform::class.java) {
                    it.taskType = LatteTransform.TaskType.SRC_GENERATOR
                    it.from = sourceDirs.toSet()
                    it.outputSourceDir = srcDestination
                    it.outputResDir = resDestination
                    it.project = project;
                    it.applicationId = variant.applicationId
                }
                var resTask = project.tasks.create(resTaskName, LatteTransform::class.java) {
                    it.taskType = LatteTransform.TaskType.RES_GENERATOR
                    it.from = sourceDirs.toSet()
                    it.outputSourceDir = srcDestination
                    it.outputResDir = resDestination
                    it.project = project;
                    it.applicationId = variant.applicationId
                }

                variant.registerJavaGeneratingTask(srcTask, srcDestination)
                variant.registerResGeneratingTask(resTask, resDestination)
            }


        }
    }

}

open class LatteTransform : DefaultTask() {

    object TaskType {
        val RES_GENERATOR = 1; val SRC_GENERATOR = 2
    }
    var from : Set<File>? = null;
    var outputSourceDir : File? = null;
    var outputResDir : File? = null;
    var applicationId : String? = null;
    var taskType : Int? = TaskType.RES_GENERATOR;

    fun getIdsXml(ids : Iterable<String> ) = """<?xml version="1.0" encoding="utf-8"?>
<resources>
${ids.map{ """<item name="$it" type="id" />"""}.joinToString("\n")}
</resources>
    """


    @TaskAction
    open fun executeTask() {
        val androidPackage = applicationId;
        println("Generating source dir $from to $outputSourceDir");
        val  allIds = mutableListOf<String>()
        try {
            from!!.forEachIndexed { i, src ->
                if (project.file(src).exists()) {
                    if (taskType == TaskType.RES_GENERATOR) {
                        allIds += io.lattekit.transformer.Transformer().transform(androidPackage!!, project.file(src).absolutePath, null)
                    } else {
                        io.lattekit.transformer.Transformer().transform(androidPackage!!, project.file(src).absolutePath, project.file(outputSourceDir).absolutePath)

                    }
                }
            }


            var resOut = project.file(outputResDir).absolutePath;
            if (taskType == TaskType.RES_GENERATOR) {
                var valuesOut = File(resOut+"/values");
                valuesOut.mkdirs();
                var writer = PrintWriter(File(resOut + "/values/latte_ids.xml"), "UTF-8");
                writer.print(getIdsXml(allIds));
                writer.close();
            }
        } catch (e: TransformerException) {
            e.errors.forEach {
                System.err.println("e: ${e.filePath}: $it")
            }
            throw InvalidLayoutException();
        }

    }
}
class InvalidLayoutException : Exception();