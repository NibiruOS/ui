package com.aajtech.ui.android.widget;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.ValueWidget;

import android.content.Context;
import android.view.View;

abstract class AndroidValueWidget<W extends View, V> extends AndroidWidget<W> implements ValueWidget<V> {
	private Value<V> value;

	AndroidValueWidget(W control, StyleResolver styleResolver) {
		super(control, styleResolver);
	}

	AndroidValueWidget(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	@Override
	public Value<V> getValue() {
		if (value == null) {
			value = buildValue();
		}
		return value;
	}

	abstract Value<V> buildValue();
}
