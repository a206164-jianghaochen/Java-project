import java.util.Scanner;
public class studentMain {
public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
int studentamount = sc.nextInt();

int[] score = new int[3];
 int sum = 0;
 int sumA=0,sumB=0,sumC=0,sumD=0,sumE=0,sumF=0;
 int countA = 0;
 int countB = 0;
 int countC = 0;
 int countD = 0;
 int countE = 0;
 int countF = 0;
 for(int i = 1; i <= studentamount; i++) {
  for(int j = 0; j < 3; j++) {
   int inputscore = sc.nextInt();
   sum += inputscore;//sum为当前行的学生总分
  }
       
        if(sum >= 90 && sum <=100) {
         countA++;
   sumA += sum;
        } else if(sum >= 80 && sum <= 89) {
         countB ++;
   sumB += sum;
        }else if(sum >= 70 && sum <= 79) {
         countC ++;
   sumC += sum;
        }else if(sum >= 60 && sum <= 69) {
         countD ++;
   sumD += sum;
        }else if(sum >= 50 && sum <= 59) {
         countE ++; 
   sumE += sum;
        }else if(sum < 50) {
         countF ++;
   sumF += sum;
        }
  sum=0;
 }
    
     

if(countA == 0){
    System.out.printf("Grade A: " + "%d " + "student(s) \n", countA);
System.out.printf("Average Mark of Grade: 0.0\n");
System.out.println();
}else{
System.out.printf("Grade A: " + "%d " + "student(s) \n", countA);
System.out.printf("Average Mark of Grade: %.1f\n", sumA/(double)countA);
System.out.println();
    }
    if(countB == 0){
    System.out.printf("Grade B: " + "%d " + "student(s) \n", countB);
System.out.printf("Average Mark of Grade: 0.0\n");
System.out.println();
}else{
System.out.printf("Grade B: " + "%d " + "student(s) \n", countB);
System.out.printf("Average Mark of Grade: %.1f\n", sumB/(double)countB);
System.out.println();
    }
    if(countC == 0){
    System.out.printf("Grade C: " + "%d " + "student(s) \n", countC);
System.out.printf("Average Mark of Grade: 0.0\n");
System.out.println();
}else{
System.out.printf("Grade C: " + "%d " + "student(s) \n", countC);
System.out.printf("Average Mark of Grade: %.1f\n", sumC/(double)countC);
System.out.println();
    }
    if(countD == 0){
    System.out.printf("Grade D: " + "%d " + "student(s) \n", countD);
System.out.printf("Average Mark of Grade: 0.0\n");
System.out.println();
}else{
System.out.printf("Grade D: " + "%d " + "student(s) \n", countD);
System.out.printf("Average Mark of Grade: %.1f\n", sumD/(double)countD);
System.out.println();
    }
    if(countE == 0){
    System.out.printf("Grade E: " + "%d " + "student(s) \n", countE);
System.out.printf("Average Mark of Grade: 0.0\n");
System.out.println();
}else{
System.out.printf("Grade E: " + "%d " + "student(s) \n", countE);
System.out.printf("Average Mark of Grade: %.1f\n", sumE/(double)countE);
System.out.println();
    }
    if(countF == 0){
    System.out.printf("Grade F: " + "%d " + "student(s) \n", countF);
System.out.printf("Average Mark of Grade: 0.0\n");
System.out.println();
}else{
System.out.printf("Grade F: " + "%d " + "student(s) \n", countF);
System.out.printf("Average Mark of Grade: %.1f\n", sumF/(double)countF);
System.out.println();
    }
}
}