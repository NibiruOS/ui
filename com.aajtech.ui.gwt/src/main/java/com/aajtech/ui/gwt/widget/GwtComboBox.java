package com.aajtech.ui.gwt.widget;

import java.util.List;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.core.api.ComboBox;
import com.google.common.collect.Lists;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.ListBox;

public class GwtComboBox<V> extends GwtValueWidget<ListBox, V> implements ComboBox<V>{
	private V selectedItem;
	private Value<Iterable<V>> items;
	private List<V> comboItems = Lists.newArrayList();
	
	public GwtComboBox(){
		this(new ListBox());
	}
	
	public GwtComboBox(ListBox control) {
		super(control);
	}

	@Override
	public Value<V> buildValue() {
		control.addChangeHandler((ChangeEvent event) -> {
			getValue().set(comboItems.get(control.getSelectedIndex()));;
		});
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
				int selectedPos = comboItems.indexOf(selectedItem);
				if (selectedPos >= 0) {
					control.setSelectedIndex(selectedPos);
				}
			}
		};
	}

	@Override
	public Value<Iterable<V>> getItems() {
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
				control.clear();
				comboItems.clear();
				for (V item : value) {
					control.addItem(item.toString());
					comboItems.add(item);
				}
			}
		};
	
		return items;
	}

}
