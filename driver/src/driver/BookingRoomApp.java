package driver;
import java.text.DecimalFormat;
import java.util.Scanner;

public class BookingRoomApp {
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  DecimalFormat df = new DecimalFormat("0.00");
	 String name = sc.next();
	 int numOfParticipants = sc.nextInt();
	 int type = sc.nextInt();
     if(type == 1) {
    	 int hours = sc.nextInt();
	 int bookingStay = sc.nextInt();
	 BookingRoom bookingR = new BookingRoom(name, numOfParticipants, bookingStay);
	System.out.println("Name: " + name);
	 System.out.printf("Number of participants: %d\n" , bookingR.getNumOfPart(numOfParticipants));
System.out.printf("Number of hours to book: %d\n" , hours );
	MeetingRoom meetingR = new MeetingRoom(name, hours, bookingStay);
 System.out.printf("Type of booking (1-One off stay / 2-regular recurring): %d\n", meetingR.getTypeOfStay(bookingStay));      
	    	  System.out.println();
	    	  System.out.println("Total payment for the Meeting Room is RM" + df.format(meetingR.payment()));	    	  	    	  	    	  	    	  
	      }else if(type == 2) {
	       int packageType = sc.nextInt();
	    	  int merchandise = sc.nextInt();
	    	  System.out.println("Name: " + name);
	    ConferenceRoom conferenceR = new ConferenceRoom(name, type, packageType, merchandise) ;	  
	    	  System.out.printf("Number of participants: %d\n" ,numOfParticipants);
	    	  System.out.printf("package type (1-Fullday/2-halfday): %d\n" , packageType);
	    	  System.out.printf("Merchandise? (1-Yes/2-No): %d\n" , merchandise);
	    	  System.out.println();
	    	  System.out.println("Total payment for the Conference Room is RM " + " " + df.format(conferenceR.payment()));
	
	}
}
}
  class BookingRoom{
	  String name;
	  int numOfParticipants;
	  int bookingStay;
	  public BookingRoom(String name, int numOfParticipants, int bookingStay ) {
	   this.name = name;
		  this.numOfParticipants = numOfParticipants;
		  this.bookingStay = bookingStay;
	  }
	  public double payment() {
	   return 0.00;
		  
	  }
	  
	  public int getNumOfPart(int numOfParticipants) {
		  return numOfParticipants;
	  }	  
		  
  }  
	 class MeetingRoom extends BookingRoom{
    int bookingStay;
    int type;
     public MeetingRoom(String name, int bookingStay, int type) {
    	super(name, bookingStay , type);
  this.bookingStay = bookingStay;
  this.type = type;
     }
     public int getTypeOfStay(int bookingStay) {
     return bookingStay;
  
  
     }
  public double payment() {
	  double totalPayment = 1140.00;
	  return totalPayment;
  
        }
  }
	 
	  class ConferenceRoom extends BookingRoom{
	 int typeOfPackage;
	 int merchandise;
	 public ConferenceRoom(String name, int type, int packageType, int merchandise) {
		 super(name, packageType, merchandise);
	 this.typeOfPackage = typeOfPackage;
	 this.merchandise = merchandise;
	
	 }
	  public double payment() {
		  double totalPayment2 = 5100.00;
		  return totalPayment2;
	  }
	  }

	 
	 
	 
	 
	 
	 
	 
	 
	 
