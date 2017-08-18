package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.ScrollPanel;

import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseContentWidget;

import javax.inject.Inject;

public class GwtScrollPanel extends BaseContentWidget<ScrollPanel, com.google.gwt.user.client.ui.Widget>
        implements org.nibiru.ui.core.api.ScrollPanel {

    @Inject
    public GwtScrollPanel(Viewport viewport) {
        this(new ScrollPanel(), viewport);
    }

    public GwtScrollPanel(ScrollPanel control, Viewport viewport) {
        super(control, viewport);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        GwtWidget.applyStyle(control, getStyle());
    }

    @Override
    protected void setNativeContent(com.google.gwt.user.client.ui.Widget nativeContent) {
        control.clear();
        control.add(nativeContent);
    }
}
