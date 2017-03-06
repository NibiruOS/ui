package org.nibiru.ui.teavm.widget;

import org.nibiru.ui.core.api.Viewport;
import org.teavm.jso.browser.Window;

import javax.inject.Inject;

public class TeaVmViewport implements Viewport {
    @Inject
    public TeaVmViewport() {
    }

    @Override
    public int getWidth() {
        return Window.current().getScreen().getWidth();
    }

    @Override
    public int getHeight() {
        return Window.current().getScreen().getHeight();
    }
}
