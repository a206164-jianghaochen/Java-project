package dataStructureAlgorithm;
import java.util.Scanner;
public class YangHuiTriangle {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 int row = sc.nextInt();
    	 int[][] arr = new int[row][row];
    	 for(int i = 0; i < row; i++) {
    		 for(int j = 0; j < i + 1; j++) {
    			 if(i == 0 || j == 0 || i == j) {
    				 arr[i][j] = 1;
    			 }else {
    				 arr[i][j] = arr[i-1][j] + arr[i-1][j-1];			 
    			 }
    			 System.out.print(arr[i][j] + " "); 			 
    		 }
    		 System.out.println(); 		 
    	 } 	 
     }
}
