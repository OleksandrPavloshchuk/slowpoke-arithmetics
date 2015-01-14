package org.slowpoke.arithmetics;

public class DivideGreater extends BinaryOperation {

	private final int precision;

	DivideGreater(int precision) {
		this.precision = 0 > precision ? 0 : precision;
	}

	@Override
	Number perform(Number n1, Number n2) {
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
		final int sign = n1.getSign() * n2.getSign();
		
		if( 0>compareAbs) {
			throw new IllegalArgumentException("1st argument by module is less that 2nd one");
		} else if (0==compareAbs ) {
			return new Factory().createFrom("1").setSign(sign);
		}
		
		Number result = new Number();

		// TODO Auto-generated method stub

		int pointOffset = n1.getPointOffset() - n2.getPointOffset() + precision;
		if (0 > pointOffset) {
			result.multiplyTo10(-pointOffset);
			result.setPointOffset(0);
		} else {
			result.setPointOffset(pointOffset);
		}
		result.setSign(sign);
		return result;
	}

}
