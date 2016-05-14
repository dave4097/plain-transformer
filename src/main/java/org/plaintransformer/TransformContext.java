package org.plaintransformer;

import java.util.HashSet;
import java.util.Set;

/**
 * The context for the current transformation to use for a transformation.
 *
 * @author David H
 */
public class TransformContext {

   private final TransformConfig transformConfig;
   private final Set<String> fieldsTransformed;

   public TransformContext(TransformConfig transformConfig) {
      this.transformConfig = transformConfig;
      this.fieldsTransformed = new HashSet<>();
   }

   public TransformConfig config() {
      return transformConfig;
   }

   public void addTransformedFieldName(String name) {
      fieldsTransformed.add(name);
   }

   public Set<String> getFieldsTransformed() {
      return fieldsTransformed;
   }
}
