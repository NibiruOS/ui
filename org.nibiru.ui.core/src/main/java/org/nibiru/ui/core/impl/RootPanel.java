package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

public class RootPanel extends BaseLayoutPanel {
	
	RootPanel(AbsolutePanel panel, Viewport viewport, Looper looper) {
		super(panel, viewport, looper);
	}

	@Override
	protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		for (Widget child : getChildren()) {

			child.measure(childWidthSpec, childHeightSpec);
	
		}
	}

}
