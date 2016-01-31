package org.plaintransformer;

import org.plaintransformer.el.ExpressionLanguageHandler;
import org.plaintransformer.el.SpelHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * The settings to use for a transformation.
 *
 * @author David H
 */
public class TransformContext {

   private Set<AnnotationProcessor> annotationProcessors = new HashSet<>();
   private ExpressionLanguageHandler expressionLanguageHandler;

   private TransformContext() {
      annotationProcessors.add(new TransformFromProcessor());
      annotationProcessors.add(new TransformFromCollectionProcessor());
      annotationProcessors.add(new TransformEmbeddedProcessor());
      expressionLanguageHandler = new SpelHandler();
   }

   /**
    * Sets up a default transform context. This includes processors for the standard annotations and a
    * Spring expression language handler.
    *
    * @return a default transform context.
    */
   public static TransformContext defaultContext() {
      return new TransformContext();
   }

   /**
    * Overrides the {@link ExpressionLanguageHandler} and returns the updated context. Use this when a you want
    * to use something other than the Spring Expression Language.
    *
    * @param expressionLanguageHandler The handler for the expression language.
    * @return The updated context.
    */
   public TransformContext expressionLanguageHandler(ExpressionLanguageHandler expressionLanguageHandler) {
      this.expressionLanguageHandler = expressionLanguageHandler;
      return this;
   }

   /**
    * Adds an {@link AnnotationProcessor} for a custom annotation - see {@link AnnotationProcessor}.
    *
    * @param annotationProcessor A processor for a custom annotation.
    * @return The update context.
    */
   public TransformContext addAnnotationProcessor(AnnotationProcessor annotationProcessor) {
      annotationProcessors.add(annotationProcessor);
      return this;
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
    * Returns the {@link ExpressionLanguageHandler} to use for a transformation.
    *
    * @return the {@link ExpressionLanguageHandler} to use for a transformation.
    */
   ExpressionLanguageHandler getExpressionLanguageHandler() {
      return expressionLanguageHandler;
   }
}
