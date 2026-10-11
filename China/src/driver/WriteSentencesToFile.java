package driver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteSentencesToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputText = new StringBuilder();
        while (true) {
            String sentence = scanner.next();
            if (sentence.equals("#")) {
                break;
            }
            inputText.append(sentence).append(" ");
        }

        // Split the collected text into words
        String[] words = inputText.toString().split("\\s+");

        // Write the words to the file
        try (FileWriter fileWriter = new FileWriter("myText.txt")) {
            for (String word : words) {
                fileWriter.write(word + System.lineSeparator());
                System.out.print(word + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }

        System.out.println();
    }
}