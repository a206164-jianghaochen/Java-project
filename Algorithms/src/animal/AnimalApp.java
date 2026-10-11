//TK2053-A206164-JiangHaochen-tutorial4-2AK2-SK-ST
package animal;

public class AnimalApp {
       public static void main(String[] args) {
    	   Dog dog = new Dog("Dog");
    	   Duck duck = new Duck("Duck");
    	   Chicken chicken = new Chicken("Chicken");
    	   Bird bird = new Bird("Bird");
    	   Animal animals[] = {dog, duck, chicken, bird};  	   
    	   for(int i = 0; i < animals.length; i++) {
    		   animals[i].move();
    	   }   	   
       }
}
