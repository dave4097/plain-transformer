# Plain Transformer

Plain Transformer is a simple way to transform one plain ol' Java object to another using annotations and an
expression language. By default, the Spring Expression Language (SpEL) is used.

## Getting Started

Say you have the a Customer domain object with one String field called customerName. Along with this there is a DTO, 
CustomerDTO, which correspondingly has a String field called customerName. To use Plain Transformer to transform
Customer to CustomerDTO, simple annotate the fields in the CustomerDTO as follows. To transform directly:

    @TransformFrom("#customerName")
    private String customerName;
    
If the class level annotation @TransformUsingAnnotationsOnly is not present, then customerName will be transformed
without the requirement to add the @TransformFrom annotation.

To transform an embedded object and override transformations within, which is optional:

    @TransformEmbedded
    @TransformOverrides(
          @TransformOverride(attribute="amount", transformFrom="#totalSold")
    )
    private MoneyDTO totalSold;
          
To transform a collection of objects to another collection of different objects:

    @TransformFromCollection(value = "#orderItemsList")
    private List<OrderItemDTO> orderItemsList;

At the moment, you will require a public default constructor in CustomerDTO. Then to perform the transformation, do
the following:

    Transformer.to(CustomerDTO.class).from(myCustomer);

For further examples, refer to the tests.

## Usage

Check out and run **mvn clean install**.