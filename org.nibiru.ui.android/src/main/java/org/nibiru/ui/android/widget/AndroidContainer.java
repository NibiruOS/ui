package org.nibiru.ui.android.widget;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

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
}
