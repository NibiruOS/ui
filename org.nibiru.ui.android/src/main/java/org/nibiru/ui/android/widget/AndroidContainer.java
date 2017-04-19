package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.Lists;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.Container;
import org.nibiru.ui.core.api.Widget;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class AndroidContainer<T extends ViewGroup> extends AndroidWidget<T>implements Container {
	private final List<Widget> children = Lists.newArrayList();

	AndroidContainer(T control, StyleResolver styleResolver) {
		super(control, styleResolver);
	}

	AndroidContainer(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	@Override
	public void add(Widget child) {
		checkNotNull(child);
		control().addView((View) child.asNative());
		children.add(child);
		child.setParent(this);
	}

	@Override
	public Iterable<Widget> getChildren() {
		return children;
	}

	@Override
	public void clear() {
		control().removeAllViews();
		for (Widget child : children) {
			child.setParent(null);
		}
		children.clear();
	}
}
