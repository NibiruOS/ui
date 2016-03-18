package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.loop.Looper;
import org.nibiru.ui.core.api.layout.Size;

public class VerticalPanelImpl extends BaseLayoutPanel implements VerticalPanel {
	
	@Inject
	public VerticalPanelImpl(AbsolutePanel panel, Looper looper) {
		super(panel, looper);
	}

	@Override
	protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		int maxWidth = 0;
		int mTotalLength = 0;

		for (Widget child : getChildren()) {

			measureChild(child, childWidthSpec, childHeightSpec);
	
			final int measuredHeight = child.getMeasuredHeight();
			final int measuredWidth = child.getMeasuredWidth();

			mTotalLength = Math.max(mTotalLength, mTotalLength + measuredHeight);

			//TODO: what are we going to do in this situation? the child wants to match our width, we need to remeasure it when we know our size
			if (childWidthSpec.getType() != Type.EXACTLY && child.getWidth() == Size.MATCH_PARENT) {
				
			}
			
			maxWidth = Math.max(maxWidth, measuredWidth);

		}

		int finalHeightSize = resolveSize(mTotalLength, childHeightSpec);

		updateSize(resolveSize(maxWidth, childWidthSpec), finalHeightSize);

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