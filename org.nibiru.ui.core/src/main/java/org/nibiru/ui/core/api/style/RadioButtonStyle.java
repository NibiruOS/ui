package org.nibiru.ui.core.api.style;

import javax.annotation.Nullable;

public class RadioButtonStyle extends Style {
    public static final RadioButtonStyle DEFAULT = new RadioButtonStyle();

    private Orientation orientation;

    public Orientation getOrientation() {
        return breadthFirstProperty(RadioButtonStyle::orientation, Orientation.VERTICAL);
    }

    Orientation orientation() {
        return orientation;
    }

    public void setOrientation(@Nullable Orientation orientation) {
        this.orientation = orientation;
    }
}
