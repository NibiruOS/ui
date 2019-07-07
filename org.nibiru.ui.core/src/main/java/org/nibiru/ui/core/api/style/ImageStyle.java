package org.nibiru.ui.core.api.style;

import javax.annotation.Nullable;

public class ImageStyle extends Style {
    public enum ScaleType {FIT_CENTER, FIT_XY}

    public static final ImageStyle DEFAULT = new ImageStyle();

    private ScaleType scaleType;

    public ScaleType getScaleType() {
        return breadthFirstProperty(ImageStyle::scaleType, ScaleType.FIT_CENTER);
    }

    ScaleType scaleType() {
        return scaleType;
    }

    public void setScaleType(@Nullable ScaleType scaleType) {
        this.scaleType = scaleType;
    }
}
