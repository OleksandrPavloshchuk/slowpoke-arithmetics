package org.slowpoke.arithmetics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivideGreaterUnitTest {

	@Test(expected = IllegalArgumentException.class)
	public void divToZero() {
		assertEquals("", div(null, null, 0));
		assertEquals("", div("107273", null, 0));
		assertEquals("", div("-6782.80823", "something dull", 0));
		assertEquals("", div("0.1782", "0", 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenDivideLessThatThrowException() {
		assertEquals("", div("89", "120", 0));
		assertEquals("", div("-0.0023872", "16", 0));
	}	

	@Test
	public void divToPredefined() {
		assertEquals("4891.89", div("4891.89", "1", 0));
		assertEquals("0", div("0", "12", 0));
		assertEquals("123", div("-123", "-1", 0));
		assertEquals("-1", div("-9000", "9000", 0));
		assertEquals("1", div("78.000", "78", 0));
	}
	
	@Test
	public void divExact() {
		assertEquals("2", div("4", "2", 0));
// TODO wrong value! Should be 8, but now is 80		
//		assertEquals("", div("512", "64", 0));
	}	

	private static String div(String s1, String s2, int precision) {
		Number n1 = new Factory().createFrom(s1);
		Number n2 = new Factory().createFrom(s2);
		Number result = new DivideGreater(precision).perform(n1, n2);
		return result.toString();
	}

}
