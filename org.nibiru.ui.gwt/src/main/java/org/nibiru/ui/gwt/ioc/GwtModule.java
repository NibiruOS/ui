package org.nibiru.ui.gwt.ioc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.Canvas;
import org.nibiru.ui.core.api.CheckBox;
import org.nibiru.ui.core.api.HorizontalScrollPanel;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.PasswordBox;
import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.Spinner;
import org.nibiru.ui.core.api.TextBox;
import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.VerticalScrollPanel;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.format.FormatFactory;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.gwt.builder.GwtComboBoxBuilderFactory;
import org.nibiru.ui.gwt.builder.GwtRadioButtonGroupBuilderFactory;
import org.nibiru.ui.gwt.format.GwtFormatFactory;
import org.nibiru.ui.gwt.resource.Resources;
import org.nibiru.ui.gwt.widget.GwtAbsolutePanel;
import org.nibiru.ui.gwt.widget.GwtButton;
import org.nibiru.ui.gwt.widget.GwtCanvas;
import org.nibiru.ui.gwt.widget.GwtCheckBox;
import org.nibiru.ui.gwt.widget.GwtImage;
import org.nibiru.ui.gwt.widget.GwtLabel;
import org.nibiru.ui.gwt.widget.GwtPasswordBox;
import org.nibiru.ui.gwt.widget.GwtPopup;
import org.nibiru.ui.gwt.widget.GwtScrollPanel;
import org.nibiru.ui.gwt.widget.GwtSpinner;
import org.nibiru.ui.gwt.widget.GwtTextBox;
import org.nibiru.ui.gwt.widget.GwtTreeView;
import org.nibiru.ui.gwt.widget.GwtViewport;

import dagger.Module;
import dagger.Provides;

@Module
public class GwtModule {
    @Provides
    public AbsolutePanel getAbsolutePanel(GwtAbsolutePanel absolutePanel) {
        return absolutePanel;
    }

    @Provides
    public Button getButton(GwtButton button) {
        return button;
    }

    @Provides
    public Canvas getCanvas(GwtCanvas canvas) {
        return canvas;
    }

    @Provides
    public CheckBox getCheckbox(GwtCheckBox checkbox) {
        return checkbox;
    }

    @Provides
    public ComboBoxBuilderFactory getComboBoxBuilderFactory(GwtComboBoxBuilderFactory factory) {
        return factory;
    }

    @Provides
    public FormatFactory getFormatFactory(GwtFormatFactory factory) {
        return factory;
    }

    @Provides
    public HorizontalScrollPanel getHorizontalScrollPanel(GwtScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Image getImage(GwtImage image) {
        return image;
    }

    @Provides
    public Label getLabel(GwtLabel label) {
        return label;
    }

    @Provides
    public PasswordBox getPasswordBox(GwtPasswordBox passwordBox) {
        return passwordBox;
    }

    @Provides
    public Popup getPopup(GwtPopup popup) {
        return popup;
    }

    @Provides
    public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(GwtRadioButtonGroupBuilderFactory factory) {
        return factory;
    }

    @Provides
    public Resources getResources() {
        return GWT.create(Resources.class);
    }

    @Provides
    public Scheduler getScheduler() {
        return Scheduler.get();
    }

    @Provides
    public Spinner getSpinner(GwtSpinner spinner) {
        return spinner;
    }

    @Provides
    public TextBox getTextBox(GwtTextBox textBox) {
        return textBox;
    }

    @Provides
    public TreeView getTreeView(GwtTreeView treeView) {
        return treeView;
    }

    @Provides
    public VerticalScrollPanel getVerticalScrollPanel(GwtScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Viewport getViewport(GwtViewport viewport) {
        return viewport;
    }
}
