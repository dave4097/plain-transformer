package org.plaintransformer.embedded;

public class Customer {

   private String name;
   private int age;
   private Address address;

   public Customer(String name, int age, Address address) {
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

   public Address getAddress() {
      return address;
   }
}
