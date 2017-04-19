package org.nibiru.ui.android.widget;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.common.collect.Lists;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.ComboBox;

import java.util.List;

import javax.inject.Inject;

public class AndroidComboBox<V>  extends AndroidValueWidget<android.widget.Spinner, V> implements ComboBox<V>{

	private V selectedItem;
	private Value<Iterable<V>> items;
	private List<V> comboItems = Lists.newArrayList();	
	
	@Inject
	public AndroidComboBox(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}	
	
	public AndroidComboBox(Spinner comboBox, StyleResolver styleResolver) {
		super(comboBox, styleResolver);
	}

	@Override
	Value<V> buildValue() {
		control().setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				getValue().notifyObservers();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				//TODO
			}
			
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
				Spinner control = control();
				if (selectedPos >= 0) {
					control.setSelection(selectedPos);
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
				Spinner control = control();
				comboItems.clear(); 
				for (V item : value) {					
					comboItems.add(item);
				}
				ArrayAdapter<V> adapter = new ArrayAdapter<V>(control.getContext(),
						android.R.layout.simple_spinner_item, comboItems);
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				control.setAdapter(adapter);
			}
		};
	
		return items;
	}

	@Override
	Spinner buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
					? new android.widget.Spinner(context)
					: new android.widget.Spinner(context, null, styleResource);
	}	
	
}
