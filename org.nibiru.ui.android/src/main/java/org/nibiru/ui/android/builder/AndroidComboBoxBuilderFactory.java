package org.nibiru.ui.android.builder;

import android.content.Context;

import org.nibiru.ui.android.widget.AndroidComboBox;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class AndroidComboBoxBuilderFactory implements ComboBoxBuilderFactory {
    private final Context context;

    @Inject
    public AndroidComboBoxBuilderFactory(Context context) {
        this.context = checkNotNull(context);
    }

    @Override
    public <T> ComboBoxBuilder<T> create(Class<T> valueClass) {
        return new ComboBoxBuilder<T>(new AndroidComboBox<T>(context));
    }
}
