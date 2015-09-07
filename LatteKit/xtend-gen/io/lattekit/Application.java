package io.lattekit;

import com.google.common.base.Objects;
import io.lattekit.device.LatteWindowManager;
import java.util.Map;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class Application {
  public static Application app;
  
  @Property
  private LatteWindowManager _windowManager;
  
  public final LatteWindowManager setWindowManager(final LatteWindowManager windowManager) {
    LatteWindowManager _xifexpression = null;
    boolean _equals = Objects.equal(this._windowManager, null);
    if (_equals) {
      _xifexpression = this._windowManager = windowManager;
    }
    return _xifexpression;
  }
  
  public static final Application getApplication() {
    return Application.app;
  }
  
  public abstract void appLaunched(final Map<String, Object> params);
  
  @Pure
  public LatteWindowManager getWindowManager() {
    return this._windowManager;
  }
}
