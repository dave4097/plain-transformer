package org.plaintransformer.flat;

import org.junit.Test;
import org.plaintransformer.Transform;
import org.plaintransformer.TransformConfig;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class FlatTransformerTest {

   @Test
   public void testTransformSingle() throws Exception {
      Address address = new Address("line1", "line2", "town", "123");
      Customer customer = new Customer("Dave", address, "nickName");

      TransformConfig transformConfig = new TransformConfig.Builder().transformAnnotatedFieldsOnly(true).build();

      CustomerDTO dto = Transform.to(CustomerDTO.class, transformConfig).from(customer);

      assertThat(dto.getName(), is("Dave"));
      assertThat(dto.getAddressLine1(), is("line1"));
      assertThat(dto.getAddressLine2(), is("line2"));
      assertThat(dto.getTown(), is("town"));
      assertThat(dto.getPostcode(), is("123"));
      assertNull(dto.getNickName());
   }

   @Test
   public void testTransformCollection() throws Exception {
      Address address1 = new Address("Apt 1", "Street", "City", "123");
      Customer customer1 = new Customer("Dave", address1, "nickName");
      Address address2 = new Address("The mannor", "Countryside", "Town", "456");
      Customer customer2 = new Customer("Jing", address2, "nickName");

      Collection<CustomerDTO> dtos = Transform.to(CustomerDTO.class).fromCollectionOf(asList(customer1, customer2));

      assertThat(dtos.size(), is(2));
   }
}