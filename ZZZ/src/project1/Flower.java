package project1;
import java.util.*;
public class Flower {
    Random random;
    Flower(){
    random = new Random();	   	
    }
   public int getRamdomNumber() {
	   int number = random.nextInt(8);
	   return number + 1;	   
   }    
}





