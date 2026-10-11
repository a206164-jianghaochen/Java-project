package testMethod;

import java.util.ArrayList;

public class TestPerson {	
	
	private static ArrayList<Person> arr = new ArrayList<>();
	
       public static void main(String[] args) {  	  	   
    	   arr.add(new Person(123, "Jim", 18));
    	   arr.add(new Person(456, "Doe", 19));
    	   arr.add(new Person(789, "James", 20));
    	   System.out.println("The current number of people is: " + Person.getTotal());   	   
       }	
}
