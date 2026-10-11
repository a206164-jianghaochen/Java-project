package javaPractice;
public class Door1 extends Door {
	private String name;	
	public Door1(int h, int w, String name, double price) {
		super(h, w, price);
		this.name = name;			
	}
	public String getName() {
		return name;	
	}
}
