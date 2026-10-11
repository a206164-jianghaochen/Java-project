import java.util.*;

//Your program will be evaluated by this DriverMain class and several test cases.

public class courseReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countlarger = 0;
        int countsmallerequal = 0;
        System.out.println(" ");
         
        for(int i=0; i < 10; i++){
        int num = sc.nextInt();
            if(num > 10){
                countlarger++;
            }else if(num <= 10){
                countsmallerequal++;
            }
        }     
            System.out.print(countlarger + " ");
            System.out.print(countsmallerequal);
        }    
    }

