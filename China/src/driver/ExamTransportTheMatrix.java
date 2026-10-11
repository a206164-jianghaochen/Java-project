package driver;

import java.util.Scanner;

public class ExamTransportTheMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M,N;
		M = sc.nextInt();
		N = sc.nextInt();
		int[][] arrwithouttransport = new int[M][N];
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
				arrwithouttransport[i][j] = sc.nextInt();
			}
		}
		System.out.println("Printing Matrix without transpose:");
		for(int i = 0; i<M; i++) {
			for(int j = 0; j<N; j++) {
		System.out.print(arrwithouttransport[i][j] + " ");
	}
         System.out.println();
}
		System.out.println("Printing Matrix After Transpose:");
		displayMatrix(M, N, arrwithouttransport);
	}
	
	public static void displayMatrix(int M, int N, int[][] arrwithouttransport) {
		int[][] arrhastransport = new int[M][N];
	
		for(int i = 0;i<M;i++) {
			for(int j = 0; j<N; j++) {
		arrhastransport[i][j] = arrwithouttransport[j][i];
		System.out.print(arrhastransport[i][j] + " ");
	}
			System.out.println();
		}
	}
}
	 
       