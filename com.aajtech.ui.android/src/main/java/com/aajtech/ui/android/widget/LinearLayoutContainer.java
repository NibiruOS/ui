package com.aajtech.ui.android.widget;

import com.aajtech.ui.android.style.StyleResolver;

import android.content.Context;
import android.widget.LinearLayout;

abstract class LinearLayoutContainer extends AndroidContainer<LinearLayout> {
	final int orientation;

	LinearLayoutContainer(LinearLayout viewGroup, StyleResolver styleResolver, int orientation) {
		super(viewGroup, styleResolver);
		viewGroup.setOrientation(orientation);
		this.orientation = orientation;
	}

	public LinearLayoutContainer(Context context, StyleResolver styleResolver, int orientation) {
		super(context, styleResolver);
		this.orientation = orientation;
	}

	@Override
	LinearLayout buildControl(Context context, int styleResource) {
		LinearLayout layout = styleResource == 0
				? new LinearLayout(context)
				: new LinearLayout(context, null, styleResource);
		layout.setOrientation(orientation);
		return layout;
	}

}
