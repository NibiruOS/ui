package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.VerticalPanel;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.uikit.UIView;

public class IOSVerticalPanel extends IOSContainer implements VerticalPanel {
	@Inject
	public IOSVerticalPanel() {
	}

	@Override
	void layout() {
		double width = 0;
		double height = 0;
		for (UIView child : control.subviews()) {
			double childWidth = child.frame().size().width();
			double childHeight = child.frame().size().height();
			child.setFrame(new CGRect(new CGPoint(0, height), new CGSize(childWidth, childHeight)));
			height += childHeight;
			if (childWidth > width) {
				width = childWidth;
			}
		}
		updateSize(width, height);
		layoutParent();
	}
}
