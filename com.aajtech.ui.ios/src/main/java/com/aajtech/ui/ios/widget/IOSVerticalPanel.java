package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIView;

import com.aajtech.ui.core.api.VerticalPanel;

public class IOSVerticalPanel extends IOSContainer implements VerticalPanel {
	@Override
	void arrangeLayout() {
		double width = 0;
		double height = 0;
		for (UIView child : control.getSubviews()) {
			double childWidth = child.getFrame().getWidth();
			double childHeight = child.getFrame().getHeight();
			child.setFrame(new CGRect(0, height, childWidth, childHeight));
			height += childHeight;
			if (childWidth > width) {
				width = childWidth;
			}
		}
		control.setFrame(new CGRect(control.getFrame().getX(), control.getFrame().getY(), width, height));
	}
}
