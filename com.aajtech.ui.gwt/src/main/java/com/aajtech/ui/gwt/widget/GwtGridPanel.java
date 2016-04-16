package com.aajtech.ui.gwt.widget;

import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.Widget;
import com.google.gwt.user.client.ui.FlexTable;

public class GwtGridPanel extends GwtWidget<FlexTable> implements GridPanel {
	private int columns;
	private int currentColumn;
	private int currentRow;

	public GwtGridPanel() {
		this(new FlexTable());
	}

	public GwtGridPanel(FlexTable table) {
		super(table);
	}

	@Override
	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	public void add(Widget child) {
		widget.setWidget(currentRow, currentColumn, (com.google.gwt.user.client.ui.Widget) child.asNative());
		currentColumn++;
		if (currentColumn >= columns) {
			currentColumn = 0;
			currentRow++;
		}
	}

	@Override
	public void clear() {
		widget.clear();
	}
}