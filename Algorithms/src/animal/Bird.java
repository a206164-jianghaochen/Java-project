package animal;

public class Bird extends Animal{
    
	public Bird(String a) {
		super(a);		
	}
	public void move() {
		super.move();
		System.out.println(animal_type + " also can fly");
	}
}
