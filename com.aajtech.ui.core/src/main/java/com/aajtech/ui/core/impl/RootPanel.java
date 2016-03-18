package com.aajtech.ui.core.impl;

import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Widget;
import com.aajtech.ui.core.api.layout.MeasureSpec;
import com.aajtech.ui.core.api.layout.Size;
import com.aajtech.ui.core.api.layout.MeasureSpec.Type;

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
