package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;

import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.inject.Inject;

import static org.nibiru.ui.android.widget.WidgetUtils.dpToPx;
import static org.nibiru.ui.android.widget.WidgetUtils.pxToDp;

public class AndroidHorizontalScrollPanel
        extends BaseScrollPanel<HorizontalScrollView, View>
        implements HorizontalScrollPanel {
    @Inject
    public AndroidHorizontalScrollPanel(Context context, Viewport viewport) {
        this(new HorizontalScrollView(context), viewport);
        WidgetUtils.bindVisible(this, control);
        control.getViewTreeObserver()
                .addOnScrollChangedListener(() ->
                        scrollPosition.set(pxToDp(Math.max(control.getScrollX(), 0), context)));
        scrollPosition.addObserver(() ->
                control.setScrollX(dpToPx(scrollPosition.get(), context)));
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
