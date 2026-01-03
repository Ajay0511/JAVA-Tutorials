import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReferences {
    public static void main(String[] args) {
        System.out.println("Welcome to Method References in Java!");

        // Reference to static method
        List<String> names = Arrays.asList("A", "B", "C", "D");
        names.forEach((s) -> System.out.println(s)); // lambda expression
        names.forEach(System.out::println); // method reference

        System.out.println("==========================");

        // Specific Object: instance::method -> Calls a method on an existing, known object (e.g., myObject::toString).
        // Arbitrary Object: Class::method -> Calls a method on an object that will be provided later as an argument (e.g., String::length).


        // Reference to instance method of a specific object
        Printer printer = new Printer();
        names.forEach((s) -> printer.print(s)); // lambda expression
        names.forEach(printer::print);

        Consumer<String> consumer = printer::print;
        consumer.accept("Hello from Consumer!");

        System.out.println("==========================");

        // Reference to instance method of an arbitrary object of a particular type
        List<String> fruits = Arrays.asList("Banana", "Apple", "Orange", "Mango");
        fruits.stream().map((s) -> s.toLowerCase()).forEach(System.out::println); // lambda expression
        fruits.stream().map(String::toLowerCase).forEach(System.out::println); // method reference

        System.out.println("==========================");

        // Reference to constructor
        List<String> colors = Arrays.asList("Red", "Green", "Blue");
        colors.stream().map((s) -> new StringBuilder(s)).forEach(System.out::println); // lambda expression
        colors.stream().map(StringBuilder::new).forEach(System.out::println); // method reference

        // usage with comparators
        List<Integer> numbList = Arrays.asList(1, 2, 3, 4, 5);
        numbList.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println); // lambda expression
        numbList.stream().sorted(Integer::compareTo).forEach(System.out::println); // method reference

        System.out.println("==========================");

    }
}

class Printer {
    public void print(String s) {
        System.out.println(s);
    }
}
