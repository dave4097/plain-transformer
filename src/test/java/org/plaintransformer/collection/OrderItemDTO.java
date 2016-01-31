package org.plaintransformer.collection;

import org.plaintransformer.TransformFrom;

import java.math.BigDecimal;

public class OrderItemDTO {

   @TransformFrom("#orderItem.productName")
   private String productName;

   @TransformFrom("#orderItem.price")
   private BigDecimal price;

   @TransformFrom("#orderItem.quantity")
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
