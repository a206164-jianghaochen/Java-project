package testMethod;

public class Person {
	
      private int pid;
	  private String pName;
	  private int age;
	  private static int total;
	public Person(int id, String name, int age) {
		this.pid = id;
		this.pName = name;
		this.age = age;	
		total++;
	}
	
	public int getPid() {
		return pid;
	}
	public String getPName() {
		return pName;
	}
	public int getAge() {
		return age;
	}
	public static int getTotal() {
		return total;		
	}
	
	
	
	
	
}
