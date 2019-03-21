package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.ImageStyle;
import org.nibiru.ui.core.api.style.ImageStyle.ScaleType;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class ImageStyleBuilder
        extends BaseBuilder<ImageStyle>
        implements BaseStyleBuilder<ImageStyle, ImageStyleBuilder> {
    @Inject
    public ImageStyleBuilder() {
        super(new ImageStyle());
    }

    public ImageStyleBuilder scaleType(@Nullable ScaleType scaleType) {
        object.setScaleType(scaleType);
        return this;
    }
}
