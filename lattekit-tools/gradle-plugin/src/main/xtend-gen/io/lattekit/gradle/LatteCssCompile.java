package io.lattekit.gradle;

import io.lattekit.transformer.LatteTransformer;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

@Accessors
@SuppressWarnings("all")
public class LatteCssCompile extends DefaultTask {
  private List<File> srcDirs;
  
  private Path srcRoot;
  
  private File outDir;
  
  @TaskAction
  public void compile() {
    final Procedure2<File, Integer> _function = (File src, Integer i) -> {
      LatteTransformer _latteTransformer = new LatteTransformer();
      Project _project = this.getProject();
      File _file = _project.file(src);
      String _absolutePath = _file.getAbsolutePath();
      Project _project_1 = this.getProject();
      File _file_1 = _project_1.file(this.outDir);
      String _absolutePath_1 = _file_1.getAbsolutePath();
      _latteTransformer.transform(_absolutePath, _absolutePath_1, ".css");
    };
    IterableExtensions.<File>forEach(this.srcDirs, _function);
  }
  
  @Pure
  public List<File> getSrcDirs() {
    return this.srcDirs;
  }
  
  public void setSrcDirs(final List<File> srcDirs) {
    this.srcDirs = srcDirs;
  }
  
  @Pure
  public Path getSrcRoot() {
    return this.srcRoot;
  }
  
  public void setSrcRoot(final Path srcRoot) {
    this.srcRoot = srcRoot;
  }
  
  @Pure
  public File getOutDir() {
    return this.outDir;
  }
  
  public void setOutDir(final File outDir) {
    this.outDir = outDir;
  }
}
