package bookApps;
import java.util.Scanner;
public class BookApp {
      public static void main(String[] args){
    	  Scanner sc = new Scanner(System.in);  	  
    	  System.out.print("Enter the number of books: ");
    	  int numberOfBooks = sc.nextInt();
    	  sc.nextLine();   	  
    	  double discount = 10.0; 
    	  for(int i = 0; i < numberOfBooks; i++) {
    		  System.out.println("\nEnter details for Book " + (i + 1) + ":");
    		  System.out.print("Enter book title: ");
    		  String title = sc.nextLine();
    		  System.out.print("Enter author name: ");
    		  String author = sc.nextLine();   		  
    		  Book book = new Book(title, author);
    		  System.out.print("Enter price: RM");
    		  book.setPrice(sc.nextDouble());
    		  sc.nextLine();
    		  book.displayInfo(discount);
    	  }
    	  sc.close();   	  
      }	
}
