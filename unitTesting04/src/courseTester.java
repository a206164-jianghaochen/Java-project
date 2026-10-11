import static org.junit.Assert.*;
import org.junit.Test;

public class courseTester {
       Course course = new Course("TTTK2023", "Java Programming");
       Lecturer lec = new Lecturer("John Doe");
	@Test
	public void testGetName() {
		assertNotNull(course.getName());
	}
	@Test
	public void testGetCode() {
		assertNotNull(course.getCode());
	}
	@Test
	public void testGetLecturer() {
		assertNotNull(lec.getName());
	}
	@Test
	public void testLecturer() {
		assertNotNull(course.getLecturer());
	}

}
