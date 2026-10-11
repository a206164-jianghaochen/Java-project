package project1;
public class Person {
    int personNumber;
    Flower flowerInhand;
    Person previousPerson;
    Person nextPerson;
    public void setFlower(Flower flower) {
    	flowerInhand = flower;
    	int n = flowerInhand.getRamdomNumber();
    	if(n == 6) {
    		previousPerson.setNextPerson(nextPerson);
    		nextPerson.setPreviousPerson(previousPerson);
    		try {
    			Thread.sleep(1000);
    		}catch(Exception exp) {	
    		}
    		 System.out.println("Number " + personNumber + " has left the game");
    	}
    	if(this == nextPerson) {
    		System.out.println("Number " + personNumber + " is the last person");
    		return;  		
    	}
    	nextPerson.setFlower(flowerInhand);
    }
    	 public void setPreviousPerson(Person person) {
    		previousPerson = person; 	
    }
    public void setNextPerson(Person person) {    	
    	nextPerson = person;
    }      
}
