package driver;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ShapeApp {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String name = sc.next();
	 if(name.equals("Circle")){
	       int radius = sc.nextInt();
	        Circle circle = new Circle(name, radius);
	        Shape shape = new Shape(name);
	        shape.displayInfo();
	        circle.displayInfo();
	        circle.CircleArea(radius);
	    circle.CircleCircumference(radius);
	    }else if(name.equals("Rectangle")){
	    int width = sc.nextInt();
	    int height = sc.nextInt();
	    Rectangle rectangle = new Rectangle(name, width, height);
	        Shape shape2 = new Shape(name);
	    shape2.displayInfo();
	        rectangle.displayInfo();
	        rectangle.RectangleArea(width , height);
	    rectangle.RectanglePerimeter(width , height);
	    
	    }
	}
	}
     class Shape{
    	 String name;
    	 
    	 
    	 public Shape(String name) {
    	   this.name = name;
    	 }
    	 public void displayInfo() {
    		 System.out.println("The Shape is" + name);
    		 
    		 
    		 
    		 
    	 }
     }
    	 class Rectangle extends Shape{
    	 int width;
    	 int height;
    	  public Rectangle(String name, int width, int height) {
    		  super(name);
    	      this.width = width;
    	      this.height = height;
    	  }
    	  
    	  public void RectangleArea(int width, int height) {
    	    int area = width * height;
    	 System.out.printf("Rectangle Area: %d\n" , area);
    	  }
    	  public void RectanglePerimeter(int width, int height) {
    	 int perimeter = 2 * (width + height);
    	 System.out.printf("Rectangle Perimeter: %d\n" , perimeter);
    	 
     }
    	   public void displayInfo() {
    	  
    	  
    	  
    	   } 
    	 }
    	 
    	
    	 class Circle extends Shape{
    	  private static int radius;
    		 DecimalFormat df = new DecimalFormat("0.000");
    		 public Circle(String name, int radius) {
    			 super(name);
    		 
    		  this.name = name;
    		  this.radius = radius;
    		 }
    		 public void CircleArea(int radius) {
    		 double area2 = Math.PI * radius * radius;
    		 System.out.println("Circle Area: " + df.format(area2));
    		 }
    		 public void CircleCircumference(int radius) {
    	      double perimeter2 = 2 * Math.PI * radius;
    	  System.out.println("Circle Circumference: " + df.format(perimeter2));
    		 }
    		 public void display() {
    		 
    		 }
    		 
    		 
    		 
    	 }
    		 
    		 
    		 
    		 
    		 
