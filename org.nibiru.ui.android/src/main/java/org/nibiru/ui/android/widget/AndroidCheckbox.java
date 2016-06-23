package org.nibiru.ui.android.widget;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.android.style.StyleResolver;
import org.nibiru.ui.core.api.Checkbox;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class AndroidCheckbox extends AndroidValueWidget<android.widget.CheckBox, Boolean> implements Checkbox {
	
	@Inject
	public AndroidCheckbox(Context context, StyleResolver styleResolver) {
		super(context, styleResolver);
	}
	
	public AndroidCheckbox(CheckBox checkbox, StyleResolver styleResolver) {
		super(checkbox, styleResolver);
	}

	@Override
	public Value<String> getTextLabel() {
		return new BaseValue<String>() {
			@Override
			@Nullable
			public String get() {
				return control().getText().toString();
			}

			@Override
			protected void setValue(@Nullable String value) {
				control().setText(value);
			}

			@Override
			public Type<String> getType() {
				return JavaType.STRING;
			}
		};
	}

	@Override
	Value<Boolean> buildValue() {
		control().setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
			getValue().notifyObservers();
		});
		return new BaseValue<Boolean>() {
			@Override
			@Nullable
			public Boolean get() {
				return control().isChecked();
			}

			@Override
			protected void setValue(Boolean value) {
				control().setChecked(value);
			}

			@Override
			public Type<Boolean> getType() {
				return JavaType.BOOLEAN;
			}
		};
	}

	@Override
	CheckBox buildControl(Context context, int styleResource) {
		return styleResource == StyleResolver.NO_STYLE
				? new android.widget.CheckBox(context)
				: new android.widget.CheckBox(context, null, styleResource);
	}


}
