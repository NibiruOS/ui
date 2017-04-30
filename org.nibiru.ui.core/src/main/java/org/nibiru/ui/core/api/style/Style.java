package org.nibiru.ui.core.api.style;

import com.google.common.base.Function;
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

	public Color getBackgroundColor() {
		return property(backgroundColor, Style::getBackgroundColor, Color.TRANSPARENT);
	}

	public void setBackgroundColor(@Nullable Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Size getWidth() {
		return property(width, Style::getWidth, Size.WRAP_CONTENT);
	}

	public void setWidth(@Nullable Size width) {
		this.width = width;
	}

	public Size getHeight() {
		return property(height, Style::getHeight, Size.WRAP_CONTENT);
	}

	public void setHeight(@Nullable Size height) {
		this.height = height;
	}

	public Alignment getHorizontalAlignment() {
		return property(horizontalAlignment, Style::getHorizontalAlignment, Alignment.START);
	}

	public void setHorizontalAlignment(@Nullable Alignment horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	public Alignment getVerticalAlignment() {
		return property(verticalAlignment, Style::getVerticalAlignment, Alignment.START);
	}

	public void setVerticalAlignment(@Nullable Alignment verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	public int getMarginTop() {
		return property(marginTop, Style::getMarginTop, 0);
	}

	public void setMarginTop(@Nullable Integer marginTop) {
		this.marginTop = marginTop;
	}

	public int getMarginRight() {
		return property(marginRight, Style::getMarginRight, 0);
	}

	public void setMarginRight(@Nullable Integer marginRight) {
		this.marginRight = marginRight;
	}

	public int getMarginLeft() {
		return property(marginLeft, Style::getMarginLeft, 0);
	}

	public void setMarginLeft(@Nullable Integer marginLeft) {
		this.marginLeft = marginLeft;
	}

	public int getMarginBottom() {
		return property(marginBottom, Style::getMarginBottom, 0);
	}

	public void setMarginBottom(@Nullable Integer marginBottom) {
		this.marginBottom = marginBottom;
	}

    private <T, S extends Style> T property(T value,
                                              Function<Style, T> parentValueFunction,
                                              T defaultValue) {
        return property(value,
                parentValueFunction,
                Style.class,
                defaultValue);
    }

    protected <T, S extends Style> T property(T value,
                                              Function<S, T> parentValueFunction,
                                              Class<S> parentClass,
                                              T defaultValue) {
        return MoreObjects.firstNonNull(
				value != null
						? value
						: (parent != null && parentClass.isAssignableFrom(parent.getClass())
							? parentValueFunction.apply((S) parent)
							: null),
				defaultValue);
	}
}
