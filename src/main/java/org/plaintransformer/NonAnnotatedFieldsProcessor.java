package org.plaintransformer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class NonAnnotatedFieldsProcessor extends TransformProcessor {

   @Override
   protected <T> List<Field> getFieldsToProcess(TransformContext context, Class<T> aClass) {
      return Arrays.stream(aClass.getDeclaredFields())
            .filter(f -> hasNoTransformAnnotation(f, context))
            .collect(toList());
   }

   @Override
   protected String getLocator(TransformContext context, Field field, Object... sources) {
      List<Class<?>> classes = Arrays.stream(sources)
            .filter(s -> hasField(s.getClass(), field.getName()))
            .map(Object::getClass)
            .collect(toList());
      if (classes.isEmpty()) {
         return null;
      } else if (classes.size() == 1) {
         return context.getExpressionLanguageHandler().createLocator(classes.get(0), field.getName());
      } else {
         throw new PlainTransformerException("Multiple possible sources for field " + field.getName() + ": " + classes);
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   protected Object transform(TransformContext context, Field destinationField, Object... sourceValues) throws IllegalAccessException, InstantiationException {
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

   private boolean hasField(Class c, String fieldName) {
      return Arrays.stream(c.getDeclaredFields())
            .map(Field::getName)
            .anyMatch(n -> n.equals(fieldName));
   }
}
