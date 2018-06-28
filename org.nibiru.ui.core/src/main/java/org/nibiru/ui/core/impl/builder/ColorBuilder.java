package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.Color;

public class ColorBuilder {
	public static Color color(int red, int green, int blue) {
		return new Color(red, green, blue);
	}

	public static Color color(int red, int green, int blue, int alpha) {
		return new Color(red, green, blue, alpha);
	}
}
