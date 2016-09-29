package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.layout.Size;

public class VerticalPanelImpl extends BaseLayoutPanel implements VerticalPanel {

	private int mTotalLength;
	
	@Inject
	public VerticalPanelImpl(AbsolutePanel panel) {
		super(panel);
	}

	@Override
	protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		boolean matchWidth = false;
		int maxWidth = 0;
		boolean allFillParent = true;
		int alternativeMaxWidth = 0;

		// See how tall everyone is. Also remember max width.
		for (Widget child : getChildren()) {

			measureChild(child, childWidthSpec, childHeightSpec);
	
			final int measuredHeight = child.getMeasuredHeight();
			final int measuredWidth = child.getMeasuredWidth();
			final int totalLength = mTotalLength;

			mTotalLength = Math.max(totalLength, totalLength + measuredHeight);


			if (childWidthSpec.getType() != Type.EXACTLY && child.getWidth() == Size.MATCH_PARENT) {
				// at least one child said it wanted to match our width. Set a flag
				// indicating that we need to remeasure at least that view when we know our width
				matchWidth = true;
			}
			
			maxWidth = Math.max(maxWidth, measuredWidth);

			allFillParent = allFillParent && child.getWidth() == Size.MATCH_PARENT;
			alternativeMaxWidth = Math.max(alternativeMaxWidth, matchWidth ? 0 : measuredWidth);

		}

		// Reconcile our calculated size with the heightMeasureSpec
		int finalHeightSize = resolveSize(mTotalLength, childHeightSpec);

		if (!allFillParent && childWidthSpec.getType() != Type.EXACTLY) {
			maxWidth = alternativeMaxWidth;
		}

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