package refactoringTest2;

public class ColourPrinter extends Printer{	
	
	public ColourPrinter(String type, String brand) {		
		super(type, brand);		
	}

	public void printInColour(String text) {
		System.out.println("Printing: "+text);
	}		
}
