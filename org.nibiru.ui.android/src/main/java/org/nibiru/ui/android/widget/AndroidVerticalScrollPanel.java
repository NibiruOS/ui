package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.inject.Inject;

import static org.nibiru.ui.android.widget.WidgetUtils.dpToPx;
import static org.nibiru.ui.android.widget.WidgetUtils.pxToDp;

public class AndroidVerticalScrollPanel
        extends BaseScrollPanel<ScrollView, View>
        implements VerticalScrollPanel {
    @Inject
    public AndroidVerticalScrollPanel(Context context,
                                      Viewport viewport,
                                      Looper looper) {
        this(new ScrollView(context), viewport, looper);
        WidgetUtils.bindVisible(this, control);
        control.getViewTreeObserver()
                .addOnScrollChangedListener(() ->
                        scrollPosition.set(pxToDp(Math.max(control.getScrollY(), 0), context)));
        scrollPosition.addObserver(() ->
                control.setScrollY(dpToPx(scrollPosition.get(), context)));
    }

    public AndroidVerticalScrollPanel(ScrollView control,
                                      Viewport viewport,
                                      Looper looper) {
        super(control, viewport, looper);
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
