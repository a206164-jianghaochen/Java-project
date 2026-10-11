package javaPractice;
public class PanpanDoor extends Door implements alarm{		    
	    private String name;	    
	  public PanpanDoor(int h, int w, String name, double price) {
		  super(h, w, price);		  
		  this.name = name;		  
	  }	 
	 public void alarm() {
		 System.out.println("I am a Panpan door, I can alarm");		 				 
	 }	
	 public String getName() {		 
		 return name;
	 }

}
    interface alarm{
    void alarm();    	 
    }   	 	 
