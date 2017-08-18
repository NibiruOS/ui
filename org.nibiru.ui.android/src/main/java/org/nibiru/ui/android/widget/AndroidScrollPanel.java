package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseContentWidget;

import javax.inject.Inject;

public class AndroidScrollPanel extends BaseContentWidget<ScrollView, View> implements ScrollPanel {
    @Inject
    public AndroidScrollPanel(Context context, Viewport viewport) {
        this(new ScrollView(context), viewport);
    }

    public AndroidScrollPanel(ScrollView control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        AndroidWidget.applyStyle(control, getStyle());
    }

    @Override
    protected void setNativeContent(View nativeContent) {
        control.removeAllViews();
        control.addView(nativeContent);
    }
}
