package org.nibiru.ui.gwt.widget;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.RadioButtonGroup;

import java.util.Map;

public class GwtRadioButtonGroup<V>
        extends GwtValueWidget<VerticalPanel, V>
        implements RadioButtonGroup<V> {

    private static int groupCount;
    private int groupId;
    private V selectedItem;
    private Value<Iterable<V>> items;
    private Map<V, RadioButton> valueToButtons = Maps.newHashMap();
    private final Value<Boolean> enabled = BaseValue.of(true);

    public GwtRadioButtonGroup() {
        this(new VerticalPanel());
    }

    public GwtRadioButtonGroup(VerticalPanel control) {
        super(control);
        groupId = groupCount++;
        enabled.addObserver(() -> {
            for (RadioButton rb : valueToButtons.values()) {
                rb.setEnabled(enabled.get());
            }
        });
    }

    @Override
    public Value<Iterable<V>> getItems() {
        if (items == null) {
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
                    while (control.getWidgetCount() > 0) {
                        control.remove(0);
                    }
                    valueToButtons.clear();
                    for (V item : value) {
                        RadioButton rb = new RadioButton("nibiru_ui_radioButton_group_" + groupId, item.toString());
                        rb.setValue(Objects.equal(selectedItem, item));
                        rb.addValueChangeHandler((ValueChangeEvent<Boolean> event) -> {
                            if (event.getValue()) {
                                getValue().set(item);
                            }
                        });
                        control.add(rb);
                        valueToButtons.put(item, rb);
                    }
                }
            };
        }
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
                RadioButton rb = valueToButtons.get(value);
                if (rb != null) {
                    rb.setValue(true);
                }
            }
        };
    }

    @Override
    public Value<Boolean> getEnabled() {
        return enabled;
    }
}
