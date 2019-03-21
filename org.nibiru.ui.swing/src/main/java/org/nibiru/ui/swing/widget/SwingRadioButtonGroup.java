package org.nibiru.ui.swing.widget;

import com.google.common.collect.Maps;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.RadioButtonGroup;
import org.nibiru.ui.core.api.style.RadioButtonStyle;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.inject.Inject;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SwingRadioButtonGroup<V>
        extends SwingHasEnabledWidget<JPanel, V>
        implements RadioButtonGroup<V> {

    private V selectedItem;
    private final Map<V, JRadioButton> valueToButton;
    private final Value<Iterable<V>> items;

    @Inject
    public SwingRadioButtonGroup() {
        super(new JPanel());
        valueToButton = Maps.newHashMap();
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
                control.removeAll();
                valueToButton.clear();
                ButtonGroup group = new ButtonGroup();
                for (V item : value) {
                    JRadioButton radioButton = new JRadioButton();
                    group.add(radioButton);
                    radioButton.setAction(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            SwingRadioButtonGroup.this.getValue().set(item);
                        }
                    });
                    radioButton.setText(item.toString());
                    control.add(radioButton);
                    valueToButton.put(item, radioButton);
                }
            }
        };
        setStyle(RadioButtonStyle.DEFAULT);
    }

    @Override
    public void applyStyle() {
        super.applyStyle();
        if (getStyle() instanceof RadioButtonStyle) {
            RadioButtonStyle radioButtonStyle = (RadioButtonStyle) getStyle();
            control.setLayout(new BoxLayout(control, WidgetUtils
                    .orientationToNative(radioButtonStyle.getOrientation())));
        }
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
                setSelected(false);
                selectedItem = value;
                setSelected(true);
            }
        };
    }

    private void setSelected(boolean selected) {
        JRadioButton button = valueToButton.get(selectedItem);
        if (button != null) {
            button.setSelected(selected);
        }
    }
}
