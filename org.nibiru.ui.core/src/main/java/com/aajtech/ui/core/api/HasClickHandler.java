package com.aajtech.ui.core.api;

import com.aajtech.model.core.api.Registration;

/**
 * Something that can be clicked.
 */
public interface HasClickHandler {
	/**
	 * Sets the click handler.
	 * 
	 * @param clickHandler
	 *            The click handler
	 * @return A handler registration
	 */
	Registration setClickHandler(ClickHandler clickHandler);
}
