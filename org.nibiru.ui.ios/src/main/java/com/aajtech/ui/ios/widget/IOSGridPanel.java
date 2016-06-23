package com.aajtech.ui.ios.widget;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIView;

import com.aajtech.ui.core.api.GridPanel;

public class IOSGridPanel extends IOSContainer implements GridPanel {
	private int columns = 1;

	@Override
	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	void layout() {
		double[] widths = new double[columns];
		double[] heights = new double[(control.getSubviews().size() + columns - 1) / columns];

		int column = 0;
		int row = 0;
		for (UIView child : control.getSubviews()) {
			double childWidth = child.getFrame().getWidth();
			double childHeight = child.getFrame().getHeight();

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
		for (UIView child : control.getSubviews()) {
			child.setFrame(
					new CGRect(currentWidth, currentHeight, child.getFrame().getWidth(), child.getFrame().getHeight()));

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
