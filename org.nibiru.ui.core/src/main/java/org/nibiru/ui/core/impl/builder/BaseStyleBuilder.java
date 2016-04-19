package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Style;

abstract public class BaseStyleBuilder<T extends Style, B extends BaseStyleBuilder<T, ?>> extends BaseBuilder<T> {
    public BaseStyleBuilder(T style) {
        super(style);
    }

    public B parent(T parent) {
        object.setParent(parent);
        return getThis();
    }

    public B backgroundColor(Color backgroundColor) {
        object.setBackgroundColor(backgroundColor);
        return getThis();
    }

    public B width(Size width) {
        object.setWidth(width);
        return getThis();
    }

    public B height(Size height) {
        object.setHeight(height);
        return getThis();
    }

    public B horizontalAlignment(Alignment horizontalAlignment) {
        object.setHorizontalAlignment(horizontalAlignment);
        return getThis();
    }

    public B verticalAlignment(Alignment verticalAlignment) {
        object.setVerticalAlignment(verticalAlignment);
        return getThis();
    }

    public B marginTop(int marginTop) {
        object.setMarginTop(marginTop);
        return getThis();
    }

    public B marginRight(int marginRight) {
        object.setMarginRight(marginRight);
        return getThis();
    }

    public B marginLeft(int marginLeft) {
        object.setMarginLeft(marginLeft);
        return getThis();
    }

    public B marginBottom(int marginBottom) {
        object.setMarginBottom(marginBottom);
        return getThis();
    }

    @SuppressWarnings("unchecked")
    B getThis() {
        return (B) this;
    }
}
