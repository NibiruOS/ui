package org.nibiru.ui.swing.widget;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ComboBox;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.inject.Inject;
import javax.swing.JComboBox;

public class SwingComboBox<V>
        extends SwingHasEnabledWidget<JComboBox<V>, V>
        implements ComboBox<V> {

    private final Value<Iterable<V>> items;

    @Inject
    public SwingComboBox() {
        this(new JComboBox<>());
    }

    public SwingComboBox(JComboBox<V> comboBox) {
        super(comboBox);
        items = new BaseValue<Iterable<V>>() {
            @Override
            public Iterable<V> get() {
                return () -> new Iterator<V>() {
                    private int current = 0;

                    @Override
                    public boolean hasNext() {
                        return current < control.getItemCount();
                    }

                    @Override
                    public V next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        V item = control.getItemAt(current);
                        current++;
                        return item;
                    }
                };
            }

            @Override
            public Type<Iterable<V>> getType() {
                return JavaType.ofUnchecked(Iterable.class);
            }

            @Override
            protected void setValue(Iterable<V> value) {
                control.removeAllItems();
                for (V item : value) {
                    control.addItem(item);
                }
            }
        };
    }

    @Override
    public Value<V> buildValue() {
        return new BaseValue<V>() {

            @Override
            public V get() {
                return control.getItemAt(control.getSelectedIndex());
            }

            @Override
            public Type<V> getType() {
                return JavaType.ofUnchecked(Object.class);
            }

            @Override
            protected void setValue(V value) {
                control.setSelectedItem(value);
            }
        };
    }

    @Override
    public Value<Iterable<V>> getItems() {
        return items;
    }
}
