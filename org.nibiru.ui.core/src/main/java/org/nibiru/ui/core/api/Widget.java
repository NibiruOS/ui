package org.nibiru.ui.core.api;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Style;

import javax.annotation.Nullable;

public interface Widget {
	Object asNative();

	void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec);

	int getMeasuredHeight();

	int getMeasuredWidth();

	int getFullMeasuredHeight();

	int getFullMeasuredWidth();

	void layout();

	@Nullable
	IsParent getParent();

	void setParent(@Nullable IsParent parent);

	void setStyle(Style style);

	Style getStyle();

	void applyStyle();

	Value<Boolean> getVisible();
}
