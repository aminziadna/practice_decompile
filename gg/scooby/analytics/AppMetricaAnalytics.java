package ru.gg.scooby.analytics;

import com.yandex.metrica.YandexMetrica;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.Bus;
import ru.gg.scooby.analytics.Analytics.AnalyticsEvent;

/* compiled from: AppMetricaAnalytics.kt */
public final class AppMetricaAnalytics {
    public static final AppMetricaAnalytics INSTANCE = new AppMetricaAnalytics();

    private AppMetricaAnalytics() {
    }

    public final void init() {
        Bus.INSTANCE.register(this);
    }

    public final void onEventMainThread(AnalyticsEvent analyticsEvent) {
        C0700j.m2715b(analyticsEvent, "event");
        YandexMetrica.reportEvent(analyticsEvent.getName(), analyticsEvent.getProps());
    }
}
