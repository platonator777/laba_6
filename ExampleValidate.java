//аннотация аннотации
@Validate(value = {String.class, Integer.class})
@interface MyCustomAnnotation {
}

@Validate(value = {String.class, Integer.class})
public class ExampleValidate {
}

