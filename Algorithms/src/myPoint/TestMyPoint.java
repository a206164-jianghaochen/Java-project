package myPoint;

import java.util.Scanner;

public class TestMyPoint {
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
    	  System.out.println("Please enter the value of x:");
    	  double x1 = sc.nextDouble();
    	  System.out.println("Please enter the value of y:");
    	  double y1 = sc.nextDouble();
    	  MyPoint point1 = new MyPoint(x1, y1);
    	  System.out.printf("The distance between two points is: %.2f",point1.getDistance());
    	  
    	  sc.close();
      }
}
