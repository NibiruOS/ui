package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;

public class VerticalPanelImpl extends BaseLayoutPanel implements VerticalPanel {
	@Inject
	public VerticalPanelImpl(AbsolutePanel panel) {
		super(panel);
	}

	@Override
	protected void measureLayout(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		int measuredHeight;
		if (childHeightSpec.getType() == Type.AT_MOST) {
			measuredHeight = childHeightSpec.getValue();
		} else {
			measuredHeight = 0;
			for (Widget child : getChildren()) {
				measuredHeight += child.getMeasuredHeight();
			}
		}
		int measuredWidth;
		if (childWidthSpec.getType() == Type.AT_MOST) {
			measuredWidth = childWidthSpec.getValue();
		} else {
			measuredWidth = 0;
			for (Widget child : getChildren()) {
				if (measuredWidth < child.getMeasuredWidth()) {
					measuredWidth = child.getMeasuredWidth();
				}
			}
		}
		updateSize(measuredHeight, measuredWidth);
	}

	@Override
	public void layoutLayout() {
		int currentY = 0;
		for (Widget child : getChildren()) {
			panel.getPosition(child).setX(0).setY(currentY);
			currentY += child.getMeasuredHeight();
		}
	}
}
