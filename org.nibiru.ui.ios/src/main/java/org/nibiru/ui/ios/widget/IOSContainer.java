package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;
import org.robovm.apple.uikit.UIView;

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

	@Override
	public void clear() {
		for (UIView child : control.getSubviews()) {
			child.removeFromSuperview();
		}
	}

	abstract void layout();
}
