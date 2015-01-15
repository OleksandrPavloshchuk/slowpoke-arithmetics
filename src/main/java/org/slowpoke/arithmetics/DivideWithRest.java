package org.slowpoke.arithmetics;

import static org.slowpoke.arithmetics.VeryLargeNumber.mul;

public class DivideWithRest extends BinaryOperation {

	private final String[] digitProducts = new String[10];
	private Number lastProbe = null;
	private Number rest = new Factory().createZero();
	private int sign = 1;

	DivideWithRest() {
		this.digitProducts[0] = "0";
	}

	@Override
	Number perform(Number n1, Number n2) {
		final Number trivial = calculateTrivial(n1, n2);
		if (null != trivial) {
			return trivial;
		}

		prepareDigitProducts(n2);

		Number result = new Number();
		final int orderDiff = getOrderDifference(n1, n2);
		this.rest = n1;
		for (int order = orderDiff; order >= 0; order--) {
			int digit = findDigit(order);
			result.setDigit(order, digit);
			rest = new SubtractAbs().perform(rest, lastProbe);
		}

		result.setSign(sign);
		return result;
	}

	private Number calculateTrivial(Number n1, Number n2) {
		if (n2.isZero()) {
			throw new IllegalArgumentException("Divide by zero");
		}
		if (n1.isZero() || n2.isA("1")) {
			return new Factory().createCopy(n1);
		}
		if (n2.isA("-1")) {
			final Number result = new Factory().createCopy(n1);
			result.setSign(-result.getSign());
			return result;
		}

		final int compareAbs = n1.compareAbs(n2);
		sign = n1.getSign() * n2.getSign();

		if (0 > compareAbs) {
			this.rest = new Factory().createCopy(n1);
			return new Factory().createZero();
		} else if (0 == compareAbs) {
			return new Factory().createFrom("1").setSign(sign);
		}
		return null;
	}

	Number getRest() {
		return rest;
	}

	private void prepareDigitProducts(Number n) {
		for (int i = 1; i < this.digitProducts.length; i++) {
			this.digitProducts[i] = mul(n.toString(), String.valueOf(i));
		}
	}

	private int findDigit(int order) {
		for (int i = 9; i >= 0; i--) {
			this.lastProbe = new Factory().createFrom(this.digitProducts[i])
					.multiplyTo10(order);
			if (0 >= this.lastProbe.compareAbs(rest)) {
				return i;
			}
		}
		return 0;
	}

	// Difference of the number orders
	private int getOrderDifference(Number n1, Number n2) {
		int size1 = n1.getDigitsCount() - n1.getPointOffset();
		int size2 = n2.getDigitsCount() - n2.getPointOffset();
		return size1 - size2;
	}

}
