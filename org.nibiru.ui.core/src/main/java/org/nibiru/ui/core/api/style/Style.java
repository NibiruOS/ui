package org.nibiru.ui.core.api.style;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

public class Style {
    public static final Style DEFAULT = new Style();

    private List<Style> parents = Lists.newArrayListWithCapacity(1);
    private Color backgroundColor;
    private Size width;
    private Size height;
    private Integer maxWidth;
    private Integer maxHeight;
    private Alignment horizontalAlignment;
    private Alignment verticalAlignment;
    private Integer marginTop;
    private Integer marginRight;
    private Integer marginLeft;
    private Integer marginBottom;

    public void addParent(Style parent) {
        parents.add(checkNotNull(parent));
    }

    public Color getBackgroundColor() {
        return breadthFirstProperty(Style::backgroundColor, Color.TRANSPARENT);
    }

    Color backgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(@Nullable Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Size getWidth() {
        return breadthFirstProperty(Style::width, Size.WRAP_CONTENT);
    }

    Size width() {
        return width;
    }

    public void setWidth(@Nullable Size width) {
        this.width = width;
    }

    public Size getHeight() {
        return breadthFirstProperty(Style::height, Size.WRAP_CONTENT);
    }

    Size height() {
        return height;
    }

    public void setHeight(@Nullable Size height) {
        this.height = height;
    }

    public Integer getMaxWidth() {
        return breadthFirstProperty(Style::maxWidth, Integer.MAX_VALUE);
    }

    Integer maxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMaxHeight() {
        return breadthFirstProperty(Style::maxHeight, Integer.MAX_VALUE);
    }

    Integer maxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Alignment getHorizontalAlignment() {
        return breadthFirstProperty(Style::horizontalAlignment, Alignment.START);
    }

    Alignment horizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(@Nullable Alignment horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public Alignment getVerticalAlignment() {
        return breadthFirstProperty(Style::verticalAlignment, Alignment.START);
    }

    Alignment verticalAlignment() {
        return verticalAlignment;
    }

    public void setVerticalAlignment(@Nullable Alignment verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    public int getMarginTop() {
        return breadthFirstProperty(Style::marginTop, 0);
    }

    Integer marginTop() {
        return marginTop;
    }

    public void setMarginTop(@Nullable Integer marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginRight() {
        return breadthFirstProperty(Style::marginRight, 0);
    }

    public Integer marginRight() {
        return marginRight;
    }

    public void setMarginRight(@Nullable Integer marginRight) {
        this.marginRight = marginRight;
    }

    public int getMarginLeft() {
        return breadthFirstProperty(Style::marginLeft, 0);
    }

    Integer marginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(@Nullable Integer marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginBottom() {
        return breadthFirstProperty(Style::marginBottom, 0);
    }

    public Integer marginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(@Nullable Integer marginBottom) {
        this.marginBottom = marginBottom;
    }

    protected <T, S extends Style> T breadthFirstProperty(Function<S, T> valueGetter,
                                                          T defaultValue) {

        T currentValue = getValue(valueGetter, this);
        if (currentValue != null) {
            return currentValue;
        }

        LinkedList<Style> pending = Lists.newLinkedList();
        pending.addAll(parents);

        while (!pending.isEmpty()) {
            Style parent = pending.remove();
            currentValue = getValue(valueGetter, parent);
            if (currentValue != null) {
                return currentValue;
            }
            pending.addAll(parent.parents);
        }

        return defaultValue;
    }

    protected <T, S extends Style> T getValue(Function<S, T> valueGetter,
                                              Style target) {
        try {
            return valueGetter.apply((S) target);
        } catch (ClassCastException e) {
            // Not expected type - value not defined
            return null;
        }
    }
}
