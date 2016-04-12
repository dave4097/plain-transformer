package org.plaintransformer.embedded;

import org.plaintransformer.TransformFrom;

import java.math.BigDecimal;

public class MoneyDTO {

   @TransformFrom("#currency")
   private String currency;

   @TransformFrom("#totalSpend")
   private BigDecimal amount;

   public MoneyDTO() {}

   public MoneyDTO(String currency, BigDecimal amount) {
      this.currency = currency;
      this.amount = amount;
   }

   public String getCurrency() {
      return currency;
   }

   public BigDecimal getAmount() {
      return amount;
   }
}
