package ru.gg.scooby;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.util.Log;

/* compiled from: ApplicationHelper.kt */
public final class ApplicationHelper implements ActivityLifecycleCallbacks {
    public static final ApplicationHelper INSTANCE = new ApplicationHelper();
    private static int activitiesCount;
    private static boolean isAppInForeground;

    /* compiled from: ApplicationHelper.kt */
    public static final class ApplicationStartEvent {
        public static final ApplicationStartEvent INSTANCE = new ApplicationStartEvent();

        private ApplicationStartEvent() {
        }
    }

    /* compiled from: ApplicationHelper.kt */
    public static final class ApplicationStopEvent {
        public static final ApplicationStopEvent INSTANCE = new ApplicationStopEvent();

        private ApplicationStopEvent() {
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C0700j.m2715b(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        C0700j.m2715b(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        C0700j.m2715b(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        C0700j.m2715b(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C0700j.m2715b(activity, "activity");
    }

    private ApplicationHelper() {
    }

    private final void setAppInForeground(boolean z) {
        isAppInForeground = z;
    }

    public final boolean isAppInForeground() {
        return isAppInForeground;
    }

    public final int getActivitiesCount() {
        return activitiesCount;
    }

    public final void setActivitiesCount(int i) {
        activitiesCount = i;
    }

    public final void onApplicationBecomeForeground() {
        Log.INSTANCE.m11183d("onApplicationBecomeForeground");
        Bus.INSTANCE.send(ApplicationStartEvent.INSTANCE);
    }

    public final void onApplicationBecomeBackground() {
        Log.INSTANCE.m11183d("onApplicationBecomeBackground");
        Bus.INSTANCE.send(ApplicationStopEvent.INSTANCE);
    }

    public void onActivityStarted(Activity activity) {
        C0700j.m2715b(activity, "activity");
        activitiesCount += 1;
        if (activitiesCount == 1) {
            isAppInForeground = true;
            onApplicationBecomeForeground();
        }
    }

    public void onActivityStopped(Activity activity) {
        C0700j.m2715b(activity, "activity");
        activitiesCount--;
        if (activitiesCount == null) {
            isAppInForeground = null;
            onApplicationBecomeBackground();
        }
    }
}
