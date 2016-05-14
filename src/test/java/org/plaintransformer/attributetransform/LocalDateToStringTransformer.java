package org.plaintransformer.attributetransform;

import org.plaintransformer.AttributeTransformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateToStringTransformer implements AttributeTransformer<LocalDate, String> {

   private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   public String transform(LocalDate date) {
      return date.format(formatter);
   }
}
