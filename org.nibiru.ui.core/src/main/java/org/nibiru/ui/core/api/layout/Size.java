package org.nibiru.ui.core.api.layout;

public class Size {
	public static enum Type {
		EXACTLY, MATCH_PARENT, WRAP_CONTENT
	}

	public static Size MATCH_PARENT = new Size(Type.MATCH_PARENT, 0);
	public static Size WRAP_CONTENT = new Size(Type.WRAP_CONTENT, 0);

	public static Size exactly(int value) {
		return new Size(Type.EXACTLY, value);
	}

	private final Type type;
	private final int value;

	private Size(Type type, int value) {
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
