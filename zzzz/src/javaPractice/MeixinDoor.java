package javaPractice;

public class MeixinDoor extends Door{	
	private String name;
	public MeixinDoor(int h, int w, String name, double price) {
		super(h, w, price);		
		this.name = name;
	}	
	public String getName() {
     return name;
}
}