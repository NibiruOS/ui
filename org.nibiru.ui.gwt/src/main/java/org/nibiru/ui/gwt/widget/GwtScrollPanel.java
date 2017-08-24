package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.inject.Inject;

public class GwtScrollPanel extends BaseScrollPanel<ScrollPanel, Widget>
        implements VerticalScrollPanel, HorizontalScrollPanel {

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
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    protected void setNativeContent(com.google.gwt.user.client.ui.Widget nativeContent) {
        control.clear();
        control.add(nativeContent);
    }

    @Override
    protected void setNativeSize(int width, int height) {
        WidgetUtils.setNativeSize(control, width, height);
    }
}
