package driver;

import java.util.Scanner;

public class Test001App {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
     Example exm1 = new Example(15 , "starRail");
    System.out.println(exm1);
    GreatExample greatexample = new GreatExample(5, 6, 7,"Genshin");
	   
	   System.out.println(greatexample);
	   System.out.println(greatexample.getName());
       
}
}
   class Example{
	   int value;
	   String name;
	   public Example(int value, String name) {
	   this.value = value;
	   this.name = name;
	   System.out.println("Constructor called with value: " + value);
	   
   }
	   public String toString() {
		   return "Constructor " + value + " and " + name +" is a good one";
	   }
   }
     class GreatExample extends Example{
    	       int value2;
    	       String str;
    	       public GreatExample(int i, int j, int z, String name) {
    	         super(i,name);
    	    	   this.value2 = j;
    	    	   
    	       }
    	       
    	       public String getName() {
    	    	   return name;
    	    	   
    	    	   
    	       }
    	       
    	       
    	       
    	       
    	       
    	       
    	       
    	       
    	       
    	       
    	       
    	       public String toString() {
    	    return "This is a very good example " + value +  " " + name;	   
    	    	   
    	    	   
    	    	   
    	    	   
    	    	   
    	    	   
    	       }
    	 
    	 
    	 
    	 
    	 
    	 
     }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
		   
		   
		   
		   
		   
	   
