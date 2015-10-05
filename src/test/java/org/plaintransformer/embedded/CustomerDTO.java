package org.plaintransformer.embedded;

import org.plaintransformer.Map;
import org.plaintransformer.MapEmbedded;

public class CustomerDTO {

   @Map("#customer.name")
   private String name;

   @Map("#customer.age")
   private int age;

   @MapEmbedded("#customer.address")
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
