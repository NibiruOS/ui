package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.HorizontalPanel;

import android.content.Context;
import android.widget.LinearLayout;

public class AndroidHorizontalPanel extends LinearLayoutContainer implements HorizontalPanel {
	@Inject
	public AndroidHorizontalPanel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver, LinearLayout.HORIZONTAL);
	}

	public AndroidHorizontalPanel(LinearLayout linearLayout, StyleResolver styleResolver) {
		super(linearLayout, styleResolver, LinearLayout.HORIZONTAL);
	}
}
