package org.plaintransformer.attributetransform;

import org.plaintransformer.AttributeTransformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateToStringTransformer implements AttributeTransformer<LocalDate, String> {

   private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

   public String transform(LocalDate date) {
      return date.format(FORMATTER);
   }
}
