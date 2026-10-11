package studentQuerySystem;
import java.util.*;
public class ManageStudent {	
      private static List<Student> stu =  new ArrayList<Student>();    
      private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {		
		  stu.add(new Student("A206164", 20, "ShangHai", "Jim"));
		  stu.add(new Student("A123456", 22, "ShenZhen", "Doe"));
		  stu.add(new Student("A123457", 21, "WuHan", "James"));
		  stu.add(new Student("A123458", 23, "BeiJing", "John"));
		  stu.add(new Student("A123459", 19, "GuangZhou", "Bob"));
		while(true) {  
		System.out.println("Welcome to the Student query system");
		System.out.println("**********Student Query System**********");
		System.out.println("1.Add students");
		System.out.println("2.Display information");
		System.out.println("3.Delete student");
		System.out.println("4.Alter information");
		System.out.println("5.Search for a student");
		System.out.println("6.Exit system");
		System.out.println("Please select a number:");				
		Integer num = sc.nextInt();
		switch(num) {
		case 1:
		System.out.println("Please enter student information.");
		Add(sc);
		break;
		case 2:
		System.out.println("students' information:");
		CheckInfo();
		break;
		case 3:
		System.out.println("Please enter a studentID to delete the student:");
		Delete(sc);
		break;
		case 4:
		System.out.println("Please enter a studentID to alter the information:");
		AlterInfo(sc);
		break;
		case 5:
			System.out.println("Please enter the name of the student to search for: ");
			if(!SearchInfo(sc)) {
				System.out.println("The student was not found!");
			}
			
			break;
		case 6:
		System.exit(0);
		    }
		}				
	}
	public static void Add(Scanner sc) {		
		System.out.println("student ID:");
		String newStuID = sc.next();
		System.out.println("student age:");
		Integer newAge = sc.nextInt();
		System.out.println("student address:");
		String newAddress = sc.next();
		System.out.println("Student name:");
	    String newName = sc.next();	    
	    stu.add(new Student(newStuID, newAge, newAddress, newName));
	    System.out.println("Student added successfully.");
	}
	  public static void CheckInfo() {
		  System.out.println("stuID " + "age " + "address " + "name ");
		  for(Student s: stu) {
			  System.out.println(s);			  			  
		  }	
	}
	  public static void Delete(Scanner sc) {		  
		  String deleteID = sc.next();
		  for(Student s : stu) {
			  if(s.getStudentid().equals(deleteID)) {
				  stu.remove(s);	
				  System.out.println("The student has been deleted successfully.");
				  return;
			  }			  			  			
		  }
		  System.out.println("The student doesn't exist in the list!");	  		  
	  }
	public static void AlterInfo(Scanner sc) {
		String alterID = sc.next();
		for(int i = 0; i < stu.size(); i++) {
			  if(stu.get(i).getStudentid().equals(alterID)) {
				  System.out.println("new age:");
				  Integer alterAge = sc.nextInt();
				  stu.get(i).setAge(alterAge);
				  System.out.println("new address:");
				  String alterAddress = sc.next();
				  stu.get(i).setAddress(alterAddress);
				  System.out.println("new name:");
				  String alterName = sc.next();
				  stu.get(i).setName(alterName);
				  System.out.println("Student information has been changed successfully!");
				  return;
			  }		  
	}
		System.out.println("The student doesn't exist in the list!");	 		
	}	
	public static boolean SearchInfo(Scanner sc) {
		String inputName = sc.next();
		for(Student s : stu) {
			if(s.getName().equals(inputName)) {
				System.out.println(s);
				return true;
			}		
		}
		return false;
	}	
}
