import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsEnhancement {
    public static void main(String[] args) {
        System.out.println("Welcome to Collections Enhancement Tutorials!");

        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana");
        names.forEach(System.out::println);

        // names.removeIf(s -> s.length() < 4); // This will throw UnsupportedOperationException because list is immutable

        List<String> names_new = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "Diana"));
        names_new.removeIf(s -> s.length() < 4);
        System.out.println("After removing names with length less than 4:");
        names_new.forEach(System.out::println);

        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .toList();
        System.out.println("Names in uppercase:");
        upperNames.forEach(System.out::println);


        //hashMap enhancements
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        map.forEach((k,v) -> System.out.println(k + " " + v));

        map.putIfAbsent(2, "Deux");
        map.putIfAbsent(4, "Four");

        System.out.println("After putIfAbsent:");
        map.forEach((k,v) -> System.out.println(k + " " + v));

        System.out.println(map.getOrDefault(5, "five not found"));

        map.compute(3, (k,v) -> v + " (updated)"); //updates only value for key 3
        System.out.println("After compute on key 3:");
        map.forEach((k,v) -> System.out.println(k + " " + v));
        map.computeIfAbsent(5, k -> "Five");
        System.out.println("After computeIfAbsent for key 5:");
        map.forEach((k,v) -> System.out.println(k + " " + v));


        map.merge(6, "merged six", (oldVal, newVal) -> oldVal + " & " + newVal); //adds new key-value pair
        map.merge(2, "TWO", (oldVal, newVal) -> oldVal + " & " + newVal); //updates value for key 2
        System.out.println("After merge operations:");
        map.forEach((k,v) -> System.out.println(k + " " + v));
        



    }
}
