package org.slowpoke.arithmetics.stress.tests;

import java.util.Random;

import org.slowpoke.arithmetics.VeryLargeNumber;

public class TestData {
	private Random random = new Random(System.currentTimeMillis());

	private int digits1;
	private int digits2;
	private long executeTime;
	private String arg1;
	private String arg2;
	private String result;
	private Operation operation = Operation.add;

	public int getDigits1() {
		return digits1;
	}

	public void setDigits1(int digits1) {
		this.digits1 = digits1;
	}

	public int getDigits2() {
		return digits2;
	}

	public void setDigits2(int digits2) {
		this.digits2 = digits2;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public long getExecuteTime() {
		return executeTime;
	}

	public String getArg1() {
		return arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public String getResult() {
		return result;
	}

	public void perform() {
		this.arg1 = generateRandomNumber(this.digits1);
		this.arg2 = generateRandomNumber(this.digits2);
		this.executeTime = System.currentTimeMillis();
		this.result = operation.perform(this.arg1, this.arg2);
		this.executeTime = System.currentTimeMillis() - this.executeTime;

		// Prepare text for showing:
		this.arg1 = split(this.arg1);
		this.arg2 = split(this.arg2);
		this.result = split(this.result);
	}

	private String split(String src) {
		StringBuilder sb = new StringBuilder(src.length());
		for (int i = 0; i < src.length(); i++) {
			sb.append(src.charAt(i)).append(' ');
		}
		return sb.toString();
	}

	private String generateRandomNumber(int digits) {
		int pointPos = 1 + random.nextInt(digits - 1);
		StringBuilder sb = new StringBuilder(digits);
		for (int i = 0; i < digits; i++) {
			sb.append(random.nextInt(10));
			if (pointPos == i) {
				sb.append('.');
			}
		}
		return sb.toString();
	}

	public enum Operation {
		add("Add") {
			@Override
			protected String perform(String s1, String s2) {
				return VeryLargeNumber.add(s1, s2);
			}
		},
		sub("Subtract") {
			@Override
			protected String perform(String s1, String s2) {
				return VeryLargeNumber.sub(s1, s2);
			}
		},
		mul("Multiply") {
			@Override
			protected String perform(String s1, String s2) {
				return VeryLargeNumber.mul(s1, s2);
			}
		},
		div("Divide") {
			@Override
			protected String perform(String s1, String s2) {
				return VeryLargeNumber.div(s1, s2);
			}
		};
		protected abstract String perform(String s1, String s2);

		private final String displayName;

		private Operation(String displayName) {
			this.displayName = displayName;
		}

		public String getDisplayName() {
			return this.displayName;
		}
	}

}
