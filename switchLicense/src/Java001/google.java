package Java001;
import java.util.Scanner;

public class google {
	
	public static void main(String[] args) {
		double meters;
        double inches;
        
        Scanner sc = new Scanner(System.in);
  
        System.out.println("input your inches:");
        
        inches = sc.nextDouble(); // Read the foot value from user input
        meters = inches * 0.0254;
        
         
        
        System.out.printf("Meters: %.2f\n", meters);
    }
}
