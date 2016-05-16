package com.aajtech.ui.android.ioc;

import com.aajtech.ui.android.builder.AndroidComboBoxBuilderFactory;
import com.aajtech.ui.android.builder.AndroidRadioButtonGroupBuilderFactory;
import com.aajtech.ui.android.widget.AndroidAbsolutePanel;
import com.aajtech.ui.android.widget.AndroidButton;
import com.aajtech.ui.android.widget.AndroidCheckbox;
import com.aajtech.ui.android.widget.AndroidGridPanel;
import com.aajtech.ui.android.widget.AndroidHorizontalPanel;
import com.aajtech.ui.android.widget.AndroidImage;
import com.aajtech.ui.android.widget.AndroidLabel;
import com.aajtech.ui.android.widget.AndroidListWidget;
import com.aajtech.ui.android.widget.AndroidPasswordBox;
import com.aajtech.ui.android.widget.AndroidPopup;
import com.aajtech.ui.android.widget.AndroidScrollPanel;
import com.aajtech.ui.android.widget.AndroidSpinner;
import com.aajtech.ui.android.widget.AndroidTextBox;
import com.aajtech.ui.android.widget.AndroidTreeView;
import com.aajtech.ui.android.widget.AndroidVerticalPanel;
import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.Checkbox;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.ScrollPanel;
import com.aajtech.ui.core.api.Spinner;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.TreeView;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.core.impl.builder.ComboBoxBuilderFactory;
import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
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
	public HorizontalPanel getHorizontalPanel(AndroidHorizontalPanel horizontalPanel) {
		return horizontalPanel;
	}

	@Provides
	public VerticalPanel getVerticalPanel(AndroidVerticalPanel verticalPanel) {
		return verticalPanel;
	}

	@Provides
	public GridPanel getGridPanel(AndroidGridPanel gridPanel) {
		return gridPanel;
	}

	@Provides
	public ScrollPanel getScrollPanel(AndroidScrollPanel scrollPanel) {
		return scrollPanel;
	}

	@Provides
	public ListWidget getListWidget(AndroidListWidget listWidget) {
		return listWidget;
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
