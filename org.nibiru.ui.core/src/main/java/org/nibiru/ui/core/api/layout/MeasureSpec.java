package org.nibiru.ui.core.api.layout;

public class MeasureSpec {
	public static enum Type {
		AT_MOST, UNSPECIFIED
	}

	public static MeasureSpec UNSPECIFIED = new MeasureSpec(Type.UNSPECIFIED, 0);

	public static MeasureSpec atMost(int value) {
		return new MeasureSpec(Type.AT_MOST, value);
	}

	private final Type type;
	private final int value;

	private MeasureSpec(Type type, int value) {
		this.type = type;
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public int getValue() {
		return value;
	}

}
