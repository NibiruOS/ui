package org.nibiru.ui.core.api.style;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkNotNull;

public class Color {
    private static final int NON_ALPHA_SPEC_LENGHT = 7;
    private static final int ALPHA_SPEC_LENGHT = NON_ALPHA_SPEC_LENGHT + 2;

    public static Color fromString(String color) {
        checkNotNull(color);
        if (color.startsWith("#")) {
            if (color.length() == NON_ALPHA_SPEC_LENGHT
                    || color.length() == ALPHA_SPEC_LENGHT) {
                int red = parseColor(color, 1);
                int green = parseColor(color, 3);
                int blue = parseColor(color, 5);
                if (color.length() == ALPHA_SPEC_LENGHT) {
                    int alpha = parseColor(color, 7);
                    return new Color(red, green, blue, alpha);
                } else {
                    return new Color(red, green, blue);
                }
            }
        } else {
            switch (color.toUpperCase()) {
                case "TRANSPARENT":
                    return TRANSPARENT;
                case "WHITE":
                    return WHITE;
                case "BLACK":
                    return BLACK;
                case "RED":
                    return RED;
                case "GREEN":
                    return GREEN;
                case "BLUE":
                    return BLUE;
                case "CYAN":
                    return CYAN;
                case "MAGENTA":
                    return MAGENTA;
                case "YELLOW":
                    return YELLOW;
                case "GRAY":
                    return GRAY;
                case "LIGHT_GRAY":
                    return LIGHT_GRAY;
            }
        }
        throw new IllegalArgumentException("Invalid color: " + color);
    }

    private static int parseColor(String spec, int start) {
        return Integer.parseInt(spec.substring(start, start + 2), 16);
    }

    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    public static final Color WHITE = new Color(0xFF, 0xFF, 0xFF);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color RED = new Color(0xFF, 0, 0);
    public static final Color GREEN = new Color(0, 0xFF, 0);
    public static final Color BLUE = new Color(0, 0, 0xFF);
    public static final Color CYAN = new Color(0, 0xFF, 0xFF);
    public static final Color MAGENTA = new Color(0xFF, 0, 0xFF);
    public static final Color YELLOW = new Color(0xFF, 0xFF, 0);
    public static final Color GRAY = new Color(0x80, 0x80, 0x80);
    public static final Color LIGHT_GRAY = new Color(0xD3, 0xD3, 0xD3);

    private final int red;
    private final int green;
    private final int blue;
    private final int alpha;

    public Color(int red, int green, int blue) {
        this(red, green, blue, 0xFF);
    }

    public Color(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getAlpha() {
        return alpha;
    }

    public String asCss() {
        return "rgba(" + red + ", " + green + ", " + blue + ", " + alpha / 255f + ")";
    }
}
