package org.nibiru.ui.core.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

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

	@Override
	public void requestLayout() {
		measure(MeasureSpec.atMost(1000), MeasureSpec.atMost(1000));
		layout();
	}

	@Override
	public void measure(MeasureSpec widthMeasureSpec, MeasureSpec heightMeasureSpec) {
		MeasureSpec childWidthSpec = computeChildMeasureSpec(widthMeasureSpec, getWidth());
		MeasureSpec childHeightSpec = computeChildMeasureSpec(heightMeasureSpec, getHeight());

		for (Widget child : getChildren()) {
			child.measure(childWidthSpec, childHeightSpec);
		}

		measureLayout(childWidthSpec, childHeightSpec);
	}
	
	@Override
	public void layout() {
		for (Widget child : getChildren()) {
			child.layout();
		}
		layoutLayout();
	}

	protected abstract void measureLayout(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec);

	protected abstract void layoutLayout();
}
