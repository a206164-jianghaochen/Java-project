package driver;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ShapeAppTest {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  DecimalFormat df = new DecimalFormat("0.00");
	  double radius = sc.nextDouble();
	  Circle circle = new Circle(radius);
	  System.out.println("Circle Area: " + df.format(circle.getArea()));
	  System.out.println("Circle Perimeter: " + df.format(circle.getPerimeter()));
	  double side = sc.nextDouble();
	  Square square = new Square(side);
	  System.out.println("Square Area: " + df.format(square.getArea()));
	  System.out.println("Square Perimeter: " + df.format(square.getPerimeter()));  
  }
}
 interface Shape{
	 double getArea();
	 double getPerimeter();
 }
   class Circle implements Shape{
	   double radius;
	   public Circle(double radius) {
		   this.radius = radius;
		   
	   }
	   public double getArea() {
	   return Math.PI * radius * radius;
	   
	   
   }
	    public double getPerimeter() {
	    	return 2 * Math.PI * radius;
	    	
	    }
}
     class Square implements Shape{
    	 double side;
    	 public Square(double side) {
    		 this.side = side;
    		 
    		 
    	 }
    	 
    	 public double getArea() {
    	 return side * side;
    	 
    	 
     }
    	 
    	 public double getPerimeter() {
    		 return 4 * side;
    		 
    		 
    	 }
   
     }
   
   
   
   
   
   
   
   
   