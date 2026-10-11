package libraryManagement;
import java.util.Scanner;
public class ParadigmLibraryApps {
     public static void main(String[] args) {
    	 Scanner input = new Scanner(System.in);    	 
    	 System.out.print("Enter library quota capacity: ");
    	 int capacity = input.nextInt();
    	 Library library = new Library(capacity);
    	 System.out.println();
    	 while(true) {
    	 System.out.println("Library Menu:");
    	 System.out.println("1. Add Book");
    	 System.out.println("2. Display All Books");
    	 System.out.println("3. Borrowing Process");
    	 System.out.println("4. Exit\n");
    	 System.out.print("Enter your choice: ");
    	 int choice = input.nextInt();
    	 switch(choice) {
    	 case 1:
    		 library.addBook();
    		 System.out.println();
    	 break;
    	 case 2:
    	     library.displayBook();
    	     System.out.println();
    	 break;
    	 case 3:
    	     library.borrowingProcess();
    	     System.out.println();
    	 break;
    	 case 4:
    		 System.out.println("Thank you for using Paradigm Library. Goodbye!");
    	return;
    	 }	  	 
    	 }  	 
     }	
}
