package employee;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class TestEmployee {
       public static void main(String[] args) {
    	   List<Employee> emp = new LinkedList<>();
    	   emp.add(new Employee(1001, "zhang", 20));
    	   emp.add(new Employee(1002, "li", 21));
    	   emp.add(new Employee(1004, "zhao", 20));
    	   emp.add(new Employee(1003, "wang", 19));
    	   
    	   for(Employee e : emp) {
    		   if(e.getEid() == 1003) {
    			   emp.remove(e);   			   
    		   } 		   
    	   }
    	   
    	 for(Employee e : emp) {
    		 System.out.println(e);
    	 }
    	 System.out.println();
    	Iterator<Employee> it = emp.iterator();
    	   while(it.hasNext()) {
    		   System.out.println(it.next());
    	   } 	   
       }
}
