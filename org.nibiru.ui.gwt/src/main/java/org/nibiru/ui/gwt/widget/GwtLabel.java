package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.api.Value;
import org.nibiru.ui.core.api.style.TextStyle;

import com.google.gwt.user.client.ui.Label;

public class GwtLabel extends GwtClickableValueWidget<Label, String> implements org.nibiru.ui.core.api.Label {
	// TODO: Fix this "magic".
	private static int MAGIC_PADDING = 2;

	@Inject
	public GwtLabel() {
		this(new Label());
	}

	public GwtLabel(Label label) {
		super(label);
	}

	@Override
	public void applyStyle() {
		super.applyStyle();
		if (getStyle() instanceof TextStyle) {
			TextStyle textStyle = (TextStyle) getStyle();
			control.getElement()
					.getStyle()
					.setColor(colorToNative(textStyle.getTextColor()));
		}
	}

	@Override
	Value<String> buildValue() {
		return new HasTextAdapter(control);
	}

	@Override
	protected int getNativeWidth() {
		return super.getNativeWidth() + MAGIC_PADDING;
	}
}
