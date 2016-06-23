package org.nibiru.ui.vaadin.ioc;

import org.nibiru.ui.core.api.AbsolutePanel;
import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.PasswordBox;
import org.nibiru.ui.core.api.TextBox;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.vaadin.widget.VaadinAbsolutePanel;
import org.nibiru.ui.vaadin.widget.VaadinButton;
import org.nibiru.ui.vaadin.widget.VaadinGridPanel;
import org.nibiru.ui.vaadin.widget.VaadinHorizontalPanel;
import org.nibiru.ui.vaadin.widget.VaadinImage;
import org.nibiru.ui.vaadin.widget.VaadinLabel;
import org.nibiru.ui.vaadin.widget.VaadinListWidget;
import org.nibiru.ui.vaadin.widget.VaadinPasswordBox;
import org.nibiru.ui.vaadin.widget.VaadinTextBox;
import org.nibiru.ui.vaadin.widget.VaadinVerticalPanel;

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
