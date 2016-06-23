package org.nibiru.ui.ios.ioc;

import org.nibiru.ui.core.api.Button;
import org.nibiru.ui.core.api.GridPanel;
import org.nibiru.ui.core.api.HorizontalPanel;
import org.nibiru.ui.core.api.Image;
import org.nibiru.ui.core.api.Label;
import org.nibiru.ui.core.api.ListWidget;
import org.nibiru.ui.core.api.PasswordBox;
import org.nibiru.ui.core.api.TextBox;
import org.nibiru.ui.core.api.VerticalPanel;
import org.nibiru.ui.ios.widget.IOSButton;
import org.nibiru.ui.ios.widget.IOSGridPanel;
import org.nibiru.ui.ios.widget.IOSHorizontalPanel;
import org.nibiru.ui.ios.widget.IOSImage;
import org.nibiru.ui.ios.widget.IOSLabel;
import org.nibiru.ui.ios.widget.IOSListWidget;
import org.nibiru.ui.ios.widget.IOSPasswordBox;
import org.nibiru.ui.ios.widget.IOSTextBox;
import org.nibiru.ui.ios.widget.IOSVerticalPanel;

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
