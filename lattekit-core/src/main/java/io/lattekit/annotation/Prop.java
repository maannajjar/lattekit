package io.lattekit.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by maan on 2/8/16.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Prop {
    String name() default "";
}
