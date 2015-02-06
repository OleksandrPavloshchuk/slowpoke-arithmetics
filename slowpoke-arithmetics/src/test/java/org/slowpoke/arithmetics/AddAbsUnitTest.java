package org.slowpoke.arithmetics;

import org.junit.Test;
import org.slowpoke.arithmetics.AddAbs;
import org.slowpoke.arithmetics.Factory;
import org.slowpoke.arithmetics.Number;

import static org.junit.Assert.assertEquals;

public class AddAbsUnitTest {

	@Test
	public void addToNull() {
		assertEquals("0", add(null, null));
		assertEquals("12", add("12", null));
		assertEquals("78", add("something dull", "78"));
	}

	@Test
	public void addWithoutOverflow() {
		assertEquals("10023", add("-10002", "-21"));
		assertEquals("456", add("12", "444"));
	}

	@Test
	public void addWithOverflow() {
		assertEquals("63", add("18", "45"));
		assertEquals("10006", add("-9999", "7"));
		assertEquals("1666665", add("888888", "777777"));
		assertEquals("18694527270786", add("9007263635143", "9687263635643"));
	}
	
	@Test
	public void addWithPoint() {
		assertEquals("1", add("0.5", "-0.5"));
		assertEquals("70110.7898356", add("70012.0000123", "98.7898233"));
		assertEquals("0.900013223", add("0.0000012", "-0.900012023"));
	}	

	private static String add(String s1, String s2) {
		Number n1 = new Factory().createFrom(s1);
		Number n2 = new Factory().createFrom(s2);
		Number result = new AddAbs().perform(n1, n2);
		return result.toString();
	}

}
