package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.style.Orientation;
import org.nibiru.ui.core.api.style.RadioButtonStyle;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class RadioButtonStyleBuilder
        extends BaseBuilder<RadioButtonStyle>
        implements BaseStyleBuilder<RadioButtonStyle, RadioButtonStyleBuilder> {

    @Inject
    public RadioButtonStyleBuilder() {
        super(new RadioButtonStyle());
    }

    public RadioButtonStyleBuilder orientation(@Nullable Orientation orientation) {
        object.setOrientation(orientation);
        return this;
    }
}
