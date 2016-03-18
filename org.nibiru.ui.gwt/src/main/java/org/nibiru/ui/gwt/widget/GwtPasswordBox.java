package org.nibiru.ui.gwt.widget;

import javax.inject.Inject;

import org.nibiru.model.core.impl.java.JavaType;

import com.google.gwt.user.client.ui.PasswordTextBox;

public class GwtPasswordBox extends GwtHasValueWidget<PasswordTextBox, String> implements org.nibiru.ui.core.api.PasswordBox {
	private static int MAGIC_PADDING = 6;

	@Inject
	public GwtPasswordBox() {
		this(new PasswordTextBox());
	}

	public GwtPasswordBox(PasswordTextBox passwordTextBox) {
		super(passwordTextBox, JavaType.STRING);
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
