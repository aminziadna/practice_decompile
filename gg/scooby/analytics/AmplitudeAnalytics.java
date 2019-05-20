package ru.gg.scooby.analytics;

import com.p056a.p057a.C0744a;
import com.p056a.p057a.C0755c;
import com.p056a.p057a.C0763i;
import org.json.JSONObject;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.Bus;
import ru.gg.scooby.analytics.Analytics.AnalyticsEvent;
import ru.gg.scooby.analytics.Analytics.AnalyticsRevenueEvent;
import ru.gg.scooby.util.MapExKt;

/* compiled from: AmplitudeAnalytics.kt */
public final class AmplitudeAnalytics {
    public static final AmplitudeAnalytics INSTANCE = new AmplitudeAnalytics();

    private AmplitudeAnalytics() {
    }

    public final void init() {
        Bus.INSTANCE.register(this);
    }

    public final void onEventMainThread(AnalyticsEvent analyticsEvent) {
        C0700j.m2715b(analyticsEvent, "event");
        C0755c a = C0744a.m2812a();
        String name = analyticsEvent.getName();
        analyticsEvent = analyticsEvent.getProps();
        JSONObject jSONObject = null;
        if (analyticsEvent != null) {
            jSONObject = MapExKt.toJsonObject$default(analyticsEvent, null, 1, null);
        }
        a.m2856a(name, jSONObject);
    }

    public final void onEventMainThread(AnalyticsRevenueEvent analyticsRevenueEvent) {
        C0700j.m2715b(analyticsRevenueEvent, "event");
        C0744a.m2812a().m2854a(new C0763i().m2965a(analyticsRevenueEvent.getPrice()).m2966a(1));
    }
}
