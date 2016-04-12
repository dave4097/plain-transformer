package org.plaintransformer.el;

import org.plaintransformer.PlainTransformerException;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParseException;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.beans.Introspector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * A handler for the Spring Expression Language to locate fields within objects and return their values.
 *
 * @author David H
 */
public class SpelHandler implements ExpressionLanguageHandler {

   private static final String DEFAULT_KEY = "source";
   private static final String DEFAULT_PREFIX = "#" + DEFAULT_KEY;

   private ExpressionParser parser;

   public SpelHandler() {
      parser = new SpelExpressionParser();
   }

   @Override
   public Object getValue(String expression, Object... sources) {
      StandardEvaluationContext context = createStandardEvaluationContext(sources);
      String adaptedExpression = adaptExpression(expression, sources);
      try {
         return parser.parseExpression(adaptedExpression).getValue(context);
      } catch (EvaluationException e) {
         throw new PlainTransformerException("Invalid locator, expression=" + adaptedExpression + ". " +
               "When transforming from a single source, field names should be prefixed with 'source' or be without a prefix. " +
               "When transforming from multiple sources, field names should be prefixed with a camel case class name (beware of proxies!).", e);
      } catch (Exception e) {
         throw new PlainTransformerException("Error parsing locator, expression=" + adaptedExpression, e);
      }
   }

   @Override
   public String createLocator(Class c, String fieldName, boolean multipleSources) {
      String prefix = "#" + (multipleSources ? adaptClassName(c) : DEFAULT_KEY) + ".";
      return prefix + fieldName;
   }

   private StandardEvaluationContext createStandardEvaluationContext(Object... sources) {
      StandardEvaluationContext context = new StandardEvaluationContext();
      context.setVariables(createSourcesMap(sources));
      return context;
   }

   private Map<String, Object> createSourcesMap(Object... sources) {
      Map<String, Object> sourcesMap = new HashMap<>();
      if (sources.length == 1) {
         sourcesMap.put(DEFAULT_KEY, sources[0]);
      } else {
         sourcesMap = Arrays.stream(sources)
                            .collect(toMap(o -> adaptClassName(o.getClass()), o -> o));
      }
      return sourcesMap;
   }

   private String adaptClassName(Class c) {
      return Introspector.decapitalize(c.getSimpleName());
   }

   private String adaptExpression(String expression, Object... sources) {
      if (sources.length == 1 && !expression.startsWith(DEFAULT_PREFIX)) {
         return expression.replaceFirst("#", DEFAULT_PREFIX + ".");
      }
      return expression;
   }
}
