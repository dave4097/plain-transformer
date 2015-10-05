package org.plaintransformer.collection;

import org.plaintransformer.Map;
import org.plaintransformer.MapCollection;

import java.util.List;
import java.util.Set;

public class OrderDTO {

   @Map("#order.customerName")
   private String customerName;

   @MapCollection(value = "#order.orderItemsSet")
   private Set<OrderItemDTO> orderItemsSet;

   @MapCollection(value = "#order.orderItemsList")
   private List<OrderItemDTO> orderItemsList;

   public OrderDTO() {}

   public OrderDTO(String customerName, Set<OrderItemDTO> orderItemsSet, List<OrderItemDTO> orderItemsList) {
      this.customerName = customerName;
      this.orderItemsSet = orderItemsSet;
      this.orderItemsList = orderItemsList;
   }

   public String getCustomerName() {
      return customerName;
   }

   public Set<OrderItemDTO> getOrderItemsSet() {
      return orderItemsSet;
   }

   public List<OrderItemDTO> getOrderItemsList() {
      return orderItemsList;
   }
}
