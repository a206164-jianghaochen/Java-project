package smallPractise;

import java.util.Objects;

public class Teacher {
    private String name;
	private String address;
	private String teacherid;
	public Teacher(String name, String address, String id) {
		this.name = name;
		this.address = address;
		this.teacherid = id;
	}
	
	public String toString() {
		return "name: " + name + " address: " + address + " teacherid: " + teacherid;						
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Teacher teacher = (Teacher) o;
	        return Objects.equals(name, teacher.name) &&
	                Objects.equals(address, teacher.address) &&
	                Objects.equals(teacherid, teacher.teacherid);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(name, address, teacherid);
	    }
	
	
	
	
}
