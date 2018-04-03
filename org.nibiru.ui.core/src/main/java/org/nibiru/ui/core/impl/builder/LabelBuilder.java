package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Label;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class LabelBuilder
        extends BaseBuilder<Label>
        implements
        HasClickHandlerBuilder<Label, LabelBuilder>,
        ValueWidgetBuilder<Label, String, LabelBuilder> {
    @Inject
    public LabelBuilder(Label label) {
        super(label);
    }

    public Label build(@Nullable String text) {
        return value(text).build();
    }
}
