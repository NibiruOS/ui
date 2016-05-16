package com.aajtech.ui.ios.ioc;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.ios.widget.IOSButton;
import com.aajtech.ui.ios.widget.IOSGridPanel;
import com.aajtech.ui.ios.widget.IOSHorizontalPanel;
import com.aajtech.ui.ios.widget.IOSImage;
import com.aajtech.ui.ios.widget.IOSLabel;
import com.aajtech.ui.ios.widget.IOSListWidget;
import com.aajtech.ui.ios.widget.IOSPasswordBox;
import com.aajtech.ui.ios.widget.IOSTextBox;
import com.aajtech.ui.ios.widget.IOSVerticalPanel;

import dagger.Module;
import dagger.Provides;

@Module
public class IOSModule {
	@Provides
	public Button getButton(IOSButton button) {
		return button;
	}

	@Provides
	public Label getLabel(IOSLabel label) {
		return label;
	}

	@Provides
	public TextBox getTextBox(IOSTextBox textBox) {
		return textBox;
	}

	@Provides
	public PasswordBox getPasswordBox(IOSPasswordBox passwordBox) {
		return passwordBox;
	}

	@Provides
	public HorizontalPanel getHorizontalPanel(IOSHorizontalPanel horizontalPanel) {
		return horizontalPanel;
	}

	@Provides
	public VerticalPanel getVerticalPanel(IOSVerticalPanel verticalPanel) {
		return verticalPanel;
	}

	@Provides
	public GridPanel getGridPanel(IOSGridPanel gridPanel) {
		return gridPanel;
	}

//	@Provides
//	public ScrollPanel getScrollPanel(IOSScrollPanel scrollPanel) {
//		return scrollPanel;
//	}

	@Provides
	public ListWidget getListWidget(IOSListWidget listWidget) {
		return listWidget;
	}

	@Provides
	public Image getImage(IOSImage image) {
		return image;
	}

//	@Provides
//	public Popup getPopup(IOSPopup popup) {
//		return popup;
//	}
//
//	@Provides
//	public Spinner getSpinner(IOSSpinner spinner) {
//		return spinner;
//	}
//
//	@Provides
//	public Checkbox getCheckbox(IOSCheckbox checkbox) {
//		return checkbox;
//	}
//
//	@Provides
//	public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(IOSRadioButtonGroupBuilderFactory factory) {
//		return factory;
//	}
//
//	@Provides
//	public ComboBoxBuilderFactory getComboBoxBuilderFactory(IOSComboBoxBuilderFactory factory) {
//		return factory;
//	}
//
//	@Provides
//	public TreeView getTreeView(IOSTreeView treeView) {
//		return treeView;
//	}
//
//	@Provides
//	public AbsolutePanel getAbsolutePanel(IOSAbsolutePanel absolutePanel) {
//		return absolutePanel;
//	}
}
