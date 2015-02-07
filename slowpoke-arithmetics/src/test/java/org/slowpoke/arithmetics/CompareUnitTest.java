package org.slowpoke.arithmetics;

import org.junit.Test;

import static org.slowpoke.arithmetics.VeryLargeNumber.compare;
import static org.junit.Assert.assertEquals;

public class CompareUnitTest {

	@Test
	public void compareDifferentSigns() {
		assertEquals(0, compare("0", "0"));
		assertEquals(-1, compare("0", "1278.0092"));
		assertEquals(1, compare("0", "-34.34021004"));
		assertEquals(1, compare("0.344", "0"));		
		assertEquals(-1, compare("-2340.3", "0"));		
		assertEquals(1, compare("7728.92", "-0.12"));
		assertEquals(-1, compare("-23.5", "13"));
	}
	
	@Test
	public void compareSameSigns() {
		assertEquals(-1, compare("78", "8901.093"));
		assertEquals(1, compare("1803", "1.093"));
		assertEquals(-1, compare("-498.90", "-67.89"));
		assertEquals(1, compare("-0.9023", "-11"));
	}
	
}
