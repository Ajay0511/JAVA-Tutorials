public class FunctionInterfaceTutorials {
    public static void main(String[] args) {
        System.out.println("Welcome to Function Interface Tutorials!");

        // implementation of sayHello method using lambda expression
        Greeting g = () -> System.out.println("Hello from the Greeting functional interface!");
        g.sayHello();
        g.greet();
        Greeting.welcome();

        //implementation of operate method using lambda expressions
        MathOperation addition = (a, b) -> a + b;
        System.out.println("Addition of 2 and 3: " + addition.operate(2, 3));

        MathOperation multiplication = (a, b) -> a * b;
        System.out.println("Multiplication of 2 and 3: " + multiplication.operate(2, 3));

        StringLength lengthFunction = (s) -> s.length();
        System.out.println("Length of 'Hello': " + lengthFunction.getLength("Hello"));
    }
}


// @FunctionalInterface
// interface MyInterface {
//     void doWork();
// }

@FunctionalInterface
interface Greeting{
    void sayHello();
    // void sayHi(); // This will cause a compilation error because functional interfaces can have only one abstract method
    // Default and static method added to provide additional functionality without violating the functional interface contract
    public default void greet(){
        System.out.println("Greetings!");
    }

    static void welcome(){
        System.out.println("Welcome");
    }
}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

@FunctionalInterface
interface StringLength {
    int getLength(String s);
}
