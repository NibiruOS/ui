package com.aajtech.ui.android.widget;

import java.util.Map;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.RadioButtonGroup;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AndroidRadioButtonGroup<V> extends AndroidValueWidget<RadioGroup, V>implements RadioButtonGroup<V> {
	private V selectedItem;
	private Value<Iterable<V>> items;
	private Map<V, RadioButton> valueToButtons = Maps.newHashMap();

	public AndroidRadioButtonGroup(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	public AndroidRadioButtonGroup(RadioGroup control, StyleResolver styleResolver) {
		super(control, styleResolver);
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
					RadioGroup radioGroup = control();
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

	@Override
	RadioGroup buildControl(Context context, int styleResource) {
		return new RadioGroup(context);
	}
}
