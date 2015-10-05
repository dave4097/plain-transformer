package org.plaintransformer.collection;

import java.math.BigDecimal;

public class OrderItem {

   private String productName;
   private BigDecimal price;
   private int quantity;

   public OrderItem(String productName, BigDecimal price, int quantity) {
      this.productName = productName;
      this.price = price;
      this.quantity = quantity;
   }

   public String getProductName() {
      return productName;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public int getQuantity() {
      return quantity;
   }
}
