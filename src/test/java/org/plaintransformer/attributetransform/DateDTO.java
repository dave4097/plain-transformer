package org.plaintransformer.attributetransform;

import org.plaintransformer.Map;

public class DateDTO {

   @Map(value = "#dateWrapper.date", attributeTransformer = StringToLocalDateTransformer.class)
   private String date;

   public DateDTO() {}

   public DateDTO(String date) {
      this.date = date;
   }

   public String getDate() {
      return date;
   }
}
