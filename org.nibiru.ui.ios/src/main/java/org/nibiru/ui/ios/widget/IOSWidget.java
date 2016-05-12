package org.nibiru.ui.ios.widget;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.api.Widget;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.uikit.UIView;

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
	public void setStyleName(Enum<?> styleName) {
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
		control.setFrame(new CGRect(new CGPoint(control.frame().origin().x(), control.frame().origin().y()),
				new CGSize(width, height)));
		layoutParent();
	}
}
