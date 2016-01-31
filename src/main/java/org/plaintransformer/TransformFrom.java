package org.plaintransformer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to instruct the transformer to transform a field.
 *
 * @author David H
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransformFrom {

   /**
    * Returns the expression language locator for the source value to transform.
    *
    * @return the expression language locator for the source value to transform.
    */
   String value();

   /**
    * Returns a custom transformer to map the field. Default behaviour is to copy the value in the source
    * without a transformation.
    *
    * @return a custom transformer to map entries of the collection.
    */
   Class<? extends AttributeTransformer> attributeTransformer() default DefaultAttributeTransformer.class;
}
