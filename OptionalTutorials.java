import java.lang.StackWalker.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTutorials {
    public static void main(String[] args) {
        System.out.println("Welcome to Optional Tutorials!");

        // Optional<T> is a container object that may or may not contain a non-null
        // value.

        // Purpose:
        // Avoid NullPointerException
        // Make null-handling explicit
        // Optional<T>

        // Before Java 8
        String name = getName();
        if (name != null) {
            System.out.println("Name length: " + name.length());
        } else {
            System.out.println("Name is null");
        }

        System.out.println("==========================");

        // Using Optional
        Optional<String> optional_name = Optional.ofNullable(getName());

        optional_name.ifPresent(s -> System.out.println("Name length: " + s.length()));

        optional_name.ifPresentOrElse(
                (s) -> System.out.println("Name length " + s.length()),
                () -> System.out.println("Name is null"));

        System.out.println("==========================");

        Optional<String> fruit = Optional.empty();
        System.out.println("Is fruit present? " + fruit.isPresent());

        fruit = Optional.of("Apple");
        System.out.println("Is fruit present? " + fruit.isPresent());
        System.out.println("Fruit: " + fruit.get());

        String defaultFruit = fruit.orElse("Banana");
        System.out.println("Default Fruit: " + defaultFruit);

        System.out.println("==========================");

        try {
            Optional<String> anotherFruit = Optional.of(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException when using Optional.of with null");
        }

        System.out.println("==========================");

        try {
            Optional<String> anotherFruit = Optional.ofNullable(null);
            System.out.println("Another fruit is present? " + anotherFruit.isPresent());
            System.out.println(anotherFruit.get());
        } catch (NoSuchElementException e) {
            System.out.println("Caught NoSuchElementException when trying to get value from empty Optional");
        }

        System.out.println("==========================");

        Optional<String> optionalFruit = Optional.ofNullable(null);
        if (optionalFruit.isPresent()) {
            String f = optionalFruit.get();
            System.out.println("Fruit: " + f);
        } else {
            System.out.println("No fruit available");
        }

        System.out.println("==========================");

        Optional<String> optionalVegetable = Optional.ofNullable(null);
        // optionalVegetable.orElseThrow(() -> new IllegalArgumentException("No vegetable available")); throws exception
        optionalVegetable.ifPresentOrElse(null, () -> {
            System.out.println("No vegetable available");
        });

        System.out.println("==========================");

        //map
        Optional<String> newFruit = Optional.of("Mango");
        Optional<String> upperFruit = newFruit.map(String::toUpperCase);
        upperFruit.ifPresent(f -> System.out.println("Uppercase Fruit: " + f));

        System.out.println("==========================");

        //flatMap
        Optional<String> lowerFruit = newFruit.flatMap(f -> Optional.of(f.toLowerCase()));
        lowerFruit.ifPresent(f -> System.out.println("Lowercase Fruit: " + f));

        System.out.println("==========================");

        Optional<Integer> fruitLength = newFruit.map(String::length);
        fruitLength.ifPresent(len -> System.out.println("Fruit name: " + newFruit.get() + ", Fruit Length: " + len));

        System.out.println("==========================");

        List<Optional<String>> optionalList = List.of(
                Optional.of("Apple"),
                Optional.empty(),
                Optional.of("Banana"),
                Optional.of("Orange"),
                Optional.empty());

        optionalList.stream()
                .filter(o -> o.isPresent())
                .forEach(f -> System.out.println("Fruit from optional list: " + f.get()));

        System.out.println("==========================");

        User user = new User();
        user.setName("John");
        user.setAddress("Lucknow");

        String address = Optional.ofNullable(user)
                .map(u -> u.getAddress())
                .orElse("Unknown");
        System.out.println("User address: " + address);

        System.out.println("==========================");

    }

    public static String getName() {
        return null; // Simulating a method that may return null
    }
}

class User {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}
