package Java001;

import java.util.Scanner;

public class revision1 {
	public static void main(String[] args) {
        int[] weight = new int[10];
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for(int i = 0; i < weight.length; i++){
       
           int inputweight = sc.nextInt();
             if(inputweight >= 0 && inputweight < 100) {
            	 weight[i] = inputweight;
            	count++;
            	
            
                 
               
        }
    }
        int sum = 0;
        for(int i = 0; i < weight.length; i++){
            sum = sum + weight[i];
        } 
        System.out.println("Total kg of flour : " + sum);
    
    double average = (double) sum / count;
    System.out.printf("Average kg of flour : %.2f\n", average );

             int max = weight[0];
              for(int i = 0; i < count; i++){
                  if(weight[i]>max){
                      max = weight[i];
                  }  
              }
         System.out.println("Flour sack for Old Folk House A : " + max + "kg");
    }
}


