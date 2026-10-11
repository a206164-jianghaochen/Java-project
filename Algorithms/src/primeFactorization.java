import java.util.Scanner;
public class primeFactorization {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int num = sc.nextInt();
	   primeFactorize(num);
	   
   }
   public static void primeFactorize(int num) {
	   int i = 2;
	   boolean first = true;
	   System.out.print(num + "=");
	   while(num > 1) {
		   if(num % i == 0) {
			   if(!first) {
				   System.out.print("*");
			   }
			   System.out.print(i);
			   first = false;
			   num = num / i;
		   }else {
			   i++;
		   }   
	   }
	   
   }
   
}
