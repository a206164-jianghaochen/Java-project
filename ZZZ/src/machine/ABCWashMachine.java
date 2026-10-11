package machine;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class ABCWashMachine {   
    private static final int SERVICE_TIME = 5; // 5 minutes per car
    public static void main(String[] args) {
        Queue<LocalTime> arrivalQueue = new LinkedList<>();
        Queue<LocalTime> waitQueue = new LinkedList<>();
        Random rand = new Random();       
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(8, 30);
        LocalTime washEnd = LocalTime.of(14, 0);
        LocalTime washStart = null;        
        LocalTime currentTime;
        int nextArrival;
        int totalWaitTime = 0;
        int maxWaitTime = 0;
        int totalServiceTime = 0;
        int numberOfCustomers = 0;
        // Generate random arrival times
        System.out.println("<List of car arrival times>");
        for (currentTime = startTime; currentTime.isBefore(endTime); ) {
            nextArrival = rand.nextInt(10); // nextArrival in the range 0 to 9 minutes
            currentTime = currentTime.plusMinutes(nextArrival);
            if (currentTime.isBefore(endTime)) {
                arrivalQueue.add(currentTime);
                numberOfCustomers++;
                System.out.println("Car arrival: " + currentTime + " << " + endTime);
            }
        }
        // Process the car wash queue
        currentTime = startTime;
        boolean machineBusy = false;
        System.out.println("\n<List of car waiting time information>");
        while (currentTime.isBefore(endTime) || !waitQueue.isEmpty() || !arrivalQueue.isEmpty()) {
            if (!arrivalQueue.isEmpty() && currentTime.equals(arrivalQueue.peek())) {
                waitQueue.add(arrivalQueue.poll());
            }            
            if (machineBusy && currentTime.equals(washEnd)) {
                machineBusy = false;
            }            
            if (!machineBusy && !waitQueue.isEmpty()) {
                washStart = currentTime;
                washEnd = currentTime.plusMinutes(SERVICE_TIME);
                LocalTime arrivalTime = waitQueue.poll();
                int waitingTime = (int) java.time.Duration.between(arrivalTime, washStart).toMinutes();
                totalWaitTime += waitingTime;
                maxWaitTime = Math.max(maxWaitTime, waitingTime);
                totalServiceTime += SERVICE_TIME;
                machineBusy = true;

                System.out.println("Customer: " + washStart 
                        + " waitQueue: " + arrivalTime 
                        + " washEnd: " + washEnd 
                        + " carwait: " + waitingTime 
                        + " maxDur: " + maxWaitTime 
                        + " Totalwait: " + totalWaitTime 
                        + " Totalwork: " + totalServiceTime);
            }
            if (!arrivalQueue.isEmpty()) {
                currentTime = (washEnd.isBefore(arrivalQueue.peek())) ? washEnd : arrivalQueue.peek();
            } else {
                currentTime = washEnd;
            }
        }
        // Calculate and print the report
        double averageWaitTime = numberOfCustomers > 0 ? (double) totalWaitTime / numberOfCustomers : 0;
        System.out.println("\nREPORT");
        System.out.println("Number of customers that arrive by 8:30 am: " + numberOfCustomers);
        System.out.println("Longest waiting time: " + maxWaitTime + " minutes");
        System.out.println("Average waiting time: " + String.format("%.2f", averageWaitTime) + " minutes");
    }
}

