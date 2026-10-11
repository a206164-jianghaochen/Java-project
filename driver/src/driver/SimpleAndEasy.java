package driver;

import java.util.Scanner;

public class SimpleAndEasy {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String[] str = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    	int N = sc.nextInt();
    	for(int i = 0; i < N; i++) {
    	int[] arr = new int[3];
    	for(int j = 0; j < 3; j++) {
    		arr[j] = sc.nextInt();
    	}
    		System.out.println(arr[0] + " " + str[arr[1]-1] + " " + arr[2]);
    		
    		
    		
    	}
    }
}
