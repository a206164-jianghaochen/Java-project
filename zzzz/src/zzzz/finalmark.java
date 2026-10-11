package zzzz;
import java.text.DecimalFormat;
import java.util.Scanner;

public class finalmark {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        int N1 = sc.nextInt(); // Number of classes

        for (int i = 0; i < N1; i++) {
            double sum = 0;
            int count = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            double mark = sc.nextDouble();

            while (mark != -1) {
                sum += mark;
                count++;
                max = Math.max(max, (int)mark);
                min = Math.min(min, (int)mark);
                mark = sc.nextDouble();
            }

            double average = (double) sum / count;

            System.out.println(df.format(sum) + " " + df.format(average) + " " + max + " " + min);
        }
    }
}

