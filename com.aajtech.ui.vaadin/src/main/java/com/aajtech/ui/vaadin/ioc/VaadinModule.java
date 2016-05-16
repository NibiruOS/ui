package com.aajtech.ui.vaadin.ioc;

import com.aajtech.ui.core.api.AbsolutePanel;
import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.vaadin.widget.VaadinAbsolutePanel;
import com.aajtech.ui.vaadin.widget.VaadinButton;
import com.aajtech.ui.vaadin.widget.VaadinGridPanel;
import com.aajtech.ui.vaadin.widget.VaadinHorizontalPanel;
import com.aajtech.ui.vaadin.widget.VaadinImage;
import com.aajtech.ui.vaadin.widget.VaadinLabel;
import com.aajtech.ui.vaadin.widget.VaadinListWidget;
import com.aajtech.ui.vaadin.widget.VaadinPasswordBox;
import com.aajtech.ui.vaadin.widget.VaadinTextBox;
import com.aajtech.ui.vaadin.widget.VaadinVerticalPanel;

import dagger.Module;
import dagger.Provides;

@Module
public class VaadinModule {
	@Provides
	public Button getButton(VaadinButton button) {
		return button;
	}

	@Provides
	public Label getLabel(VaadinLabel label) {
		return label;
	}

	@Provides
	public TextBox getTextBox(VaadinTextBox textBox) {
		return textBox;
	}

	@Provides
	public PasswordBox getPasswordBox(VaadinPasswordBox passwordBox) {
		return passwordBox;
	}

	@Provides
	public HorizontalPanel getHorizontalPanel(VaadinHorizontalPanel horizontalPanel) {
		return horizontalPanel;
	}

	@Provides
	public VerticalPanel getVerticalPanel(VaadinVerticalPanel verticalPanel) {
		return verticalPanel;
	}

	@Provides
	public GridPanel getGridPanel(VaadinGridPanel gridPanel) {
		return gridPanel;
	}

//	@Provides
//	public ScrollPanel getScrollPanel(VaadinScrollPanel scrollPanel) {
//		return scrollPanel;
//	}

	@Provides
	public ListWidget getListWidget(VaadinListWidget listWidget) {
		return listWidget;
	}

	@Provides
	public Image getImage(VaadinImage image) {
		return image;
	}

//	@Provides
//	public Popup getPopup(VaadinPopup popup) {
//		return popup;
//	}
//
//	@Provides
//	public Spinner getSpinner(VaadinSpinner spinner) {
//		return spinner;
//	}
//
//	@Provides
//	public Checkbox getCheckbox(VaadinCheckbox checkbox) {
//		return checkbox;
//	}
//
//	@Provides
//	public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(VaadinRadioButtonGroupBuilderFactory factory) {
//		return factory;
//	}
//
//	@Provides
//	public ComboBoxBuilderFactory getComboBoxBuilderFactory(VaadinComboBoxBuilderFactory factory) {
//		return factory;
//	}
//
//	@Provides
//	public TreeView getTreeView(VaadinTreeView treeView) {
//		return treeView;
//	}

	@Provides
	public AbsolutePanel getAbsolutePanel(VaadinAbsolutePanel absolutePanel) {
		return absolutePanel;
	}
}
