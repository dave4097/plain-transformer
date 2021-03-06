package org.plaintransformer.embedded;

import org.plaintransformer.TransformFrom;

public class AddressDTO {

   @TransformFrom("#addressLine1")
   private String addressLine1;

   @TransformFrom("#addressLine2")
   private String addressLine2;

   @TransformFrom("#town")
   private String town;

   @TransformFrom("#postcode")
   private String postcode;

   public AddressDTO() {}

   public AddressDTO(String addressLine1, String addressLine2, String town, String postcode) {
      this.addressLine1 = addressLine1;
      this.addressLine2 = addressLine2;
      this.town = town;
      this.postcode = postcode;
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
