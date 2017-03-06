package org.nibiru.ui.teavm.ioc;

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
import org.nibiru.ui.core.impl.builder.ComboBoxBuilderFactory;
import org.nibiru.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import org.nibiru.ui.teavm.builder.TeaVmComboBoxBuilderFactory;
import org.nibiru.ui.teavm.builder.TeaVmRadioButtonGroupBuilderFactory;
import org.nibiru.ui.teavm.widget.TeaVmAbsolutePanel;
import org.nibiru.ui.teavm.widget.TeaVmButton;
import org.nibiru.ui.teavm.widget.TeaVmCheckbox;
import org.nibiru.ui.teavm.widget.TeaVmImage;
import org.nibiru.ui.teavm.widget.TeaVmLabel;
import org.nibiru.ui.teavm.widget.TeaVmPasswordBox;
import org.nibiru.ui.teavm.widget.TeaVmPopup;
import org.nibiru.ui.teavm.widget.TeaVmScrollPanel;
import org.nibiru.ui.teavm.widget.TeaVmSpinner;
import org.nibiru.ui.teavm.widget.TeaVmTextBox;
import org.nibiru.ui.teavm.widget.TeaVmTreeView;
import org.nibiru.ui.teavm.widget.TeaVmViewport;

import dagger.Module;
import dagger.Provides;

@Module
public class TeaVmModule {
	@Provides
	public Viewport getViewport(TeaVmViewport viewport) {
		return viewport;
	}

	@Provides
	public Button getButton(TeaVmButton button) {
		return button;
	}

	@Provides
	public Label getLabel(TeaVmLabel label) {
		return label;
	}

	@Provides
	public TextBox getTextBox(TeaVmTextBox textBox) {
		return textBox;
	}

	@Provides
	public PasswordBox getPasswordBox(TeaVmPasswordBox passwordBox) {
		return passwordBox;
	}

	@Provides
	public ScrollPanel getScrollPanel(TeaVmScrollPanel scrollPanel) {
		return scrollPanel;
	}

	@Provides
	public Image getImage(TeaVmImage image) {
		return image;
	}

	@Provides
	public Popup getPopup(TeaVmPopup popup) {
		return popup;
	}

	@Provides
	public Spinner getSpinner(TeaVmSpinner spinner) {
		return spinner;
	}

	@Provides
	public Checkbox getCheckbox(TeaVmCheckbox checkbox) {
		return checkbox;
	}

	@Provides
	public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(TeaVmRadioButtonGroupBuilderFactory factory) {
		return factory;
	}

	@Provides
	public ComboBoxBuilderFactory getComboBoxBuilderFactory(TeaVmComboBoxBuilderFactory factory) {
		return factory;
	}

	@Provides
	public TreeView getTreeView(TeaVmTreeView treeView) {
		return treeView;
	}

	@Provides
	public AbsolutePanel getAbsolutePanel(TeaVmAbsolutePanel absolutePanel) {
		return absolutePanel;
	}
}
