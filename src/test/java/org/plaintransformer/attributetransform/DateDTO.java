package org.plaintransformer.attributetransform;

import org.plaintransformer.TransformFrom;

public class DateDTO {

   @TransformFrom(value = "#dateWrapper.date", attributeTransformer = StringToLocalDateTransformer.class)
   private String date;

   public DateDTO() {}

   public DateDTO(String date) {
      this.date = date;
   }

   public String getDate() {
      return date;
   }
}
