import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;


public class LambdaTutorials {
    public static void main(String[] args) {
        System.out.println("Welcome to Lambda Tutorials!");

        // Example of using a lambda expression
        Runnable runnable = () -> System.out.println("This is a lambda expression in Java 8.");
        new Thread(runnable).start();

        //Comparator using Lambda
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("Sorted names: " + names);





        // Predicate<T> is a functional interface that:
        //     Takes one input
        //     Returns boolean
        // @FunctionalInterface
        // public interface Predicate<T> {
        //     boolean test(T t);
        // }
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        Predicate<Employee> isHighEarner = emp -> emp.getSalary() > 50000;
        Employee emp1 = new Employee("Alice", 60000);
        System.out.println("Is Alice a high earner? " + isHighEarner.test(emp1));

        List<Employee> employees = Arrays.asList(
                new Employee("Bob", 45000),
                new Employee("Charlie", 70000),
                new Employee("David", 30000));

        employees.stream().filter(isHighEarner).forEach(System.out::println);





        // Consumer<T>
        // Definition
        // Consumer<T>:
        // Takes one input
        // Returns nothing (void)

        // @FunctionalInterface
        // public interface Consumer<T> {
        //     void accept(T t);
        // }

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        printUpperCase.accept("hello world");

        Consumer<Employee> giveRaise = emp -> {
            int newSalary = emp.getSalary() + 5000;
            System.out.println(emp.getName() + "'s new salary: " + newSalary);
        };
        employees.stream().filter(emp -> emp.getName().equals("Bob")).forEach(giveRaise);





        // Supplier Definition
        // Supplier<T>:
        // Takes no input
        // Returns a value

        // @FunctionalInterface
        // public interface Supplier<T> {
        //     T get();
        // }

        Supplier<Double> randomValueSupplier = () -> Math.random();
        System.out.println("Random value: " + randomValueSupplier.get());

        Supplier<Employee> employeeSupplier = () -> new Employee("Ace", 67000);
        Employee newEmp = employeeSupplier.get();
        System.out.println("New Employee: " + newEmp.getName() + ", Salary: " + newEmp.getSalary());


        // Function<T, R>
        // Takes one input of type T
        // Returns a value of type R
        // @FunctionalInterface
        // public interface Function<T, R> {
        //     R apply(T t);
        // }
        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("Java"));

    }
}



class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
