package org.plaintransformer.el;

import org.junit.Test;
import org.plaintransformer.PlainTransformerException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpelHandlerTest {

   private SpelHandler spelHandler = new SpelHandler();

   @Test
   public void shouldGenerateLocatorExpressionForSingleSource() throws Exception {
      String locator = spelHandler.createLocator(Object.class, "hello", false);

      assertThat(locator, is("#source.hello"));
   }

   @Test
   public void shouldGenerateLocatorExpressionForMultiSource() throws Exception {
      String locator = spelHandler.createLocator(Object.class, "hello", true);

      assertThat(locator, is("#object.hello"));
   }

   @Test
   public void shouldEvaluateExpressionForSingleSource_1() throws Exception {
      Object value = spelHandler.getValue("#field1", new MyClass("test"));

      assertThat(value, is("test"));
   }

   @Test
   public void shouldEvaluateExpressionForSingleSource_2() throws Exception {
      Object value = spelHandler.getValue("#source.field1", new MyClass("test"));

      assertThat(value, is("test"));
   }

   @Test
   public void shouldEvaluateExpressionForMultiSource_1() throws Exception {
      Object value = spelHandler.getValue("#myClass.field1", new MyClass("test"), new Object());

      assertThat(value, is("test"));
   }

   @Test(expected = PlainTransformerException.class)
   public void shouldThrowExceptionWhenLocatorIsInvalid() throws Exception {
      spelHandler.getValue("#source.field1", new MyClass("test"), new Object());
   }

   private class MyClass {
      private String field1;

      MyClass(String field1) {
         this.field1 = field1;
      }

      public String getField1() {
         return field1;
      }
   }
}