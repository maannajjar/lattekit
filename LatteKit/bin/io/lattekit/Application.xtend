package io.lattekit

import io.lattekit.device.LatteWindowManager
import java.util.Map
import org.eclipse.xtend.lib.Property

abstract class Application {
	public static Application app;

//	@Property Controller rootViewController;
	@Property LatteWindowManager windowManager;

	final def setWindowManager(LatteWindowManager windowManager) {
		if (_windowManager == null) {
			_windowManager = windowManager;
		}
	}

	final static def Application getApplication() {
		return app;
	}

	def abstract void appLaunched(Map<String, Object> params);

}
