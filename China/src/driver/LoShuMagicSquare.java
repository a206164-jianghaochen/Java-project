package driver;
import java.util.HashSet;
import java.util.Scanner;

public class LoShuMagicSquare {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <=N; caseNumber++) {
        	int[][] square = new int[3][3];
        	for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    square[i][j] = scanner.nextInt();
                }          
        	}     
                boolean result = ifLoShuMagicSquare(square);
                System.out.println("Case # " + caseNumber + ": " + (result ? "Yes" : "No"));
        }
        scanner.close();
	}

	   public static boolean ifLoShuMagicSquare(int[][] square) {
		   int magicSum = 0;
	        for (int i = 0; i < 3; i++) {
	            magicSum += square[0][i];
	        }
	        for (int i = 0; i < 3; i++) {
	            int rowSum = 0;
	            for (int j = 0; j < 3; j++) {
	                rowSum += square[i][j];
	            }
	            if (rowSum != magicSum) {
	                return false;
	            }
	        }
	        
	        
	        for(int i = 0; i < 3; i++) {
	          int columnSum = 0;
	        for(int j = 0; j < 3; j++) {
	        columnSum += square[j][i];
	        }
	        if(columnSum != magicSum) {
	           return false;
	        }
	     }
	        int  diagonalSum = square[0][0]+square[1][1]+square[2][2];
	        if(diagonalSum != magicSum) {
	        return false;
	        }
	        HashSet<Integer> elements = new HashSet<>();
	        for(int i = 0; i < 3; i++) {
	        for(int j = 0; j < 3; j++) {
	        int num = square[i][j];
	        if(num < 1 || num > 9 || !elements.add(num)) {
	        return false;
	        }
	       }
	      }
			return true;
	   }    
}
	        