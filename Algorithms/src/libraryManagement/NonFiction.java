package libraryManagement;
public class NonFiction extends Book{
      String attribute;
      public NonFiction(String title, String author, double price, String attribute) {
    	  super(title, author,price);
    	  this.attribute = attribute;  	  
      }
      public void displayDetails() {
          super.displayDetails();
          System.out.println("attribute: " + attribute);   
          System.out.println();
         }          
      public void borrow() {
   	   int day = sc.nextInt();
   	   if(day >= 21) {
   		   System.out.println("You cannot borrow the non-fiction book: " + title + " for more than 21 days");   		   
   	   }else {
   		   System.out.println("You have borrowed the non-fiction book: " + title + " for " + day + " days. Enjoy your storytime!");   		   
   	   } 	  
      }     
}
