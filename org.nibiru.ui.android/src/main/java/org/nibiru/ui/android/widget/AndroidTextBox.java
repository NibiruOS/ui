package org.nibiru.ui.android.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.TextBox;

import android.content.Context;
import android.widget.EditText;

public class AndroidTextBox extends AndroidValueWidget<EditText, String> implements TextBox {
	@Inject
	public AndroidTextBox(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidTextBox(EditText editText, StyleResolver styleResolver) {
		super(editText, styleResolver);
	}

	@Override
	EditText buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
				? new EditText(context)
				: new EditText(context, null, styleResource);
	}

	@Override
	Value<String> buildValue() {
		return new TextBoxValue(control());
	}
}
