package org.plaintransformer;

import org.plaintransformer.el.ExpressionLanguageHandler;
import org.plaintransformer.el.SpelHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * The configuration for the transformation.
 */
public class TransformConfig {

   private final Set<AnnotationProcessor> annotationProcessors;
   private final ExpressionLanguageHandler expressionLanguageHandler;
   private final boolean transformAnnotatedFieldsOnly;

   private TransformConfig(Builder builder) {
      this.annotationProcessors = new HashSet<>(builder.annotationProcessors);
      this.expressionLanguageHandler = builder.expressionLanguageHandler;
      this.transformAnnotatedFieldsOnly = builder.transformAnnotatedFieldsOnly;
   }

   /**
    * Sets up a default transform config. This includes processors for the standard annotations and a
    * Spring expression language handler.
    *
    * @return a default transform config.
    */
   public static TransformConfig defaultConfig() {
      return new Builder().build();
   }

   /**
    * Returns the {@link ExpressionLanguageHandler} to use for a transformation.
    *
    * @return the {@link ExpressionLanguageHandler} to use for a transformation.
    */
   ExpressionLanguageHandler getExpressionLanguageHandler() {
      return expressionLanguageHandler;
   }

   /**
    * Returns the set of {@link AnnotationProcessor} to perform a transformation.
    *
    * @return the set of {@link AnnotationProcessor} to perform a transformation.
    */
   Set<AnnotationProcessor> getAnnotationProcessors() {
      return annotationProcessors;
   }

   /**
    * Returns the setting that indicates if only annotated fields should be transformed.
    *
    * @return the setting that indicates if only annotated fields should be transformed.
    */
   boolean isTransformAnnotatedFieldsOnly() {
      return transformAnnotatedFieldsOnly;
   }

   public static class Builder {

      private Set<AnnotationProcessor> annotationProcessors = new HashSet<>();
      private ExpressionLanguageHandler expressionLanguageHandler;
      private boolean transformAnnotatedFieldsOnly;

      /**
       * Creates a builder with the default configuration.
       */
      public Builder() {
         this.annotationProcessors.add(new TransformFromProcessor());
         this.annotationProcessors.add(new TransformFromCollectionProcessor());
         this.annotationProcessors.add(new TransformEmbeddedProcessor());
         this.expressionLanguageHandler = new SpelHandler();
      }

      /**
       * Creates a builder with the setting from an existing configuration.
       */
      public Builder(TransformConfig toCopy) {
         this.annotationProcessors = toCopy.annotationProcessors;
         this.expressionLanguageHandler = toCopy.expressionLanguageHandler;
         this.transformAnnotatedFieldsOnly = toCopy.transformAnnotatedFieldsOnly;
      }

      /**
       * Overrides the {@link ExpressionLanguageHandler} and returns the updated config. Use this when a you want
       * to use something other than the Spring Expression Language.
       *
       * @param val The handler for the expression language.
       * @return The config builder.
       */
      public Builder expressionLanguageHandler(ExpressionLanguageHandler val) {
         this.expressionLanguageHandler = val;
         return this;
      }

      /**
       * Adds an {@link AnnotationProcessor} for a custom annotation - see {@link AnnotationProcessor}.
       *
       * @param val A processor for a custom annotation.
       * @return The config builder.
       */
      public Builder addAnnotationProcessor(AnnotationProcessor val) {
         this.annotationProcessors.add(val);
         return this;
      }

      /**
       * Set to true if only fields that are annotated should be transformed. If set to false (default)
       * then Plain Transformer will attempt transform all fields.
       *
       * @return The config builder.
       */
      public Builder transformAnnotatedFieldsOnly() {
         this.transformAnnotatedFieldsOnly = true;
         return this;
      }

      public TransformConfig build() {
         return new TransformConfig(this);
      }
   }
}
