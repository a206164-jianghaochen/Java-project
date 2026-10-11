package Java001;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("enter marks");
		int marks = sc.nextInt();
		char grade = 0;
		
		switch(marks/10)
		{
		case 10: grade = 'A';
		
		case 9: grade = 'A';
		        break;
		        
		case 8: grade = 'B';
		        break;
		        
		case 7: grade = 'C';
		        break;
		        
		default: grade = 'F';
		         break;
		}
		        
	System.out.println(grade);	        
                                          }
	
                   }
		



