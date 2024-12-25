@ToString
class ExampleToString {
    @ToString
    private String field1 = "Hello";

    @ToString(value = ToString.Value.NO)
    private String field2 = "ignore";
}
