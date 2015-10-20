package com.aajtech.ui.android.widget;

import com.aajtech.ui.core.api.Container;
import com.aajtech.ui.core.api.Widget;

import android.view.View;
import android.view.ViewGroup;

abstract class AndroidContainer<T extends ViewGroup> extends AndroidWidget<T>implements Container {
	AndroidContainer(T viewGroup) {
		super(viewGroup);
	}

	@Override
	public void add(Widget child) {
		view.addView((View) child.asNative());
	}
}
