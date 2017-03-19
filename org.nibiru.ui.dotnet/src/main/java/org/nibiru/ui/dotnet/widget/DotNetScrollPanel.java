package org.nibiru.ui.dotnet.widget;

import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Widget;

import javax.inject.Inject;

import cli.System.Windows.Controls.StackPanel;
import dagger.internal.Preconditions;

public class DotNetScrollPanel extends DotNetContainer implements ScrollPanel {
    @Inject
    public DotNetScrollPanel() {
        super(new StackPanel());
    }

    @Override
    public void setContent(Widget content) {
        Preconditions.checkNotNull(content);
        clear();
        //control.set_Con((UIView) content.asNative());
    }

    @Override
    public void requestLayout() {
    }

    @Override
    protected int getNativeHeight() {
        // TODO Fix value - add size computation
        return 480;
    }

    @Override
    protected int getNativeWidth() {
        // TODO Fix value - add size computation
        return 320;
    }
}
