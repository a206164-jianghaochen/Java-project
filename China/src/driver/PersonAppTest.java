package driver;

import java.util.Scanner;

public class PersonAppTest {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String name = sc.nextLine();
	int age = sc.nextInt();
	Person person = new Person(name, age);
	Student student = new Student(name, age);
	String studentId = sc.next();
	String major = sc.next();
	person.displayInofo();
	student.displayInfo(studentId, major);
}
}
   class Person{
	   String name;
	   int age;
	   public Person(String name, int age) {
		   this.name = name;
		   this.age = age;
		   
	   }
	   public void displayInofo() {
	    System.out.println("Name: " + name);
	    System.out.println("Age: " + age);
	   
	   } 
	   
   }
   class Student extends Person{
	   public Student(String name, int age) {
		super(name, age);
	}
	String studentId;
	   String major;
	   public void displayInfo(String studentId, String major) {
		   this.studentId = studentId;
		   this.major = major;
		   System.out.println("Student ID: " + studentId);
		   System.out.println("major: " + major);
	   }
	   
   }
   
   
   
   
   
