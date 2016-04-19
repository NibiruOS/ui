package org.nibiru.ui.core.api.style;

import com.google.common.base.MoreObjects;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class Style {
	public static final Style DEFAULT = new Style();

	private Style parent;
	private Color backgroundColor;
	private Size width;
	private Size height;
	private Alignment horizontalAlignment;
	private Alignment verticalAlignment;
	private Integer marginTop;
	private Integer marginRight;
	private Integer marginLeft;
	private Integer marginBottom;

	@Nullable
	public Style getParent() {
		return parent;
	}

	public void setParent(@Nullable Style parent) {
		this.parent = parent;
	}

	@Nullable
	public Color getBackgroundColor() {
		return MoreObjects.firstNonNull(
				backgroundColor != null ?
						backgroundColor
						: (parent != null ? parent.getBackgroundColor() : null),
				Color.WHITE);
	}

	public void setBackgroundColor(@Nullable Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Nullable
	public Size getWidth() {
		return MoreObjects.firstNonNull(
				width != null ? width : (parent != null ? parent.getWidth() : null),
				Size.WRAP_CONTENT);
	}

	public void setWidth(Size width) {
		this.width = checkNotNull(width);
	}

	public Size getHeight() {
		return MoreObjects.firstNonNull(
				height != null ? height : (parent != null ? parent.getHeight() : null),
				Size.WRAP_CONTENT);
	}

	public void setHeight(@Nullable Size height) {
		this.height = checkNotNull(height);
	}

	public Alignment getHorizontalAlignment() {
		return MoreObjects.firstNonNull(
				horizontalAlignment != null ? horizontalAlignment : (parent != null ? parent.getHorizontalAlignment() : null),
				Alignment.START);
	}

	public void setHorizontalAlignment(@Nullable Alignment horizontalAlignment) {
		this.horizontalAlignment = checkNotNull(horizontalAlignment);
	}

	public Alignment getVerticalAlignment() {
		return MoreObjects.firstNonNull(
				verticalAlignment != null ? verticalAlignment : (parent != null ? parent.getVerticalAlignment() : null),
				Alignment.START);
	}

	public void setVerticalAlignment(@Nullable Alignment verticalAlignment) {
		this.verticalAlignment = checkNotNull(verticalAlignment);
	}

	public int getMarginTop() {
		return MoreObjects.firstNonNull(
				marginTop != null ? marginTop : (parent != null ? parent.getMarginTop() : null),
				0);
	}

	public void setMarginTop(@Nullable Integer marginTop) {
		this.marginTop = marginTop;
	}

	public int getMarginRight() {
		return MoreObjects.firstNonNull(
				marginRight != null ? marginRight : (parent != null ? parent.getMarginRight() : null),
				0);
	}

	public void setMarginRight(@Nullable Integer marginRight) {
		this.marginRight = marginRight;
	}

	public int getMarginLeft() {
		return MoreObjects.firstNonNull(
				marginLeft != null ? marginLeft : (parent != null ? parent.getMarginLeft() : null),
				0);
	}

	public void setMarginLeft(@Nullable Integer marginLeft) {
		this.marginLeft = marginLeft;
	}

	public int getMarginBottom() {
		return MoreObjects.firstNonNull(
				marginBottom != null ? marginBottom : (parent != null ? parent.getMarginBottom() : null),
				0);
	}

	public void setMarginBottom(@Nullable Integer marginBottom) {
		this.marginBottom = marginBottom;
	}
}
