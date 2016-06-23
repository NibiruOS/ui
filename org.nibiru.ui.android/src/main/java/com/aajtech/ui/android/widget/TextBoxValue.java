package com.aajtech.ui.android.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class TextBoxValue extends LabelValue {

	TextBoxValue(EditText view) {
		super(view);
		view.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				notifyObservers();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}
}
