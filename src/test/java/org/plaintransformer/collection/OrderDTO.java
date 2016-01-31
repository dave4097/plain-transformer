package org.plaintransformer.collection;

import org.plaintransformer.TransformFrom;
import org.plaintransformer.TransformFromCollection;

import java.util.List;
import java.util.Set;

public class OrderDTO {

   @TransformFrom("#order.customerName")
   private String customerName;

   @TransformFromCollection(value = "#order.orderItemsSet")
   private Set<OrderItemDTO> orderItemsSet;

   @TransformFromCollection(value = "#order.orderItemsList")
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
