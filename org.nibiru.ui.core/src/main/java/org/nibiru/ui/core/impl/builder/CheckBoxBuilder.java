package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.CheckBox;

import javax.inject.Inject;

public class CheckBoxBuilder
        extends BaseBuilder<CheckBox>
        implements
        FocusableBuilder<CheckBox, CheckBoxBuilder>,
        HasEnabledBuilder<CheckBox, CheckBoxBuilder>,
        ValueWidgetBuilder<CheckBox, Boolean, CheckBoxBuilder> {

    @Inject
    public CheckBoxBuilder(CheckBox checkBox) {
        super(checkBox);
    }

    public CheckBoxBuilder label(String text) {
        object.getTextLabel().set(text);
        return this;
    }
}
