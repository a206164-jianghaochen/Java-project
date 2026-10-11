package driver;

import java.util.Scanner;

public class multiplyTwoMatrices {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int M = sc.nextInt();
	int N = sc.nextInt();
	int[][] matrixA = new int[M][N];
	int[][] matrixB = new int[M][N];
	
	    for(int i = 0; i<M; i++) {
	for(int j = 0; j<N; j++) {
	matrixA[i][j] = sc.nextInt();
	}
}
	    for(int i = 0; i<M; i++) {
	    	for(int j = 0; j<N; j++) {
	    		matrixB[i][j] = sc.nextInt();
	    	}
	    }
	    if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            System.out.println("Matrices must have the same dimensions for multiplication.");
            return;
	    	
	    	
	    	
	    }
	    
	    int[][] result = new int[M][N];
	    for(int i = 0; i<M; i++) {
	    	for(int j = 0; j<N; j++) {
	    		result[i][j] = matrixA[i][j] * matrixB[i][j];
	    	}
	    	}
	    
	    for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
	    }
}
}
