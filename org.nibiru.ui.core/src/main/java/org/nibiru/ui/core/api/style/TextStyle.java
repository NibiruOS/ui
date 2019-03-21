package org.nibiru.ui.core.api.style;

import javax.annotation.Nullable;

public class TextStyle extends Style {
    public static final TextStyle DEFAULT = new TextStyle();
    public static final int DEFAULT_FONT_SIZE = 0;

    private Color textColor;
    private Alignment horizontalTextAlignment;
    private Integer fontSize;
    private Boolean allCaps;

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

    public Integer getFontSize() {
        return property(fontSize, TextStyle::getFontSize, DEFAULT_FONT_SIZE);
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Boolean getAllCaps() {
        return property(allCaps, TextStyle::getAllCaps, false);
    }

    public void setAllCaps(Boolean allCaps) {
        this.allCaps = allCaps;
    }
}
