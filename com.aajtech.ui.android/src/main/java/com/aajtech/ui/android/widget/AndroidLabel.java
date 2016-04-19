package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Label;

import android.content.Context;
import android.widget.TextView;

public class AndroidLabel extends AndroidWidget<TextView>implements Label {
	@Inject
	public AndroidLabel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidLabel(TextView textView, StyleResolver styleResolver) {
		super(textView, styleResolver);
	}

	@Override
	public Value<String> getValue() {
		return new LabelValue(control());
	}

	@Override
	TextView buildControl(Context context, int styleResource) {
		return styleResource == 0 ? new TextView(context) : new TextView(context, null, styleResource);
	}
}
