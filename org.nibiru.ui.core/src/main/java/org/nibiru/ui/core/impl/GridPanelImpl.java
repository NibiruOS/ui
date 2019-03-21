package org.nibiru.ui.core.impl;

import com.google.common.collect.Iterables;

import org.nibiru.async.core.api.loop.Looper;
import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;

import javax.inject.Inject;

import static org.nibiru.ui.core.api.layout.MeasureSpec.Type.AT_MOST;
import static org.nibiru.ui.core.api.layout.MeasureSpec.Type.EXACTLY;

public class GridPanelImpl extends BaseLayoutPanel implements GridPanel {
    private int columns = 1;
    private int maxHeights[];
    private int maxWidths[];

    @Inject
    public GridPanelImpl(AbsolutePanel panel, Viewport viewport, Looper looper) {
        super(panel, viewport, looper);
    }

    @Override
    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {
        int column = 0;
        int row = 0;
        int height = 0;
        int rows = (Iterables.size(getVisibleChildren()) + columns - 1) / columns;
        maxWidths = new int[columns];
        maxHeights = new int[rows];

        for (Widget child : getVisibleChildren()) {

            measureChild(child, widthSpec, heightSpec);

            maxHeights[row] = Math.max(child.getFullMeasuredHeight(), maxHeights[row]);
            maxWidths[column] = Math.max(child.getFullMeasuredWidth(), maxWidths[column]);

            column++;

            if (column == columns) {
                height += maxHeights[row];
                column = 0;
                row++;
            }

        }

        int width = 0;

        for (int n : maxWidths) {
            width += n;
        }

        if (widthSpec.getType() == EXACTLY ||
                (widthSpec.getType() == AT_MOST && width > widthSpec.getValue())) {
            int averageWidth = widthSpec.getValue() / columns;
            for (int n = 0; n < maxWidths.length; n++) {
                maxWidths[n] = averageWidth;
            }
        }
        if (heightSpec.getType() == EXACTLY ||
                (heightSpec.getType() == AT_MOST && height > heightSpec.getValue())) {
            int averageHeight = heightSpec.getValue() / columns;
            for (int n = 0; n < maxHeights.length; n++) {
                maxHeights[n] = averageHeight;
            }
        }

        updateSize(resolveWidth(width, widthSpec),
                resolveHeight(height, heightSpec));
    }


    @Override
    public void onLayout() {
        int column = 0;
        int row = 0;
        int currentWidth = 0;
        int currentHeight = 0;
        for (Widget child : getVisibleChildren()) {
            child.layout();
            panel.getPosition(child)
                    .setX(currentWidth + computeChildX(child, maxWidths[column]))
                    .setY(currentHeight + computeChildY(child, maxHeights[row]));

            currentWidth += maxWidths[column];

            column++;
            if (column >= this.columns) {
                currentWidth = 0;
                currentHeight += maxHeights[row];
                column = 0;
                row++;
            }
        }
        super.onLayout();
    }

}
