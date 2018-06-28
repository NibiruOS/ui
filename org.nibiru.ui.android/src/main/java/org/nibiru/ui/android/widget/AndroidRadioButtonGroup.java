package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.RadioButtonGroup;

import java.util.Map;

public class AndroidRadioButtonGroup<V>
        extends AndroidHasEnabledWidget<RadioGroup, V>
        implements RadioButtonGroup<V> {

    private V selectedItem;
    private Value<Iterable<V>> items;
    private Map<V, RadioButton> valueToButtons = Maps.newHashMap();

    public AndroidRadioButtonGroup(Context context) {
        this(new RadioGroup(context));
    }

    public AndroidRadioButtonGroup(RadioGroup control) {
        super(control);
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
                    RadioGroup radioGroup = control;
                    radioGroup.removeAllViews();
                    valueToButtons.clear();
                    for (V item : value) {
                        RadioButton rb = new RadioButton(radioGroup.getContext());
                        rb.setText(item.toString());
                        rb.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
                            if (isChecked) {
                                getValue().set(item);
                            }
                        });
                        radioGroup.addView(rb);
                        rb.setChecked(Objects.equal(selectedItem, item));
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
                    rb.setChecked(true);
                }
            }
        };
    }
}
