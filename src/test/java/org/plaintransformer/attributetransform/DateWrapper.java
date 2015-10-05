package org.plaintransformer.attributetransform;

import java.time.LocalDate;

public class DateWrapper {

   private LocalDate date;

   public DateWrapper(LocalDate date) {
      this.date = date;
   }

   public LocalDate getDate() {
      return date;
   }
}
