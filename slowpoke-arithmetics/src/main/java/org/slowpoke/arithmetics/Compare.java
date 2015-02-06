package org.slowpoke.arithmetics;

class Compare {

	int perform(Number n1, Number n2) {
		final int sign1 = n1.getSign();
		final int sign2 = n2.getSign();
		if (n2.isZero()) {
			if (n1.isZero()) {
				return 0;
			}
			return sign1;
		}
		if (n1.isZero()) {
			return -sign2;
		}
		if (0 > sign1 && 0 < sign2) {
			return -1;
		}
		if (0 < sign1 && 0 > sign2) {
			return 1;
		}

		if (1 == sign1) {
			return n1.compareAbs(n2);
		}
		return n2.compareAbs(n1);
	}
}
