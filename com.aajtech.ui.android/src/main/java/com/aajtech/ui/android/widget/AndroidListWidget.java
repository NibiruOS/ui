package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.Widget;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AndroidListWidget extends AndroidWidget<ListView>implements ListWidget {
	private final Value<Iterable<Widget>> value;
	private ArrayAdapter<Widget> adapter;

	@Inject
	public AndroidListWidget(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
		value = buildValue();
	}

	public AndroidListWidget(ListView view, StyleResolver styleResolver) {
		super(view, styleResolver);
		value = buildValue();
	}

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
	}
	
	@Override
	ListView buildControl(Context context, int styleResource) {
		ListView list = styleResource == 0 ? new ListView(context) : new ListView(context, null, styleResource);
		adapter = new ArrayAdapter<Widget>(control().getContext(), 0, Lists.newArrayList()) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				return (View) getItem(position).asNative();
			}

			@Override
			public boolean isEnabled(int position) {
				return false;
			}
		};
		list.setAdapter(adapter);
		return list;
	}
	
	private Value<Iterable<Widget>> buildValue() {
		return new BaseValue<Iterable<Widget>>() {
			private Iterable<Widget> value;

			@Override
			public Iterable<Widget> get() {
				return value;
			}

			@Override
			public Type<Iterable<Widget>> getType() {
				return JavaType.ofIterable(Widget.class);
			}

			@Override
			protected void setValue(Iterable<Widget> value) {
				this.value = value;
				adapter.clear();
				adapter.addAll(ImmutableList.copyOf(value));
				adapter.notifyDataSetChanged();
			}
		};
	}
}
