package libraryManagement;
public class Reference extends Book{
       boolean restricted_status;
   public Reference(String title, String author, double price, boolean restricted_states) {
	   super(title, author, price);
	   this.restricted_status = restricted_status;
   }
   public void displayDetails() {
       super.displayDetails();
       System.out.println("Restricted status: " + restricted_status);  
       System.out.println();
      }      
       public void borrow() {
    	   int day = sc.nextInt();
    	   if(restricted_status) {
    		   System.out.println(title + " is restricted and cannot be borrowed.");   		   
    	   }else {
    		   System.out.println("You have borrowed the reference book: " + title + " for " + day + " days.");   		   
    	   }   
       }     
}
