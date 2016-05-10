package com.aajtech.ui.core.api;

public interface Popup extends HasContent {
	void show();

	void hide();

	void setAutoHide(boolean autoHide);
}
