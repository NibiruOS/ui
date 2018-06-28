package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.Alignment;
import org.nibiru.ui.core.api.style.Color;
import org.nibiru.ui.core.api.style.TextStyle;

import javax.inject.Inject;

public class TextStyleBuilder
        extends BaseBuilder<TextStyle>
        implements BaseStyleBuilder<TextStyle, TextStyleBuilder> {

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

    public TextStyleBuilder fontSize(int size) {
        object.setFontSize(size);
        return this;
    }

    public TextStyleBuilder allCaps(boolean allCaps) {
        object.setAllCaps(allCaps);
        return this;
    }
}
