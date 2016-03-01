package com.aajtech.ui.core.impl.builder;

import com.aajtech.ui.core.api.Color;
import com.aajtech.ui.core.api.Style;
import com.aajtech.ui.core.api.Style.Alignment;
import com.aajtech.ui.core.api.Style.SizeType;

abstract public class BaseStyleBuilder<T extends Style, B extends BaseStyleBuilder<T, ?>> extends BaseBuilder<T> {
	public BaseStyleBuilder(T style) {
		super(style);
	}

	public B backgroundColor(Color backgroundColor) {
		object.setBackgroundColor(backgroundColor);
		return getThis();
	}

	public B setWidthType(SizeType widthType) {
		object.setWidthType(widthType);
		return getThis();
	}

	public B setHeightType(SizeType heightType) {
		object.setHeightType(heightType);
		return getThis();
	}

	public B setWidth(int width) {
		object.setWidth(width);
		return getThis();
	}

	public B setHeight(int height) {
		object.setHeight(height);
		return getThis();
	}

	public B horizontalAlignment(Alignment horizontalAlignment) {
		object.setHorizontalAlignment(horizontalAlignment);
		return getThis();
	}

	public B verticalAlignment(Alignment verticalAlignment) {
		object.setVerticalAlignment(verticalAlignment);
		return getThis();
	}

	public B marginTop(int marginTop) {
		object.setMarginTop(marginTop);
		return getThis();
	}

	public B marginRight(int marginRight) {
		object.setMarginRight(marginRight);
		return getThis();
	}

	public B marginLeft(int marginLeft) {
		object.setMarginLeft(marginLeft);
		return getThis();
	}

	public B marginBottom(int marginBottom) {
		object.setMarginBottom(marginBottom);
		return getThis();
	}

	@SuppressWarnings("unchecked")
	B getThis() {
		return (B) this;
	}
}
