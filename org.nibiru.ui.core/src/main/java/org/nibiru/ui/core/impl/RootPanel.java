package org.nibiru.ui.core.impl;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

public class RootPanel extends BaseLayoutPanel {
	
	RootPanel(AbsolutePanel panel) {
		super(panel);
	}

	@Override
	protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		for (Widget child : getChildren()) {

			child.measure(childWidthSpec, childHeightSpec);
	
		}
	}

}
