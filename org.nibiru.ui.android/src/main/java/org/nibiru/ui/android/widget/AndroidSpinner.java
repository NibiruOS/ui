package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.ProgressBar;

import org.nibiru.ui.core.api.Spinner;

import javax.inject.Inject;

public class AndroidSpinner extends AndroidWidget<ProgressBar> implements Spinner {
    @Inject
    public AndroidSpinner(Context context) {
        this(new ProgressBar(context, null));
    }

    public AndroidSpinner(ProgressBar control) {
        super(control);
    }
}
