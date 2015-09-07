package io.lattekit;

import io.lattekit.LatteViewProcessor;
import org.eclipse.xtend.lib.macro.Active;

@Active(LatteViewProcessor.class)
public @interface LatteView {
  public String[] variants() default {};
}
