package test;
public class Test01 {
       public static void main(String[] args) { 
    	   Execution exe = new StarRail();
    	   exe.play();   	   
    	   StarRail sr = new StarRail();
    	   sr.defaultMethod();
    	   
       }	
}
     interface Execution{
    	 void play();  
    	 default void defaultMethod() {
    	        System.out.println("Interface default method");
     }     
     }
     class Game implements Execution{
    	 public void play() {
    		 System.out.println("Let's begin!");	 
     }
    	 public void fight() {    		 
    		 System.out.println("We don't have any advanced weapons, but we will win the battle!");
    	 }
     }
     class Pvz extends Game{
    	 public void play() {
    		 System.out.println("Let's select our plants"); 
    	 }
    	 public void fight() {   		 
    		 System.out.println("The flower defeat a strong enemy.");
    	 }	 
     } 
    	 class StarRail extends Game{
    		 public void play() {
        		 System.out.println("Let's select our character. This battle is unavoidable"); 
    	 }
    		 public void fight() {   		 
        		 System.out.println("We use 2 turns to get all rewards on the forgotten hall");
    		 }
    	 }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    	 
    	 
    	 
    	 
    	 
     
    	 
     
     
     
	