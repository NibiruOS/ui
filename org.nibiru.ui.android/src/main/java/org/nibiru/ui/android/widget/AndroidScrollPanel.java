package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

public class AndroidScrollPanel extends AndroidWidget<ScrollView> implements ScrollPanel {
    @Inject
    public AndroidScrollPanel(Context context) {
        this(new ScrollView(context));
    }

    public AndroidScrollPanel(ScrollView control) {
        super(control);
    }

    @Override
    public void setContent(Widget content) {
        control.removeAllViews();
        control.addView((View) content.asNative());
    }

    @Override
    public void requestLayout() {
        // TODO Auto-generated method stub
    }
}
