package org.plaintransformer.flat;

import org.plaintransformer.TransformFrom;

public class CustomerDTO {

   @TransformFrom("#customer.name")
   private String name;

   @TransformFrom("#customer.address.addressLine1")
   private String addressLine1;

   @TransformFrom("#customer.address.addressLine2")
   private String addressLine2;

   @TransformFrom("#customer.address.town")
   private String town;

   @TransformFrom("#customer.address.postcode")
   private String postcode;

   public CustomerDTO() {}

   public CustomerDTO(String name, String addressLine1, String addressLine2, String town, String postcode) {
      this.name = name;
      this.addressLine1 = addressLine1;
      this.addressLine2 = addressLine2;
      this.town = town;
      this.postcode = postcode;
   }

   public String getName() {
      return name;
   }

   public String getAddressLine1() {
      return addressLine1;
   }

   public String getAddressLine2() {
      return addressLine2;
   }

   public String getTown() {
      return town;
   }

   public String getPostcode() {
      return postcode;
   }
}
