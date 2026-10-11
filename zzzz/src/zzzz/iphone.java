package zzzz;
import java.util.Scanner;



public class iphone {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int z =1;int i = 1; int h = 1; int j =1;
        int N1 = sc.nextInt(); //频率
        int N2 = sc.nextInt(); // 振幅
        for (i = 1; i<=N1; i++) {
        	z = 1;
            for (j = 1; j<= N2; j++) {
                for (  h = 1; h<= j; h++) {
                    System.out.print(z);
                }
                z++;
                System.out.println();
            }   z = N2 -1;
            for ( j = N2 - 1; j>= 1; j--) {
                for(h = 1; h <= j; h++) {
                    System.out.print(z);
                }

                z--;
                System.out.println();

            }






        }
    }


}
