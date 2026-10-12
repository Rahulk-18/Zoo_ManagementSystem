package org.example;
import java.util.*;

class ZooAnimal {
    private final String name;
    private final String preferredFood;
    private final int feedingTime; // Feeding time in 24-hour format
    private final String enclosure;
    private final int quantity;
    private final int dailyConsumption;
    private final Keeper keeper; // Keeper for the animal

    public ZooAnimal(String name, String preferredFood, int feedingTime, String enclosure, int quantity, int dailyConsumption, Keeper keeper) {
        this.name = name;
        this.preferredFood = preferredFood;
        this.feedingTime = feedingTime;
        this.enclosure = enclosure;
        this.quantity = quantity;
        this.dailyConsumption = dailyConsumption;
        this.keeper = keeper;
    }

    public String getName() {
        return name;
    }

    public String getPreferredFood() {
        return preferredFood;
    }

    public int getFeedingTime() {
        return feedingTime;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDailyConsumption() {
        return dailyConsumption;
    }

    public Keeper getKeeper() {
        return keeper;
    }
}
class Zoo {
    private final List<ZooAnimal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }
    public void addAnimal(ZooAnimal animal) {
        animals.add(animal);
    }
    public ZooAnimal getAnimalForTime(int time) {
        for (ZooAnimal animal : animals) {
            if (animal.getFeedingTime() == time) {
                return animal;
            }
        }
        return null;
    }
}
class Keeper {
    private final String name;

    public Keeper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
public class ZooManagementSystem {
    public static void main(String[] args) {
        Keeper lionKeeper = new Keeper("Lion Keeper");
        Keeper giraffeKeeper = new Keeper("Giraffe Keeper");
        Keeper elephantKeeper = new Keeper("Elephant Keeper");
        Keeper behemothKeeper = new Keeper("Behemoth Keeper");

        ZooAnimal lion = new ZooAnimal("Lion", "Meat", 8, "Aviary", 5, 15, lionKeeper);
        ZooAnimal giraffe = new ZooAnimal("Giraffe", "Grass", 10, "Aviary", 8, 15, giraffeKeeper);
        ZooAnimal elephant = new ZooAnimal("Elephant", "Fruit", 9, "Aviary", 2, 25, elephantKeeper);
        ZooAnimal behemoth = new ZooAnimal("Behemoth", "Vegetables", 11, "Pool", 1, 10, behemothKeeper);

        Zoo zoo = new Zoo();
        zoo.addAnimal(lion);
        zoo.addAnimal(giraffe);
        zoo.addAnimal(elephant);
        zoo.addAnimal(behemoth);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the current time (in 24-hour format, e.g., 13 for 1 PM): ");
        int currentTime = scanner.nextInt();

        ZooAnimal animalForTime = zoo.getAnimalForTime(currentTime);

        if (animalForTime != null) {
            System.out.println("A REMINDER FOR THE: " + animalForTime.getKeeper().getName());
            System.out.println("It's feeding time for " + animalForTime.getName() + "!");
            System.out.println("In the " + animalForTime.getEnclosure() + " " + animalForTime.getQuantity() + ".");
            System.out.println("Feed them with " + animalForTime.getPreferredFood() + ".");
            System.out.println("Daily consumption: " + animalForTime.getDailyConsumption() + " kilogram per animal.");
        } else {
            System.out.println("No animal scheduled for feeding at the specified time.");
        }
        scanner.close();
    }
}
