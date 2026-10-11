package animal;

public class Animal {
      protected String animal_type;
	
	public Animal(String a) {
		animal_type = a;
	}
	
	public void move() {
		System.out.println(animal_type + " can walk and run");
	}
	
}
