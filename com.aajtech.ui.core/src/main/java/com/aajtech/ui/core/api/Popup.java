package com.aajtech.ui.core.api;

public interface Popup {
	void setContent(Widget content);

	void show();

	void hide();

	void setAutoHide(boolean autoHide);
}
