package org.plaintransformer.flat;

public class Address {

   private String addressLine1;
   private String addressLine2;
   private String town;
   private String postcode;

   public Address(String addressLine1, String addressLine2, String town, String postcode) {
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
