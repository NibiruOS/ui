package org.nibiru.ui.android.builder;

import android.content.Context;

import org.nibiru.ui.android.widget.AndroidRadioButtonGroup;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilder;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidRadioButtonGroupBuilderFactory implements RadioButtonGroupBuilderFactory {
    private final Context context;

    @Inject
    public AndroidRadioButtonGroupBuilderFactory(Context context) {
        this.context = checkNotNull(context);
    }

    @Override
    public <T> RadioButtonGroupBuilder<T> create(Class<T> valueClass) {
        return new RadioButtonGroupBuilder<T>(new AndroidRadioButtonGroup<T>(context));
    }
}
