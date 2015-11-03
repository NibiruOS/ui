package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.Button;

import android.content.Context;

public class AndroidButton extends AndroidLabel implements Button {
	@Inject
	public AndroidButton(Context context) {
		super(new LabelValue(new android.widget.Button(context)));
	}
}
