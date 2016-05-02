package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.Label;

import android.content.Context;
import android.widget.TextView;

public class AndroidLabel extends AndroidValueWidget<TextView, String> implements Label {
	@Inject
	public AndroidLabel(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidLabel(TextView textView, StyleResolver styleResolver) {
		super(textView, styleResolver);
	}

	@Override
	TextView buildControl(Context context, int styleResource) {
		return styleResource == 0 ? new TextView(context) : new TextView(context, null, styleResource);
	}

	@Override
	Value<String> buildValue() {
		return new LabelValue(control());
	}
}
