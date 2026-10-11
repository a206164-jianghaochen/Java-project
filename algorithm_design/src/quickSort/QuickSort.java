package quickSort;

import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		System.out.println("Please enter the length of the list: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n <= 0) {
			System.out.println("Please enter an integer number.");
			sc.close();
			return;
		}
		int arr[] = new int[n];
		System.out.println("Please enter n numbers: ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}	
		quickSort(arr, 0, n - 1);
		System.out.println("The sorted list is:");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");		
		}
		sc.close();
	}
	public static void quickSort(int[] arr, int left, int right) {
		if(left < right) {
			int pivotIndex = partition(arr, left, right);
			quickSort(arr, left, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, right);			
		}				
	}
	public static int partition(int[] arr, int left, int right) {
		swap(arr, left, left + (right - left) / 2);
		int pivot = arr[left];
		int i = left + 1;
		int j = right;
		while(true) {
			while(i <= j && arr[i] < pivot) {
				i++;
			}
			while(i <= j && arr[j] > pivot) {
				j--;
			}
			if(i >= j) {
				break;
			}
			swap(arr, i, j);	
		}
		swap(arr, j, left);	
		return j;	
	}
	public static void swap(int[] arr, int a, int b) {	
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;	
	}
}
