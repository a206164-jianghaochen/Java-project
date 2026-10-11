package driver;

import java.util.Scanner;
public class TripleIntegerExam {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
   int N = sc.nextInt();
       int[] arr = new int[N];
       for(int i = 0; i<N; i++) {
       arr[i] = sc.nextInt();
   
   
    	}
       
       display(arr, N);
       
       
    }
    public static void display(int[] arr, int N) {
    	for(int i = N - 1; i>=0; i--) {
    		System.out.print(arr[i] + " ");
    	}
    	
    	
    }
}
       
       
       
       
       
    