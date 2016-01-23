package io.lattekit;


public @interface StyleProperty {
  public String[] shorthands() default {};
  public boolean animatable() default true;
}
