package animal;

public class Dog extends Animal{
     public Dog(String a) {
    	 super(a);
     }
     public void move() {
    	 super.move();
    	 System.out.println(animal_type + " also can jump");
     }
}
