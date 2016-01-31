package org.plaintransformer;

import java.lang.reflect.Field;

/**
 * Processor for the {@link TransformEmbedded} annotation.
 *
 * @author David H
 */
public class TransformEmbeddedProcessor extends AnnotationProcessor<TransformEmbedded> {

   @Override
   protected Class<TransformEmbedded> getAnnotationClass() {
      return TransformEmbedded.class;
   }

   @Override
   protected String getLocator(TransformEmbedded annotation) {
      return annotation.value();
   }

   @Override
   protected <T> T transform(Object sourceValue, Field destinationField, TransformContext context)
         throws IllegalAccessException, InstantiationException {
      @SuppressWarnings("unchecked")
      Class<T> type = (Class<T>) destinationField.getType();
      To<T> to = new To<>(type, context);
      return to.from(sourceValue);
   }
}
