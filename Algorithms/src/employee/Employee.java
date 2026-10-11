package employee;

public class Employee {
     private int eid;
	private String name;
	private int age;
	public Employee(int id, String name, int age) {
		this.setEid(id);
		this.setName(name);
		this.setAge(age);
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "The id is: " + eid + " The name is: " + name + " The age is: " + age;		
	}
	
}
