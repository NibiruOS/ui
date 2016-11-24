package org.nibiru.ui.gwt.loop;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.RootPanel;

import org.nibiru.ui.core.api.loop.Looper;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class SchedulerLooper implements Looper {
	private final Scheduler scheduler;

	@Inject
	public SchedulerLooper(Scheduler scheduler) {
		this.scheduler = checkNotNull(scheduler);
	}

    @Override
    public void post(final Runnable runnable) {
        checkNotNull(runnable);
        RootPanel.get().setVisible(false);
        scheduler.scheduleDeferred(() -> {
            runnable.run();
            RootPanel.get().setVisible(true);
        });
    }
}
