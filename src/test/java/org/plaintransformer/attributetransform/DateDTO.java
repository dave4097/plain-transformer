package org.plaintransformer.attributetransform;

import org.plaintransformer.TransformFrom;

public class DateDTO {

   @TransformFrom(value = "#date", attributeTransformer = LocalDateToStringTransformer.class)
   private String date;

   public DateDTO() {}

   public DateDTO(String date) {
      this.date = date;
   }

   public String getDate() {
      return date;
   }
}
