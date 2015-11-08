package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIView;

import com.aajtech.ui.core.api.HorizontalPanel;

public class IOSHorizontalPanel extends IOSContainer implements HorizontalPanel {
	@Override
	void arrangeLayout() {
		double width = 0;
		double height = 0;
		for (UIView child : control.getSubviews()) {
			double childWidth = child.getFrame().getWidth();
			double childHeight = child.getFrame().getHeight();
			child.setFrame(new CGRect(width, 0, childWidth, childHeight));
			width += childWidth;
			if (childHeight > height) {
				height = childHeight;
			}
		}
		control.setFrame(new CGRect(control.getFrame().getX(), control.getFrame().getY(), width, height));
	}
}
