package libraryManagement;
import java.util.ArrayList;
import java.util.Scanner;
public class Library {
     ArrayList<Book> books = new ArrayList<>();  
	static int bookCount;
	int capacity;
	public Library(int capacity) {
		this.capacity = capacity;			
	}
	public void addBook() {
		if(bookCount == capacity) {
			System.out.println("Cannot add more books");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter book type (1: Fiction, 2: Non-Fiction, 3: Reference): ");
		int typeChoice = sc.nextInt();
		sc.nextLine();
		switch(typeChoice) {
		case 1:
		System.out.print("Enter book title: ");
		String title1 = sc.nextLine();
		System.out.print("Enter book author: ");
		String author1 = sc.nextLine();
		System.out.print("Enter book price RM: ");
		double price1 = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter book genre: ");
		String genre = sc.nextLine();		
		books.add(new Fiction(title1, author1, price1, genre));
		break;
		case 2:
			System.out.print("Enter book title: ");
			String title2 = sc.nextLine();
			System.out.print("Enter book author: ");
			String author2 = sc.nextLine();
			System.out.print("Enter book price RM: ");
			double price2 = sc.nextDouble();
			sc.nextLine();
			System.out.print("Enter book subject: ");
			String attribute = sc.nextLine();		
			books.add(new NonFiction(title2, author2, price2, attribute));
			break;
		case 3:
			System.out.print("Enter book title: ");
			String title3 = sc.nextLine();
			System.out.print("Enter book author: ");
			String author3 = sc.nextLine();
			System.out.print("Enter book price RM: ");
			double price3 = sc.nextDouble();
			sc.nextLine();
			System.out.print("Is the book restricted? (true/false): ");
			boolean restricted_status = sc.nextBoolean();		
			books.add(new Reference(title3, author3, price3, restricted_status));
			break;		
		}				
		bookCount++;
	}
   public void displayBook() {	   
	   if(books.isEmpty()) {		   
		  System.out.println("No book in the list");
		  return;
	   }
	   int count = 1;
	   for(Book book : books) {
		   System.out.println("Book " + count + ":");
		   book.displayDetails();	
		   count++;
	   }      
   }
   public void borrowingProcess() {
	   if(books.isEmpty()) {
		   System.out.println("No books in the list for borrwing.");
		   return;
	   }	   
	   for(Book book:books) {
		   System.out.print("Enter borrowing duration for " + book.title + ": ");		  
			   book.borrow();
			   System.out.println();
	   }  
   }
}
