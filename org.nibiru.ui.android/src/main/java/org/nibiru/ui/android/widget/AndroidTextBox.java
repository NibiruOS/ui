package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.EditText;

import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.ui.core.api.TextBox;

import javax.inject.Inject;

public class AndroidTextBox
        extends AndroidHasEnabledWidget<EditText, String>
        implements TextBox {

    // TODO: Fix this "magic".
    private static int MAGIC_PADDING = 2;
    private final Value<Boolean> enabled = BaseValue.of(true);

    @Inject
    public AndroidTextBox(Context context) {
        this(new EditText(context));
    }

    public AndroidTextBox(EditText editText) {
        super(editText);
    }

    @Override
    Value<String> buildValue() {
        return new TextBoxValue(control);
    }

    @Override
    protected int getNativeWidth() {
        return super.getNativeWidth() + MAGIC_PADDING;
    }
}
