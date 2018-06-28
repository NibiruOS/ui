package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.Window;

import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

public class GwtViewport implements Viewport {
    @Inject
    public GwtViewport() {
        Window.enableScrolling(false);
    }

    @Override
    public int getWidth() {
        return Window.getClientWidth();
    }

    @Override
    public int getHeight() {
        return Window.getClientHeight();
    }
}
