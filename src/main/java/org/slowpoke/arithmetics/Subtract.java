package org.slowpoke.arithmetics;

class Subtract extends BinaryOperation {

	@Override
	Number perform(Number n1, Number n2) {
		n1.setCommonPointOffset(n2);
		final int sign1 = n1.getSign();
		final int sign2 = n2.getSign();
		if (sign1 != sign2) {
			return new AddAbs().perform(n1, n2).setSign(sign1)
					.setPointOffset(n1.getPointOffset());
		}
		final int compareAbs = n1.compareAbs(n2);
		if (0 < compareAbs) {
			return new SubtractAbs().perform(n1, n2).setSign(sign1)
					.setPointOffset(n1.getPointOffset());
		} else if (0 > compareAbs) {
			return new SubtractAbs().perform(n2, n1).setSign(-sign2)
					.setPointOffset(n1.getPointOffset());
		} else {
			return new Factory().createZero();
		}
	}

}
