package org.nibiru.ui.core.api.style;

import static com.google.common.base.Preconditions.checkArgument;

public class Size {
    /**
     * This class is used by the child widget to specify its size.
     * EXACTLY -> Child wants to have an exact size
     * MATCH_PARENT -> Child wants to have same size as parent
     * WRAP_CONTENT -> Child wants to be big enough to enclose its content
     */
    public static enum Type {
        EXACTLY, MATCH_PARENT, WRAP_CONTENT
    }

    public static Size MATCH_PARENT = new Size(Type.MATCH_PARENT, -1);
    public static Size WRAP_CONTENT = new Size(Type.WRAP_CONTENT, -2);

    public static Size exactly(int value) {
        //checkArgument(value >= 0, "Size must be positive. Current value: %s", value);
        return new Size(Type.EXACTLY, value < 0 ? 0 : value);
    }

    private final Type type;
    private final int value;

    private Size(Type type, int value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}