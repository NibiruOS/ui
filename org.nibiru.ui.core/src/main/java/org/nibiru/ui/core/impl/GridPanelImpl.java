package org.nibiru.ui.core.impl;

import javax.inject.Inject;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.layout.MeasureSpec;
import org.nibiru.ui.core.api.layout.MeasureSpec.Type;
import org.nibiru.ui.core.api.layout.Size;
import com.google.common.collect.Iterables;
import java.lang.Math;

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

    @Override
    protected void onMeasure(MeasureSpec widthSpec, MeasureSpec heightSpec) {

        int widthSansPadding = 0;
        int heightSansPadding = 0;
        int count = 0;
        int maxWidth = 0;
        int maxheight = 0;
        int height = 0;
        int rows = (Iterables.size(getChildren()) + columns - 1) / columns;
        for (Widget child : getChildren()) {

                measureChild(child, widthSpec, heightSpec);
                count++;
                heightSansPadding = child.getMeasuredHeight();
//        	if (orientation == HORIZONTAL) {
                if (count < columns) {
                	maxheight = heightSansPadding > maxheight ? heightSansPadding : maxheight;
                	widthSansPadding += child.getMeasuredWidth();
                } else {
                	maxheight = heightSansPadding > maxheight ? heightSansPadding : maxheight;
                	widthSansPadding += child.getMeasuredWidth();
                	if (maxWidth < widthSansPadding) {
                		maxWidth = widthSansPadding;
                	}
                	height += maxheight;
                	widthSansPadding = 0;
                    maxheight = 0;
                	count = 0;
                }
//        	} else {

//        	}
        }
        updateSize(maxWidth, height);
    }
	
	
	@Override
	public void onLayout() {
		int column = 0;
		int currentWidth = 0;
		int currentHeight = 0;
		column = 0;
		for (Widget child : getChildren()) {
			child.layout();
			panel.getPosition(child)
			.setX(currentWidth)
			.setY(currentHeight);

			currentWidth += child.getMeasuredWidth();
	
			column++;
			if (column >= this.columns) {
				column = 0;
				currentWidth = 0;
				currentHeight += child.getMeasuredHeight();
			}
		}
		super.onLayout();
	}

}
