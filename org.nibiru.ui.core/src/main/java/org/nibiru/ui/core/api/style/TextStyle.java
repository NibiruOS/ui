package org.nibiru.ui.core.api.style;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class TextStyle extends Style {
    public static final TextStyle DEFAULT = new TextStyle();

    private Color textColor;
    private Alignment horizontalTextAlignment;
    private Alignment verticalTextAlignment;

    public Color getTextColor() {
        return property(textColor, TextStyle::getTextColor, Color.BLACK);
    }

    public void setTextColor(@Nullable Color textColor) {
        this.textColor = textColor;
    }

    public Alignment getHorizontalTextAlignment() {
        return property(horizontalTextAlignment, TextStyle::getHorizontalTextAlignment, Alignment.START);
    }

    public void setHorizontalTextAlignment(@Nullable Alignment horizontalTextAlignment) {
        this.horizontalTextAlignment = horizontalTextAlignment;
    }

    public Alignment getVerticalTextAlignment() {
        return property(verticalTextAlignment, TextStyle::getVerticalTextAlignment, Alignment.START);
    }

    public void setVerticalTextAlignment(@Nullable Alignment verticalTextAlignment) {
        this.verticalTextAlignment = verticalTextAlignment;
    }

    private <T, S extends Style> T property(T value,
                                            Function<TextStyle, T> parentValueFunction,
                                            T defaultValue) {
        return property(value,
                parentValueFunction,
                TextStyle.class,
                defaultValue);
    }
}
