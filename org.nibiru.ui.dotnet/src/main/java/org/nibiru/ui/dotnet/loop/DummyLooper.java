package org.nibiru.ui.dotnet.loop;

import org.nibiru.ui.core.api.loop.Looper;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class DummyLooper implements Looper {
    @Inject
    public DummyLooper() {
    }

    @Override
    public void post(Runnable runnable) {
        checkNotNull(runnable);
        runnable.run();
    }
}
