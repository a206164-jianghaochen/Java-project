package machinetest;
import java.util.*;
public class DEFWashMachine {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
  Random r = new Random();
  int serviceTime = 0;
	int totalNumCustomers = 0;
	int customerType1 = 0;
	int customerType2 = 0;
	int currentTime = 0;
	int machineAvailableTime = 0;
	int totalWaitingTime = 0;
	int longestWaitingTime = 0;
	int N = sc.nextInt();
	for(int i = 0; i < N; i++) {
		int arrivalTime = currentTime + r.nextInt(10) + 1;
		int serviceType = r.nextInt(2) + 1;
		if(serviceType == 1) {
			serviceTime = 6;			
		}else if(serviceType == 2) {
			serviceTime = 10;			
		}
		int waitingTime = Math.max(0, machineAvailableTime - arrivalTime);
		totalWaitingTime += waitingTime;
        longestWaitingTime = Math.max(longestWaitingTime, waitingTime);
		if(serviceType == 1) {
			customerType1 ++;
		}else {
			customerType2 ++;
		}
		machineAvailableTime = arrivalTime + waitingTime + serviceTime;
        currentTime = arrivalTime;
        totalNumCustomers++;
    }
	double averageWaitingTime = (double) totalWaitingTime / totalNumCustomers;
	 System.out.println("Total customers: " + totalNumCustomers);
     System.out.println("Number of customers for service of type 1: " + customerType1);
     System.out.println("Number of customers for service of type 2: " + customerType2);
     System.out.println("Longest customer waiting time: " + longestWaitingTime);
     System.out.println("Average customer waiting time: " + averageWaitingTime);
 }
}

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	

