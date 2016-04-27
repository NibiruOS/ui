package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Button;

import android.content.Context;

public class AndroidButton extends AndroidLabel implements Button {
	@Inject
	public AndroidButton(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidButton(android.widget.Button button, StyleResolver styleResolver) {
		super(button, styleResolver);
	}

	@Override
	android.widget.Button buildControl(Context context, int styleResource) {
		android.widget.Button button = styleResource == 0 ? new android.widget.Button(context) : new android.widget.Button(context, null, styleResource);
		// Set focusable to false so it can be added to lists.
		// Click event on lists fails randomly if the widget is focusable. 
		button.setFocusable(false);
		return button;
	}
}
