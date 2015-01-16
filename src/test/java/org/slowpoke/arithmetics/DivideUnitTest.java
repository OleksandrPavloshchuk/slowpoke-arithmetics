package org.slowpoke.arithmetics;

import static org.junit.Assert.assertEquals;
import static org.slowpoke.arithmetics.VeryLargeNumber.div;

import org.junit.Test;

public class DivideUnitTest {
	
	@Test
	public void exact() {
		assertEquals( "12.23", div( "122.3", "10" ) );
	}
	
}
