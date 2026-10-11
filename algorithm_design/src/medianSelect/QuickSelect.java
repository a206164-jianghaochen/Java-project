package medianSelect;

import java.util.Scanner;
public class QuickSelect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the size of the list: ");
		int n = sc.nextInt();
		if(n <= 0) {
			System.out.println("Please enter a positive number");
			sc.close();
			return;
		}
		System.out.println("Please enter the k for top-k: ");
		int k = sc.nextInt();
		if(n < k) {
			System.out.printf("The list size (%d) is smaller than Top-%d!\n", n, k);
			sc.close();
            return;
		}
		int arr[] = new int[n];
		System.out.println("Please enter " + n + " integers");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target_index = n - k;
		quickSelect(arr, 0, n - 1, target_index);
		System.out.printf("The top %d elements are: ", k);
		for(int i = target_index; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}
	public static int lomutoPartitioning(int[] arr, int left, int right) {
		swap(arr, left, left + (right - left)/2);
		int pivot = arr[left];
		int s = left;
		for(int i = left + 1; i <= right; i++) {
			if(arr[i] < pivot) {
				s++;
				swap(arr, s, i);
			}	
		}
		swap(arr, s, left);
		return s;	
	}
	public static int quickSelect(int[] arr, int left, int right, int target_index) {
		if(left == right) {
			return arr[left];
		}
		int s = lomutoPartitioning(arr, left, right);
		if(s==target_index) {
			return arr[s];
		}else if(s > target_index) {
			return quickSelect(arr, left, s - 1, target_index);
		}else {
			return quickSelect(arr, s + 1, right, target_index);
		}	
	}
	public static void swap(int[] arr,int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
