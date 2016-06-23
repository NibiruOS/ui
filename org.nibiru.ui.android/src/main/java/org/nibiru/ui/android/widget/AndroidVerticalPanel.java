package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.VerticalPanel;

import android.content.Context;
import android.widget.LinearLayout;

public class AndroidVerticalPanel extends LinearLayoutContainer implements VerticalPanel {
	@Inject
	public AndroidVerticalPanel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver, LinearLayout.VERTICAL);
	}

	public AndroidVerticalPanel(LinearLayout linearLayout, StyleResolver styleResolver) {
		super(linearLayout, styleResolver, LinearLayout.VERTICAL);
	}
}
