package org.nibiru.ui.swing.widget;

import org.nibiru.ui.core.api.Viewport;

import java.awt.Dimension;

import javax.inject.Inject;
import javax.swing.JFrame;

import static com.google.common.base.Preconditions.checkNotNull;

public class SwingViewport implements Viewport {
    private final JFrame jFrame;

    @Inject
    public SwingViewport(JFrame jFrame) {
        this.jFrame = checkNotNull(jFrame);
    }

    @Override

    public int getWidth() {
        return getSize().width;
    }

    @Override
    public int getHeight() {
        return getSize().height;
    }

    private Dimension getSize() {
        return jFrame.getContentPane().getSize();
    }
}
