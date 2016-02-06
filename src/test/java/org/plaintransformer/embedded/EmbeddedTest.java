package org.plaintransformer.embedded;

import org.junit.Test;
import org.plaintransformer.Transform;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class EmbeddedTest {

   @Test
   public void testTransform() throws Exception {
      Address address = new Address("line1", "line2", "town", "123");
      Customer customer = new Customer("name", 30, address, "EUR", BigDecimal.ONE, BigDecimal.TEN);

      CustomerDTO dto = Transform.to(CustomerDTO.class).from(customer);

      assertThat(dto.getName(), is(customer.getName()));
      assertThat(dto.getAge(), is(customer.getAge()));
      assertNotNull(dto.getAddress());
      assertThat(dto.getAddress().getAddressLine1(), is(address.getAddressLine1()));
      assertThat(dto.getAddress().getAddressLine2(), is(address.getAddressLine2()));
      assertThat(dto.getAddress().getPostcode(), is(address.getPostcode()));
      assertThat(dto.getAddress().getTown(), is(address.getTown()));
      assertNotNull(dto.getTotalSold());
      assertThat(dto.getTotalSold().getCurrency(), is("EUR"));
      assertThat(dto.getTotalSold().getAmount(), is(BigDecimal.ONE));
      assertNotNull(dto.getTotalSpend());
      assertThat(dto.getTotalSpend().getCurrency(), is("EUR"));
      assertThat(dto.getTotalSpend().getAmount(), is(BigDecimal.TEN));
   }
}