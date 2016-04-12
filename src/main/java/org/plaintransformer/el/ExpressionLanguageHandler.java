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

   /**
    * Returns an expression conforming to the expression language which is to access a field
    * in the given class.
    *
    * @param c The class on which the expression will be created.
    * @param fieldName The name of the filed being accessed/used.
    * @param multipleSources True if the locator expression is to be used to locate a field
    *                        over more than one class.
    * @return an expression conforming to the expression language which is to access a field
    * in the given class.
    */
   String createLocator(Class c, String fieldName, boolean multipleSources);
}
