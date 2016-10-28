package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.TextBox;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class AndroidTextBox extends AndroidValueWidget<EditText, String> implements TextBox {
	// TODO: Fix this "magic".
	private static int MAGIC_PADDING = 2;
	
	@Inject
	public AndroidTextBox(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidTextBox(EditText editText, StyleResolver styleResolver) {
		super(editText, styleResolver);
	}

	@Override
	EditText buildControl(Context context, int styleResource) {
		EditText edit = styleResource == StyleResolver.NO_STYLE
				? new EditText(context)
				: new EditText(context, null, styleResource);
		edit.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				scheduleLayout();
			}
		});
		return edit;
	}

	@Override
	Value<String> buildValue() {
		return new TextBoxValue(control());
	}

	@Override
	protected int getNativeWidth() {
		return super.getNativeWidth() + MAGIC_PADDING;
	}
}
