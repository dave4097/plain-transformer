package org.plaintransformer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

/**
 * Processor for the {@link TransformFromCollection} annotation.
 *
 * @author David H
 */
public class TransformFromCollectionProcessor extends AnnotationProcessor<TransformFromCollection> {

   @Override
   protected Class<TransformFromCollection> getAnnotationClass() {
      return TransformFromCollection.class;
   }

   @Override
   protected String getLocator(TransformFromCollection annotation) {
      return annotation.value();
   }

   @Override
   @SuppressWarnings("unchecked")
   protected Collection<Object> transform(TransformContext context, Field destinationField, Object... sourceValues)
         throws IllegalAccessException, InstantiationException {
      Collection collectionToTransform = (Collection) sourceValues[0];

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
