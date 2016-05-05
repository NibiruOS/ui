package com.aajtech.ui.android.widget;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.TreeView;
import com.aajtech.ui.core.api.TreeView.Item;

import android.content.Context;
import android.view.View;

public class AndroidTreeView extends AndroidValueWidget<View, Iterable<Item>> implements TreeView {
	public AndroidTreeView(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	@Override
	Value<Iterable<Item>> buildValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	View buildControl(Context context, int styleResource) {
		// TODO Auto-generated method stub
		return null;
	}
}
