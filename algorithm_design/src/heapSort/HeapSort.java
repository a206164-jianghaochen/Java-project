package heapSort;

import java.util.Scanner;

public class HeapSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the size of the list: ");
		int n = sc.nextInt();
		if(n <= 0) {
			System.out.println("Please enter a positive number");
			sc.close();
			return;
		}
		int arr[] = new int[n];
		System.out.println("Please enter " + n + " integers");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		heapSort(arr);

		System.out.println("The sorted list is: ");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	/**
	 * Sorts the array in place: build a max-heap, then repeatedly move the root
	 * to the end and restore the heap. Extracted from main so it can be timed.
	 */
	public static void heapSort(int[] arr) {
		int n = arr.length;
		for(int i = (n - 2) / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for(int i = n - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	public static void heapify(int[] arr, int n, int i) {
		while(true) {
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			int currentLargest = i;
			if(l < n && arr[l] > arr[currentLargest]) {
				currentLargest = l;
			}
			if(r < n && arr[r] > arr[currentLargest]) {
				currentLargest = r;
			}
			if(currentLargest != i) {
				swap(arr, i, currentLargest);
				i = currentLargest;
			} else {
				break;
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
