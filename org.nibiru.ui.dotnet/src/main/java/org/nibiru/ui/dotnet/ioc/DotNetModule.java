package org.nibiru.ui.dotnet.ioc;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.Checkbox;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.PasswordBox;
import org.nibiru.ui.core.api.Popup;
import org.nibiru.ui.core.api.ScrollPanel;
import org.nibiru.ui.core.api.Spinner;
import org.nibiru.ui.core.api.TextBox;
import org.nibiru.ui.core.api.TreeView;
import org.nibiru.ui.core.api.Viewport;
import org.nibiru.ui.core.api.loop.Looper;
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.dotnet.loop.DummyLooper;
import org.nibiru.ui.dotnet.builder.DotNetComboBoxBuilderFactory;
import org.nibiru.ui.dotnet.builder.DotNetRadioButtonGroupBuilderFactory;
import org.nibiru.ui.dotnet.widget.DotNetAbsolutePanel;
import org.nibiru.ui.dotnet.widget.DotNetButton;
import org.nibiru.ui.dotnet.widget.DotNetCheckbox;
import org.nibiru.ui.dotnet.widget.DotNetImage;
import org.nibiru.ui.dotnet.widget.DotNetLabel;
import org.nibiru.ui.dotnet.widget.DotNetPasswordBox;
import org.nibiru.ui.dotnet.widget.DotNetPopup;
import org.nibiru.ui.dotnet.widget.DotNetScrollPanel;
import org.nibiru.ui.dotnet.widget.DotNetSpinner;
import org.nibiru.ui.dotnet.widget.DotNetTextBox;
import org.nibiru.ui.dotnet.widget.DotNetTreeView;
import org.nibiru.ui.dotnet.widget.DotNetViewport;

import dagger.Module;
import dagger.Provides;

@Module
public class DotNetModule {
    @Provides
    public Viewport getViewport(DotNetViewport viewport) {
        return viewport;
    }

    @Provides
    public Button getButton(DotNetButton button) {
        return button;
    }

    @Provides
    public Label getLabel(DotNetLabel label) {
        return label;
    }

    @Provides
    public TextBox getTextBox(DotNetTextBox textBox) {
        return textBox;
    }

    @Provides
    public PasswordBox getPasswordBox(DotNetPasswordBox passwordBox) {
        return passwordBox;
    }

    @Provides
    public ScrollPanel getScrollPanel(DotNetScrollPanel scrollPanel) {
        return scrollPanel;
    }

    @Provides
    public Image getImage(DotNetImage image) {
        return image;
    }

    @Provides
    public Popup getPopup(DotNetPopup popup) {
        return popup;
    }

    @Provides
    public Spinner getSpinner(DotNetSpinner spinner) {
        return spinner;
    }

    @Provides
    public Checkbox getCheckbox(DotNetCheckbox checkbox) {
        return checkbox;
    }

    @Provides
    public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(DotNetRadioButtonGroupBuilderFactory factory) {
        return factory;
    }

    @Provides
    public ComboBoxBuilderFactory getComboBoxBuilderFactory(DotNetComboBoxBuilderFactory factory) {
        return factory;
    }

    @Provides
    public TreeView getTreeView(DotNetTreeView treeView) {
        return treeView;
    }

    @Provides
    public AbsolutePanel getAbsolutePanel(DotNetAbsolutePanel absolutePanel) {
        return absolutePanel;
    }

    @Provides
    public Looper getLooper(DummyLooper looper) {
        return looper;
    }
}
