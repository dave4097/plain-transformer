package org.plaintransformer.customannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TotalFor {

   String transformFrom() default "#source";

   String[] value();
}
