package com.aajtech.ui.gwt.ioc;

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
import com.aajtech.ui.gwt.builder.GwtComboBoxBuilderFactory;
import com.aajtech.ui.gwt.builder.GwtRadioButtonGroupBuilderFactory;
import com.aajtech.ui.gwt.resource.Resources;
import com.aajtech.ui.gwt.widget.GwtAbsolutePanel;
import com.aajtech.ui.gwt.widget.GwtButton;
import com.aajtech.ui.gwt.widget.GwtCheckbox;
import com.aajtech.ui.gwt.widget.GwtGridPanel;
import com.aajtech.ui.gwt.widget.GwtHorizontalPanel;
import com.aajtech.ui.gwt.widget.GwtImage;
import com.aajtech.ui.gwt.widget.GwtLabel;
import com.aajtech.ui.gwt.widget.GwtListWidget;
import com.aajtech.ui.gwt.widget.GwtPasswordBox;
import com.aajtech.ui.gwt.widget.GwtPopup;
import com.aajtech.ui.gwt.widget.GwtScrollPanel;
import com.aajtech.ui.gwt.widget.GwtSpinner;
import com.aajtech.ui.gwt.widget.GwtTextBox;
import com.aajtech.ui.gwt.widget.GwtTreeView;
import com.aajtech.ui.gwt.widget.GwtVerticalPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;

import dagger.Module;
import dagger.Provides;

@Module
public class GwtModule {
	@Provides
	public Button getButton(GwtButton button) {
		return button;
	}

	@Provides
	public Label getLabel(GwtLabel label) {
		return label;
	}

	@Provides
	public TextBox getTextBox(GwtTextBox textBox) {
		return textBox;
	}

	@Provides
	public PasswordBox getPasswordBox(GwtPasswordBox passwordBox) {
		return passwordBox;
	}

	@Provides
	public HorizontalPanel getHorizontalPanel(GwtHorizontalPanel horizontalPanel) {
		return horizontalPanel;
	}

	@Provides
	public VerticalPanel getVerticalPanel(GwtVerticalPanel verticalPanel) {
		return verticalPanel;
	}

	@Provides
	public GridPanel getGridPanel(GwtGridPanel gridPanel) {
		return gridPanel;
	}

	@Provides
	public ScrollPanel getScrollPanel(GwtScrollPanel scrollPanel) {
		return scrollPanel;
	}

	@Provides
	public ListWidget getListWidget(GwtListWidget listWidget) {
		return listWidget;
	}

	@Provides
	public Image getImage(GwtImage image) {
		return image;
	}

	@Provides
	public Popup getPopup(GwtPopup popup) {
		return popup;
	}

	@Provides
	public Spinner getSpinner(GwtSpinner spinner) {
		return spinner;
	}

	@Provides
	public Checkbox getCheckbox(GwtCheckbox checkbox) {
		return checkbox;
	}

	@Provides
	public RadioButtonGroupBuilderFactory getRadioButtonGroupBuilderFactory(GwtRadioButtonGroupBuilderFactory factory) {
		return factory;
	}

	@Provides
	public ComboBoxBuilderFactory getComboBoxBuilderFactory(GwtComboBoxBuilderFactory factory) {
		return factory;
	}

	@Provides
	public TreeView getTreeView(GwtTreeView treeView) {
		return treeView;
	}

	@Provides
	public AbsolutePanel getAbsolutePanel(GwtAbsolutePanel absolutePanel) {
		return absolutePanel;
	}

	@Provides
	public Scheduler getScheduler() {
		return Scheduler.get();
	}

	@Provides
	public Resources getResources() {
		return GWT.create(Resources.class);
	}
}
