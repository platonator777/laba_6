@ToString(ToString.Value.NO)
class A extends Entity {
    String s = "hello";
    @ToString(ToString.Value.YES)
    int x = 34;
}
