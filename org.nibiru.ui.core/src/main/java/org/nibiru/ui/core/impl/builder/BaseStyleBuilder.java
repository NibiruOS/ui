package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.Size;
import org.nibiru.ui.core.api.style.Style;

public interface BaseStyleBuilder<T extends Style, B extends BaseStyleBuilder<T, ?>>
        extends ObjectBuilder<T>, ChainBuilder<B> {

    default B parent(Style parent) {
        object().setParent(parent);
        return getThis();
    }

    default B backgroundColor(Color backgroundColor) {
        object().setBackgroundColor(backgroundColor);
        return getThis();
    }

    default B width(Size width) {
        object().setWidth(width);
        return getThis();
    }

    default B height(Size height) {
        object().setHeight(height);
        return getThis();
    }

    default B maxWidth(int maxWidth) {
        object().setMaxWidth(maxWidth);
        return getThis();
    }

    default B maxHeight(int maxHeight) {
        object().setMaxHeight(maxHeight);
        return getThis();
    }

    default B horizontalAlignment(Alignment horizontalAlignment) {
        object().setHorizontalAlignment(horizontalAlignment);
        return getThis();
    }

    default B verticalAlignment(Alignment verticalAlignment) {
        object().setVerticalAlignment(verticalAlignment);
        return getThis();
    }

    default B marginTop(int marginTop) {
        object().setMarginTop(marginTop);
        return getThis();
    }

    default B marginRight(int marginRight) {
        object().setMarginRight(marginRight);
        return getThis();
    }

    default B marginLeft(int marginLeft) {
        object().setMarginLeft(marginLeft);
        return getThis();
    }

    default B marginBottom(int marginBottom) {
        object().setMarginBottom(marginBottom);
        return getThis();
    }
}
