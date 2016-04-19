package org.nibiru.ui.core.api;

import javax.annotation.Nullable;

import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;

public interface Widget {
	String STYLE_NAME_PREFIX = "nibiru_";

	Object asNative();

	void setStyleName(Enum<?> styleName);

	void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec);

	int getMeasuredHeight();

	int getMeasuredWidth();

	void layout();

	@Nullable
	IsParent getParent();

	void setParent(@Nullable IsParent parent);

	void setStyle(Style style);

	Style getStyle();

	void applyStyle();
}
