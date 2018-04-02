package org.nibiru.ui.core.api;

import org.nibiru.model.core.api.Value;

public interface CheckBox
        extends ValueWidget<Boolean>, HasEnabled {

    Value<String> getTextLabel();
}
