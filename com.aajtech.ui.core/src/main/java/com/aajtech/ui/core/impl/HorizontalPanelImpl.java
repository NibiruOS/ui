package com.aajtech.ui.core.impl;

import javax.inject.Inject;

import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Widget;
import com.aajtech.ui.core.api.layout.MeasureSpec;
import com.aajtech.ui.core.api.layout.Size;
import com.aajtech.ui.core.api.layout.MeasureSpec.Type;

public class HorizontalPanelImpl extends BaseLayoutPanel implements HorizontalPanel {
	
	private int mTotalLength;
	
	@Inject
	public HorizontalPanelImpl(AbsolutePanel panel) {
		super(panel);
	}
	
	@Override
	protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		boolean matchHeight = false;
		int maxHeight = 0;
		boolean allFillParent = true;
		int alternativeMaxHeight = 0;

		// See how tall everyone is. Also remember max width.
		for (Widget child : getChildren()) {

			measureChild(child, childWidthSpec, childHeightSpec);
	
			final int childWidth = child.getMeasuredWidth();
			final int childHeight = child.getMeasuredHeight();
			final int totalLength = mTotalLength;

			mTotalLength = Math.max(totalLength, totalLength + childWidth);

			if(childHeightSpec.getType() != Type.EXACTLY && child.getHeight() == Size.MATCH_PARENT) {
				// we will need to measure this widget again when we have the parent height
				matchHeight = true;
			}
			
			maxHeight = Math.max(maxHeight, childHeight);
		
			allFillParent = allFillParent && child.getHeight() == Size.MATCH_PARENT;
			alternativeMaxHeight = Math.max(alternativeMaxHeight, matchHeight ? 0 : childHeight);
		}

		// Reconcile our calculated size with the heightMeasureSpec
		int finalWidthSize = resolveSize(mTotalLength, childWidthSpec);

		if (!allFillParent && childWidthSpec.getType() != Type.EXACTLY) {
			maxHeight = alternativeMaxHeight;
		}

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
