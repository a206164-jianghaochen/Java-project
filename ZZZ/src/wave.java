import java.util.Scanner;

public class wave {
	public static void main(String[] arg) {
		int x,y;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		int i, j , z, h = 1;
		for(h = 1; h <= x; h++ ) {
			z = 1;
		for(i = 1; i <= y; i++) {
			for(j = 1; j <= i; j++) {
				System.out.print(z);
			}
			  z++;
			  System.out.println();
		}z = y - 1;
		for(i = y - 1; i >= 1; i--) {
			for(j = 1; j <= i; j++) {
				System.out.print(z);
	}
			z--;
			System.out.println();
			
}
		  
		}
		}
	}
