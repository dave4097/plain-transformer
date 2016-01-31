package org.plaintransformer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to instruct the transformer to apply a transformation to an attribute. The class representing the
 * attribute should be annotated with plain-transformer annotations.
 *
 * @author David H
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransformEmbedded {

   /**
    * Returns the expression language locator for the source value to transform.
    *
    * @return the expression language locator for the source value to transform.
    */
   String value();
}
