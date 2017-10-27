package org.nibiru.ui.core.impl;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.style.Size;

import javax.inject.Inject;

public class VerticalPanelImpl extends BaseLayoutPanel implements VerticalPanel {

    @Inject
    public VerticalPanelImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
        super(panel, viewport, looper);
    }

    @Override
    protected void onMeasure(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
        int maxWidth = 0;
        int mTotalLength = 0;
        int childrenMP = 0;

        for (Widget child : getVisibleChildren()) {
            if (child.getStyle().getHeight().equals(Size.MATCH_PARENT)) {
                childrenMP++;
            } else {
                measureChild(child, childWidthSpec, childHeightSpec);

                mTotalLength += child.getFullMeasuredHeight();

                maxWidth = Math.max(maxWidth, child.getFullMeasuredWidth());

                //TODO: what are we going to do in this situation? the child wants to match our width, we need to remeasure it when we know our size
                if (childWidthSpec.getType() != Type.EXACTLY && child.getStyle().getWidth() == Size.MATCH_PARENT) {

                }
            }
        }

        if (childrenMP > 0) {
            final int remainingSpace = (childHeightSpec.getValue() - mTotalLength) / childrenMP;

            for (Widget child : getVisibleChildren()) {
                if (child.getStyle().getHeight().equals(Size.MATCH_PARENT)) {
                    measureChild(child, childWidthSpec, MeasureSpec.atMost(remainingSpace));

                    mTotalLength += child.getFullMeasuredHeight();

                    maxWidth = Math.max(maxWidth, child.getFullMeasuredWidth());
                }
            }
        }

        updateSize(resolveWidth(maxWidth, childWidthSpec), resolveHeight(mTotalLength, childHeightSpec));

    }

    @Override
    public void onLayout() {
        int currentY = 0;
        for (Widget child : getVisibleChildren()) {
            int x = 0;
            switch (child.getStyle().getHorizontalAlignment()) {
                case START:
                    x = child.getStyle().getMarginLeft();
                    break;
                case CENTER:
                    x = (getMeasuredWidth() - child.getMeasuredWidth()) / 2;
                    break;
                case END:
                    x = getMeasuredWidth() - child.getMeasuredWidth() - child.getStyle().getMarginRight();
                    break;
            }
            child.layout();
            panel.getPosition(child)
                    .setX(x)
                    .setY(currentY + child.getStyle().getMarginTop());
            currentY += child.getFullMeasuredHeight();
        }
        super.onLayout();
    }
}