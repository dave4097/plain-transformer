package org.plaintransformer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Processor for the {@link TransformEmbedded} annotation.
 *
 * @author David H
 */
class TransformEmbeddedProcessor extends AnnotationProcessor<TransformEmbedded> {

   @Override
   protected Class<TransformEmbedded> getAnnotationClass() {
      return TransformEmbedded.class;
   }

   @Override
   protected String getLocator(TransformEmbedded annotation) {
      return annotation.value();
   }

   @Override
   protected Object transform(TransformContext context, Field destinationField, AttributeTransformData transformOverride, Object... sourceValues)
         throws IllegalAccessException, InstantiationException {
      @SuppressWarnings("unchecked")
      Class<Object> type = (Class<Object>) destinationField.getType();
      To<Object> to = new To<>(type, getOverrides(destinationField), context);
      return to.from(sourceValues);
   }

   private Map<String, AttributeTransformData> getOverrides(Field field) {
      if (field.isAnnotationPresent(TransformOverrides.class)) {
         TransformOverrides overridesAnnotation = field.getAnnotationsByType(TransformOverrides.class)[0];
         return Arrays.stream(overridesAnnotation.value())
               .collect(toMap(TransformOverride::attribute, this::getOverrideData));
      }
      return new HashMap<>();
   }

   private AttributeTransformData getOverrideData(TransformOverride override) {
      return new AttributeTransformData(override.transformFrom(), override.attributeTransformer());
   }
}
