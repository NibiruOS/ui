package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.GridPanel;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.GridLayout;

public class AndroidGridPanel extends AndroidContainer<GridLayout>implements GridPanel {
	@Inject
	public AndroidGridPanel(Context context, StyleResolver styleResolver) {
		this(new GridLayout(new ContextThemeWrapper(context, 0)), styleResolver);
	}

	public AndroidGridPanel(GridLayout grid, StyleResolver styleResolver) {
		super(grid, styleResolver);
	}

	@Override
	public void setColumns(int columns) {
		view.setColumnCount(columns);
	}
}
