package driver;
public class FarmApp {
    public static void main(String[] args) {
	  Animal animal = new Animal("Animal");
	  Bird bird = new Bird("Bird");
	  Dog dog = new Dog("Dog");
	    dog.move();
	  Duck duck = new Duck("Duck");
	  duck.move();
	 
	  Chicken chicken = new Chicken("Chicken");
	  chicken.move();
    }
}
   class Animal {
	   String animal_type;
	   public Animal(String animal_type) {
		   this.animal_type = animal_type;
	   }
	   public void move() {
	   }
   }
   class Bird extends Animal{
	   public Bird(String animal_type) {
		   super(animal_type); 
	   }
	   public void move() {
   }
   }
   class Dog extends Animal{
	   public Dog(String animal_type) {
		   super(animal_type);
	   }
	   public void move() {
	System.out.println(animal_type + " can walk and run");
	   System.out.println(animal_type + " also can jump");
   }
   }
   class Chicken extends Bird{
	   public Chicken(String animal_type) {
		   super(animal_type);
		   System.out.println(animal_type + " can walk and run");
		   System.out.println(animal_type + " also can fly");
	   }
   }
    class Duck extends Bird{
    	
    	public Duck(String animal_type) {
    	super(animal_type);
    	}
   public void move() {
	   System.out.println(animal_type + " can walk and run");
	   System.out.println(animal_type + " also can fly");
	   System.out.println(animal_type + " also can swim"); 
   }
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   