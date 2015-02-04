package org.slowpoke.arithmetics;

class Multiply extends BinaryOperation {

	private final AddAbs addAbs = new AddAbs();

	private final Number[] calculatedProducts = new Number[10];

	@Override
	Number perform(Number n1, Number n2) {
		Number result = new Number();
		for (int i = 0; i < n2.getDigitsCount(); i++) {
			result = addAbs.perform(get(n1, n2.getDigit(i)).multiplyTo10(i),
					result);
		}
		result.setSign(n1.getSign() * n2.getSign());
		result.setPointOffset(n1.getPointOffset() + n2.getPointOffset());
		return result;
	}

	private Number get(Number src, int b) {
		Number result = calculatedProducts[b];
		if (null == result) {
			calculatedProducts[b] = multiply(src, b);
			result = calculatedProducts[b];
		}
		return new Factory().createCopy(result);
	}

	private Number multiply(Number src, int b) {
		final Number result = new Number();
		int prev = 0;
		for (int i = 0; i < src.getDigitsCount(); i++) {
			final int n = src.getDigit(i) * b + prev;
			prev = n / 10;
			result.addDigit(n % 10);
		}
		result.addDigit(prev);
		return result;
	}

}
