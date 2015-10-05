package org.plaintransformer;

import java.lang.reflect.Field;

/**
 * Processor for the {@link MapEmbedded} annotation.
 *
 * @author David H
 */
public class MapEmbeddedProcessor extends AnnotationProcessor<MapEmbedded> {

   @Override
   protected Class<MapEmbedded> getAnnotationClass() {
      return MapEmbedded.class;
   }

   @Override
   protected String getLocator(MapEmbedded annotation) {
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
