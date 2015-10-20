package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.ui.core.api.TextBox;

import android.content.Context;
import android.widget.EditText;

public class AndroidTextBox extends AndroidLabel implements TextBox {
	@Inject
	public AndroidTextBox(Context context) {
		super(new TextBoxValue(new EditText(context)));
	}
}
