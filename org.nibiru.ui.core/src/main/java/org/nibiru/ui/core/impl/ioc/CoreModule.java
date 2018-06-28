package org.nibiru.ui.core.impl.ioc;

import org.nibiru.ui.core.api.FramePanel;
import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.RelativePanel;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.core.impl.FramePanelImpl;
import org.nibiru.ui.core.impl.GridPanelImpl;
import org.nibiru.ui.core.impl.HorizontalPanelImpl;
import org.nibiru.ui.core.impl.ListWidgetImpl;
import org.nibiru.ui.core.impl.RelativePanelImpl;
import org.nibiru.ui.core.impl.VerticalPanelImpl;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilder;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilder;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.core.impl.builder.UiBuilder;
import org.nibiru.ui.core.impl.builder.UiBuilderImpl;

import java.util.Date;

import dagger.Module;
import dagger.Provides;

@Module
public class CoreModule {
    @Provides
    public UiBuilder getUiBuilder(UiBuilderImpl uiBuilder) {
        return uiBuilder;
    }

    @Provides
    public HorizontalPanel getHorizontalPanel(HorizontalPanelImpl horizontalPanel) {
        return horizontalPanel;
    }

    @Provides
    public VerticalPanel getVerticalPanel(VerticalPanelImpl verticalPanel) {
        return verticalPanel;
    }

    @Provides
    public GridPanel getGridPanel(GridPanelImpl gridPanel) {
        return gridPanel;
    }

    @Provides
    public FramePanel getFramePanel(FramePanelImpl framePanel) {
        return framePanel;
    }

    @Provides
    public ListWidget getListWidget(ListWidgetImpl listWidget) {
        return listWidget;
    }

    @Provides
    public ComboBoxBuilder<String> getStringComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(String.class);
    }

    @Provides
    public ComboBoxBuilder<Byte> getByteComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Byte.class);
    }

    @Provides
    public ComboBoxBuilder<Short> getShortComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Short.class);
    }

    @Provides
    public ComboBoxBuilder<Character> getCharacterComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Character.class);
    }

    @Provides
    public ComboBoxBuilder<Integer> getIntegerComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Integer.class);
    }

    @Provides
    public ComboBoxBuilder<Long> getLongComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Long.class);
    }

    @Provides
    public ComboBoxBuilder<Float> getFloatComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Float.class);
    }

    @Provides
    public ComboBoxBuilder<Double> getDoubleComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Double.class);
    }

    @Provides
    public ComboBoxBuilder<Number> getNumberComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Number.class);
    }

    @Provides
    public ComboBoxBuilder<Boolean> getBooleanComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Boolean.class);
    }

    @Provides
    public ComboBoxBuilder<Date> getDateComboBoxBuilder(ComboBoxBuilderFactory factory) {
        return factory.create(Date.class);
    }

    @Provides
    public RadioButtonGroupBuilder<String> getStringRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(String.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Byte> getByteRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Byte.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Short> getShortRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Short.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Character> getCharacterRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Character.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Integer> getIntegerRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Integer.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Long> getLongRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Long.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Float> getFloatRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Float.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Double> getDoubleRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Double.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Number> getNumberRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Number.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Boolean> getBooleanRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Boolean.class);
    }

    @Provides
    public RadioButtonGroupBuilder<Date> getDateRadioButtonGroupBuilder(RadioButtonGroupBuilderFactory factory) {
        return factory.create(Date.class);
    }

    @Provides
    public RelativePanel getRelativePanel(RelativePanelImpl relativePanel) {
        return relativePanel;
    }
}
