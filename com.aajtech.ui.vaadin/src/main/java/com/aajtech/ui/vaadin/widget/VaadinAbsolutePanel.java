package com.aajtech.ui.vaadin.widget;

import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Widget;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.AbsoluteLayout.ComponentPosition;
import com.vaadin.ui.Component;

public class VaadinAbsolutePanel extends VaadinContainer<AbsoluteLayout>implements AbsolutePanel {

	public VaadinAbsolutePanel() {
		this(new AbsoluteLayout());
	}

	public VaadinAbsolutePanel(AbsoluteLayout component) {
		super(component);
	}

	@Override
	public Position getPosition(Widget child) {
		final Component component = (Component) child.asNative();
		return new Position() {

			@Override
			public int getX() {
				return control.getPosition(component).getLeftValue().intValue();
			}

			@Override
			public Position setX(int x) {
				ComponentPosition position = control.getPosition(component);
				position.setLeft(Float.valueOf(x), Unit.PIXELS);
				control.setPosition(component, position);
				return this;
			}

			@Override
			public int getY() {
				return control.getPosition((Component) child.asNative()).getTopValue().intValue();
			}

			@Override
			public Position setY(int y) {
				ComponentPosition position = control.getPosition(component);
				position.setTop(Float.valueOf(y), Unit.PIXELS);
				control.setPosition(component, position);
				return this;
			}
		};
	}
}
