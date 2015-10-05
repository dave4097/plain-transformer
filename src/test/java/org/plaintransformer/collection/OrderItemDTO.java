package org.plaintransformer.collection;

import org.plaintransformer.Map;

import java.math.BigDecimal;

public class OrderItemDTO {

   @Map("#orderItem.productName")
   private String productName;

   @Map("#orderItem.price")
   private BigDecimal price;

   @Map("#orderItem.quantity")
   private int quantity;

   public OrderItemDTO() {}

   public OrderItemDTO(String productName, BigDecimal price, int quantity) {
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
