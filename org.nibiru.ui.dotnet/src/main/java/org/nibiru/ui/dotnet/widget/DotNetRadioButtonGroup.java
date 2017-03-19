package org.nibiru.ui.dotnet.widget;

import com.google.common.collect.Iterables;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.RadioButtonGroup;

import javax.inject.Inject;

import cli.System.Windows.Controls.RadioButton;

public class DotNetRadioButtonGroup<V>
        extends DotNetValueWidget<RadioButton, V>
        implements RadioButtonGroup<V> {
    private V selectedItem;
    private final Value<Iterable<V>> items;

    @Inject
    public DotNetRadioButtonGroup() {
        this(new RadioButton());
    }

    public DotNetRadioButtonGroup(RadioButton control) {
        super(control);

        items = new BaseValue<Iterable<V>>() {
            private Iterable<V> value;

            @Override
            public Iterable<V> get() {
                return value;
            }

            @Override
            public Type<Iterable<V>> getType() {
                return JavaType.ofUnchecked(Iterable.class);
            }

            @Override
            protected void setValue(Iterable<V> value) {
                this.value = value;
            }
        };
    }

    @Override
    public Value<Iterable<V>> getItems() {
        return items;
    }

    @Override
    Value<V> buildValue() {
        return new BaseValue<V>() {

            @Override
            public V get() {
                return selectedItem;
            }

            @Override
            public Type<V> getType() {
                return JavaType.ofUnchecked(Object.class);
            }

            @Override
            protected void setValue(V value) {
                selectedItem = value;
            }
        };
    }


    @Override
    protected int getNativeHeight() {
        return items.get() != null
                ? 25 * Iterables.size(items.get())
                : 0;
    }

    @Override
    protected int getNativeWidth() {
        return 50;
    }
}
