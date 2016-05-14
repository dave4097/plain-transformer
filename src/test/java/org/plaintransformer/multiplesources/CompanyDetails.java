package org.plaintransformer.multiplesources;

public class CompanyDetails {

   private String name;
   private String registrationNumber;

   public CompanyDetails(String name, String registrationNumber) {
      this.name = name;
      this.registrationNumber = registrationNumber;
   }

   public String getName() {
      return name;
   }

   public String getRegistrationNumber() {
      return registrationNumber;
   }
}
