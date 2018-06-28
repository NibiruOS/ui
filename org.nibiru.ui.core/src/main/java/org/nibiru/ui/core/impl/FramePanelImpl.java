package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.FramePanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.style.Alignment;

import javax.inject.Inject;

public class FramePanelImpl
        extends BaseLayoutPanel
        implements FramePanel {

    @Inject
    public FramePanelImpl(AbsolutePanel panel,
                          Viewport viewport,
                          Looper looper) {
        super(panel, viewport, looper);
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (Widget child : getChildren()) {

            measureChild(child, widthSpec, heightSpec);

            maxHeight = Math.max(child.getFullMeasuredHeight(), maxHeight);
            maxWidth = Math.max(child.getFullMeasuredWidth(), maxWidth);

        }

        updateSize(resolveWidth(maxWidth, widthSpec),
                resolveHeight(maxHeight, heightSpec));
    }


    @Override
    public void onLayout() {
        for (Widget child : getChildren()) {
            child.layout();
            panel.getPosition(child)
                    .setX(computeOffset(child.getStyle().getHorizontalAlignment(),
                            getFullMeasuredWidth(),
                            child.getMeasuredWidth(),
                            child.getStyle().getMarginLeft(),
                            child.getStyle().getMarginRight()))
                    .setY(computeOffset(child.getStyle().getVerticalAlignment(),
                            getFullMeasuredHeight(),
                            child.getMeasuredHeight(),
                            child.getStyle().getMarginTop(),
                            child.getStyle().getMarginBottom()));
        }
        super.onLayout();
    }

    private int computeOffset(Alignment alignment,
                              int containerSize,
                              int childsize,
                              int startMargin,
                              int endMargin) {
        switch (alignment) {
            case START:
                return startMargin;
            case END:
                return containerSize - childsize - endMargin;
            case CENTER:
                return (containerSize - childsize) / 2 + startMargin - endMargin;
            default:
                throw new IllegalArgumentException("Invalid alignment: " + alignment);
        }
    }
}
