package org.plaintransformer.customannotation;

public class StatisticsDTO {

   @TotalFor("Jing")
   private int totalForJing;

   @TotalFor("David")
   private int totalForDavid;

   @TotalFor("Cara")
   private int totalForCara;

   @TotalFor({"Jing", "David", "Cara"})
   private int totalForAll;

   public int getTotalForJing() {
      return totalForJing;
   }

   public int getTotalForDavid() {
      return totalForDavid;
   }

   public int getTotalForCara() {
      return totalForCara;
   }

   public int getTotalForAll() {
      return totalForAll;
   }
}
