package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.TextStyle;

import static com.google.common.base.Preconditions.checkNotNull;


abstract class TextValue extends BaseValue<String> {
    private final Widget widget;
    private String text;

    protected TextValue(Widget widget) {
        this.widget = checkNotNull(widget);
    }

    @Override
    public String get() {
        return text;
    }

    @Override
    public Type<String> getType() {
        return JavaType.STRING;
    }

    @Override
    protected void setValue(String text) {
        this.text = text;

        setNativeText(convert(text));
    }

    protected abstract void setNativeText(String text);

    private String convert(String text) {
        if (widget.getStyle() instanceof TextStyle) {
            TextStyle textStyle = (TextStyle) widget.getStyle();
            if (textStyle.getAllCaps()) {
                return text.toUpperCase();
            }
        }
        return text;
    }
}
