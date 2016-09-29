package org.nibiru.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.layout.Size;

public abstract class BaseLayoutPanel extends BaseWidget implements Container {
	protected final AbsolutePanel panel;

	BaseLayoutPanel(AbsolutePanel panel) {
		this.panel = checkNotNull(panel);
	}

	@Override
	public Object asNative() {
		return panel.asNative();
	}

	@Override
	public void add(Widget child) {
		panel.add(child);
	}

	@Override
	public Iterable<Widget> getChildren() {
		return panel.getChildren();
	}

	@Override
	public void clear() {
		panel.clear();
	}

	/**
	 * Method to request the measure and layout of the panel and all its children.
	 * For the measure phase the MeasureSpec with the restrictions to its children should be passed.
	 */
	@Override
	public void requestLayout() {
		measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		layout();
	}

	protected void measureChild(Widget child, MeasureSpec parentWidthMeasureSpec,
			MeasureSpec parentHeightMeasureSpec) {
		final MeasureSpec childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, child.getWidth());
		final MeasureSpec childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, child.getHeight());

		child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
	}
	
	/**
	 * This method propagates the restriction imposed to the widget to its children
	 * @param spec restriction imposed to the parent widget
	 * @param childDimension size of the child 
	 * @return
	 */
	public static MeasureSpec getChildMeasureSpec(MeasureSpec spec, Size childDimension) {

		int size = spec.getValue();

		int resultSize = 0;
		Type resultMode = null;

		switch (spec.getType()) {
		// Parent has imposed an exact size on us
		case EXACTLY:
			if (childDimension.getValue() >= 0) {
				resultSize = childDimension.getValue();
				resultMode = Type.EXACTLY;
			} else if (childDimension == Size.MATCH_PARENT) {
				// Child wants to be our size. So be it.
				resultSize = size;
				resultMode = Type.EXACTLY;
			} else if (childDimension == Size.WRAP_CONTENT) {
				// Child wants to determine its own size. It can't be
				// bigger than us.
				resultSize = size;
				resultMode = Type.AT_MOST;
			}
			break;

		// Parent has imposed a maximum size on us
		case AT_MOST:
			if (childDimension.getValue() >= 0) {
				// Child wants a specific size... so be it
				resultSize = childDimension.getValue();
				resultMode = Type.EXACTLY;
			} else if (childDimension == Size.MATCH_PARENT) {
				// Child wants to be our size, but our size is not fixed.
				// Constrain child to not be bigger than us.
				resultSize = size;
				resultMode = Type.AT_MOST;
			} else if (childDimension == Size.WRAP_CONTENT) {
				// Child wants to determine its own size. It can't be
				// bigger than us.
				resultSize = size;
				resultMode = Type.AT_MOST;
			}
			break;

		// Parent asked to see how big we want to be
		case UNSPECIFIED:
			if (childDimension.getValue() >= 0) {
				// Child wants a specific size... let him have it
				resultSize = childDimension.getValue();
				resultMode = Type.EXACTLY;
			} else if (childDimension == Size.MATCH_PARENT) {
				// Child wants to be our size... find out how big it should
				// be
				resultSize = 0;
				resultMode = Type.UNSPECIFIED;
			} else if (childDimension == Size.WRAP_CONTENT) {
				// Child wants to determine its own size.... find out how
				// big it should be
				resultSize = 0;
				resultMode = Type.UNSPECIFIED;
			}
			break;
		}
		MeasureSpec mspec = null;
		switch (resultMode) {
		case AT_MOST:
			mspec = MeasureSpec.atMost(resultSize);
			break;
		case EXACTLY:
			mspec = MeasureSpec.exactly(resultSize);
			break;
		case UNSPECIFIED:
			mspec = MeasureSpec.UNSPECIFIED;
			break;
		}
		return mspec;
	}
	
	@Override
	public void onLayout() {
		panel.setNativeSize(getMeasuredWidth(), getMeasuredHeight());
	}
	
}