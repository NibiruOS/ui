package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.style.Size;

import javax.inject.Inject;

public class HorizontalPanelImpl extends BaseLayoutPanel implements HorizontalPanel {

    @Inject
    public HorizontalPanelImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
        super(panel, viewport, looper);
    }

    @Override
    protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
        int maxHeight = 0;
        int mTotalLength = 0;
        int childrenMP = 0;

        for (Widget child : getVisibleChildren()) {
            if (child.getStyle().getWidth().equals(Size.MATCH_PARENT)) {
                childrenMP++;
            } else {
                measureChild(child, childWidthSpec, childHeightSpec);

                mTotalLength += child.getFullMeasuredWidth();

                maxHeight = Math.max(maxHeight, child.getFullMeasuredHeight());

                //TODO: what are we going to do in this situation? the child wants to match our width, we need to remeasure it when we know our size
                if (childHeightSpec.getType() != Type.EXACTLY && child.getStyle().getHeight() == Size.MATCH_PARENT) {

                }
            }
        }

        if (childrenMP > 0) {
            int remainingSpace = (childWidthSpec.getValue() - mTotalLength) / childrenMP;

            for (Widget child : getVisibleChildren()) {
                if (child.getStyle().getWidth().equals(Size.MATCH_PARENT)) {
                    measureChild(child, MeasureSpec.atMost(remainingSpace), childHeightSpec);

                    mTotalLength += child.getFullMeasuredWidth();

                    maxHeight = Math.max(maxHeight, child.getFullMeasuredHeight());
                }
            }
        }

        updateSize(resolveWidth(mTotalLength, childWidthSpec), resolveHeight(maxHeight, childHeightSpec));

    }

    @Override
    public void onLayout() {
        int currentX = 0;
        for (Widget child : getVisibleChildren()) {
            int y = 0;
            switch (child.getStyle().getVerticalAlignment()) {
                case START:
                    y = child.getStyle().getMarginTop();
                    break;
                case CENTER:
                    y = (getMeasuredHeight() - child.getMeasuredHeight()) / 2;
                    break;
                case END:
                    y = getMeasuredHeight() - child.getMeasuredHeight() - child.getStyle().getMarginTop();
                    break;
            }
            child.layout();
            panel.getPosition(child)
                    .setX(currentX + child.getStyle().getMarginLeft())
                    .setY(y);
            currentX += child.getFullMeasuredWidth();
        }
        super.onLayout();
    }
}
