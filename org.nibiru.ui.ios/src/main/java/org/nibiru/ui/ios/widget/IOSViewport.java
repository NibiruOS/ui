package org.nibiru.ui.ios.widget;

import org.nibiru.ui.core.api.Viewport;

import javax.inject.Inject;

import apple.coregraphics.struct.CGSize;
import apple.uikit.UIApplication;
import apple.uikit.UIScreen;

public class IOSViewport implements Viewport {
    @Inject
    public IOSViewport() {
    }

    @Override

    public int getWidth() {
        return (int) getSize().width();
    }

    @Override
    public int getHeight() {
        return (int) (getSize().height() - UIApplication.sharedApplication().statusBarFrame().size().height());
    }

    private CGSize getSize() {
        return UIScreen.mainScreen().bounds().size();
    }
}
