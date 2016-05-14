package org.plaintransformer.performance;

import org.junit.BeforeClass;
import org.junit.Test;
import org.plaintransformer.Transform;

public class PerformanceTest {

   private static Domain domain = new Domain(
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field",
         "field"
   );

   @BeforeClass
   public static void warmUp() {
      long start1 = System.currentTimeMillis();
      Transform.to(AnnotatedDTO.class).from(domain);
      long end1 = System.currentTimeMillis();
      System.out.println("Warm up : " + (end1 - start1));
   }

   @Test
   public void testPerformanceOfTransformer() throws Exception {
      long start = System.currentTimeMillis();
      DomainTransformer transform = new DomainTransformer();
      transform.toDTO(domain);
      long end = System.currentTimeMillis();
      System.out.println("Not PT: " + (end - start));
   }

   @Test
   public void testPerformanceWithAnnotations() throws Exception {
      long start = System.currentTimeMillis();
      Transform.to(AnnotatedDTO.class).from(domain);
      long end = System.currentTimeMillis();
      System.out.println("Annotated : " + (end - start));
   }

   @Test
   public void testPerformanceWithoutAnnotations() throws Exception {
      long start = System.currentTimeMillis();
      Transform.to(NonAnnotatedDTO.class).from(domain);
      long end = System.currentTimeMillis();
      System.out.println("Non-annotated 1 : " + (end - start));
      long start2 = System.currentTimeMillis();
      Transform.to(NonAnnotatedDTO.class).from(domain);
      long end2 = System.currentTimeMillis();
      System.out.println("Non-annotated 2 : " + (end2 - start2));
   }
}
