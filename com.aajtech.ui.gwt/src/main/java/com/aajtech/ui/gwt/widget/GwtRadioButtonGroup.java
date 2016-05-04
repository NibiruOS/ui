package com.aajtech.ui.gwt.widget;

import java.util.Map;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.RadioButtonGroup;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GwtRadioButtonGroup<V> extends GwtValueWidget<VerticalPanel, V> implements RadioButtonGroup<V> {
	private static int groupCount;
	private int groupId;
	private V selectedItem;
	private Value<Iterable<V>> items;
	private Map<V, RadioButton> valueToButtons = Maps.newHashMap();

	public GwtRadioButtonGroup() {
		this(new VerticalPanel());
	}

	public GwtRadioButtonGroup(VerticalPanel control) {
		super(control);
		groupId = groupCount++;
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
						RadioButton rb = new RadioButton("aaj_ui_radioButton_group_"+groupId, item.toString());
						rb.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
							@Override
							public void onValueChange(ValueChangeEvent<Boolean> event) {
								if (event.getValue()) {
									getValue().set(item);
								}
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
			public void set(V value) {
				if (!Objects.equal(value, get())) {
					RadioButton rb = valueToButtons.get(value);
					if (rb != null) {
						setValue(value);
						rb.setValue(true);
						notifyObservers();
					}
				}
			}

			@Override
			protected void setValue(V value) {
				selectedItem = value;
			}
		};
	}
}
