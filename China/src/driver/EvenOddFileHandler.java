package driver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenOddFileHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        System.out.println("Enter the number of integers:");
        int numberOfIntegers = scanner.nextInt();

        System.out.println("Enter " + numberOfIntegers + " integers separated by spaces:");
        for (int i = 0; i < numberOfIntegers; i++) {
            int number = scanner.nextInt();
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
        writeNumbersToFile(evenNumbers, "even.txt");
        writeNumbersToFile(oddNumbers, "odd.txt");
        List<Integer> evenNumbersFromFile = readNumbersFromFile("even.txt");
        List<Integer> oddNumbersFromFile = readNumbersFromFile("odd.txt");

        // Display results
        System.out.print("Even Number: ");
        evenNumbersFromFile.forEach(num -> System.out.print(num + " "));
        System.out.println();
        System.out.println("Total of even: " + evenNumbersFromFile.size());

        System.out.print("Odd Number: ");
        oddNumbersFromFile.forEach(num -> System.out.print(num + " "));
        System.out.println();
        System.out.println("Total of odd: " + oddNumbersFromFile.size());

        scanner.close();
    }
    private static void writeNumbersToFile(List<Integer> numbers, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int number : numbers) {
                writer.write(Integer.toString(number));
                writer.newLine();
                System.out.println(number);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to " + filename);
            e.printStackTrace();
        }
    }
    private static List<Integer> readNumbersFromFile(String filename) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading from " + filename);
            e.printStackTrace();
        }
        return numbers;
    }
}

