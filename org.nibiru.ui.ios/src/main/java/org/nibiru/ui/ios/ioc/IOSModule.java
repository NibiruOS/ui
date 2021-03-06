package org.nibiru.ui.ios.ioc;

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
import org.nibiru.ui.core.impl.format.JavaFormatFactory;
import org.nibiru.ui.ios.builder.IOSComboBoxBuilderFactory;
import org.nibiru.ui.ios.builder.IOSRadioButtonGroupBuilderFactory;
import org.nibiru.ui.ios.widget.IOSAbsolutePanel;
import org.nibiru.ui.ios.widget.IOSButton;
import org.nibiru.ui.ios.widget.IOSCanvas;
import org.nibiru.ui.ios.widget.IOSCheckBox;
import org.nibiru.ui.ios.widget.IOSHorizontalScrollPanel;
import org.nibiru.ui.ios.widget.IOSImage;
import org.nibiru.ui.ios.widget.IOSLabel;
import org.nibiru.ui.ios.widget.IOSPasswordBox;
import org.nibiru.ui.ios.widget.IOSPopup;
import org.nibiru.ui.ios.widget.IOSSpinner;
import org.nibiru.ui.ios.widget.IOSTextBox;
import org.nibiru.ui.ios.widget.IOSTreeView;
import org.nibiru.ui.ios.widget.IOSVerticalScrollPanel;
import org.nibiru.ui.ios.widget.IOSViewport;

import dagger.Module;
import dagger.Provides;

@Module
public class IOSModule {
    @Provides
    public AbsolutePanel getAbsolutePanel(IOSAbsolutePanel absolutePanel) {
        return absolutePanel;
    }

    @Provides
    public Button getButton(IOSButton button) {
        return button;
    }

    @Provides
    public Canvas getCanvas(IOSCanvas canvas) {
        return canvas;
    }

    @Provides
    public CheckBox getCheckbox(IOSCheckBox checkbox) {
        return checkbox;
    }

    @Provides
    public ComboBoxBuilderFactory getComboBoxBuilderFactory(IOSComboBoxBuilderFactory factory) {
        return factory;
    }

    @Provides
    public FormatFactory getFormatFactory(JavaFormatFactory factory) {
        return factory;
    }

    @Provides
    public HorizontalScrollPanel getHorizontalScrollPanel(IOSHorizontalScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Image getImage(IOSImage image) {
        return image;
    }

    @Provides
    public Label getLabel(IOSLabel label) {
        return label;
    }

    @Provides
    public Popup getPopup(IOSPopup popup) {
        return popup;
    }

    @Provides
    public PasswordBox getPasswordBox(IOSPasswordBox passwordBox) {
        return passwordBox;
    }

    @Provides
    public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(IOSRadioButtonGroupBuilderFactory factory) {
        return factory;
    }

    @Provides
    public Spinner getSpinner(IOSSpinner spinner) {
        return spinner;
    }

    @Provides
    public TextBox getTextBox(IOSTextBox textBox) {
        return textBox;
    }

    @Provides
    public TreeView getTreeView(IOSTreeView treeView) {
        return treeView;
    }

    @Provides
    public VerticalScrollPanel getVerticalScrollPanel(IOSVerticalScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Viewport getViewport(IOSViewport viewport) {
        return viewport;
    }
}
