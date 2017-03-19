package org.nibiru.ui.dotnet.widget;

import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

public class DotNetViewport implements Viewport {
    @Inject
    public DotNetViewport() {
    }

    @Override

    public int getWidth() {
        return 600;
    }

    @Override
    public int getHeight() {
        return 400;
    }
}
