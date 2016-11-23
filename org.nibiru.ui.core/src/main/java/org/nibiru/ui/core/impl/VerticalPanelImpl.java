package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.loop.Looper;
import org.nibiru.ui.core.api.layout.Size;

public class VerticalPanelImpl extends BaseLayoutPanel implements VerticalPanel {
	
	@Inject
	public VerticalPanelImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
		super(panel, viewport, looper);
	}

	@Override
	protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		int maxWidth = 0;
		int mTotalLength = 0;
		int childrenMP = 0;

		for (Widget child : getChildren()) {
			if(child.getHeight().equals(Size.MATCH_PARENT)) {
				childrenMP++;
			} else {
				measureChild(child, childWidthSpec, childHeightSpec);

				mTotalLength = Math.max(mTotalLength, mTotalLength + child.getMeasuredHeight());

				maxWidth = Math.max(maxWidth, child.getMeasuredWidth());

				//TODO: what are we going to do in this situation? the child wants to match our width, we need to remeasure it when we know our size
				if (childWidthSpec.getType() != Type.EXACTLY && child.getWidth() == Size.MATCH_PARENT) {

				}
			}
		}

		if(childrenMP > 0) {
			final int remainingSpace = (childHeightSpec.getValue() - mTotalLength) / childrenMP;

			for (Widget child : getChildren()) {
				if (child.getHeight().equals(Size.MATCH_PARENT)) {
					measureChild(child, childWidthSpec, MeasureSpec.atMost(remainingSpace));

					mTotalLength = Math.max(mTotalLength, mTotalLength + child.getMeasuredHeight());

					maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
				}
			}
		}

		updateSize(resolveSize(maxWidth, childWidthSpec, true), resolveSize(mTotalLength, childHeightSpec, false));

	}
	
	@Override
	public void onLayout() {
		int currentY = 0;
		for (Widget child : getChildren()) {
			child.layout();
			panel.getPosition(child).setX(0).setY(currentY);
			currentY += child.getMeasuredHeight();
		}
		super.onLayout();
	}

}