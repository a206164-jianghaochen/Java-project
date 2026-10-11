package driver;
import java.util.Scanner;
public class GameDevelopmentApp {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	   int N = sc.nextInt();	   
	       Game01 game = null;
	   if(N == 1) {
		   for(int i = 0; i < 4; i++) {
			   System.out.println("Select your character");
		   String name = sc.next();
		   game = new YuanShen(name);		   
		   }
		   game.start();
		   game.fight();
		   game.result();
	   }else if(N == 2) {
		   for(int i = 0; i < 4; i++) {
			   System.out.println("Select your character");
			   String name = sc.next();		   
		   game = new starRail(name);		
		   }
		   game.start();
		   game.fight();
		   game.result();	  
	   }
	       
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
		   
       }
		  
		  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  

