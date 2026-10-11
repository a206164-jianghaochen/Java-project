package driver;
	import java.util.Scanner;
	public class number {
		public static void main(String[] args) {
			int NumberGuess = 75;
			int count = 0;
			int num = 0;
			 
			do {
				Scanner sc = new Scanner("System.in ");
				System.out.println("请输入猜测的数字");
				num = sc.nextInt();
				if(num > NumberGuess) {
					System.out.println("你猜高了");
				}
				if(num < NumberGuess) {
					System.out.println("你猜低了");
				}
				count++;
			}
			while(num != NumberGuess);
			
				System.out.print("你用了" + count + "次猜对了数字" + 75);
			}
		}


