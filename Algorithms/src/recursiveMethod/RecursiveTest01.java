package recursiveMethod;
import java.util.Scanner;
public class RecursiveTest01 {
   public static void main(String[] args) {
	   int[] arr = {2,4,6,8,10,12,14,16,18,20,22,24,26};
	   Scanner sc = new Scanner(System.in);
	   int target = sc.nextInt();
	   int num = FindTargetNumber(arr, 0, arr.length - 1, target);
	   System.out.println("The index of the target number is " + num);	   
   }
   public static int FindTargetNumber(int[] arr, int left, int right, int target) {	   
	   if(left > right) {
		   return -1;		   
	   }
	   int mid = left + (right - left)/2;
	   if(arr[mid] == target) {
		 return mid;  		   
	   }
	   else if(arr[mid] < target) {
		   return FindTargetNumber(arr, mid + 1, right, target);
		   
	   }else {
		   return FindTargetNumber(arr, 0, mid - 1, target);		   
	   }
	   
	   
   }
   
}

  
