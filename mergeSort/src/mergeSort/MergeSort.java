package mergeSort;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {3,1,4,5,2,7,9,8,6,10};
		mergeSort(arr);
		print_result(arr);
	}
	private static void mergeSort(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		for(int size = 1; size < n; size*=2) {
			for(int left = 0; left < n - size; left += size * 2) {
				int mid = left + size - 1;
				int right = (left + size * 2 - 1 < n - 1)? left + size * 2 - 1 : n - 1;
				merger(arr, left, mid, right,temp);
			}		
		}
		
		
	}
	private static void merger(int[] arr, int left, int mid, int right, int[] temp) {
		int k = 0;
		int i = left;
		int j = mid + 1;
		
		while(i <= mid && j <= right) {
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;		
			}else {
				temp[k] = arr[j];
				j++;			
			}
			k++;		
		}
		while(i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;	
		}
		while(j <= right) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		k = 0;
		while(left <= right) {
			arr[left] = temp[k];
			left++;
			k++;
		}
		
	}	
	private static void print_result(int[] arr) {
		for(int element : arr) {
			System.out.print(element + " ");	
		}	
	}	
}
