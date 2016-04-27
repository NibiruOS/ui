package com.aajtech.ui.android.widget;

import javax.inject.Inject;

import com.aajtech.model.core.api.Type;
import com.aajtech.model.core.api.Value;
import com.aajtech.model.core.impl.BaseValue;
import com.aajtech.model.core.impl.java.JavaType;
import com.aajtech.ui.android.style.StyleResolver;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.Widget;

import android.content.Context;
import android.view.View;

public class AndroidListWidget extends AndroidVerticalPanel implements ListWidget {
	private final Value<Iterable<Widget>> value = buildValue();

	@Inject
	public AndroidListWidget(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}

	@Override
	public Value<Iterable<Widget>> getValue() {
		return value;
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
				control().removeAllViews();
				for (Widget child : value) {
					control().addView((View) child.asNative());
				}
			}
		};
	}
}