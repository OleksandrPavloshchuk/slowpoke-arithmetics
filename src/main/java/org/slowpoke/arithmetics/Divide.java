package org.slowpoke.arithmetics;


public class Divide extends BinaryOperation {

	private final int precision;

	Divide(int precision) {
		this.precision = 0 > precision ? 0 : precision;
	}

	@Override
	Number perform(Number n1, Number n2) {
		if (n2.isZero()) {
			throw new IllegalArgumentException("Divide by zero");
		}
		

		// TODO Auto-generated method stub
		return null;
	}

}
