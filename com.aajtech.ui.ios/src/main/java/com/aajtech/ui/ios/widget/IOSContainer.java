package com.aajtech.ui.ios.widget;

import org.robovm.apple.uikit.UIView;

import com.aajtech.ui.core.api.Container;
import com.aajtech.ui.core.api.Widget;

abstract class IOSContainer extends IOSWidget<UIView> implements Container {
	IOSContainer() {
		super(new UIView());
	}

	@Override
	public void add(Widget widget) {
		IOSWidget<?> iOSWidget = (IOSWidget<?>) widget;
		control.addSubview(iOSWidget.control);
		iOSWidget.setParent(this);
		layout();
	}

	abstract void layout();
}
