package org.plaintransformer;

import java.lang.reflect.Field;

/**
 * Processor for the {@link TransformFrom} annotation.
 *
 * @author David H
 */
public class TransformFromProcessor extends AnnotationProcessor<TransformFrom> {

   @Override
   protected Class<TransformFrom> getAnnotationClass() {
      return TransformFrom.class;
   }

   @Override
   protected String getLocator(TransformFrom annotation) {
      return annotation.value();
   }

   @Override
   protected <T> T transform(Object sourceValue, Field destinationField, TransformContext context)
         throws IllegalAccessException, InstantiationException {
      AttributeTransformer<Object, T> attributeTransformer = createAttributeTransformer(destinationField);
      return attributeTransformer.transform(sourceValue);
   }

   @SuppressWarnings("unchecked")
   private <T> AttributeTransformer<Object, T> createAttributeTransformer(Field destinationField)
         throws IllegalAccessException, InstantiationException {
      TransformFrom annotation = destinationField.getAnnotationsByType(getAnnotationClass())[0];
      Class<? extends AttributeTransformer> attributeTransformer = annotation.attributeTransformer();
      return (AttributeTransformer<Object, T>) attributeTransformer.newInstance();
   }
}
