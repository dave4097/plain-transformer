package org.plaintransformer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

class NonAnnotatedFieldsProcessor extends TransformProcessor {

   @Override
   protected <T> List<Field> getFieldsToProcess(TransformContext context, Class<T> aClass) {
      if (aClass.isAnnotationPresent(TransformUsingAnnotationsOnly.class)) {
         return Collections.emptyList();
      }
      return Arrays.stream(aClass.getDeclaredFields())
            .filter(f -> hasNoTransformAnnotation(f, context))
            .collect(toList());
   }

   @Override
   protected String getLocator(TransformContext context, Field field, Object... sources) {
      if (sources.length == 0) {
         return "";
      } else if (sources.length == 1) {
         return context.getExpressionLanguageHandler().createLocator(sources[0].getClass(), field.getName(), false);
      } else {
         throw new PlainTransformerException("Multiple possible sources for field " + field.getName() +
               ", numSources=" + sources.length);
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   protected Object transform(TransformContext context, Field destinationField, AttributeTransformData transformOverride, Object... sourceValues)
         throws IllegalAccessException, InstantiationException {
      return sourceValues[0];
   }

   private boolean hasNoTransformAnnotation(Field field, TransformContext transformContext) {
      for (AnnotationProcessor<?> annotationProcessor : transformContext.getAnnotationProcessors()) {
         if (field.isAnnotationPresent(annotationProcessor.getAnnotationClass())) {
            return false;
         }
      }
      return true;
   }
}
