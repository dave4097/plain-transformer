package org.plaintransformer.customannotation;

import org.junit.Test;
import org.plaintransformer.Transform;
import org.plaintransformer.TransformConfig;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomAnnotationTest {

   @Test
   public void shouldTransform() throws Exception {
      Statistics statistics = new Statistics();

      TransformConfig transformConfig = new TransformConfig.Builder()
            .addAnnotationProcessor(new TotalForProcessor())
            .build();
      StatisticsDTO statisticsDTO = Transform.to(StatisticsDTO.class, transformConfig).from(statistics);

      assertThat(statisticsDTO.getTotalForJing(), is(5));
      assertThat(statisticsDTO.getTotalForDavid(), is(10));
      assertThat(statisticsDTO.getTotalForCara(), is(6));
      assertThat(statisticsDTO.getTotalForAll(), is(21));
   }
}
