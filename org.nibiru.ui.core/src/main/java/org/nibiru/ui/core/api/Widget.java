package org.nibiru.ui.core.api;

import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.Size;

public interface Widget {
	String STYLE_NAME_PREFIX = "nibiru_";

	Object asNative();

	void setStyleName(Enum<?> styleName);

	void setHeight(Size height);
	
	void setWidth(Size width);
	
	void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec);
	
	int getMeasuredHeight();

	int getMeasuredWidth();

	void layout();
}
