package com.aajtech.ui.android.widget;

import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Container;
import com.aajtech.ui.core.api.Widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

abstract class AndroidContainer<T extends ViewGroup> extends AndroidWidget<T>implements Container {
	AndroidContainer(T control, StyleResolver styleResolver) {
		super(control, styleResolver);
	}

	AndroidContainer(Context context, StyleResolver styleResolver) {
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

	@Override
	public Iterable<Widget> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layout() {
		// TODO Auto-generated method stub
	}
}
