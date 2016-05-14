package org.plaintransformer.customannotation;

import org.plaintransformer.AnnotationProcessor;
import org.plaintransformer.AttributeTransformData;
import org.plaintransformer.TransformContext;

import java.lang.reflect.Field;

public class TotalForProcessor extends AnnotationProcessor<TotalFor> {

   @Override
   protected Class<TotalFor> getAnnotationClass() {
      return TotalFor.class;
   }

   @Override
   protected String getLocator(TotalFor annotation) {
      return annotation.transformFrom();
   }

   @Override
   protected Object transform(TransformContext context,
                              Field destinationField,
                              AttributeTransformData transformOverride,
                              Object... sources) throws IllegalAccessException, InstantiationException {
      TotalFor annotation = destinationField.getAnnotationsByType(getAnnotationClass())[0];
      String[] names = annotation.value();
      Statistics statistics = (Statistics) sources[0];
      return statistics.getTotalFor(names);
   }
}
