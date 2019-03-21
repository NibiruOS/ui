package org.nibiru.ui.core.impl.builder;

import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.Widget;
import org.nibiru.ui.core.api.style.Style;

import javax.inject.Inject;
import javax.inject.Provider;

import static com.google.common.base.Preconditions.checkNotNull;

public class FormBuilder
        extends BaseBuilder<GridPanel>
        implements WidgetBuilder<GridPanel, FormBuilder> {
    private final HorizontalPanelBuilder horizontalPanelBuilder;
    private final Provider<Label> labelProvider;

    @Inject
    public FormBuilder(GridPanel gridPanel, HorizontalPanelBuilder horizontalPanelBuilder,
                       Provider<Label> labelProvider) {
        super(gridPanel);
        this.horizontalPanelBuilder = checkNotNull(horizontalPanelBuilder);
        this.labelProvider = checkNotNull(labelProvider);
        gridPanel.setColumns(2);
    }

    public FormBuilder field(Label label, Widget field) {
        checkNotNull(label);
        checkNotNull(field);
        label.getValue().set(label.getValue().get() + " :");
        object.add(label);
        object.add(field);
        return this;
    }

    public FormBuilder field(Builder<? extends Label> label, Widget field) {
        checkNotNull(label);
        checkNotNull(field);
        return field(label.build(), field);
    }

    public FormBuilder field(Label label, Builder<? extends Widget> field) {
        checkNotNull(label);
        checkNotNull(field);
        return field(label, field.build());
    }

    public FormBuilder field(Builder<? extends Label> label, Builder<? extends Widget> field) {
        checkNotNull(label);
        checkNotNull(field);
        return field(label.build(), field.build());
    }

    public FormBuilder button(Widget button) {
        checkNotNull(button);
        horizontalPanelBuilder.add(button);
        return this;
    }

    public FormBuilder button(Builder<? extends Widget> button) {
        checkNotNull(button);
        return button(button.build());
    }

    @Override
    public GridPanel build() {
        object.add(labelProvider.get());
        object.add(horizontalPanelBuilder.build());
        return super.build();
    }
}
