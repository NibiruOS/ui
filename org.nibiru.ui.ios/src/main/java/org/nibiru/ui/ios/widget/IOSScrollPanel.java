package org.nibiru.ui.ios.widget;

import org.nibiru.model.core.impl.java.JavaValue;
import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.inject.Inject;

import apple.uikit.UIScrollView;
import apple.uikit.UIView;

public class IOSScrollPanel
        extends BaseScrollPanel<UIScrollView, UIView>
        implements VerticalScrollPanel, HorizontalScrollPanel {

    @Inject
    public IOSScrollPanel(Viewport viewport) {
        this(UIScrollView.alloc().init(), viewport);
    }

    public IOSScrollPanel(UIScrollView control, Viewport viewport) {
        super(control, viewport);
        WidgetUtils.bindVisible(this, control);
        // TODO: Add listeners for scroll position
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    protected void setNativeContent(UIView nativeContent) {
        if (getContent() != null) {
            ((UIView) getContent().asNative()).removeFromSuperview();
        }
        control.addSubview(nativeContent);
    }

    @Override
    protected void setNativeSize(int width, int height) {
        WidgetUtils.setNativeSize(control, width, height);
    }
}
