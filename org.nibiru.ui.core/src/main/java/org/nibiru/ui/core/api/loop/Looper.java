package org.nibiru.ui.core.api.loop;

/**
 * UI looper. Used to post callbacks to UI loop.
 */
public interface Looper {
	void post(Runnable runnable);
}
