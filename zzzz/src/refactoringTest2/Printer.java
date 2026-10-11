package refactoringTest2;
public class Printer {
	protected String type;
	protected String brand;
	public Printer(String type, String brand) {
		this.type = type;
		this.brand = brand;		
	}		
	public void displayDetails() {
		System.out.println("\nType: "+type);
		System.out.println("Brand: "+brand);
	}
	public void printInBlack(String text) {
		System.out.println("Printing: "+text);
	}
	
	
	
}
