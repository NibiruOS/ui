package org.nibiru.ui.gwt.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.impl.BaseControlWidget;
import com.google.gwt.user.client.ui.Widget;

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
		String height = control.getElement().getStyle().getHeight();
		control.getElement().getStyle().clearHeight();
		int nativeHeight = control.getOffsetHeight();
		control.setHeight(height);
		return nativeHeight;
	}

	@Override
	protected int getNativeWidth() {
		String width = control.getElement().getStyle().getWidth();
		control.getElement().getStyle().clearWidth();
		int nativeWidth = control.getOffsetWidth();
		control.setWidth(width);
		return nativeWidth;
	}

	@Override
	protected void setNativeSize(int measuredWidth, int measuredHeight) {
		control.setWidth(measuredWidth + "px");
		control.setHeight(measuredHeight + "px");
	}
}
