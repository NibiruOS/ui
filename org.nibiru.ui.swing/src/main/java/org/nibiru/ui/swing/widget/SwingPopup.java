package org.nibiru.ui.swing.widget;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.impl.BasePopup;

import javax.inject.Inject;
import javax.swing.JComponent;
import javax.swing.JPanel;

// TODO: Implement popup!
public class SwingPopup extends BasePopup<JPanel, JComponent> implements Popup {

    @Inject
    public SwingPopup(Viewport viewport,
                      Looper looper) {
        this(new JPanel(), viewport, looper);
    }

    public SwingPopup(JPanel panel,
                      Viewport viewport,
                      Looper looper) {
        super(panel, viewport, looper);
    }

    @Override
    public void show() {
        control.setVisible(true);
        requestLayout();
    }

    @Override
    public void hide() {
        control.hide();
    }

    @Override
    public void setAutoHide(boolean autoHide) {
//        control.setAutoHide(autoHide);
    }

    @Override
    public void requestLayout() {
        super.requestLayout();
//        control.centerContent();
    }

    @Override
    protected void setNativeContent(JComponent nativeContent) {
//        control.setContent(nativeContent);
//        control.centerContent();
    }

    @Override
    protected void setNativeSize(int width, int height) {
        if (getContent() != null) {
            WidgetUtils.setNativeSize((JComponent) getContent().asNative(), width, height);
        }
    }
}
