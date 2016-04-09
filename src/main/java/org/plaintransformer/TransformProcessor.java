package org.plaintransformer;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Base class to process a transformation from one or more sources to a new object.
 *
 * @author David H
 */
abstract class TransformProcessor {

   /**
    * Process each field annotated with the annotation in the class that will be the output of the transformation.
    *
    * @param context The transformation settings.
    * @param instance The instance of the class that is the output of transformation.
    * @param transformOverrides Optional overrides for the attribute mappings.
    * @param sources The objects to transform from.
    * @param <T> The type of the object that is the output of the transformation.
    * @throws IllegalAccessException
    * @throws InstantiationException
    */
   <T> void process(TransformContext context,
                    T instance,
                    Map<String, AttributeTransformData> transformOverrides,
                    Object... sources)
         throws IllegalAccessException, InstantiationException {
      for (Field field : getFieldsToProcess(context, instance.getClass())) {
         AttributeTransformData transformOverride = transformOverrides.get(field.getName());
         String elLocator = getSourceLocator(context, transformOverride, field, sources);
         Object[] sourceValues = getSourceValues(context, elLocator, sources);
         if (sourceValues.length != 0) {
            if (!field.isAccessible()) {
               field.setAccessible(true);
            }
            field.set(instance, transform(context, field, transformOverride, sourceValues));
         }
      }
   }

   /**
    * Returns the fields to be processed in the transformation.
    *
    * @param context The transformation settings.
    * @param aClass The class of the object that will be the result of the transformation.
    * @param <T> The type of the object that will be the result of the transformation.
    * @return the fields to be processed in the transformation.
    */
   protected abstract <T> List<Field> getFieldsToProcess(TransformContext context, Class<T> aClass);

   /**
    * Returns the expression language string to locate the field to provide a value for transformation.
    *
    * @param context The transformation settings.
    * @param field The field which is defining the locator.
    * @param sources The objects to transform from.
    * @return the expression language string to locate the field to provide a value for transformation.
    */
   protected abstract String getLocator(TransformContext context, Field field, Object... sources);

   /**
    * Performs the transformation for an annotated filed.
    *
    * @param context The transformation settings.
    * @param destinationField The field where the value will be set.
    * @param sourceValues The values from the source objects to be set on the result of the transformation.
    * @return The transformed field value.
    * @throws IllegalAccessException
    * @throws InstantiationException
    */
   protected abstract Object transform(TransformContext context, Field destinationField, AttributeTransformData transformOverride, Object... sourceValues)
         throws IllegalAccessException, InstantiationException;

   private String getSourceLocator(TransformContext context, AttributeTransformData transformOverride, Field field, Object... sources) {
      String elLocator;
      if (transformOverride != null) {
         elLocator = transformOverride.getTransformFrom();
      } else {
         elLocator = getLocator(context, field, sources);
      }
      return elLocator;
   }

   private Object[] getSourceValues(TransformContext context, String elLocator, Object[] sources) {
      if ("".equals(elLocator)) {
         return sources;
      }
      return new Object[]{context.getExpressionLanguageHandler().getValue(elLocator, sources)};
   }
}
