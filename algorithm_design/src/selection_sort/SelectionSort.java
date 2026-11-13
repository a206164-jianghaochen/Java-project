package selection_sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {1,4,7,2,3,5,6,9,8,10};
		selection_sort(arr);
		print_result(arr);
	}

	/** Sorts the array in place. Public so the benchmark can drive it directly. */
	public static void selection_sort(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	private static void print_result(int[] arr) {
		for(int element : arr) {
			System.out.print(element + " ");
		}
	}
}
