package org.nibiru.ui.gwt.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.TextBox;

import org.nibiru.model.core.impl.java.JavaType;

import javax.inject.Inject;

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
    protected int getNativeWidth() {
        Element e = DOM.createDiv();
        e.setInnerText(getValue().get() != null ? getValue().get() : "I");
        e.getStyle().setPosition(Style.Position.ABSOLUTE);
        Document.get().getBody().appendChild(e);
        int width = e.getOffsetWidth();
        e.removeFromParent();
        return width + MAGIC_PADDING;
    }

    @Override
    public void setNativeSize(int measuredWidth, int measuredHeight) {
        super.setNativeSize(measuredWidth, measuredHeight - MAGIC_PADDING);
    }
}
