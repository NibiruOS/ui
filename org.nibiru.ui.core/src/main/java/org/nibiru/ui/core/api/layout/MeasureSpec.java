package org.nibiru.ui.core.api.layout;

public class MeasureSpec {
	/**
	 * Class used to pass restriction from the parent to the children.
	 * AT_MOST -> The parent imposed a maximum size on the child
	 * EXACTLY -> The parent imposed an exact size on the child
	 * UNSPECIFIED -> The parent let the child determine its desired dimension
	 */
	public enum Type {
		AT_MOST, UNSPECIFIED, EXACTLY
	}

	public static MeasureSpec UNSPECIFIED = new MeasureSpec(Type.UNSPECIFIED, 0);

	public static MeasureSpec atMost(int value) {
		return new MeasureSpec(Type.AT_MOST, value);
	}
	
	public static MeasureSpec exactly(int value) {
		return new MeasureSpec(Type.EXACTLY, value);
	}

	private final Type type;
	private final int value;

	private MeasureSpec(Type type,
						int value) {
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