package io.lattekit.gradle;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.ExternalModuleDependency;
import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.api.execution.TaskExecutionAdapter;
import org.gradle.api.execution.TaskExecutionGraph;
import org.gradle.api.file.FileCollection;
import org.gradle.api.invocation.Gradle;

@SuppressWarnings("all")
public class GradleExtensions {
  public static <T extends Task> void beforeExecute(final T taskToConfigure, final Procedure1<? super T> action) {
    Project _project = taskToConfigure.getProject();
    Gradle _gradle = _project.getGradle();
    TaskExecutionGraph _taskGraph = _gradle.getTaskGraph();
    _taskGraph.addTaskExecutionListener(
      new TaskExecutionAdapter() {
        @Override
        public void beforeExecute(final Task task) {
          if ((task == taskToConfigure)) {
            action.apply(((T) task));
          }
        }
      });
  }
  
  public static Dependency externalModule(final DependencyHandler dependencyHandler, final String coordinates, final Procedure1<ExternalModuleDependency> config) {
    Dependency _xblockexpression = null;
    {
      final Dependency dependency = dependencyHandler.create(coordinates);
      config.apply(((ExternalModuleDependency) dependency));
      _xblockexpression = dependency;
    }
    return _xblockexpression;
  }
  
  public static FileCollection operator_plus(final FileCollection first, final FileCollection second) {
    return first.plus(second);
  }
}
