package topK;

import java.util.Scanner;

public class Top_K {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the size of the list: ");
		int n = sc.nextInt();
		if(n <= 0) {
			System.out.println("Please enter a positive number");
			sc.close();
			return;
		}
		System.out.println("Please enter the K: ");  //Top-K
		int k = sc.nextInt();
		if(n < k) {
			System.out.println("k cannot be greater than n.");
			sc.close();
			return;
		}
		int arr[] = new int[n];
		System.out.println("Please enter " + n + " integers: ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = (k - 2)/2; i >= 0; i--) {
			minHeapify(arr, k, i);
		}
		for(int i = k; i < n; i++) {
			if(arr[i] > arr[0]) {
				arr[0] = arr[i];
				minHeapify(arr, k, 0);	
			}
		}
		System.out.printf("The top-%d list is: \n", k);
		for(int i = 0; i < k; i++) {
			System.out.print(arr[i] + "\t");
		}
		sc.close();
	}
	private static void minHeapify(int arr[], int n, int i) {	
		while(true) {	
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			int currentSmallest = i;
			
			if(l < n && arr[l] < arr[currentSmallest]) {
				currentSmallest = l;
			}
			if(r < n && arr[r] < arr[currentSmallest]) {
				currentSmallest = r;
			}
			if(currentSmallest != i) {
				swap(arr, currentSmallest, i);
				i = currentSmallest;
			}else {
				break;
			}			
		}			
	}
	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}
