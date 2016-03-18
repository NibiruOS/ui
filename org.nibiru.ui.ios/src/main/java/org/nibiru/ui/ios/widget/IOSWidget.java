package org.nibiru.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIView;

import org.nibiru.ui.core.impl.BaseControlWidget;

abstract class IOSWidget<T extends UIView> extends BaseControlWidget<T> {
	IOSWidget(T control) {
		super(control);
	}

	@Override
	public int getMeasuredHeight() {
		return (int) control.getFrame().getHeight();
	}

	@Override
	public void setStyleName(Enum<?> styleName) {
		// TODO Auto-generated method stub
	}

	public void setHeight(int height) {
		CGRect frame = control.getFrame();
		frame.setHeight(height);
		control.setFrame(frame);
	}

	@Override
	public int getMeasuredWidth() {
		return (int) control.getFrame().getWidth();
	}

	@Override
	public void setWidth(int width) {
		CGRect frame = control.getFrame();
		frame.setWidth(width);
		control.setFrame(frame);
	}
}
