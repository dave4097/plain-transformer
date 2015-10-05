package org.plaintransformer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

/**
 * Processor for the {@link MapCollection} annotation.
 *
 * @author David H
 */
public class MapCollectionProcessor extends AnnotationProcessor<MapCollection> {

   @Override
   protected Class<MapCollection> getAnnotationClass() {
      return MapCollection.class;
   }

   @Override
   protected String getLocator(MapCollection annotation) {
      return annotation.value();
   }

   @Override
   @SuppressWarnings("unchecked")
   protected Collection<Object> transform(Object sourceValue, Field destinationField, TransformContext context)
         throws IllegalAccessException, InstantiationException {
      Collection collectionToTransform = (Collection) sourceValue;

      Collection<Object> transformedCollection = null;
      if (collectionToTransform != null) {
         ParameterizedType collectionEntryType = (ParameterizedType) destinationField.getGenericType();
         Class<?> entryType = (Class<?>) collectionEntryType.getActualTypeArguments()[0];

         transformedCollection = collectionToTransform.getClass().newInstance();
         To<?> entryTo = new To<>(entryType, context);
         for (Object entry : collectionToTransform) {
            transformedCollection.add(entryTo.from(entry));
         }
      }
      return transformedCollection;
   }
}
