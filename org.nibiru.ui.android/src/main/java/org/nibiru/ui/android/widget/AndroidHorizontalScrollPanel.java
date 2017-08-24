package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;

import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.inject.Inject;

public class AndroidHorizontalScrollPanel extends BaseScrollPanel<HorizontalScrollView, View> implements HorizontalScrollPanel {
    @Inject
    public AndroidHorizontalScrollPanel(Context context, Viewport viewport) {
        this(new HorizontalScrollView(context), viewport);
    }

    public AndroidHorizontalScrollPanel(HorizontalScrollView control, Viewport viewport) {
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
