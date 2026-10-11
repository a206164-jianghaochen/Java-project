import static org.junit.Assert.*;
import org.junit.Test;

public class calculatorTester {
         Calculator calc = new Calculator();
	@Test
	public void testSubtraction() {
		assertEquals(8,calc.subtractTwoInteger(10,2));
	}
	@Test
	public void testDivision() {
		assertEquals(8,calc.divideTwoInteger(16,2));
	}

}
