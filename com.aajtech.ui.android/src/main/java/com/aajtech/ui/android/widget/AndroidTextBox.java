package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Value;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.TextBox;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.EditText;

public class AndroidTextBox extends AndroidWidget<EditText> implements TextBox {
	@Inject
	public AndroidTextBox(Context context, StyleResolver styleResolver) {
		this(new EditText(new ContextThemeWrapper(context, 0)), styleResolver);
	}

	public AndroidTextBox(EditText editText, StyleResolver styleResolver) {
		super(editText, styleResolver);
	}

	@Override
	public Value<String> getValue() {
		return new TextBoxValue(view);
	}
}
