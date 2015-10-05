package org.plaintransformer.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order {

   private String customerName;
   private Set<OrderItem> orderItemsSet;
   private List<OrderItem> orderItemsList;

   public Order(String customerName) {
      this.customerName = customerName;
      this.orderItemsSet = new HashSet<>();
      this.orderItemsList = new ArrayList<>();
   }

   public void addOrderItem(OrderItem orderItem) {
      this.orderItemsSet.add(orderItem);
      this.orderItemsList.add(orderItem);
   }

   public String getCustomerName() {
      return customerName;
   }

   public Set<OrderItem> getOrderItemsSet() {
      return orderItemsSet;
   }

   public List<OrderItem> getOrderItemsList() {
      return orderItemsList;
   }
}
