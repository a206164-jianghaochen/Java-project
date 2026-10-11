package driver;

public class Test002 {
  public static void main(String[] args) {
	  X x = new Y();
      x.staticMethod();
     System.out.println(x.name);
     XY xy = new XY("superHero");
     System.out.println(xy.toGetZ());
	  ZW zw = new ZW("niubi", 23);
	  System.out.println(zw.toGetZ());
	  
  }
}
class X {
	String name = "class1";
           public void staticMethod() {
             System.out.println("Static method in class X");       
         }
      }
class Y extends X {
	    String name = "class2";
           public void staticMethod() {
              System.out.println("Static method in class Y");
       }
    }    
            interface Z{
    	    public String toGetZ();
          }
    	 
          class XY implements Z{
    	   String name;
    	   public XY(String name) {
    	   this.name = name;
    	     }
    	   public String toGetZ() {
    		 return "My name is " + name;
    	   }   	 
       }   
     class ZW extends XY{
    	 String superName;
    	 public ZW(String name, int age) {
    		 super(name);
    		 this.superName = name; 
    	 }	 
    	 public String toGetZ() {
    		 return "My name is spiderman" ; 
    	 }
   
     }
    	 
    	 
    	 
    	 
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    	 
    	 
     
              