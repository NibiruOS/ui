package org.nibiru.ui.core.api.style;

import javax.annotation.Nullable;

public class ImageStyle extends Style {
    public enum ScaleType {FIT_CENTER, FIT_XY}

    public static final ImageStyle DEFAULT = new ImageStyle();

    private ScaleType scaleType;

    public ScaleType getScaleType() {
        return property(scaleType, ImageStyle::getScaleType, ScaleType.FIT_CENTER);
    }

    public void setScaleType(@Nullable ScaleType scaleType) {
        this.scaleType = scaleType;
    }
}
