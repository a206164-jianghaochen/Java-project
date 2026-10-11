package javaPractice;
public abstract class Door {
  private int height;
  private int width;
  private double price;
    public Door(int h, int w, double price) {
    	this.height = h;
    	this.width = w;
    	this.price = price;
    }
	 public abstract String getName();     
	    
	 public void open(Door typeDoor) {
 	    System.out.println("I am a " + typeDoor.getName() + ", I can open.");    	      	   
    }
	   public void close(Door typeDoor) {
		   System.out.println("I am a " + typeDoor.getName() + ", I can close.");		   
	   }
	   public void printPrice(Door typeDoor) {
		   System.out.println("you can spend " + typeDoor.price + " RMB"+ " to get a " + typeDoor.getName());		  		   
	   }
}
