package org.nibiru.ui.gwt.widget;

import java.util.List;

import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.ComboBox;

import com.google.common.collect.Lists;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.ListBox;

public class GwtComboBox<V> extends GwtValueWidget<ListBox, V> implements ComboBox<V>{
	private V selectedItem;
	private final Value<Iterable<V>> items;
	private final List<V> comboItems;
	
	@Inject
	public GwtComboBox(){
		this(new ListBox());
	}
	
	public GwtComboBox(ListBox control) {
		super(control);
		comboItems = Lists.newArrayList();
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
		return items;
	}

}
