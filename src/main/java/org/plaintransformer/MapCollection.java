package org.plaintransformer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to instruct the transformation to apply a transformation on each of the objects contained in
 * the collection attribute.  The class representing the entries in the collection should be annotated
 * with plain-transformer annotations.
 *
 * @author David H
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapCollection {

   /**
    * Returns the expression language locator for the source value to transform.
    *
    * @return the expression language locator for the source value to transform.
    */
   String value();
}
