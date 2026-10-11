package libraryManagement;
public class Fiction extends Book{
         String genre;
         public Fiction(String title, String author, double price, String genre) {
        	 super(title, author, price);
        	 this.genre = genre;       	 
         }       
         public void displayDetails() {
          super.displayDetails();
          System.out.println("Genre: " + genre);  
          System.out.println();
         }      
       public void borrow() {
    	   int day = sc.nextInt();
    	   if(day >= 14) {
    		   System.out.println("You cannot borrow the fiction book: " + title + " for more than 14 days");   		   
    	   }else {
    		   System.out.println("You have borrowed the fiction book: " + title + " for " + day + " days. Enjoy your storytime!");   		   
    	   }
       }            
}
