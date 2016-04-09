package org.plaintransformer;

public class AttributeTransformData {

   private final String transformFrom;

   private final Class<? extends AttributeTransformer> attributeTransformer;

   public AttributeTransformData(String transformFrom) {
      this(transformFrom, null);
   }

   public AttributeTransformData(String transformFrom, Class<? extends AttributeTransformer> attributeTransformer) {
      this.transformFrom = transformFrom;
      this.attributeTransformer = attributeTransformer;
   }

   public String getTransformFrom() {
      return transformFrom;
   }

   public Class<? extends AttributeTransformer> getAttributeTransformer() {
      return attributeTransformer;
   }
}