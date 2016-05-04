package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Spinner;

import android.content.Context;
import android.widget.ProgressBar;

public class AndroidSpinner extends AndroidWidget<ProgressBar>implements Spinner {
	@Inject
	public AndroidSpinner(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidSpinner(ProgressBar control, StyleResolver styleResolver) {
		super(control, styleResolver);
	}

	@Override
	ProgressBar buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
				? new ProgressBar(context, null)
				: new ProgressBar(context, null, styleResource);
	}
}
