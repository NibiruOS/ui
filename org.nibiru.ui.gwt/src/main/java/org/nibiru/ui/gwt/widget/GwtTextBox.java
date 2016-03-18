package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.impl.java.JavaType;

import com.google.gwt.user.client.ui.TextBox;

public class GwtTextBox extends GwtHasValueWidget<TextBox, String> implements org.nibiru.ui.core.api.TextBox {
	// TODO: Fix this "magic".
	private static int MAGIC_PADDING = 6;

	@Inject
	public GwtTextBox() {
		this(new TextBox());
	}

	public GwtTextBox(TextBox textBox) {
		super(textBox, JavaType.STRING);
	}

	@Override
	protected int getNativeHeight() {
		return super.getNativeHeight() + MAGIC_PADDING;
	}

	@Override
	public void setNativeSize(int measuredWidth, int measuredHeight) {
		super.setNativeSize(measuredWidth, measuredHeight - MAGIC_PADDING);
	}
}
