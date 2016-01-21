package io.lattekit.gradle

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.gradle.api.Task
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.execution.TaskExecutionAdapter
import org.gradle.api.file.FileCollection

class GradleExtensions {
	static def <T extends Task> beforeExecute(T taskToConfigure, (T)=>void action) {
		taskToConfigure.project.gradle.taskGraph.addTaskExecutionListener(
			new TaskExecutionAdapter() {
				override beforeExecute(Task task) {
					if (task === taskToConfigure) {
						action.apply(task as T)
					}
				}
			}
		)
	}
	
	static def externalModule(DependencyHandler dependencyHandler, String coordinates,
		Procedure1<ExternalModuleDependency> config) {
		val dependency = dependencyHandler.create(coordinates)
		config.apply(dependency as ExternalModuleDependency)
		dependency
	}

	static def + (FileCollection first, FileCollection second) {
		first.plus(second)
	}
	
}