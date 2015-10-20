package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.HorizontalPanel;

import android.content.Context;
import android.widget.LinearLayout;

public class AndroidHorizontalPanel extends LinearLayoutContainer implements HorizontalPanel {
	@Inject
	public AndroidHorizontalPanel(Context context) {
		super(new LinearLayout(context), LinearLayout.VERTICAL);
	}
}
