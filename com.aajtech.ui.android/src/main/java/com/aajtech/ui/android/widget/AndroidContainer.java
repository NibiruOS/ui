package com.aajtech.ui.android.widget;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Container;
import com.aajtech.ui.core.api.Widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

abstract class AndroidContainer<T extends ViewGroup> extends AndroidWidget<T>implements Container {
	AndroidContainer(T viewGroup, StyleResolver styleResolver) {
		super(viewGroup, styleResolver);
	}

	public AndroidContainer(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	@Override
	public void add(Widget child) {
		control().addView((View) child.asNative());
	}

	@Override
	public void clear() {
		control().removeAllViews();
	}
}
