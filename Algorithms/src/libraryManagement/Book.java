package libraryManagement;
import java.util.Scanner;
public class Book {
	  Scanner sc = new Scanner(System.in);
      String title;
      String author;
      double price;
     public Book(String title, String author, double price) {
    	 this.title = title;
    	 this.author = author;
    	 this.price = price;
     }
   public void displayDetails() {
	   System.out.println("Title: " + title);
	   System.out.println("Author: " + author);
	   System.out.printf("Price: RM%.2f\n", price);
   }
   public void borrow() {	   
	   int day = sc.nextInt();
	   System.out.println("Borrowing the book " + title + " for " + day + " days.");	   
   }    
}
