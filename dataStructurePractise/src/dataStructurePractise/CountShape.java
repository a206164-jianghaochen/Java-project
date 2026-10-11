package dataStructurePractise;

import java.util.Scanner;

public class CountShape {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();  //m represents the length;
		int n = sc.nextInt();   //n represents the width;
		int x1,y1,x2,y2;
		int countRec = 0;
		int countSqua = 0;
		for( x1 = 0; x1 <= m; x1++) {
			for(y1 = 0; y1 <= n; y1++) {
				for(x2 = x1+1; x2 <= m; x2++) {
					for(y2 = y1+1; y2<=n; y2++) {
						if(x2-x1 == y2-y1) {
							countSqua++;
							
						}else {
						countRec++;	
						}
					}										
				}								
			}	
		}
		   System.out.println("The amount of Square is: " + countSqua);
		   System.out.println("The amount of Rectangle is: " + countRec);
	
	}

}
