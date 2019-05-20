package ru.gg.scooby.manager;

import io.card.payment.BuildConfig;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.util.Log;

/* compiled from: UpdateManager.kt */
public final class UpdateManager {
    public static final UpdateManager INSTANCE = new UpdateManager();

    private UpdateManager() {
    }

    public final void init() {
        setFirstLaunchDate();
    }

    private final void setFirstLaunchDate() {
        if (Settings.INSTANCE.getFirstLaunchDate() == 0) {
            Log.INSTANCE.dTrace(BuildConfig.FLAVOR);
            Settings.INSTANCE.setFirstLaunchDate(System.currentTimeMillis());
            Analytics.INSTANCE.firstLaunch();
        }
    }
}
