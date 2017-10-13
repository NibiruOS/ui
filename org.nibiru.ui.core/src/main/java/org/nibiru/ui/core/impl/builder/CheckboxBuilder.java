package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Checkbox;

import javax.inject.Inject;

public class CheckboxBuilder
        extends BaseValueBuilder<Checkbox, Boolean, CheckboxBuilder> {

    @Inject
    public CheckboxBuilder(Checkbox checkbox) {
        super(checkbox);
    }

    public CheckboxBuilder label(String text) {
        object.getTextLabel().set(text);
        return this;
    }

    public CheckboxBuilder enabled(boolean enabled) {
        object.getEnabled().set(enabled);
        return this;
    }
}
