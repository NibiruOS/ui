package org.nibiru.ui.ios.widget;

import javax.inject.Inject;

import org.nibiru.ui.core.api.GridPanel;

import ios.coregraphics.struct.CGPoint;
import ios.coregraphics.struct.CGRect;
import ios.coregraphics.struct.CGSize;
import ios.uikit.UIView;

public class IOSGridPanel extends IOSContainer implements GridPanel {
    private int columns = 1;

	@Inject
    public IOSGridPanel() {
	}

	@Override
    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    void layout() {
        double[] widths = new double[columns];
        double[] heights = new double[(control.subviews().size() + columns - 1) / columns];

        int column = 0;
        int row = 0;
        for (UIView child : control.subviews()) {
            double childWidth = child.frame().size().width();
            double childHeight = child.frame().size().height();

            if (childWidth > widths[column]) {
                widths[column] = childWidth;
            }
            if (childHeight > heights[row]) {
                heights[row] = childHeight;
            }

            column++;
            if (column >= widths.length) {
                column = 0;
                row++;
            }
        }

        double currentWidth = 0;
        double currentHeight = 0;
        column = 0;
        row = 0;
        for (UIView child : control.subviews()) {
            child.setFrame(new CGRect(new CGPoint(currentWidth, currentHeight),
                    new CGSize(child.frame().size().width(), child.frame().size().height())));

            currentWidth += widths[column];

            column++;
            if (column >= widths.length) {
                column = 0;
                currentWidth = 0;
                currentHeight += heights[row];
                row++;
            }
        }

        double width = 0;
        double height = 0;
        for (double columnWidth : widths) {
            width += columnWidth;
        }
        for (double rowHeight : heights) {
            height += rowHeight;
        }
        updateSize(width, height);
    }
}
