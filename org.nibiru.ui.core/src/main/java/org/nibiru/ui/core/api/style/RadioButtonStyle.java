package org.nibiru.ui.core.api.style;

import javax.annotation.Nullable;

public class RadioButtonStyle extends Style {
    public static final RadioButtonStyle DEFAULT = new RadioButtonStyle();

    private Orientation orientation;

    public Orientation getOrientation() {
        return property(orientation, RadioButtonStyle::getOrientation, Orientation.VERTICAL);
    }

    public void setOrientation(@Nullable Orientation orientation) {
        this.orientation = orientation;
    }
}
