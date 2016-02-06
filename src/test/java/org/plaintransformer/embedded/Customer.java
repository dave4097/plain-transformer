package org.plaintransformer.embedded;

import java.math.BigDecimal;

public class Customer {

   private String name;
   private int age;
   private Address address;
   private String currency;
   private BigDecimal totalSold;
   private BigDecimal totalSpend;

   public Customer(String name, int age, Address address, String currency, BigDecimal totalSold, BigDecimal totalSpend) {
      this.name = name;
      this.age = age;
      this.address = address;
      this.currency = currency;
      this.totalSold = totalSold;
      this.totalSpend = totalSpend;
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

   public String getCurrency() {
      return currency;
   }

   public BigDecimal getTotalSold() {
      return totalSold;
   }

   public BigDecimal getTotalSpend() {
      return totalSpend;
   }
}
