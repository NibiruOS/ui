package com.aajtech.ui.android.widget;

import android.widget.LinearLayout;

abstract class LinearLayoutContainer extends AndroidContainer<LinearLayout> {
	LinearLayoutContainer(LinearLayout viewGroup, int orientation) {
		super(viewGroup);
		viewGroup.setOrientation(orientation);
	}
}
