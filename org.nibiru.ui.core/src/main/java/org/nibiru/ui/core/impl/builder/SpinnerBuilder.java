package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.Spinner;

import javax.inject.Inject;

public class SpinnerBuilder
        extends BaseBuilder<Spinner>
        implements WidgetBuilder<Spinner, SpinnerBuilder> {
    @Inject
    public SpinnerBuilder(Spinner object) {
        super(object);
    }
}
