package org.plaintransformer.multiplesources;

import org.junit.Test;
import org.plaintransformer.Transform;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MultipleSourcesTest {

   @Test
   public void shouldTransform() throws Exception {
      CompanyDetails companyDetails = new CompanyDetails("name", "123");
      Owner owner = new Owner("John", "Doe");

      CompanyDTO companyDTO = Transform.to(CompanyDTO.class).from(companyDetails, owner);

      assertThat(companyDTO.getName(), is("name"));
      assertThat(companyDTO.getRegistrationNumber(), is("123"));
      assertThat(companyDTO.getOwnerFirstName(), is("John"));
      assertThat(companyDTO.getOwnerSurname(), is("Doe"));
   }
}
