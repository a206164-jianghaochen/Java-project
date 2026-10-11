package driver;
public class starRail extends Game01 {
	String name;
	public starRail(String name) {
		super(name);
		this.name = name;	
	}
	public void fight() {
		 System.out.println("This is my turn! We can kill the enemies immediately!");		 		 
	 }
	 public void result() {
		 System.out.println("I only used 1 turn to defeat a very strong enemy! I got 800 Stars!");		 		 
	 }
}

