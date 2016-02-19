package com.aajtech.ui.core.api;

public class Style {
	private static int idCounter;
	private final int id;
	private Color backgroundColor;
	private int marginTop;
	private int marginRight;
	private int marginLeft;
	private int marginBottom;

	public Style() {
		this.id = idCounter++;
	}

	public String getId() {
		return "nibiru_mobile_style_" + id;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public int getMarginTop() {
		return marginTop;
	}

	public void setMarginTop(int marginTop) {
		this.marginTop = marginTop;
	}

	public int getMarginRight() {
		return marginRight;
	}

	public void setMarginRight(int marginRight) {
		this.marginRight = marginRight;
	}

	public int getMarginLeft() {
		return marginLeft;
	}

	public void setMarginLeft(int marginLeft) {
		this.marginLeft = marginLeft;
	}

	public int getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(int marginBottom) {
		this.marginBottom = marginBottom;
	}

	public String asCss() {
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		sb.append(getId());
		sb.append(" {\n");
		if (backgroundColor != null) {
			sb.append("  background-color: " + backgroundColor.asCss() + ";\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
