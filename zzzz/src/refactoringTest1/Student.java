package refactoringTest1;

public class Student {
	private String firstName;   //rename the variables
	private String lastName; 
	private String matricNum;
	
	public Student(String firstName, String lastName, String matric) {
		this.firstName = firstName;
		this.lastName = lastName;
		matricNum = matric;
	}
	
	public String getfirstName() {         //rename the method
		return firstName;
	}
	
	public String getlastName() {
		return lastName;
	}

	public String getMatricNum() {
		return matricNum;
	}

    public void printInfo() {
    	System.out.println("\nName: "+firstName +" "+ lastName);
		System.out.println("Matric number: "+ matricNum);              //The method for students' information.
    	
    	
    }
}

