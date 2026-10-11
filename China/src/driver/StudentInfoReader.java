package driver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentInfoReader {
    public static void main(String[] args) {
        String filePath = "E:\\Lab Java\\Java 4\\stdInfo.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String name = parts[0];
                    String matric = parts[1];
                    String program = parts[2];
                    String email = parts[3];
               
                    System.out.println("Name: " + name);
                    System.out.println("Matric: " + matric);
                    System.out.println("Program: " + program);
                    System.out.println("Email: " + email);
                    System.out.println(); 
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
