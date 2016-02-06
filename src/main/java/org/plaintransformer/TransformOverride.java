package org.plaintransformer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to override a transformation mapping in the class of an attribute annotated
 * with the {@link TransformEmbedded} annotation.
 *
 * @author David H
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TransformOverride {

   /**
    * Returns the name of the attribute for which the override should be applied.
    *
    * @return the name of the attribute for which the override should be applied.
    */
   String attribute();

   /**
    * Returns an override of the expression language locator for the source value to transform.
    *
    * @return an override of the expression language locator for the source value to transform.
    */
   String transformFrom();
}
