package org.plaintransformer.embedded;

import org.plaintransformer.TransformFrom;
import org.plaintransformer.TransformEmbedded;
import org.plaintransformer.TransformOverride;
import org.plaintransformer.TransformOverrides;

public class CustomerDTO {

   private String name;

   private int age;

   @TransformEmbedded("#address")
   private AddressDTO address;

   @TransformEmbedded
   private MoneyDTO totalSpend;

   @TransformEmbedded
   @TransformOverrides(
         @TransformOverride(attribute="amount", transformFrom="#totalSold")
   )
   private MoneyDTO totalSold;

   public CustomerDTO() {}

   public CustomerDTO(String name, int age, AddressDTO address, MoneyDTO totalSpend, MoneyDTO totalSold) {
      this.name = name;
      this.age = age;
      this.address = address;
      this.totalSpend = totalSpend;
      this.totalSold = totalSold;
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

   public MoneyDTO getTotalSpend() {
      return totalSpend;
   }

   public MoneyDTO getTotalSold() {
      return totalSold;
   }
}
