package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.HorizontalPanel;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIView;

public class IOSHorizontalPanel extends IOSContainer implements HorizontalPanel {
	@Override
	void layout() {
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
		updateSize(width, height);
	}
}
