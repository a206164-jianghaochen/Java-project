package driver;
import java.text.DecimalFormat;
import java.util.Scanner;
public class ChairApp {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.0");
	int num = sc.nextInt();
	  for(int i = 0; i < num; i++) {
		double loadCapacity = sc.nextDouble();
	    String color = sc.next();
	    Chair chair = new Chair(loadCapacity, color);
        System.out.println(chair.toString());
	    int row = sc.nextInt();
	     int col = sc.nextInt();
	     String name = sc.next();
	     FixedChair fc = new FixedChair(loadCapacity, name, row, col);
	     System.out.println(fc);
	     int weight = sc.nextInt();
	     if(weight <= loadCapacity) {
	     Person person = new Person(name, weight);
	     System.out.println(person.toString());
	     }else if(weight > loadCapacity) {
	    	 Person person2 = new Person(name, weight);
	    	 person2.setWeight(weight);
	     
	    	 
	    	 
	     }
}
	  System.out.println();
}
}
  class Chair{
     double loadCapacity;
     String color;
     public Chair(double loadCapacity, String color) {
    	 this.loadCapacity = loadCapacity;
    	 this.color = color;
     }
       public double getLoadCapacity() {
         return loadCapacity;
       }
       public String getColor() {
       return color;
       }
       public String toString() {
    	   return "The chair can bear up to " + getLoadCapacity() + "kg and its color is " + getColor();
     
       }
    	 
     }
  class FixedChair extends Chair{
   int row;
   int col;
   Person sitter;
     public FixedChair(double loadCapacity, String Name, int row, int col) {
    	 super(loadCapacity, Name);
     
      this.row = row;
      this.col = col;
     }
     public void setSitter() {
     this.sitter = sitter;
     
     }
     
        public Person getSitter() {
    	 return sitter;
    	 
        }
        
        public void occupiedBy(Person person) {
        
        }
        public String toString() {
        	
        	return "Location of chair is row " + row + " column " + col;
        	
        	
   
        }
  }
   class Person{
	   DecimalFormat df = new DecimalFormat("0.0");
   String name;
   double weight;
   public Person(String name, double weight) {
      this.name = name;
      this.weight = weight;
   
   }
      public void setWeight(double weight) {
   
   
      }
      public String getName() {
   return name;
    	  
    	  
      }
       public double getWeight() {
   return weight;
   
       }
       
       public String toString() {
        return "The chair can bear " + getName() + " that has weight of " + df.format(getWeight()) + "kg!";
   
    	   
    	   
    	   
    	   
    	   
    	   
       }
   
   }
   
   
   
   
   
   
  
  
  
  
  
  