package org.plaintransformer.attributetransform;

import org.junit.Test;
import org.plaintransformer.Transform;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

public class AttributeTransformTest {

   @Test
   public void testTransform() {
      DateWrapper dateWrapper = new DateWrapper(LocalDate.now());

      DateDTO dto = Transform.to(DateDTO.class).from(dateWrapper);

      assertNotNull(dto.getDate());
   }
}