package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.ImageStyle;
import org.nibiru.ui.core.api.style.ImageStyle.ScaleType;

import javax.inject.Inject;

public class ImageStyleBuilder extends BaseStyleBuilder<ImageStyle, ImageStyleBuilder> {
    @Inject
    public ImageStyleBuilder() {
        super(new ImageStyle());
    }

    public ImageStyleBuilder scaleType(ScaleType scaleType) {
        object.setScaleType(scaleType);
        return this;
    }
}
