package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import com.google.common.collect.Iterables;

public class GridPanelImpl extends BaseLayoutPanel implements GridPanel {
	private int columns = 1;

	@Inject
	public GridPanelImpl(AbsolutePanel panel) {
		super(panel);
	}

	@Override
	public void setColumns(int columns) {
		this.columns = columns;
	}

	// TODO: Ugly state coupling among methods
	private int[] widths;
	private int[] heights;
	
	@Override
	protected void measureLayout(MeasureSpec childWidthSpec, MeasureSpec childHeightSpec) {
		widths = new int[columns];
		heights = new int[(Iterables.size(getChildren()) + columns - 1) / columns];

		int column = 0;
		int row = 0;
		for (Widget child : getChildren()) {
			int childWidth = child.getMeasuredWidth();
			int childHeight = child.getMeasuredHeight();

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

		int width = 0;
		int height = 0;
		for (int columnWidth : widths) {
			width += columnWidth;
		}
		for (int rowHeight : heights) {
			height += rowHeight;
		}
		updateSize(width, height);
	}

	@Override
	public void layoutLayout() {
		int column = 0;
		int row = 0;
		int currentWidth = 0;
		int currentHeight = 0;
		column = 0;
		row = 0;
		for (Widget child : getChildren()) {
			panel.getPosition(child)
				.setX(currentWidth)
				.setY(currentHeight);

			currentWidth += widths[column];

			column++;
			if (column >= widths.length) {
				column = 0;
				currentWidth = 0;
				currentHeight += heights[row];
				row++;
			}
		}
	}
}
