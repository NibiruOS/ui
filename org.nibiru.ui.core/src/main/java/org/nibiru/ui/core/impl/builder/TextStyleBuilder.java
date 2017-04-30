package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.TextStyle;

import javax.inject.Inject;

public class TextStyleBuilder extends BaseStyleBuilder<TextStyle, TextStyleBuilder> {
    @Inject
    public TextStyleBuilder() {
        super(new TextStyle());
    }

    public TextStyleBuilder textColor(Color textColor) {
        object.setTextColor(textColor);
        return this;
    }

    public TextStyleBuilder horizontalTextAlignment(Alignment horizontalTextAlignment) {
        object.setHorizontalTextAlignment(horizontalTextAlignment);
        return this;
    }

    public TextStyleBuilder verticalTextAlignment(Alignment verticalTextAlignment) {
        object.setVerticalTextAlignment(verticalTextAlignment);
        return this;
    }
}
