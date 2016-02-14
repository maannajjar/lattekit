package io.lattekit.gradle;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.BaseExtension;
import com.android.build.gradle.LibraryExtension;
import com.android.build.gradle.api.AndroidSourceDirectorySet;
import com.android.build.gradle.api.AndroidSourceFile;
import com.android.build.gradle.api.AndroidSourceSet;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariant;
import groovy.lang.Closure;
import io.lattekit.gradle.LatteTransform;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.gradle.api.Action;
import org.gradle.api.DomainObjectSet;
import org.gradle.api.GradleException;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.internal.file.FileResolver;
import org.gradle.api.invocation.Gradle;
import org.gradle.api.plugins.ExtensionContainer;

@SuppressWarnings("all")
public class LattePlugin implements Plugin<Project> {
  private FileResolver fileResolver;
  
  private Project project;
  
  private BaseExtension android;
  
  private DomainObjectSet<? extends BaseVariant> variants;
  
  private Map<String, Set<File>> originalSourceDir = CollectionLiterals.<String, Set<File>>newHashMap();
  
  @Inject
  public LattePlugin(final FileResolver fileResolver) {
    this.fileResolver = fileResolver;
  }
  
  @Override
  public void apply(final Project project) {
    abstract class __LattePlugin_1 extends Closure {
      __LattePlugin_1(final Object owner) {
        super(owner);
      }
      
      public abstract void doCall();
    }
    
    this.project = project;
    Gradle _gradle = project.getGradle();
    __LattePlugin_1 ___LattePlugin_1 = new __LattePlugin_1(this) {
      public void doCall() {
        NamedDomainObjectContainer<AndroidSourceSet> _sourceSets = LattePlugin.this.android.getSourceSets();
        final Consumer<AndroidSourceSet> _function = (AndroidSourceSet sourceSet) -> {
          String _name = sourceSet.getName();
          boolean _containsKey = LattePlugin.this.originalSourceDir.containsKey(_name);
          if (_containsKey) {
            AndroidSourceDirectorySet _java = sourceSet.getJava();
            String _name_1 = sourceSet.getName();
            Set<File> _get = LattePlugin.this.originalSourceDir.get(_name_1);
            _java.setSrcDirs(_get);
          }
        };
        _sourceSets.forEach(_function);
      }
    };
    _gradle.buildFinished(___LattePlugin_1);
    final Action<Project> _function = (Project it) -> {
      ExtensionContainer _extensions = project.getExtensions();
      Object _byName = _extensions.getByName("android");
      this.android = ((BaseExtension) _byName);
      DomainObjectSet<? extends BaseVariant> _switchResult = null;
      final BaseExtension android = this.android;
      boolean _matched = false;
      if (!_matched) {
        if (android instanceof AppExtension) {
          _matched=true;
          DomainObjectSet<ApplicationVariant> _applicationVariants = ((AppExtension)this.android).getApplicationVariants();
          _switchResult = ((DomainObjectSet<? extends BaseVariant>) _applicationVariants);
        }
      }
      if (!_matched) {
        if (android instanceof LibraryExtension) {
          _matched=true;
          _switchResult = ((LibraryExtension)this.android).getLibraryVariants();
        }
      }
      if (!_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Unknown packaging type ");
        Class<? extends BaseExtension> _class = this.android.getClass();
        String _simpleName = _class.getSimpleName();
        _builder.append(_simpleName, "");
        throw new GradleException(_builder.toString());
      }
      this.variants = _switchResult;
      NamedDomainObjectContainer<AndroidSourceSet> _sourceSets = this.android.getSourceSets();
      final Consumer<AndroidSourceSet> _function_1 = (AndroidSourceSet sourceSet) -> {
        LatteTransform task = new LatteTransform();
        AndroidSourceDirectorySet _java = sourceSet.getJava();
        Set<File> _srcDirs = _java.getSrcDirs();
        task.setJavaSrc(_srcDirs);
        AndroidSourceDirectorySet _aidl = sourceSet.getAidl();
        Set<File> aidlSrc = _aidl.getSrcDirs();
        AndroidSourceDirectorySet _assets = sourceSet.getAssets();
        Set<File> assetsSrc = _assets.getSrcDirs();
        AndroidSourceDirectorySet _jniLibs = sourceSet.getJniLibs();
        Set<File> jniSrc = _jniLibs.getSrcDirs();
        AndroidSourceDirectorySet _res = sourceSet.getRes();
        Set<File> resSrc = _res.getSrcDirs();
        AndroidSourceFile _manifest = sourceSet.getManifest();
        File manifestFile = _manifest.getSrcFile();
        boolean _and = false;
        boolean _exists = manifestFile.exists();
        if (!_exists) {
          _and = false;
        } else {
          AndroidSourceDirectorySet _java_1 = sourceSet.getJava();
          Set<File> _srcDirs_1 = _java_1.getSrcDirs();
          final Function1<File, Boolean> _function_2 = (File it_1) -> {
            File _absoluteFile = it_1.getAbsoluteFile();
            return Boolean.valueOf(_absoluteFile.exists());
          };
          Iterable<File> _filter = IterableExtensions.<File>filter(_srcDirs_1, _function_2);
          boolean _isEmpty = IterableExtensions.isEmpty(_filter);
          boolean _not = (!_isEmpty);
          _and = _not;
        }
        if (_and) {
          AndroidSourceDirectorySet _java_2 = sourceSet.getJava();
          Set<File> _srcDirs_2 = _java_2.getSrcDirs();
          final Function1<File, File> _function_3 = (File it_1) -> {
            return it_1.getAbsoluteFile();
          };
          Iterable<File> files = IterableExtensions.<File, File>map(_srcDirs_2, _function_3);
          String _name = sourceSet.getName();
          AndroidSourceDirectorySet _java_3 = sourceSet.getJava();
          Set<File> _srcDirs_3 = _java_3.getSrcDirs();
          this.originalSourceDir.put(_name, _srcDirs_3);
          File _buildDir = project.getBuildDir();
          String _absolutePath = _buildDir.getAbsolutePath();
          String _plus = (_absolutePath + File.separator);
          String _plus_1 = (_plus + "latte/");
          String _name_1 = sourceSet.getName();
          String _plus_2 = (_plus_1 + _name_1);
          File target = new File(_plus_2);
          AndroidSourceDirectorySet _java_4 = sourceSet.getJava();
          HashSet<File> _newHashSet = CollectionLiterals.<File>newHashSet(target);
          _java_4.setSrcDirs(_newHashSet);
          AndroidSourceDirectorySet _java_5 = sourceSet.getJava();
          Set<File> _srcDirs_4 = _java_5.getSrcDirs();
          task.setJavaToSrc(_srcDirs_4);
          task.setProject(project);
          task.execute();
        }
      };
      _sourceSets.forEach(_function_1);
    };
    project.afterEvaluate(_function);
  }
}
