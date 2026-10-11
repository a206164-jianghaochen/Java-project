package smallPractise;

public class Practise01 {
      public static void main(String[] args) {
    	  int result = addAll(1,8,3,7);
    	  System.out.println(result);
    	  
      }
	   public static int addAll(int ... para) {
		   int sum = 0;
		   for(int i = 0; i < para.length; i++) {
			   sum += para[i];			   			   
		   }
		   return sum;		   		   
	   }
	
	
	
}
