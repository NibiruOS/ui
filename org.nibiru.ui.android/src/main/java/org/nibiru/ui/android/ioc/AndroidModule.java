package org.nibiru.ui.android.ioc;

import org.nibiru.ui.android.builder.AndroidComboBoxBuilderFactory;
import org.nibiru.ui.android.builder.AndroidRadioButtonGroupBuilderFactory;
import org.nibiru.ui.android.clipboard.AndroidClipboard;
import org.nibiru.ui.android.widget.AndroidAbsolutePanel;
import org.nibiru.ui.android.widget.AndroidButton;
import org.nibiru.ui.android.widget.AndroidCanvas;
import org.nibiru.ui.android.widget.AndroidCheckBox;
import org.nibiru.ui.android.widget.AndroidHorizontalScrollPanel;
import org.nibiru.ui.android.widget.AndroidImage;
import org.nibiru.ui.android.widget.AndroidLabel;
import org.nibiru.ui.android.widget.AndroidPasswordBox;
import org.nibiru.ui.android.widget.AndroidPopup;
import org.nibiru.ui.android.widget.AndroidSpinner;
import org.nibiru.ui.android.widget.AndroidTextBox;
import org.nibiru.ui.android.widget.AndroidTreeView;
import org.nibiru.ui.android.widget.AndroidVerticalScrollPanel;
import org.nibiru.ui.android.widget.AndroidViewport;
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
import org.nibiru.ui.core.api.clipboard.Clipboard;
import org.nibiru.ui.core.api.format.FormatFactory;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.core.impl.format.JavaFormatFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
    @Provides
    public AbsolutePanel getAbsolutePanel(AndroidAbsolutePanel absolutePanel) {
        return absolutePanel;
    }

    @Provides
    public Button getButton(AndroidButton button) {
        return button;
    }

    @Provides
    public Canvas getCanvas(AndroidCanvas canvas) {
        return canvas;
    }

    @Provides
    public CheckBox getCheckbox(AndroidCheckBox checkbox) {
        return checkbox;
    }

    @Provides
    public Clipboard getClipboard(AndroidClipboard clipboard) {
        return clipboard;
    }

    @Provides
    public ComboBoxBuilderFactory getComboBoxBuilderFactory(AndroidComboBoxBuilderFactory factory) {
        return factory;
    }

    @Provides
    public FormatFactory getFormatFactory(JavaFormatFactory factory) {
        return factory;
    }

    @Provides
    public HorizontalScrollPanel getHorizontalScrollPanel(AndroidHorizontalScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Image getImage(AndroidImage image) {
        return image;
    }

    @Provides
    public Label getLabel(AndroidLabel label) {
        return label;
    }

    @Provides
    public PasswordBox getPasswordBox(AndroidPasswordBox passwordBox) {
        return passwordBox;
    }

    @Provides
    public Popup getPopup(AndroidPopup popup) {
        return popup;
    }

    @Provides
    public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(
            AndroidRadioButtonGroupBuilderFactory factory) {
        return factory;
    }

    @Provides
    public Spinner getSpinner(AndroidSpinner spinner) {
        return spinner;
    }

    @Provides
    public TreeView getTreeView(AndroidTreeView treeView) {
        return treeView;
    }

    @Provides
    public TextBox getTextBox(AndroidTextBox textBox) {
        return textBox;
    }

    @Provides
    public VerticalScrollPanel getVerticalScrollPanel(AndroidVerticalScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Viewport getViewport(AndroidViewport viewport) {
        return viewport;
    }
}
