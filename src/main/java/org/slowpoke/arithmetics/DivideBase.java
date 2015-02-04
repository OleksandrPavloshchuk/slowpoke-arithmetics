package org.slowpoke.arithmetics;

abstract class DivideBase extends BinaryOperation {
	private Number rest = new Factory().createZero();

	protected void setRest(Number rest) {
		this.rest = rest;
	}

	Number getRest() {
		return this.rest;
	}

}
