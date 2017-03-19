package org.nibiru.ui.dotnet.widget;

import org.nibiru.ui.core.impl.BaseControlWidget;

import cli.System.Windows.FrameworkElement;

abstract class DotNetWidget<T extends FrameworkElement> extends BaseControlWidget<T> {
	DotNetWidget(T control) {
		super(control);
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		// Not implemented on Windows
	}

	@Override
	public void applyStyle() {
	}

	@Override
	public void setNativeSize(int measuredWidth, int measuredHeight) {
		control.set_Width(measuredWidth);
		control.set_Height(measuredWidth);
	}
}
