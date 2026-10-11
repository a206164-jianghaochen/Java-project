package driver;
import java.util.Scanner;
public class IncredibleAndExtraodinary {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int caseNumber = 1;
	     while(true) {
	  String password = sc.next();
	     if(password.equals("#")) {
	break;
     }
	         String result = isValidPassword(password) ? "valid" : "invalid";
	         System.out.println("Case #" + caseNumber + ": " + result);
	            caseNumber++;
   }       
         }
   public static boolean isValidPassword(String password) {
	   if(password.length() < 6) {
		   return false;
	   }
	   for(char c : password.toCharArray()) {
		   if(!Character.isDigit(c) && !Character.isLowerCase(c)) {
		   return false;
		   }
	   }
	   return true;
   }
}