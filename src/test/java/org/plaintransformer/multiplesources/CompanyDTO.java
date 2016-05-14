package org.plaintransformer.multiplesources;

import org.plaintransformer.TransformFrom;

public class CompanyDTO {

   @TransformFrom("#owner.firstName")
   private String ownerFirstName;

   @TransformFrom("#owner.surname")
   private String ownerSurname;

   @TransformFrom("#companyDetails.name")
   private String name;

   private String registrationNumber;

   public CompanyDTO() {}

   public CompanyDTO(String ownerFirstName, String ownerSurname, String name, String registrationNumber) {
      this.ownerFirstName = ownerFirstName;
      this.ownerSurname = ownerSurname;
      this.name = name;
      this.registrationNumber = registrationNumber;
   }

   public String getOwnerFirstName() {
      return ownerFirstName;
   }

   public String getOwnerSurname() {
      return ownerSurname;
   }

   public String getName() {
      return name;
   }

   public String getRegistrationNumber() {
      return registrationNumber;
   }
}
