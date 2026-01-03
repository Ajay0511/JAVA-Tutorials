import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITutorials {
    public static void main(String[] args) {
        System.out.println("Welcome to Stream API Tutorials!");

        //A Stream is a sequence of elements that supports functional-style operations.
        //Source -> Intermediate Operations -> Terminal Operations

        //Creating Streams from collections
        List<String> names = Arrays.asList("Ajay", "Amit", "Anjali", "Sahil");
        Stream<String> nameStream = names.stream();
        System.out.println("Names in the list:");
        nameStream.forEach(System.out::println);

        System.out.println("==========================");


        //Creating Streams from arrays
        String[] colors = {"Red", "Green", "Blue"};
        Stream<String> colorStream = Arrays.stream(colors);
        System.out.println("Colors in the array:");
        colorStream.forEach(System.out::println);

        System.out.println("==========================");

        Stream.generate(Math::random)
            // Math::random is a method reference, not a method call. It passes the function itself to generate random numbers each time it's called.
            .limit(5)
            // System.out::println is a method reference to the println method, so each generated value is printed. It allows forEach to call println for every element.
            .forEach(System.out::println);

        System.out.println("==========================");

        Random random = new Random();
        Stream.generate(() -> random.nextInt(100))
            .limit(5)
            .forEach(System.out::println);

        System.out.println("==========================");

        
        //Intermediate Operations: filter, map, sorted
        List<Integer> numbers = Arrays.asList(17,11,25,13,4);

        numbers.stream()
            .filter(n->n%2==0)
            .forEach(System.out::println);
        
        System.out.println("==========================");
        
        numbers.stream()
        .map(x -> x*2)
        .forEach(System.out::println);

        System.out.println("==========================");

        numbers.stream()
        .sorted()
        .forEach(System.out::println);

        System.out.println("==========================");

        //descending order
        numbers.stream()
        .sorted((a,b) -> b - a)
        .forEach(System.out::println);
        
        System.out.println("==========================");

        //skip first n elements
        numbers.stream()
        .skip(1)
        .forEach(System.out::println);

        System.out.println("==========================");

        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );

        listOfLists.stream()
            .flatMap(List::stream)
            .forEach(System.out::println);
        

        
        //Termainal Operations: collect, reduce, forEach

        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango");

        fruits.stream()
            .forEach(System.out::println);

        System.out.println("==========================");

        List<String> fruitsList = fruits.stream().collect(Collectors.toList());
        System.out.println("Fruits List: " + fruitsList);

        System.out.println("==========================");

        long count = fruits.stream().count(); //if defined as int, typecast to int
        System.out.println("Number of fruits: " + count);

        System.out.println("==========================");

        int sum = numbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println("Sum of numbers: " + sum);

        System.out.println("==========================");

        Optional<Integer> max = numbers.stream().reduce((a,b) -> a>b ? a : b);
        max.ifPresent(m -> System.out.println("Max number: " + m));

        System.out.println("==========================");

        Optional<Integer> o = numbers.stream().findFirst();
        o.ifPresent(val -> System.out.println("Found any value: " + val));



        /*
            * map() vs flatMap()
                * map():
                    * Takes one element
                    * Converts it into exactly one element
                * flatMap():
                    * Takes one element
                    * Converts it into multiple elements (stream)
                    * Flattens into a single stream
            */



        



    }
}
