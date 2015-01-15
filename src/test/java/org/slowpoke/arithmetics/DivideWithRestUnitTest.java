package org.slowpoke.arithmetics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivideWithRestUnitTest {

	@Test(expected = IllegalArgumentException.class)
	public void divToZero() {
		assertEquals("", div(null, null));
		assertEquals("", div("107273", null));
		assertEquals("", div("-6782.80823", "something dull"));
		assertEquals("", div("0.1782", "0"));
	}

	@Test
	public void divLess() {
		divWithRest("0", "0", "0", "56");
		divWithRest("0", "7882", "7882", "10034");
	}

	@Test
	public void trivial() {
		divWithRest("182773", "0", "182773", "1");
		divWithRest("-16", "0", "16", "-1");
		divWithRest("77", "0", "-77", "-1");
		divWithRest("-1", "0", "101", "-101");
		divWithRest("1", "0", "8291", "8291");
	}

	@Test
	public void divExact() {
		divWithRest("2", "0", "4", "2");
		divWithRest("8", "0", "512", "64");
		divWithRest("8908", "0", "1487636", "167");
	}

	@Test
	public void divWithRest() {
		divWithRest("4", "1", "9", "2");
		divWithRest("78505720", "521", "786234786321", "10015");
		divWithRest("1", "1023", "2047", "1024");
	}

	private void divWithRest(String expectedResult, String expectedRest,
			String s1, String s2) {
		final String[] actual = div(s1, s2);
		assertEquals(expectedResult, actual[0]);
		assertEquals(expectedRest, actual[1]);
	}

	private static String[] div(String s1, String s2) {
		final Number n1 = new Factory().createFrom(s1);
		final Number n2 = new Factory().createFrom(s2);
		final DivideWithRest div = new DivideWithRest();
		Number result = div.perform(n1, n2);
		return new String[] { result.toString(), div.getRest().toString() };
	}
}
