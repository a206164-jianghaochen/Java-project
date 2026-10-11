package project1;
public class Application {
    public static void main(String args[]) {
    	Flower roseFlower = new Flower();
    	int length = 12;
    	if(length < 2)
    		return;
    	Person[] personInCircle = new Person[length];
    	for(int i = 0; i < personInCircle.length; i++) {
    		personInCircle[i] = new Person();
    		personInCircle[i].personNumber = i + 1;  		
    	}
    	for(int i = 0; i < personInCircle.length; i++) {
    		if(i == 0) {
    			personInCircle[i].setNextPerson(personInCircle[i+1]);
    			personInCircle[i].setPreviousPerson(personInCircle[length - 1]);
    		}
    		else if(i == length - 1) {
    			personInCircle[i].setNextPerson(personInCircle[0]);
    			personInCircle[i].setPreviousPerson(personInCircle[i-1]);
    		}
    		else {
    			personInCircle[i].setNextPerson(personInCircle[i+1]);
    			personInCircle[i].setPreviousPerson(personInCircle[i-1]);  			
    		}    		
    	}
    	 personInCircle[0].setFlower(roseFlower);	
    }
	
}
