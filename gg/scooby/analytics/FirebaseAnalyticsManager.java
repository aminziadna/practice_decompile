package ru.gg.scooby.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.Bus;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.analytics.Analytics.AnalyticsEvent;
import ru.gg.scooby.util.MapExKt;

/* compiled from: FirebaseAnalyticsManager.kt */
public final class FirebaseAnalyticsManager {
    public static final FirebaseAnalyticsManager INSTANCE = new FirebaseAnalyticsManager();
    public static FirebaseAnalytics firebaseAnalytics;

    private FirebaseAnalyticsManager() {
    }

    public final FirebaseAnalytics getFirebaseAnalytics() {
        FirebaseAnalytics firebaseAnalytics = firebaseAnalytics;
        if (firebaseAnalytics == null) {
            C0700j.m2716b("firebaseAnalytics");
        }
        return firebaseAnalytics;
    }

    public final void setFirebaseAnalytics(FirebaseAnalytics firebaseAnalytics) {
        C0700j.m2715b(firebaseAnalytics, "<set-?>");
        firebaseAnalytics = firebaseAnalytics;
    }

    public final void init() {
        Bus.INSTANCE.register(this);
        Object instance = FirebaseAnalytics.getInstance(ContextProvider.INSTANCE.getContext());
        C0700j.m2711a(instance, "FirebaseAnalytics.getIns…(ContextProvider.context)");
        firebaseAnalytics = instance;
    }

    public final void onEventMainThread(AnalyticsEvent analyticsEvent) {
        C0700j.m2715b(analyticsEvent, "event");
        FirebaseAnalytics firebaseAnalytics = firebaseAnalytics;
        if (firebaseAnalytics == null) {
            C0700j.m2716b("firebaseAnalytics");
        }
        String name = analyticsEvent.getName();
        analyticsEvent = analyticsEvent.getProps();
        Bundle bundle = null;
        if (analyticsEvent != null) {
            bundle = MapExKt.toBundle$default(analyticsEvent, null, 1, null);
        }
        firebaseAnalytics.logEvent(name, bundle);
    }
}
