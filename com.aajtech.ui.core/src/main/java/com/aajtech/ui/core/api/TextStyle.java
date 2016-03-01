package com.aajtech.ui.core.api;

public class TextStyle extends Style {
	public static final TextStyle DEFAULT = new TextStyle();

	private Color textColor;

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
}
