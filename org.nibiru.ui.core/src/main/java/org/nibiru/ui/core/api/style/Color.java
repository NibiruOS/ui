package org.nibiru.ui.core.api.style;

public class Color {
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GREEN = new Color(0, 255, 0);
	public static final Color BLUE = new Color(255, 0, 0);
	private final int red;
	private final int green;
	private final int blue;
	private final int alpha;

	public Color(int red, int green, int blue) {
		this(red, green, blue, 255);
	}

	public Color(int red, int green, int blue, int alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}

	public int getAlpha() {
		return alpha;
	}

	public String asCss() {
		return "rgba(" + red + ", " + green + ", " + blue + ", " + alpha / 255f + ")";
	}
}
