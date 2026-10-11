package driver;

import java.util.Scanner;

public class DriverMain {
  public static void main(String[] args) {
	  double Celsius;
	  System.out.println("Celsius");
	     Scanner sc = new Scanner(System.in);
	     Celsius = sc.nextDouble();
	     double Fahrenheit = Celsius * (9.0 / 5.0) + 32;
	     
	     System.out.printf("%.1f\n", Fahrenheit);
	     
	     
	  
  }
}
