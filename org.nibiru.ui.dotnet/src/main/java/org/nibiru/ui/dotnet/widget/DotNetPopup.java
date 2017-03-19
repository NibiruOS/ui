package org.nibiru.ui.dotnet.widget;

import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import cli.System.Windows.Window;

import static com.google.common.base.Preconditions.checkNotNull;

public class DotNetPopup implements Popup {
    private Widget content;
    private Window popup;

    @Inject
    public DotNetPopup() {
        popup = new Window();
        popup.set_Topmost(true);
    }

    @Override
    public void setContent(Widget content) {
        checkNotNull(content);
        if (this.content != null) {
            this.content.setParent(null);
        }
        this.content = content;
        popup.set_Content(content.asNative());
        content.setParent(this);
        content.layout();
    }

    @Override
    public void show() {
        popup.ShowDialog();
    }

    @Override
    public void hide() {
        popup.Close();
    }

    @Override
    public void setAutoHide(boolean autoHide) {
    }

    @Override
    public void requestLayout() {
    }

    @Override
    public void scheduleLayout() {
        requestLayout();
    }
}
