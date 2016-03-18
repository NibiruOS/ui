package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.loop.Looper;

import com.google.common.collect.Iterables;

public class GridPanelImpl extends BaseLayoutPanel implements GridPanel {
	private int columns = 1;
	private int maxHeights[];
	private int maxWidths[];
	
	@Inject
	public GridPanelImpl(AbsolutePanel panel, Looper looper) {
		super(panel, looper);
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
        int rows = (Iterables.size(getChildren()) + columns - 1) / columns;
        maxWidths = new int[columns];
        maxHeights = new int[rows];
        
        for (Widget child : getChildren()) {

            measureChild(child, widthSpec, heightSpec);

        	maxHeights[row] = Math.max(child.getMeasuredHeight(), maxHeights[row]);
        	maxWidths[column] = Math.max(child.getMeasuredWidth(), maxWidths[column]);

            column++;

            if (column == columns) {
            	height += maxHeights[row];
            	column = 0;
            	row++;
            }
            
        }
        
        int maxWidth = 0;
        
        for (int n : maxWidths) {
        	maxWidth += n;
        }
        
        updateSize(maxWidth, height);
    }
	
	
	@Override
	public void onLayout() {
		int column = 0;
		int row = 0;
		int currentWidth = 0;
		int currentHeight = 0;
		for (Widget child : getChildren()) {
			child.layout();
			panel.getPosition(child)
			.setX(currentWidth)
			.setY(currentHeight);

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
