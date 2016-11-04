package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.Size;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.loop.Looper;

public class HorizontalPanelImpl extends BaseLayoutPanel implements HorizontalPanel {
	
	@Inject
	public HorizontalPanelImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
		super(panel, viewport, looper);
	}
	
	@Override
	protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		int maxHeight = 0;
		int mTotalLength = 0;

		for (Widget child : getChildren()) {

			measureChild(child, childWidthSpec, childHeightSpec);
	
			final int childWidth = child.getMeasuredWidth();
			final int childHeight = child.getMeasuredHeight();

			mTotalLength = Math.max(mTotalLength, mTotalLength + childWidth);

			//TODO: what are we going to do in this situation? the child wants to match our width, we need to remeasure it when we know our size
			if (childHeightSpec.getType() != Type.EXACTLY && child.getHeight() == Size.MATCH_PARENT) {
				
			}
			
			maxHeight = Math.max(maxHeight, childHeight);

		}

		int finalWidthSize = resolveSize(mTotalLength, childWidthSpec);

		updateSize(finalWidthSize, resolveSize(maxHeight, childHeightSpec));

	}
	
	@Override
	public void onLayout() {
		int currentX = 0;
		for (Widget child : getChildren()) {
			child.layout();
			panel.getPosition(child).setX(currentX).setY(0);
			currentX += child.getMeasuredWidth();
		}
		super.onLayout();
	}
}
