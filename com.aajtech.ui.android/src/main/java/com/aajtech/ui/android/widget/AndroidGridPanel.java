package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.GridPanel;

import android.content.Context;
import android.widget.GridLayout;

public class AndroidGridPanel extends AndroidContainer<GridLayout>implements GridPanel {
	@Inject
	public AndroidGridPanel(Context context) {
		this(new GridLayout(context));
	}

	public AndroidGridPanel(GridLayout grid) {
		super(grid);
	}

	@Override
	public void setColumns(int columns) {
		view.setColumnCount(columns);
	}
}
