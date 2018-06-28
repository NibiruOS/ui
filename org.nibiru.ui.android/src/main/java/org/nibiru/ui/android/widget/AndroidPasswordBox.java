package org.nibiru.ui.android.widget;

import android.content.Context;
import android.text.InputType;

import org.nibiru.ui.core.api.PasswordBox;

import javax.inject.Inject;

public class AndroidPasswordBox extends AndroidTextBox implements PasswordBox {
    @Inject
    public AndroidPasswordBox(Context context) {
        super(context);
        control.setHint("Password");
        control.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }
}
