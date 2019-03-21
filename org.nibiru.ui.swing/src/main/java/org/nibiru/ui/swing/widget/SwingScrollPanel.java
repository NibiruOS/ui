package org.nibiru.ui.swing.widget;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BaseScrollPanel;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import static com.google.common.base.Preconditions.checkNotNull;

class SwingScrollPanel
        extends BaseScrollPanel<JScrollPane, JComponent> {

    SwingScrollPanel(JScrollPane control,
                     Viewport viewport,
                     Looper looper) {
        super(control, viewport, looper);
        WidgetUtils.bindVisible(this, control);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    protected void setNativeContent(JComponent nativeContent) {
        checkNotNull(nativeContent);
        control.setViewportView(nativeContent);
    }

    @Override
    protected void setNativeSize(int width, int height) {
        WidgetUtils.setNativeSize(control, width, height);
    }
}
