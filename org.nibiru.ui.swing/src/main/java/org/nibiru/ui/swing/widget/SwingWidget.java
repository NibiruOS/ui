package org.nibiru.ui.swing.widget;

import org.nibiru.ui.core.api.Focusable;
import org.nibiru.ui.core.impl.BaseControlWidget;

import javax.swing.JComponent;

abstract class SwingWidget<T extends JComponent>
        extends BaseControlWidget<T>
        implements Focusable {
    SwingWidget(T control) {
        super(control);
        WidgetUtils.bindVisible(this, control);
    }

    @Override
    public void applyStyle() {
        WidgetUtils.applyStyle(control, getStyle());
    }

    @Override
    public void setNativeSize(int width, int height) {
        WidgetUtils.setNativeSize(control, width, height);
    }

    @Override
    public void requestFocus() {
        control.requestFocus();
    }

    @Override
    protected int getNativeHeight() {
        return (int) control.getPreferredSize().getHeight();
    }

    @Override
    protected int getNativeWidth() {
        return (int) control.getPreferredSize().getWidth();
    }
}
