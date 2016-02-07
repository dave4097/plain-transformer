package org.plaintransformer.flat;

public class Customer {

   private String name;
   private Address address;
   private String nickName;

   public Customer(String name, Address address, String nickName) {
      this.name = name;
      this.address = address;
      this.nickName = nickName;
   }

   public String getName() {
      return name;
   }

   public Address getAddress() {
      return address;
   }

   public String getNickName() {
      return nickName;
   }
}
