package driver;

public class ParentApp {
public static void main(String[] args) {
	Child c1 = new Child();
	c1.getInfo();
	c1.display();
	
	
}
}
    class Parent{
    	   public Parent() {
    	   System.out.println("Constructor of Parent Class");
    	   }
    	   public void getInfo() {
    		   System.out.println("This is Parent class");
    		   
    	   }
    	   public void display() {
    		   
    		   System.out.println("Execute Parent Method");
    	   }
   }
   
   
    class Child extends Parent{
	   public Child() {
		   super();
		   System.out.println("Constructor of Child class");
	   }
		 public void display()  {
		   System.out.println("Execute Child Method");
		   
		 }
		   
		   
	   
   }
    	   