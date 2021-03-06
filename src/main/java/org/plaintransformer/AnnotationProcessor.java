package org.plaintransformer;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Extend this class to implement an annotation processor. An annotation processor is a class that finds all
 * fields in a class that are annotated with a specific annotation and processes them for the transformation.
 *
 * @param <A> The type of the annotation to be processed.
 */
public abstract class AnnotationProcessor<A extends Annotation> extends TransformProcessor {

   @Override
   protected <T> List<Field> getFieldsToProcess(TransformContext context, Class<T> aClass) {
      return FieldUtils.getFieldsListWithAnnotation(aClass, getAnnotationClass());
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
