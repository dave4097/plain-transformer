package org.plaintransformer.performance;

public class DomainTransformer {

   public AnnotatedDTO toDTO(Domain domain) {
      return new AnnotatedDTO(
            domain.getField01(),
            domain.getField02(),
            domain.getField03(),
            domain.getField04(),
            domain.getField05(),
            domain.getField06(),
            domain.getField07(),
            domain.getField08(),
            domain.getField09(),
            domain.getField10(),
            domain.getField11(),
            domain.getField12(),
            domain.getField13(),
            domain.getField14(),
            domain.getField15(),
            domain.getField16(),
            domain.getField17(),
            domain.getField18(),
            domain.getField19(),
            domain.getField20()
      );
   }
}
