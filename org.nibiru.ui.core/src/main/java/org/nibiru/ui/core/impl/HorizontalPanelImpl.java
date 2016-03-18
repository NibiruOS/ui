package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;

public class HorizontalPanelImpl extends BaseLayoutPanel implements HorizontalPanel {
	@Inject
	public HorizontalPanelImpl(AbsolutePanel panel) {
		super(panel);
	}

	@Override
	protected void measureLayout(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		int measuredWidth;
		if (childWidthSpec.getType() == Type.AT_MOST) {
			measuredWidth = childWidthSpec.getValue();
		} else {
			measuredWidth = 0;
			for (Widget child : getChildren()) {
				measuredWidth += child.getMeasuredWidth();
			}
		}
		int measuredHeight;
		if (childHeightSpec.getType() == Type.AT_MOST) {
			measuredHeight = childHeightSpec.getValue();
		} else {
			measuredHeight = 0;
			for (Widget child : getChildren()) {
				if (measuredHeight < child.getMeasuredHeight()) {
					measuredHeight = child.getMeasuredHeight();
				}
			}
		}
		updateSize(measuredWidth, measuredHeight);
	}

	@Override
	public void layoutLayout() {
		int xPosition = 0;
		for (Widget child : getChildren()) {
			panel.getPosition(child).setX(xPosition).setY(0);
			xPosition += child.getMeasuredWidth();
		}
	}
}
