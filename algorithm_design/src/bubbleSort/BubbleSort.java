package bubbleSort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {3,1,4,5,2,7,9,8,6,10};
		bubbleSort(arr);
		print_result(arr);	
	}
	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}	
			}		
		}	
	}
	private static void print_result(int[] arr) {
		for(int element : arr) {
			System.out.print(element + " ");	
		}	
	}
}
