package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Label;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

public class AndroidLabel extends AndroidWidget<TextView> implements Label {
	@Inject
	public AndroidLabel(Context context, StyleResolver styleResolver) {
		this(new TextView(new ContextThemeWrapper(context, 0)), styleResolver);
	}

	public AndroidLabel(TextView textView, StyleResolver styleResolver) {
		super(textView, styleResolver);
	}

	@Override
	public Value<String> getValue() {
		return new LabelValue(control);
	}
}
