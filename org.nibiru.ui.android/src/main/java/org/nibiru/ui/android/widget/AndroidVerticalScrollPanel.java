package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.inject.Inject;

public class AndroidVerticalScrollPanel extends BaseScrollPanel<ScrollView, View> implements VerticalScrollPanel {
    @Inject
    public AndroidVerticalScrollPanel(Context context, Viewport viewport) {
        this(new ScrollView(context), viewport);
    }

    public AndroidVerticalScrollPanel(ScrollView control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    protected void setNativeContent(View nativeContent) {
        control.removeAllViews();
        control.addView(nativeContent);
    }

    @Override
    protected void setNativeSize(int width, int height) {
        WidgetUtils.setNativeSize(control, width, height);
    }
}
