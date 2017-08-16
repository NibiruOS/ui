package org.nibiru.ui.core.api.style;

import javax.annotation.Nullable;

public class TextStyle extends Style {
    public static final TextStyle DEFAULT = new TextStyle();

    private Color textColor;
    private Alignment horizontalTextAlignment;

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
}
