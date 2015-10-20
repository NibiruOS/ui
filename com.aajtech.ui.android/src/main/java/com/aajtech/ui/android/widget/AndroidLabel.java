package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.core.api.Label;

import android.content.Context;
import android.widget.TextView;

public class AndroidLabel extends AndroidWidget<TextView>implements Label {
	private final Value<String> value;

	@Inject
	public AndroidLabel(Context context) {
		this(new LabelValue(new TextView(context)));
	}

	AndroidLabel(LabelValue value) {
		super(value.view);
		this.value = value;
	}

	@Override
	public Value<String> getValue() {
		return value;
	}
}
