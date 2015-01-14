package org.slowpoke.arithmetics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.slowpoke.arithmetics.VeryLargeNumber.div;

public class DivideGreaterUnitTest {

	@Test(expected=IllegalArgumentException.class)
	public void divToZero() {
		assertEquals("", div(null, null, 0));
		assertEquals("", div("107273", null, 0));
		assertEquals("", div("-6782.80823", "something dull", 0));
		assertEquals("", div("0.1782", "0", 0));
	}
	
	@Test
	public void divToPredefined() {
		assertEquals("4891.89", div("4891.89", "1", 0));
		assertEquals("0", div("0", "12", 0));
		assertEquals("123", div("-123", "-1", 0));
		assertEquals("-1", div("-9000", "9000", 0));
		assertEquals("1", div("78.000", "78", 0));
	}	


}
