package org.plaintransformer.embedded;

import org.plaintransformer.TransformFrom;
import org.plaintransformer.TransformEmbedded;

public class CustomerDTO {

   @TransformFrom("#customer.name")
   private String name;

   @TransformFrom("#customer.age")
   private int age;

   @TransformEmbedded("#customer.address")
   private AddressDTO address;

   public CustomerDTO() {}

   public CustomerDTO(String name, int age, AddressDTO address) {
      this.name = name;
      this.age = age;
      this.address = address;
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public AddressDTO getAddress() {
      return address;
   }
}
