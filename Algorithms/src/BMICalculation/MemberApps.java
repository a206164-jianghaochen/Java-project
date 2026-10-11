package BMICalculation;
import java.util.Scanner;
public class MemberApps {
     public static void main(String[] args) {
    	 Scanner input = new Scanner(System.in);
    	 System.out.print("Enter the number of members: ");
    	 int num = input.nextInt();
    	  input.nextLine();
    	 for(int i = 1; i <= num; i++) {
    		 System.out.println("\nEnter details for Member " + i + ":");
    		 System.out.print("Enter member name: ");
    		String name = input.nextLine();
    		System.out.print("Enter age: ");
    		 int age = input.nextInt();
    		 System.out.print("Enter weight (kg): ");
    		 double weight = input.nextDouble();
    		 System.out.print("Enter height (m): ");
    		 double height = input.nextDouble();
   		     System.out.println();
   		     input.nextLine();
   		     System.out.println("--- Member Information ---");
    		 Member member = new Member(name, age);
    		 member.setHeight(height);
    		 member.setWeight(weight);   	
    		 member.displayInfo();
    	 }  	 
    	input.close(); 
     }
}
