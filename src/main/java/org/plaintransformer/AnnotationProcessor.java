package org.plaintransformer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Extend this interface to implement an annotation processor. An annotation processor is a class that finds all
 * fields in a class that are annotated with a specific annotation and processes them for the transformation.
 *
 * @param <A> The type of the annotation to be processed.
 */
public abstract class AnnotationProcessor<A extends Annotation> {

   /**
    * Process each field annotated with the annotation in the class that will be the output of the transformation.
    *
    * @param context The transformation settings.
    * @param instance The instance of the class that is the output of transformation.
    * @param sources The objects to transform from.
    * @param <T> The type of the object that is the output of the transformation.
    * @throws IllegalAccessException
    * @throws InstantiationException
    */
   <T> void process(TransformContext context, T instance, Object... sources)
         throws IllegalAccessException, InstantiationException {
      List<Field> fields = getAnnotatedFields(instance.getClass());
      for (Field field : fields) {
         String elLocator = getLocator(field.getAnnotationsByType(getAnnotationClass())[0]);
         Object sourceValue = context.getExpressionLanguageHandler().getValue(elLocator, sources);
         if (sourceValue != null) {
            if (!field.isAccessible()) {
               field.setAccessible(true);
            }
            field.set(instance, transform(sourceValue, field, context));
         }
      }
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

   /**
    * Performs the transformation for an annotated filed.
    *
    * @param sourceValue The value from he source objects to be set on the result of the transformation.
    * @param destinationField The field where the value will be set.
    * @param context The transformation settings.
    * @param <T> The type of the result of the field transformation.
    * @return The transformed field value.
    * @throws IllegalAccessException
    * @throws InstantiationException
    */
   protected abstract <T> T transform(Object sourceValue, Field destinationField, TransformContext context)
         throws IllegalAccessException, InstantiationException;

   private <T> List<Field> getAnnotatedFields(Class<T> clazz) {
      return Arrays.stream(clazz.getDeclaredFields())
            .filter(f -> f.isAnnotationPresent(getAnnotationClass()))
            .collect(toList());
   }
}
