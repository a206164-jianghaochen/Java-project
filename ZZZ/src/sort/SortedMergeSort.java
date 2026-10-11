package sort;
import java.util.*;
public class SortedMergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        int N = sc.nextInt();       
        if (N == 0){
            System.out.println("no element present");
            return;
        }        
        for (int i = 0; i < N; i++){
            int num = sc.nextInt();
            list.add(num);           
        }       
        Integer[] array = list.toArray(new Integer[0]);
        mergeSort(array, 0, array.length - 1);
        list = Arrays.asList(array);       
        for (Integer in : list){
            System.out.print(in + " ");
        }  
    }
    private static void mergeSort(Integer[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }
    private static void merge(Integer[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Integer[] leftArray = new Integer[n1];
        Integer[] rightArray = new Integer[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}