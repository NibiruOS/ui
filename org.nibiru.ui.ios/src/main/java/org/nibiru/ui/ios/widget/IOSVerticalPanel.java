package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.VerticalPanel;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIView;

public class IOSVerticalPanel extends IOSContainer implements VerticalPanel {
	@Override
	void layout() {
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
		updateSize(width, height);
		layoutParent();
	}
}
