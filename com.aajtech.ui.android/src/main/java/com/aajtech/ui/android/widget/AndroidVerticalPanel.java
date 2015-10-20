package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.VerticalPanel;

import android.content.Context;
import android.widget.LinearLayout;

public class AndroidVerticalPanel extends LinearLayoutContainer implements VerticalPanel {
	@Inject
	public AndroidVerticalPanel(Context context) {
		super(new LinearLayout(context), LinearLayout.VERTICAL);
	}
}
