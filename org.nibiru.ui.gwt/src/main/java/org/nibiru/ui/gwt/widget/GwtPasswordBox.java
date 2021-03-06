package org.nibiru.ui.gwt.widget;

import com.google.gwt.user.client.ui.PasswordTextBox;

import org.nibiru.model.core.impl.java.JavaType;

import javax.inject.Inject;

public class GwtPasswordBox
        extends GwtHasEnabledHasValueWidget<PasswordTextBox, String>
        implements org.nibiru.ui.core.api.PasswordBox, GwtFocusable<PasswordTextBox> {

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
