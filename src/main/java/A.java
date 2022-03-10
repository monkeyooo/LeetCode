package src.main.java;

public class A {
    private static int counter = 0;
    public A () {
        counter++;
    }
    public static int getInstantCount() {
        return counter;
    }
}
