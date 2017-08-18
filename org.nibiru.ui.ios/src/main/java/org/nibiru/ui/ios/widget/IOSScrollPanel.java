package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseContentWidget;

import javax.inject.Inject;

import apple.uikit.UIScrollView;
import apple.uikit.UIView;

public class IOSScrollPanel extends BaseContentWidget<UIScrollView, UIView> implements ScrollPanel {

    @Inject
    public IOSScrollPanel(Viewport viewport) {
        this(UIScrollView.alloc().init(), viewport);
    }

    public IOSScrollPanel(UIScrollView control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        IOSWidget.applyStyle(control, getStyle());
    }

    @Override
    protected void setNativeContent(UIView nativeContent) {
        if (getContent() != null) {
            ((UIView) getContent().asNative()).removeFromSuperview();
        }
        control.addSubview(nativeContent);
    }
}
