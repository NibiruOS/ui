package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.EditText;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.TextBox;

import javax.inject.Inject;

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
		return styleResource == StyleResolver.NO_STYLE
				? new EditText(context)
				: new EditText(context, null, styleResource);
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
