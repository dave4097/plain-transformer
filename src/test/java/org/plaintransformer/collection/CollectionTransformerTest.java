package org.plaintransformer.collection;

import org.junit.Test;
import org.plaintransformer.Transform;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CollectionTransformerTest {

   @Test
   public void testTransform() throws Exception {
      OrderItem orderItem = new OrderItem("product", BigDecimal.TEN, 1);
      Order order = new Order("name");
      order.addOrderItem(orderItem);

      OrderDTO dto = Transform.to(OrderDTO.class).from(order);

      assertThat(dto.getCustomerName(), is(order.getCustomerName()));
      assertNotNull(dto.getOrderItemsList());
      OrderItemDTO orderItemDTO1 = dto.getOrderItemsList().get(0);
      assertThat(orderItemDTO1.getPrice(), is(orderItem.getPrice()));
      assertThat(orderItemDTO1.getProductName(), is(orderItem.getProductName()));
      assertThat(orderItemDTO1.getQuantity(), is(orderItem.getQuantity()));
      OrderItemDTO orderItemDTO2 = dto.getOrderItemsSet().iterator().next();
      assertThat(orderItemDTO2.getPrice(), is(orderItem.getPrice()));
      assertThat(orderItemDTO2.getProductName(), is(orderItem.getProductName()));
      assertThat(orderItemDTO2.getQuantity(), is(orderItem.getQuantity()));
   }
}