package driver;
import java.util.Scanner;

public class ZooLegsCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the number of animal types from the user
        
        int N = scanner.nextInt();
        
        // Arrays to store data
        String[] animalTypes = new String[N];
        int[] legsPerAnimal = new int[N];
        int[] numAnimals = new int[N];
        
        // Get animal types
        System.out.println("Mini Zoo");
        for (int i = 0; i < N; i++) {
            animalTypes[i] = scanner.next();
        }
        
        // Get number of legs for each animal
        
        for (int i = 0; i < N; i++) {
            legsPerAnimal[i] = scanner.nextInt();
        }
        
        // Get number of animals for each type
        System.out.println("How many types of animals are in your Mini Zoo: ");
        for (int i = 0; i < N; i++) {
            numAnimals[i] = scanner.nextInt();
        }
        
        // Calculate total number of legs
        int totalLegs = 0;
        for (int i = 0; i < N; i++) {
            totalLegs += legsPerAnimal[i] * numAnimals[i];
        }
        
        System.out.println("Total legs: " + totalLegs);
        
        scanner.close();
    }
}
