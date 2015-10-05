package org.plaintransformer.el;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.beans.Introspector;
import java.util.HashMap;
import java.util.Map;

/**
 * A handler for the Spring Expression Language to locate fields within objects and return their values.
 *
 * @author David H
 */
public class SpelHandler implements ExpressionLanguageHandler {

   private ExpressionParser parser;

   public SpelHandler() {
      parser = new SpelExpressionParser();
   }

   @Override
   public Object getValue(String expression, Object... sources) {
      StandardEvaluationContext context = createStandardEvaluationContext(sources);
      return parser.parseExpression(expression).getValue(context);
   }

   private StandardEvaluationContext createStandardEvaluationContext(Object... sources) {
      StandardEvaluationContext context = new StandardEvaluationContext();
      context.setVariables(createSourcesMap(sources));
      return context;
   }

   private Map<String, Object> createSourcesMap(Object... sources) {
      Map<String, Object> sourcesMap = new HashMap<>();
      for (Object o : sources) {
         sourcesMap.put(Introspector.decapitalize(o.getClass().getSimpleName()), o);
      }
      return sourcesMap;
   }
}
