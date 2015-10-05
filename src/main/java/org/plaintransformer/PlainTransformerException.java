package org.plaintransformer;

/**
 * Catch all exception for errors during a transformation.
 *
 * @author David H
 */
public class PlainTransformerException extends RuntimeException {

   public PlainTransformerException(Throwable cause) {
      super(cause);
   }

   public PlainTransformerException(String message, Throwable cause) {
      super(message, cause);
   }
}
