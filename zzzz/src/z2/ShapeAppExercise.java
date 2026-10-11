package z2;
import java.util.Scanner;
public class ShapeAppExercise {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       double width = sc.nextDouble();
       double height1 = sc.nextDouble();
       double base = sc.nextDouble();
       double height2 = sc.nextDouble();
       Shape[] shapes = {new Rectangle(width, height1), new Triangle(base, height2)};
       ShapePrinter shapeP = new ShapePrinter();	   
       shapeP.printAreas(shapes);	   
   }
}
class Shape {  
    public double getArea() {
        return 0.0;
    }
}
class Rectangle extends Shape {
    double width;
    double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }    
    @Override
    public double getArea() {
        return width * height;
    }
}
class Triangle extends Shape {
    double base;
    double height;   
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }   
    @Override
    public double getArea() {
        return base * height * 0.5;
    }
}
class ShapePrinter {
    public void printAreas(Shape[] shapes) {
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                System.out.printf("Rectangle Area: %.1f\n", shape.getArea());
            } else if (shape instanceof Triangle) {
                System.out.printf("Triangle Area: %.1f\n", shape.getArea());
            }
        }
    }
}

