package mystudent;

public class TestStudent {
      public static void main(String[] args) {
    	  MyStudent stu1 = new MyStudent("A206164", "Jim", 99, 97, 98);
          System.out.printf("The total score is: %.2f. The average is: %.2f. The highest score is: %.2f", stu1.calculateTotal(),stu1.calculateAverage(),stu1.getMaxScore());  	  
      }
}
