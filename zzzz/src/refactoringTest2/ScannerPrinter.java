package refactoringTest2;

public class ScannerPrinter extends ColourPrinter {	
	
	private Scanner scanner = new Scanner();

	public ScannerPrinter(String type, String brand) {		
		super(type, brand);
	}

	public void scan(String docName) {
		scanner.scan(docName);
	}		
}
