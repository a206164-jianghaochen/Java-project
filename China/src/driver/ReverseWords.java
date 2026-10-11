package driver;
import java.util.Scanner;
public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String reversedString = reverseWords(inputString);
        System.out.println(reversedString);
    }

    public static String reverseWords(String str) {
        if (str == null || str.isEmpty()) {
            return str; // Return the input string as is if it's null or empty
        }

        // Split the input string by space to get individual words
        String[] words = str.split("\\s+");

        // Create a StringBuilder to build the reversed string
        StringBuilder reversedString = new StringBuilder();

        // Iterate over the words array in reverse order and append each word to the StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
            // Add a space after each word, except for the last word
            if (i != 0) {
                reversedString.append(" ");
            }
        }

        return reversedString.toString();
    }
}
