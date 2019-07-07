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
        return breadthFirstProperty(TextStyle::textColor, Color.BLACK);
    }

    Color textColor() {
        return textColor;
    }

    public void setTextColor(@Nullable Color textColor) {
        this.textColor = textColor;
    }

    public Alignment getHorizontalTextAlignment() {
        return breadthFirstProperty(TextStyle::horizontalTextAlignment, Alignment.START);
    }

    Alignment horizontalTextAlignment() {
        return horizontalTextAlignment;
    }

    public void setHorizontalTextAlignment(@Nullable Alignment horizontalTextAlignment) {
        this.horizontalTextAlignment = horizontalTextAlignment;
    }

    public int getFontSize() {
        return breadthFirstProperty(TextStyle::fontSize, DEFAULT_FONT_SIZE);
    }

    public Integer fontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public boolean getAllCaps() {
        return breadthFirstProperty(TextStyle::allCaps, false);
    }

    public Boolean allCaps() {
        return allCaps;
    }

    public void setAllCaps(Boolean allCaps) {
        this.allCaps = allCaps;
    }
}
