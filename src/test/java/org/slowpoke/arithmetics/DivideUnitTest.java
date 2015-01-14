package org.slowpoke.arithmetics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.slowpoke.arithmetics.VeryLargeNumber.div;

public class DivideUnitTest {

	@Test(expected=IllegalArgumentException.class)
	public void divToZero() {
		assertEquals("", div(null, null, 0));
		assertEquals("", div("107273", null, 0));
		assertEquals("", div("-6782.80823", "something dull", 0));
		assertEquals("", div("0.1782", "0", 0));
	}


}
