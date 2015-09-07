package io.lattekit;

import io.lattekit.LayoutProcessor;
import org.eclipse.xtend.lib.macro.Active;

@Active(LayoutProcessor.class)
public @interface Layout {
  public String[] imports() default {};
}
