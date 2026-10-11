import static org.junit.Assert.*;

import org.junit.Test;

public class bookTester {
     Book bookOne = new Book("Java Programming", "John Doe");
	@Test
	public void testGetTitle() {
		assertEquals("Java Programming", bookOne.getTitle());
	}
	@Test
	public void testGetAuthor() {
		assertEquals("John Doe", bookOne.getAuthor());
	}

}
