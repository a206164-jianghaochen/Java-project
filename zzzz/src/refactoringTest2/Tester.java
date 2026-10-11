package refactoringTest2;

public class Tester {
	public static void main(String[] args) {
		Printer printer1 = new Printer("Black and white printer","Epson");
		ColourPrinter printer2 = new ColourPrinter("Colour printer","Canon");
		ScannerPrinter printer3 = new ScannerPrinter("Colour scanner printer","HP");
	
		printer1.displayDetails();
		printer1.printInBlack("Text in black");
		
		printer2.displayDetails();
		printer2.printInBlack("Text in black");
		printer2.printInColour("Text in colour");
		
		printer3.displayDetails();
		printer3.printInBlack("Text in black");
		printer3.printInColour("Text in colour");
		printer3.scan("A document");
	}
}