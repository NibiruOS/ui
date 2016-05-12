package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.HorizontalPanel;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.uikit.UIView;

public class IOSHorizontalPanel extends IOSContainer implements HorizontalPanel {
	@Inject
	public IOSHorizontalPanel() {
	}

	@Override
    void layout() {
        double width = 0;
        double height = 0;
        for (UIView child : control.subviews()) {
            double childWidth = child.frame().size().width();
            double childHeight = child.frame().size().height();
            child.setFrame(new CGRect(new CGPoint(width, 0),
                    new CGSize(childWidth, childHeight)));
            width += childWidth;
            if (childHeight > height) {
                height = childHeight;
            }
        }
        updateSize(width, height);
    }
}
