package java2;

	import java.util.Scanner;
	public class main{

		public static void main(String[] args) {
			int NumberGuess = 75;
			int count = 0;
			int num = 0;
			 
			do {
				Scanner sc = new Scanner(System.in );
				System.out.println("input your number");
				num = sc.nextInt();
				if(num > NumberGuess) {
					System.out.println("higher");
				}
				if(num < NumberGuess) {
					System.out.println("lower");
				}
				count++;
			}
			while(num != NumberGuess);
			
				System.out.print("use" + count + "to guess 75");
			}
		}

