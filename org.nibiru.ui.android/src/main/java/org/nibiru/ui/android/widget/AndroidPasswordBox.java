package org.nibiru.ui.android.widget;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;

import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.PasswordBox;

import javax.inject.Inject;

public class AndroidPasswordBox extends AndroidTextBox implements PasswordBox {
	@Inject
	public AndroidPasswordBox(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	@Override
	EditText buildControl(Context context, int styleResource) {
		EditText editText = super.buildControl(context, styleResource);
		
		editText.setHint("Password");
		editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		
		return editText;
	}
}
