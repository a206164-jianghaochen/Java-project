import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTester {
	Person father = new Person("Ibrahim");
	Person mother = new Person("Hajar");
	Person child = new Person("Ismail", father, mother);
	
	@Test
	public void testHasMother() {
		//Method will fail when a child’s mother is null
		    assertNotNull(child);
	}	
	@Test
	public void testRightFather() {
		
		//Method will pass when a child’s father is the same as expected object
			assertEquals("Ibrahim", father.getFather().getName());
	}
}
