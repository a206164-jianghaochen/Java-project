package interfaceTest;
public class TestClass1 {	
	public static void main(String[] args) {
	ExampleInterface exampleInterface = new ImplementClass();
	         exampleInterface.method1();
	         System.out.println(exampleInterface.j);	
	}
}
  interface ExampleInterface{
	  int i = 20;
	  int j = 10;
	  void method1();	 	  
  }
  interface ExampleInterface1{
	  String str = "interface";	  	  
	  void method2();  
  }
  interface ExampleInterface2 extends ExampleInterface,ExampleInterface1{
	  	  	  
	  
	  
	  
	  
  }