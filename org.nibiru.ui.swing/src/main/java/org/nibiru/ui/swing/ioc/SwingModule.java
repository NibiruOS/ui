package org.nibiru.ui.swing.ioc;

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
import org.nibiru.ui.swing.builder.SwingComboBoxBuilderFactory;
import org.nibiru.ui.swing.builder.SwingRadioButtonGroupBuilderFactory;
import org.nibiru.ui.swing.widget.SwingAbsolutePanel;
import org.nibiru.ui.swing.widget.SwingButton;
import org.nibiru.ui.swing.widget.SwingCanvas;
import org.nibiru.ui.swing.widget.SwingCheckBox;
import org.nibiru.ui.swing.widget.SwingHorizontalScrollPanel;
import org.nibiru.ui.swing.widget.SwingImage;
import org.nibiru.ui.swing.widget.SwingLabel;
import org.nibiru.ui.swing.widget.SwingPasswordBox;
import org.nibiru.ui.swing.widget.SwingPopup;
import org.nibiru.ui.swing.widget.SwingSpinner;
import org.nibiru.ui.swing.widget.SwingTextBox;
import org.nibiru.ui.swing.widget.SwingTreeView;
import org.nibiru.ui.swing.widget.SwingVerticalScrollPanel;
import org.nibiru.ui.swing.widget.SwingViewport;

import dagger.Module;
import dagger.Provides;

@Module
public class SwingModule {
    @Provides
    public AbsolutePanel getAbsolutePanel(SwingAbsolutePanel absolutePanel) {
        return absolutePanel;
    }

    @Provides
    public Button getButton(SwingButton button) {
        return button;
    }

    @Provides
    public Canvas getCanvas(SwingCanvas canvas) {
        return canvas;
    }

    @Provides
    public CheckBox getCheckbox(SwingCheckBox checkbox) {
        return checkbox;
    }

    @Provides
    public ComboBoxBuilderFactory getComboBoxBuilderFactory(SwingComboBoxBuilderFactory factory) {
        return factory;
    }

    @Provides
    public FormatFactory getFormatFactory(JavaFormatFactory factory) {
        return factory;
    }

    @Provides
    public HorizontalScrollPanel getHorizontalScrollPanel(SwingHorizontalScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Image getImage(SwingImage image) {
        return image;
    }

    @Provides
    public Label getLabel(SwingLabel label) {
        return label;
    }

    @Provides
    public Popup getPopup(SwingPopup popup) {
        return popup;
    }

    @Provides
    public PasswordBox getPasswordBox(SwingPasswordBox passwordBox) {
        return passwordBox;
    }

    @Provides
    public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(SwingRadioButtonGroupBuilderFactory factory) {
        return factory;
    }

    @Provides
    public Spinner getSpinner(SwingSpinner spinner) {
        return spinner;
    }

    @Provides
    public TextBox getTextBox(SwingTextBox textBox) {
        return textBox;
    }

    @Provides
    public TreeView getTreeView(SwingTreeView treeView) {
        return treeView;
    }

    @Provides
    public VerticalScrollPanel getVerticalScrollPanel(SwingVerticalScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Viewport getViewport(SwingViewport viewport) {
        return viewport;
    }
}
