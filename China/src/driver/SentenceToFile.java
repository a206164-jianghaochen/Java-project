package driver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SentenceToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputText = new StringBuilder();
        System.out.println("Enter sentences (type '#' to stop):");
        
        try {
            while (true) {
                String sentence = scanner.nextLine();
                if (sentence.equals("#")) {
                    break;
                }
                inputText.append(sentence).append(" ");
            }

            // Split the collected text into words
            String[] words = inputText.toString().trim().split("\\s+");

            // Write the words to the file
            try (FileWriter fileWriter = new FileWriter("myText.txt")) {
                for (String word : words) {
                    fileWriter.write(word + System.lineSeparator());
                }
                
            } catch (IOException e) {
            	
            }
        } finally {
            scanner.close();
        }
    }
}


