package org.plaintransformer;

import java.lang.reflect.Field;

/**
 * Processor for the {@link TransformFrom} annotation.
 *
 * @author David H
 */
class TransformFromProcessor extends AnnotationProcessor<TransformFrom> {

   @Override
   protected Class<TransformFrom> getAnnotationClass() {
      return TransformFrom.class;
   }

   @Override
   protected String getLocator(TransformFrom annotation) {
      return annotation.value();
   }

   @Override
   protected Object transform(TransformContext context, Field destinationField, AttributeTransformData transformOverride, Object... sourceValues)
         throws IllegalAccessException, InstantiationException {
      AttributeTransformer<Object, Object> attributeTransformer = createAttributeTransformer(destinationField, transformOverride);
      return attributeTransformer.transform(sourceValues[0]);
   }

   @SuppressWarnings("unchecked")
   private AttributeTransformer<Object, Object> createAttributeTransformer(Field destinationField, AttributeTransformData transformOverride)
         throws IllegalAccessException, InstantiationException {
      TransformFrom annotation = destinationField.getAnnotationsByType(getAnnotationClass())[0];
      Class<? extends AttributeTransformer> attributeTransformer = annotation.attributeTransformer();
      if (transformOverride != null) {
         attributeTransformer = transformOverride.getAttributeTransformer();
      }
      return attributeTransformer.newInstance();
   }
}
