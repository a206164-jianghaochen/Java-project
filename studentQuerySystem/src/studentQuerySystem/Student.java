package studentQuerySystem;
public class Student {
      private String studentid;
      private Integer age;
      private String address;
      private String name;
      
      public Student(String id, Integer age, String address, String name) {
    	  this.studentid = id;
    	  this.age = age;
    	  this.address = address;
    	  this.setName(name);
      }         
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String toString() {
    	return studentid + " " + age + " " + address + " " + name;
    }
      
}
