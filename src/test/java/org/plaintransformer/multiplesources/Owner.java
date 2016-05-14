package org.plaintransformer.multiplesources;

public class Owner {

   private String firstName;
   private String surname;

   public Owner(String firstName, String surname) {
      this.firstName = firstName;
      this.surname = surname;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getSurname() {
      return surname;
   }
}
