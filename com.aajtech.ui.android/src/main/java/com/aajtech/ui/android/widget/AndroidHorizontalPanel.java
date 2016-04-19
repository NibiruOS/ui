package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.HorizontalPanel;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;

public class AndroidHorizontalPanel extends LinearLayoutContainer implements HorizontalPanel {
	@Inject
	public AndroidHorizontalPanel(Context context, StyleResolver styleResolver) {
		this(new LinearLayout(new ContextThemeWrapper(context, 0)), styleResolver);
	}

	public AndroidHorizontalPanel(LinearLayout linearLayout, StyleResolver styleResolver) {
		super(linearLayout, styleResolver, LinearLayout.HORIZONTAL);
	}
}
