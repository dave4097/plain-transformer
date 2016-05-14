package org.plaintransformer.customannotation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Statistics {

   private Map<String, Integer> totals;

   public Statistics() {
      totals = new HashMap<>();
      totals.put("Jing", 5);
      totals.put("David", 10);
      totals.put("Cara", 6);
   }

   public int getTotalFor(String... name) {
      return Arrays.stream(name)
            .mapToInt(n -> totals.get(n))
            .sum();
   }
}
