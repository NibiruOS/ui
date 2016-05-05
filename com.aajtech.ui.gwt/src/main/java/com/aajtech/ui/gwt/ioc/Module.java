package com.aajtech.ui.gwt.ioc;

import com.aajtech.ui.core.api.Button;
import com.aajtech.ui.core.api.Checkbox;
import com.aajtech.ui.core.api.GridPanel;
import com.aajtech.ui.core.api.HorizontalPanel;
import com.aajtech.ui.core.api.Image;
import com.aajtech.ui.core.api.Label;
import com.aajtech.ui.core.api.ListWidget;
import com.aajtech.ui.core.api.PasswordBox;
import com.aajtech.ui.core.api.Popup;
import com.aajtech.ui.core.api.Spinner;
import com.aajtech.ui.core.api.TextBox;
import com.aajtech.ui.core.api.TreeView;
import com.aajtech.ui.core.api.VerticalPanel;
import com.aajtech.ui.core.impl.builder.ComboBoxBuilderFactory;
import com.aajtech.ui.core.impl.builder.RadioButtonGroupBuilderFactory;
import com.aajtech.ui.gwt.builder.GwtComboBoxBuilderFactory;
import com.aajtech.ui.gwt.builder.GwtRadioButtonGroupBuilderFactory;
import com.aajtech.ui.gwt.widget.GwtButton;
import com.aajtech.ui.gwt.widget.GwtCheckbox;
import com.aajtech.ui.gwt.widget.GwtGridPanel;
import com.aajtech.ui.gwt.widget.GwtHorizontalPanel;
import com.aajtech.ui.gwt.widget.GwtImage;
import com.aajtech.ui.gwt.widget.GwtLabel;
import com.aajtech.ui.gwt.widget.GwtListWidget;
import com.aajtech.ui.gwt.widget.GwtPasswordBox;
import com.aajtech.ui.gwt.widget.GwtPopup;
import com.aajtech.ui.gwt.widget.GwtSpinner;
import com.aajtech.ui.gwt.widget.GwtTextBox;
import com.aajtech.ui.gwt.widget.GwtTreeView;
import com.aajtech.ui.gwt.widget.GwtVerticalPanel;
import com.google.gwt.inject.client.AbstractGinModule;

public class Module extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(Label.class).to(GwtLabel.class);
		bind(TextBox.class).to(GwtTextBox.class);
		bind(PasswordBox.class).to(GwtPasswordBox.class);
		bind(HorizontalPanel.class).to(GwtHorizontalPanel.class);
		bind(VerticalPanel.class).to(GwtVerticalPanel.class);
		bind(GridPanel.class).to(GwtGridPanel.class);
		bind(Button.class).to(GwtButton.class);
		bind(ListWidget.class).to(GwtListWidget.class);
		bind(Image.class).to(GwtImage.class);
		bind(Popup.class).to(GwtPopup.class);
		bind(Spinner.class).to(GwtSpinner.class);
		bind(RadioButtonGroupBuilderFactory.class).to(GwtRadioButtonGroupBuilderFactory.class);
		bind(Checkbox.class).to(GwtCheckbox.class);
		bind(ComboBoxBuilderFactory.class).to(GwtComboBoxBuilderFactory.class);
		bind(TreeView.class).to(GwtTreeView.class);
	}
}
