package com.aajtech.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIView;

import com.aajtech.ui.core.api.Widget;

abstract class IOSWidget<T extends UIView> implements Widget {
	final T control;
	private IOSContainer parent;

	IOSWidget(T control) {
		this.control = checkNotNull(control);
	}

	@Override
	public Object asNative() {
		return control;
	}

	@Override
	public void addStyleName(Enum<?> styleName) {
		// TODO Auto-generated method stub
	}

	void setParent(IOSContainer parent) {
		this.parent = parent;
	}

	void layoutParent() {
		if (parent != null) {
			parent.layout();
		}
	}

	void updateSize(double width, double height) {
		control.setFrame(new CGRect(control.getFrame().getX(), control.getFrame().getY(), width, height));
		layoutParent();
	}
}
