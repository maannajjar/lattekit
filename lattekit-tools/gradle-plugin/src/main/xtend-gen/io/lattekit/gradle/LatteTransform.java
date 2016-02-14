package io.lattekit.gradle;

import io.lattekit.transformer.LatteTransformer;
import java.io.File;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.gradle.api.Action;
import org.gradle.api.Project;
import org.gradle.api.file.CopySpec;
import org.gradle.api.tasks.TaskAction;

@Accessors
@SuppressWarnings("all")
public class LatteTransform {
  private Set<File> javaSrc;
  
  private Set<File> javaToSrc;
  
  private Project project;
  
  public void copy(final Set<File> from, final Set<File> to) {
    final Procedure2<File, Integer> _function = (File file, Integer i) -> {
      final Action<CopySpec> _function_1 = (CopySpec it) -> {
        it.from(file);
        Object _get = ((Object[])Conversions.unwrapArray(to, Object.class))[(i).intValue()];
        it.into(_get);
      };
      this.project.copy(_function_1);
    };
    IterableExtensions.<File>forEach(from, _function);
  }
  
  @TaskAction
  public void execute() {
    final Procedure2<File, Integer> _function = (File src, Integer i) -> {
      File to = ((File[])Conversions.unwrapArray(this.javaToSrc, File.class))[0];
      File _file = this.project.file(src);
      boolean _exists = _file.exists();
      if (_exists) {
        LatteTransformer _latteTransformer = new LatteTransformer();
        File _file_1 = this.project.file(src);
        String _absolutePath = _file_1.getAbsolutePath();
        File _file_2 = this.project.file(to);
        String _absolutePath_1 = _file_2.getAbsolutePath();
        _latteTransformer.transform(_absolutePath, _absolutePath_1, 
          ".java", ".xtend", "css");
      }
    };
    IterableExtensions.<File>forEach(this.javaSrc, _function);
  }
  
  @Pure
  public Set<File> getJavaSrc() {
    return this.javaSrc;
  }
  
  public void setJavaSrc(final Set<File> javaSrc) {
    this.javaSrc = javaSrc;
  }
  
  @Pure
  public Set<File> getJavaToSrc() {
    return this.javaToSrc;
  }
  
  public void setJavaToSrc(final Set<File> javaToSrc) {
    this.javaToSrc = javaToSrc;
  }
  
  @Pure
  public Project getProject() {
    return this.project;
  }
  
  public void setProject(final Project project) {
    this.project = project;
  }
}
