package org.plaintransformer.el;

/**
 * To use an expression language for locating fields within an object, implement this interface.
 *
 * @author David H
 */
public interface ExpressionLanguageHandler {

   /**
    * Returns the value of a field within one of the given source objects using the given expression.
    *
    * @param expression The expression to locate the field in one of the source objects.
    * @param sources The sources in which to fine the field.
    * @return the value of a field within one of the given source objects using the given expression.
    */
   Object getValue(String expression, Object... sources);
}
