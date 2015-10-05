package org.plaintransformer;

/**
 * An attribute transformer that simply returns the object it's given.
 *
 * @author David H
 */
class DefaultAttributeTransformer implements AttributeTransformer<Object, Object> {

   DefaultAttributeTransformer() {}

   @Override
   public Object transform(Object value) {
      return value;
   }
}
