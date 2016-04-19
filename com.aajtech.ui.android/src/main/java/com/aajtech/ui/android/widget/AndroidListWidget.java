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
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AndroidListWidget extends AndroidWidget<ListView>implements ListWidget {
	private final Value<Iterable<Widget>> value;
	private ArrayAdapter<Widget> adapter;

	@Inject
	public AndroidListWidget(Context context, StyleResolver styleResolver) {
		this(new ListView(new ContextThemeWrapper(context, 0)), styleResolver);
		adapter = new ArrayAdapter<Widget>(control.getContext(), 0, Lists.newArrayList()) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				return (View) getItem(position).asNative();
			}

		    @Override
		    public boolean isEnabled(int position) {
		        return false;
		    }
		};
		control.setAdapter(adapter);
	}

	public AndroidListWidget(ListView view, StyleResolver styleResolver) {
		super(view, styleResolver);
		value = new BaseValue<Iterable<Widget>>() {
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

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
	}
}
