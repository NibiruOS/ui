package com.aajtech.ui.core.api;

import static com.google.common.base.Preconditions.checkNotNull;

public class Style {
	public static final Style DEFAULT = new Style();

	public static enum Alignment {
		START, CENTER, END
	}

	public static enum SizeType {
		FIXED, MATCH_PARENT, WRAP_CONTENT
	}

	private static int idCounter;
	private final int id;
	private Color backgroundColor;
	private SizeType widthType = SizeType.WRAP_CONTENT;
	private SizeType heightType = SizeType.WRAP_CONTENT;
	private int width;
	private int height;
	private Alignment horizontalAlignment = Alignment.START;
	private Alignment verticalAlignment = Alignment.START;
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

	public SizeType getWidthType() {
		return widthType;
	}

	public void setWidthType(SizeType widthType) {
		this.widthType = widthType;
	}

	public SizeType getHeightType() {
		return heightType;
	}

	public void setHeightType(SizeType heightType) {
		this.heightType = heightType;
		widthType = SizeType.FIXED;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		widthType = SizeType.FIXED;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Alignment getHorizontalAlignment() {
		return horizontalAlignment;
	}

	public void setHorizontalAlignment(Alignment horizontalAlignment) {
		this.horizontalAlignment = checkNotNull(horizontalAlignment);
	}

	public Alignment getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(Alignment verticalAlignment) {
		this.verticalAlignment = checkNotNull(verticalAlignment);
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

		switch (widthType) {
		case MATCH_PARENT:
			sb.append("  width: 100%;\n");
			break;

		case WRAP_CONTENT:
			sb.append("  width: auto;\n");
			break;

		case FIXED:
			sb.append("  width: " + width + "px;\n");
			break;

		default:
			break;
		}
		switch (heightType) {
		case MATCH_PARENT:
			sb.append("  height: 100%;\n");
			break;

		case WRAP_CONTENT:
			sb.append("  height: auto;\n");
			break;

		case FIXED:
			sb.append("  height: " + height + "px;\n");
			break;

		default:
			break;
		}

		switch (horizontalAlignment) {
		case START:
			sb.append("  float: left;\n");
			break;

		case CENTER:
			sb.append("  float: center;\n"); // FIXME: Float center does not exist 
			break;

		case END:
			sb.append("  float: rigth;\n");
			break;

		default:
			break;
		}
		sb.append("}");
		return sb.toString();
	}
}
