package org.slowpoke.arithmetics;

class Divide extends BinaryOperation {

	@Override
	Number perform(Number n1, Number n2) {
		if( n2.isZero() ) {
			throw new IllegalArgumentException("Divide by zero");
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
