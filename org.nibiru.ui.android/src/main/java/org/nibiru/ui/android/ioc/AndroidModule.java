package org.nibiru.ui.android.ioc;

import org.nibiru.ui.android.builder.AndroidComboBoxBuilderFactory;
import org.nibiru.ui.android.builder.AndroidRadioButtonGroupBuilderFactory;
import org.nibiru.ui.android.widget.AndroidAbsolutePanel;
import org.nibiru.ui.android.widget.AndroidButton;
import org.nibiru.ui.android.widget.AndroidCheckbox;
import org.nibiru.ui.android.widget.AndroidImage;
import org.nibiru.ui.android.widget.AndroidLabel;
import org.nibiru.ui.android.widget.AndroidPasswordBox;
import org.nibiru.ui.android.widget.AndroidPopup;
import org.nibiru.ui.android.widget.AndroidScrollPanel;
import org.nibiru.ui.android.widget.AndroidSpinner;
import org.nibiru.ui.android.widget.AndroidTextBox;
import org.nibiru.ui.android.widget.AndroidTreeView;
import org.nibiru.ui.android.widget.AndroidViewport;
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

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
	@Provides
	public Viewport getViewport(AndroidViewport viewport) {
		return viewport;
	}

	@Provides
	public Button getButton(AndroidButton button) {
		return button;
	}

	@Provides
	public Label getLabel(AndroidLabel label) {
		return label;
	}

	@Provides
	public TextBox getTextBox(AndroidTextBox textBox) {
		return textBox;
	}

	@Provides
	public PasswordBox getPasswordBox(AndroidPasswordBox passwordBox) {
		return passwordBox;
	}

	@Provides
	public ScrollPanel getScrollPanel(AndroidScrollPanel scrollPanel) {
		return scrollPanel;
	}

	@Provides
	public Image getImage(AndroidImage image) {
		return image;
	}

	@Provides
	public Popup getPopup(AndroidPopup popup) {
		return popup;
	}

	@Provides
	public Spinner getSpinner(AndroidSpinner spinner) {
		return spinner;
	}

	@Provides
	public Checkbox getCheckbox(AndroidCheckbox checkbox) {
		return checkbox;
	}

	@Provides
	public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(
			AndroidRadioButtonGroupBuilderFactory factory) {
		return factory;
	}

	@Provides
	public ComboBoxBuilderFactory getComboBoxBuilderFactory(AndroidComboBoxBuilderFactory factory) {
		return factory;
	}

	@Provides
	public TreeView getTreeView(AndroidTreeView treeView) {
		return treeView;
	}

	@Provides
	public AbsolutePanel getAbsolutePanel(AndroidAbsolutePanel absolutePanel) {
		return absolutePanel;
	}
}
