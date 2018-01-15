package interfaces;

@SuppressWarnings("unused")
class Parent {

    private static final int value = 42;

    public static int getValue() {
        return value;
    }
}

@SuppressWarnings("unused")
class Child extends Parent {

    private static final int value = 0;

    public static int getValue() {
        return value;
    }
}

@SuppressWarnings("unused")
class GrandChild extends Child {

    private static final int value = -42;
}

/**
 * @see <a href="https://jcp.org/en/jsr/detail?id=335">JSR-335: Lambda Expressions for the Java Programming Language</a>
 */
@SuppressWarnings("all")
class Launcher1 {

    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println("--- Parent ---");
        System.out.println(parent.getValue());
        System.out.println(Parent.getValue());

        parent = new Child();
        System.out.println("\n--- Child ---");
        System.out.println(parent.getValue());
        System.out.println(Child.getValue());

        parent = new GrandChild();
        System.out.println("\n--- GrandChild ---");
        System.out.println(parent.getValue());
        System.out.println(GrandChild.getValue());

        parent = null;
        System.out.println("\n--- null ---");
        System.out.println(parent.getValue());
        System.out.println(((GrandChild)null).getValue());
    }
}