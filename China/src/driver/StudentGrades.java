package driver;

import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the number of students from the user
         
        int N = scanner.nextInt();
        
        // Array to store test scores
        int[][] testScores = new int[N][3];
        
        // Get test scores for each student
         
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                testScores[i][j] = scanner.nextInt();
            }
        }
        
        // Calculate average scores and determine grades for each student
        determineGradeForMultipleTests(testScores);
        
        scanner.close();
    }
    
    public static void determineGradeForMultipleTests(int[][] testScores) {
        
        for (int i = 0; i < testScores.length; i++) {
            int totalScore = 0;
            for (int j = 0; j < 3; j++) {
                totalScore += testScores[i][j];
            }
            int averageScore = totalScore / 3;
            
            if (averageScore >= 90) {
                System.out.println("Grade: A");
            } else if (averageScore >= 80) {
                System.out.println("Grade: B");
            } else if (averageScore >= 70) {
                System.out.println("Grade: C");
            } else if (averageScore >= 60) {
                System.out.println("Grade: D");
            } else {
                System.out.println("Grade: F");
            }
        }
    }
}
