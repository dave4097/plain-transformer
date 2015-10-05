package org.plaintransformer;

/**
 * Extend this interface to create a custom transformer for an attribute. An example of its use would be to convert
 * a {@link java.time.LocalDate} field to a {@link String}
 *
 * @param <F> The type to transform from.
 * @param <T> The type to transform to.
 */
public interface AttributeTransformer<F, T> {

   /**
    * Transforms a value of type F to type T.
    *
    * @param value The value to transform.
    * @return a transformed value.
    */
   T transform(F value);
}
