package ru.gg.scooby;

import android.app.Application;
import android.content.Context;
import com.crashlytics.android.C3319a.C1054a;
import com.crashlytics.android.p097c.C3342l;
import com.crashlytics.android.p097c.C3342l.C1131a;
import com.evernote.android.job.C1171f;
import com.evernote.android.job.C1177i;
import com.google.firebase.C1637b;
import com.mapbox.mapboxsdk.C1890d;
import com.p056a.p057a.C0744a;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import io.p169a.p170a.p171a.C2453c;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.analytics.AmplitudeAnalytics;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.analytics.AppMetricaAnalytics;
import ru.gg.scooby.analytics.FirebaseAnalyticsManager;
import ru.gg.scooby.manager.BankCardsManager;
import ru.gg.scooby.manager.UpdateManager;
import ru.gg.scooby.service.DefaultJobCreator;

/* compiled from: Scooby.kt */
public final class Scooby extends Application {
    public static final Companion Companion = new Companion();
    public static final String TERMS_URL = "https://www.skoo.by/terms/";

    /* compiled from: Scooby.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public void onCreate() {
        super.onCreate();
        Context context = this;
        ContextProvider.INSTANCE.setContext(context);
        C1890d.m7203a(context, BuildConfig.MAPBOX_API_KEY);
        BankCardsManager.INSTANCE.init();
        initErrorReporter();
        initAnalytics();
        initSingletons();
        registerActivityLifecycleCallbacks(ApplicationHelper.INSTANCE);
        C1177i.m4407a(context).m4418a((C1171f) new DefaultJobCreator());
    }

    public final void initErrorReporter() {
        C3342l a = new C1131a().m4288a(false).m4289a();
        C2453c.m10196a((Context) this, new C1054a().m3970a(a).m3971a());
    }

    public final void initAnalytics() {
        Context context = this;
        Application application = this;
        C0744a.m2812a().m2846a(context, BuildConfig.AMPLITUDE_KEY).m2845a(application);
        Object build = YandexMetricaConfig.newConfigBuilder(BuildConfig.APP_METRICA_KEY).build();
        C0700j.m2711a(build, "YandexMetricaConfig.newC….APP_METRICA_KEY).build()");
        YandexMetrica.activate(getApplicationContext(), build);
        YandexMetrica.enableActivityAutoTracking(application);
        Analytics.INSTANCE.init();
        C1637b.m6051a(context);
        FirebaseAnalyticsManager.INSTANCE.init();
        AmplitudeAnalytics.INSTANCE.init();
        AppMetricaAnalytics.INSTANCE.init();
    }

    public final void initSingletons() {
        UpdateManager.INSTANCE.init();
    }
}
