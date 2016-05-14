package org.plaintransformer;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

class NonAnnotatedFieldsProcessor extends TransformProcessor {

   @Override
   protected List<Field> getFieldsToProcess(TransformContext context, Class aClass) {
      if (context.config().isTransformAnnotatedFieldsOnly()) {
         return Collections.emptyList();
      }
      List<Field> fields = FieldUtils.getAllFieldsList(aClass);
      if (fields.size() == context.getFieldsTransformed().size()) {
         return Collections.emptyList();
      }
      return fields.stream()
            .filter(f -> isFieldYetToBeTransformed(f, context))
            .collect(toList());
   }

   @Override
   protected String getLocator(TransformContext context, Field field, Object... sources) {
      String fieldName = field.getName();
      if (sources.length == 1) {
         return context.config().getExpressionLanguageHandler().createLocator(sources[0].getClass(), fieldName, false);
      }

      List<Class> classes = getSourceClass(sources, fieldName);
      if (classes.size() == 1) {
         return context.config().getExpressionLanguageHandler().createLocator(classes.get(0), fieldName, sources.length > 1);
      } else if (classes.isEmpty()) {
         throw new PlainTransformerException("Cannot derive source class for field " + fieldName +
               ", numSources=" + sources.length);
      } else {
         throw new PlainTransformerException("Multiple possible sources for field " + fieldName +
               ", numSources=" + sources.length);
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   protected Object transform(TransformContext context, Field destinationField, AttributeTransformData transformOverride, Object... sourceValues)
         throws IllegalAccessException, InstantiationException {
      return sourceValues[0];
   }

   private boolean isFieldYetToBeTransformed(Field field, TransformContext transformContext) {
      return !transformContext.getFieldsTransformed().contains(field.getName());
   }

   private List<Class> getSourceClass(Object[] sources, String fieldName) {
      return Arrays.stream(sources)
            .filter(s -> hasField(s.getClass(), fieldName))
            .map(Object::getClass)
            .collect(toList());
   }

   private boolean hasField(Class c, String fieldName) {
      return FieldUtils.getAllFieldsList(c).stream()
            .map(Field::getName)
            .anyMatch(n -> n.equals(fieldName));
   }
}
