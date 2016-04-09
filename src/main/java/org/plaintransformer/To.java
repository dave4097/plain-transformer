package org.plaintransformer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toSet;

/**
 * Executes a transformation to T from given source objects.
 *
 * @author David H
 * @param <T> The type of the object that results from the transformation.
 */
public class To<T> {

   private Class<T> annotatedClass;
   private TransformContext transformContext;
   private Map<String, AttributeTransformData> transformOverrides;
   private NonAnnotatedFieldsProcessor nonAnnotatedFieldsProcessor;

   /**
    * Constructor for internal use.
    *
    * @param annotatedClass The class for the object that results from the transformation.
    * @param transformContext The settings for the transformation.
    */
   To(Class<T> annotatedClass, TransformContext transformContext) {
      this(annotatedClass, new HashMap<>(), transformContext);
   }

   /**
    * Constructor for internal use.
    *
    * @param annotatedClass The class for the object that results from the transformation.
    * @param transformOverrides Optional overrides for the attribute mappings.
    * @param transformContext The settings for the transformation.
    */
   To(Class<T> annotatedClass, Map<String, AttributeTransformData> transformOverrides, TransformContext transformContext) {
      this.annotatedClass = annotatedClass;
      this.transformOverrides = transformOverrides;
      this.transformContext = transformContext;
      this.nonAnnotatedFieldsProcessor = new NonAnnotatedFieldsProcessor();
   }

   /**
    * Returns the result of transforming the given objects to T. This can be a many-to-one transformation.
    *
    * @param sources execute a transformation of these objects.
    * @return the result of transforming the given objects to T.
    */
   public final T from(Object... sources) {
      T instance;
      try {
         instance = annotatedClass.newInstance();
         for (AnnotationProcessor annotationProcessor : transformContext.getAnnotationProcessors()) {
            annotationProcessor.process(transformContext, instance, transformOverrides, sources);
         }
         nonAnnotatedFieldsProcessor.process(transformContext, instance, transformOverrides, sources);
      } catch (Exception e) {
         throw new PlainTransformerException(e);
      }
      return instance;
   }

   /**
    * Returns the result of transforming each entry in the given collection to an instance of T. This is
    * a one-to-one transformation.
    *
    * @param sourcesToMap the objects to transform.
    * @return the result of transforming each entry in the given collection to an instance of T.
    */
   public final Collection<T> fromCollectionOf(Collection<?> sourcesToMap) {
      return sourcesToMap.stream().map(this::from).collect(toSet());
   }
}
