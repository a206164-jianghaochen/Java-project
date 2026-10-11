
public class Person {
	private String name;
	private Person father;
	private Person mother;
	
	public Person(String n) {
		name = n;
	}	
	public Person(String n, Person f, Person m) {
		name = n;
		father = f;
		mother = m;
	}
	
	public String getName() {
		return name;
	}
	
	public Person getFather() {
		return father;
	}
	
	public Person getMother() {
		return mother;
	}	
}
