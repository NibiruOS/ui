
package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseLayoutPanel extends BaseWidget implements Container {
	protected final AbsolutePanel panel;
	protected final Viewport viewport;
	private final Looper looper;
	private boolean isLayoutScheduled;
	private boolean isLayoutDirty;

	BaseLayoutPanel(AbsolutePanel panel, Viewport viewport, Looper looper) {
		this.panel = checkNotNull(panel);
		this.viewport = checkNotNull(viewport);
		this.looper = checkNotNull(looper);
	}

	@Override
	public Object asNative() {
		return panel.asNative();
	}

	@Override
	public void add(Widget child) {
		panel.add(child);
		child.setParent(this);
		scheduleLayout();
	}

	@Override
	public Iterable<Widget> getChildren() {
		return panel.getChildren();
	}

	@Override
	public void clear() {
		panel.clear();
		scheduleLayout();
	}

	/**
	 * Method to request the measure and layout of the panel and all its children.
	 * For the measure phase the MeasureSpec with the restrictions to its children should be passed.
	 */
	@Override
	public void requestLayout() {
		if (getParent() != null) {
			getParent().requestLayout();
		} else {
			MeasureSpec widthSpec = getChildMeasureSpec(MeasureSpec.atMost(viewport.getWidth()), getStyle().getWidth());
			MeasureSpec heightSpec = getChildMeasureSpec(MeasureSpec.atMost(viewport.getHeight()), getStyle().getHeight());
			measure(widthSpec, heightSpec);
			layout();
		}
	}

	@Override
	public void layout() {
		super.layout();
		isLayoutDirty = false;
	}

	@Override
	public void scheduleLayout() {
		isLayoutDirty = true;
		if (getParent() != null) {
			getParent().scheduleLayout();
			isLayoutScheduled = false;
		} else if (!isLayoutScheduled) {
			looper.post(() -> {
				isLayoutScheduled = false;
				if (getParent() != null) {
					getParent().scheduleLayout();
				} else {
					if (isLayoutDirty) {
						requestLayout();
					}
				}
			});
		}
	}

	protected void measureChild(Widget child, MeasureSpec parentWidthMeasureSpec,
			MeasureSpec parentHeightMeasureSpec) {
		MeasureSpec childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec, child.getStyle().getWidth());
		MeasureSpec childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, child.getStyle().getHeight());

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
				// Child wants to determine its own size. It can't be bigger than us.
				resultSize = size;
				resultMode = Type.AT_MOST;
			}
			break;

		// Parent has imposed a maximum size on us
		case AT_MOST:
			if (childDimension.getValue() >= 0) {
				// Child wants a specific size
				resultSize = childDimension.getValue();
				resultMode = Type.EXACTLY;
			} else if (childDimension == Size.MATCH_PARENT) {
				// Child wants to be our size, but our size is not fixed. Constrain child to not be bigger than us.
				resultSize = size;
				resultMode = Type.AT_MOST;
			} else if (childDimension == Size.WRAP_CONTENT) {
				// Child wants to determine its own size. It can't be bigger than us.
				resultSize = size;
				resultMode = Type.AT_MOST;
			}
			break;

		// Parent asked to see how big we want to be
		case UNSPECIFIED:
			if (childDimension.getValue() >= 0) {
				// Child wants a specific size
				resultSize = childDimension.getValue();
				resultMode = Type.EXACTLY;
			} else if (childDimension == Size.MATCH_PARENT) {
				// Child wants to be our size but we have to find out how big it should be
				resultSize = 0;
				resultMode = Type.UNSPECIFIED;
			} else if (childDimension == Size.WRAP_CONTENT) {
				// Child wants to determine its own size but we have to find out how big it should be
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

	@Override
	public void setStyleName(Enum<?> styleName) {
		panel.setStyleName(styleName);
	}

	@Override
	public void setStyle(Style style) {
		super.setStyle(style);
		panel.setStyle(style);
	}

	@Override
	public void applyStyle() {
		panel.applyStyle();
	}
}