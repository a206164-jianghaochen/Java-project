import java.util.*;
public class flowerNumbers {
  public static void main(String[] args) {
	  int count = 0;
	  for(int i = 100; i <= 999; i++) {
		  if(isFlowerNumber(i)) {
			  count++;
			  System.out.println(i);
		  }	  
	  }
	  System.out.println("The total of Flower number is: " + count);
	  
  }
  public static boolean isFlowerNumber(int num) {
	  int b,s,g;
	  g = num % 10;
	  s = (num % 100) / 10;
	  b = num / 100;
	  if(Math.pow(g, 3) + Math.pow(s, 3) + Math.pow(b, 3) == num) {
		  return true;
	  }
	  return false;
  }
  
}
