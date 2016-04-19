package com.aajtech.ui.android.widget;

import com.aajtech.ui.android.style.StyleResolver;

import android.widget.LinearLayout;

abstract class LinearLayoutContainer extends AndroidContainer<LinearLayout> {
	LinearLayoutContainer(LinearLayout viewGroup, StyleResolver styleResolver, int orientation) {
		super(viewGroup, styleResolver);
		viewGroup.setOrientation(orientation);
	}
}
