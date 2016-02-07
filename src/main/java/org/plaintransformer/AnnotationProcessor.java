package org.plaintransformer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Extend this class to implement an annotation processor. An annotation processor is a class that finds all
 * fields in a class that are annotated with a specific annotation and processes them for the transformation.
 *
 * @param <A> The type of the annotation to be processed.
 */
public abstract class AnnotationProcessor<A extends Annotation> extends TransformProcessor {

   @Override
   protected <T> List<Field> getFieldsToProcess(TransformContext context, Class<T> aClass) {
      return Arrays.stream(aClass.getDeclaredFields())
            .filter(f -> f.isAnnotationPresent(getAnnotationClass()))
            .collect(toList());
   }

   @Override
   protected String getLocator(TransformContext context, Field field, Object... sources) {
      return getLocator(field.getAnnotationsByType(getAnnotationClass())[0]);
   }

   /**
    * Returns the class for the annotation being processed.
    *
    * @return the class for the annotation being processed.
    */
   protected abstract Class<A> getAnnotationClass();

   /**
    * Returns the expression language string to locate the field to provide a value for transformation.
    *
    * @param annotation The annotation defining the locator.
    * @return the expression language string to locate the field to provide a value for transformation.
    */
   protected abstract String getLocator(A annotation);
}
