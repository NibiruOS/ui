package org.nibiru.ui.android.widget;

import android.content.Context;

import org.nibiru.ui.core.api.Button;

import javax.inject.Inject;

public class AndroidButton extends AndroidLabel implements Button {
    @Inject
    public AndroidButton(Context context) {
        this(new android.widget.Button(context));
    }

    public AndroidButton(android.widget.Button button) {
        super(button);
    }
}
