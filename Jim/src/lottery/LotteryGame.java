package lottery;
import java.util.Random;
public class LotteryGame {
    public static void main(String[] args) {
        String[] prizes = {"3-Stars", "4-Stars", "5-Stars"};
        double[] probabilities = {0.9, 0.094, 0.006};
        int chances = 10;
        Random random = new Random();
        for (int i = 1; i <= chances; i++) {
            String prize = drawPrize(prizes, probabilities, random);
            System.out.println("Congratulations! You won: " + prize + "!\n");
        }      
    }
    public static String drawPrize(String[] prizes, double[] probabilities, Random random) {
        double randomValue = random.nextDouble(); 
        double cumulativeProbability = 0.0;
        for (int i = 0; i < prizes.length; i++) {
            cumulativeProbability += probabilities[i];
            if (randomValue <= cumulativeProbability) {
                return prizes[i];
            }
        }
        return prizes[0];
    }
}
