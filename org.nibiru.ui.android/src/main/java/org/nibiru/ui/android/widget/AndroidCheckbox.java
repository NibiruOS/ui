package org.nibiru.ui.android.widget;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import org.nibiru.model.core.api.Type;
import org.nibiru.model.core.api.Value;
import org.nibiru.model.core.impl.BaseValue;
import org.nibiru.model.core.impl.java.JavaType;
import org.nibiru.ui.core.api.Checkbox;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class AndroidCheckbox
        extends AndroidHasEnabledWidget<CheckBox, Boolean>
        implements Checkbox {

    @Inject
    public AndroidCheckbox(Context context) {
        this(new android.widget.CheckBox(context));
    }

    public AndroidCheckbox(CheckBox checkbox) {
        super(checkbox);
    }

    @Override
    public Value<String> getTextLabel() {
        return new BaseValue<String>() {
            @Override
            @Nullable
            public String get() {
                return control.getText().toString();
            }

            @Override
            protected void setValue(@Nullable String value) {
                control.setText(value);
            }

            @Override
            public Type<String> getType() {
                return JavaType.STRING;
            }
        };
    }

    @Override
    Value<Boolean> buildValue() {
        control.setOnCheckedChangeListener((CompoundButton buttonView, boolean isChecked) -> {
            getValue().notifyObservers();
        });
        return new BaseValue<Boolean>() {
            @Override
            @Nullable
            public Boolean get() {
                return control.isChecked();
            }

            @Override
            protected void setValue(Boolean value) {
                control.setChecked(value);
            }

            @Override
            public Type<Boolean> getType() {
                return JavaType.BOOLEAN;
            }
        };
    }
}
