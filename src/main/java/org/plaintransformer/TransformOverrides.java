package org.plaintransformer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that contains {@link TransformOverride}s, which are overrides of the transformation mappings
 * in the class of an attribute annotated with the {@link TransformEmbedded} annotation.
 *
 * @author David H
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransformOverrides {

   TransformOverride[] value();
}
