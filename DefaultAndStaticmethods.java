public class DefaultAndStaticmethods {
    public static void main(String[] args) {
        System.out.println("Welcome to Default and Static Methods in Interfaces!");

        /*
         * Before Java 8:
         * Interfaces had only abstract methods
         * Adding a method broke all implementing classes
         * 
         * Java 8 solved this by allowing:
         * default methods → backward compatibility
         * static methods → utility methods inside interface
        
         * Default = inherited & overridable
         * Static = interface-level utility methods
        */

        
        Bike myBike = new Bike();
        myBike.start(); // Calls the overridden start method
        myBike.stop();  // Calls the default stop method from the interface
        Vehicle.honk(); // Calls the static honk method from the interface
        
    }
}

@FunctionalInterface
interface Vehicle {
    void start();

    default void stop() {
        System.out.println("Vehicle stopped.");
    }

    static void honk() {
        System.out.println("Vehicle honking!");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started.");
    }
}
