package dataStructureAlgorithm;
import java.util.Scanner;
public class YangHui {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();		
		int[][] triangle = new int[row][];
		for(int i = 0; i < triangle.length; i++) {
			triangle[i] = new int[i + 1];	
		}
		for(int i = 0; i < triangle.length; i++) {
			for(int j = 0; j < triangle[i].length; j++) {
				if(i == 0 || j == 0 || i == j) {
					triangle[i][j] = 1;				
				}else {
					triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];					
				}
				System.out.print(triangle[i][j] + " ");			
			}
			System.out.println();			
		}
	}
}
