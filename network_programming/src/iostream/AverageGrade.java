package iostream;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AverageGrade {
	public static void main(String args[]) throws IOException{
		int course = 0;
		int maxCourse;
		int totalMarks = 0;
		double gradeAvg;
		char grade;
		
		try(Scanner sc = new Scanner(System.in)){
		String numOfCourse = JOptionPane.showInputDialog("Enter number of course taken: ");
		maxCourse = Integer.parseInt(numOfCourse);
		
		while(course < maxCourse) {
			System.out.print("Input grade for Course "+(course+1)+" Aand press <ENTER>");
			String input = sc.next().trim();
			if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
			
			grade = Character.toUpperCase(input.charAt(0));
			
			switch(grade) {
			case 'A' -> totalMarks += 4;
			case 'B' -> totalMarks += 3;
			case 'C' -> totalMarks += 2;
			case 'D' -> totalMarks += 1;
			case 'E' -> totalMarks += 0;
			default->{
		        System.out.println("Invalid grade! Please enter A, B, C, D, or E.");
		        continue;
		      }
			}
			course++;
		}
		gradeAvg = (double) totalMarks / course;
		System.out.println("Your grade average: " + gradeAvg);
		}
	}
}
