package com.aajtech.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import com.aajtech.ui.core.impl.BaseControlWidget;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.TextMetrics;

abstract class GwtWidget<T extends Widget> extends BaseControlWidget<T> {

	GwtWidget(T control) {
		super(control);
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		checkNotNull(styleName);
		control.addStyleName(STYLE_NAME_PREFIX + styleName.name().toLowerCase());
	}

	@Override
	protected int getNativeHeight() {
//		String height = control.getElement().getStyle().getHeight();
//		control.getElement().getStyle().clearHeight();
//		int nativeHeight = control.getOffsetHeight();
//		control.setHeight(height);
		TextMetrics metrics = TextMetrics.get();
		return metrics.getHeight(control.getElement().getInnerText());
	}

	@Override
	protected int getNativeWidth() {
//		String width = control.getElement().getStyle().getWidth();
//		control.getElement().getStyle().clearWidth();
//		int nativeWidth = control.getOffsetWidth();
//		control.setWidth(width);
		TextMetrics metrics = TextMetrics.get();
		return metrics.getWidth(control.getElement().getInnerText());
	}

	@Override
	protected void setNativeSize(int measuredWidth, int measuredHeight) {
		control.setWidth(measuredWidth + "px");
		control.setHeight(measuredHeight + "px");
		control.getElement().getStyle().setOverflow(Style.Overflow.HIDDEN);
	}
}
