package org.plaintransformer.flat;

import org.plaintransformer.TransformFrom;

public class CustomerDTO {

   @TransformFrom("#name")
   private String name;

   @TransformFrom("#address.addressLine1")
   private String addressLine1;

   @TransformFrom("#address.addressLine2")
   private String addressLine2;

   @TransformFrom("#address.town")
   private String town;

   @TransformFrom("#address.postcode")
   private String postcode;

   private String nickName;

   public CustomerDTO() {}

   public CustomerDTO(String name, String addressLine1, String addressLine2, String town, String postcode, String nickName) {
      this.name = name;
      this.addressLine1 = addressLine1;
      this.addressLine2 = addressLine2;
      this.town = town;
      this.postcode = postcode;
      this.nickName = nickName;
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

   public String getNickName() {
      return nickName;
   }
}
