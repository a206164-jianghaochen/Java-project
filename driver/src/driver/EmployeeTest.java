package driver;
import java.text.DecimalFormat;
import java.util.Scanner;

public class EmployeeTest {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");
	String name = sc.nextLine();
	int yob = sc.nextInt();
	 sc.nextLine();
	String desig = sc.nextLine();
	double salary = sc.nextDouble();
	int currentyear = sc.nextInt();
	
	
	
	Employee empOne = new Employee(name,yob);
	
	
	empOne.empDesignation(desig);
   empOne.empSalary(salary);
   empOne.printEmployee(currentyear);
}
}
     class Employee{
    	 String name;
    	 int yob;
    	 String designation;
    	 double salary;
    	 public Employee(String name, int yob) {
    	 this.name = name;
    	 this.yob = yob;
    	 }
    	 public int calculateAge(int currentyear) {
    		 return currentyear-yob;
    	 }
    	 public void empDesignation(String empDesig) {
    		 designation = empDesig;
    		 
    		 
    	 }
    	 public void empSalary(double empSalary) {
    	 salary = empSalary;
    	 
    	 }
    	 
    	 void printEmployee(int cyear) {
    		 DecimalFormat df = new DecimalFormat("0.00");
    	 System.out.println("Name: " + name);
    	 System.out.println("Age: " + calculateAge(cyear));
    	 System.out.println("Designation: " + designation);
    	 System.out.println("Salary: " + df.format(salary));
    	 
    	 
     }
     }






















