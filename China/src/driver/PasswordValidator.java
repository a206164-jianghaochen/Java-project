package driver;
import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check if the password length is at least 6 characters
        if (password.length() < 6) {
            return false;
        }
        // Check if the password consists only of lowercase letters and digits
        for (char c : password.toCharArray()) {  
            if (!Character.isDigit(c) && !Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;

        while (true) {
            
            String password = scanner.nextLine();

            if (password.equals("#")) {
                break;
            }

            String result = isValidPassword(password) ? "valid" : "invalid";
            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }

        scanner.close();
    }
}