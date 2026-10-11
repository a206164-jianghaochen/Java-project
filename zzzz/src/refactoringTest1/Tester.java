package refactoringTest1;

public class Tester {
	public static void main(String[] args) {
		Student student1 = new Student("Aisyah", "Ahmad", "A11789");
		Student student2 = new Student("Harris", "Azlan", "A11790");
		
		 student1.printInfo();     //Extract method.
		 student2.printInfo();

	}
}

