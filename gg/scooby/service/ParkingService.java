package ru.gg.scooby.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.evernote.android.job.C1177i;
import com.evernote.android.job.C1187m.C1184b;
import com.evernote.android.job.C1187m.C1186d;
import com.google.android.gms.location.C1475d;
import com.google.android.gms.location.C1477f;
import com.google.android.gms.location.C3456b;
import com.google.android.gms.location.LocationRequest;
import io.card.payment.BuildConfig;
import java.util.concurrent.TimeUnit;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ApplicationHelper;
import ru.gg.scooby.ApplicationHelper.ApplicationStartEvent;
import ru.gg.scooby.ApplicationHelper.ApplicationStopEvent;
import ru.gg.scooby.Bus;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.util.Log;
import ru.gg.scooby.util.NotificationUtils;

/* compiled from: ParkingService.kt */
public final class ParkingService extends Service {
    public static final String ARG_COMMAND_ID = "ARG_COMMAND_ID";
    private static final long BACKGROUND_LOCATION_UPDATES_INTERVAL_MAX = BACKGROUND_LOCATION_UPDATES_INTERVAL_MAX;
    private static final long BACKGROUND_LOCATION_UPDATES_INTERVAL_MIN = BACKGROUND_LOCATION_UPDATES_INTERVAL_MIN;
    public static final int COMMAND_REPORT_LOCATION = 1;
    public static final Companion Companion = new Companion();
    public C3456b fusedLocationClient;
    private final C1475d locationCallback = new ParkingService$locationCallback$1(this);
    private WakeLock locationWakeLock;
    private final LocationRequest request;

    /* compiled from: ParkingService.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void startService$default(Companion companion, Context context, Bundle bundle, int i, Object obj) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            companion.startService(context, bundle);
        }

        public final void startService(Context context, Bundle bundle) {
            C0700j.m2715b(context, "context");
            Intent intent = new Intent(context, ParkingService.class);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }

        public final void stopService(Context context) {
            C0700j.m2715b(context, "context");
            context.stopService(new Intent(context, ParkingService.class));
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public ParkingService() {
        Object a = LocationRequest.m19585a();
        C0700j.m2711a(a, "LocationRequest.create()");
        this.request = a;
        this.request.m19588a(102);
        this.request.m19589a(1000);
        this.request.m19592c(100);
    }

    public final C3456b getFusedLocationClient() {
        C3456b c3456b = this.fusedLocationClient;
        if (c3456b == null) {
            C0700j.m2716b("fusedLocationClient");
        }
        return c3456b;
    }

    public final void setFusedLocationClient(C3456b c3456b) {
        C0700j.m2715b(c3456b, "<set-?>");
        this.fusedLocationClient = c3456b;
    }

    public final LocationRequest getRequest() {
        return this.request;
    }

    public final WakeLock getLocationWakeLock() {
        return this.locationWakeLock;
    }

    public final void setLocationWakeLock(WakeLock wakeLock) {
        this.locationWakeLock = wakeLock;
    }

    public final C1475d getLocationCallback() {
        return this.locationCallback;
    }

    public void onCreate() {
        super.onCreate();
        Log.INSTANCE.dTrace(BuildConfig.FLAVOR);
        Context context = this;
        startForeground(1, NotificationUtils.INSTANCE.createOngoingNotification(context));
        Object a = C1477f.m5649a(context);
        C0700j.m2711a(a, "LocationServices.getFuse…ationProviderClient(this)");
        this.fusedLocationClient = a;
        Bus.INSTANCE.register(this);
    }

    public void onDestroy() {
        super.onDestroy();
        Bus.INSTANCE.unregister(this);
        removeLocationUpdates();
        releaseBackgroundLocationWakelock();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        i = Log.INSTANCE;
        i2 = new StringBuilder();
        i2.append("intent = ");
        i2.append(intent);
        i.dTrace(i2.toString());
        if (ApplicationHelper.INSTANCE.isAppInForeground() == null) {
            acquireBackgroundLocationWakelock();
        }
        requestLocationUpdates();
        return 1;
    }

    private final void scheduleLocationReportingTask() {
        int C = new C1184b(ParkingLocationJob.Companion.getTAG()).m4469a(BACKGROUND_LOCATION_UPDATES_INTERVAL_MIN, BACKGROUND_LOCATION_UPDATES_INTERVAL_MAX).m4470a(C1186d.ANY).m4471a().m4479C();
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jobId = ");
        stringBuilder.append(C);
        log.dTrace(stringBuilder.toString());
    }

    private final void cancelLocationReportingTask() {
        removeLocationUpdates();
        C1177i.m4406a().m4420b(ParkingLocationJob.Companion.getTAG());
    }

    public final void requestLocationUpdates() {
        Log.INSTANCE.dTrace(BuildConfig.FLAVOR);
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null && activeParking.getType() == 0) {
            C3456b c3456b = this.fusedLocationClient;
            if (c3456b == null) {
                C0700j.m2716b("fusedLocationClient");
            }
            c3456b.m15091a(this.request, this.locationCallback, null);
        }
    }

    public final void removeLocationUpdates() {
        Log.INSTANCE.dTrace(BuildConfig.FLAVOR);
        C3456b c3456b = this.fusedLocationClient;
        if (c3456b == null) {
            C0700j.m2716b("fusedLocationClient");
        }
        c3456b.m15092a(this.locationCallback);
    }

    private final void acquireBackgroundLocationWakelock() {
        Log.INSTANCE.dTrace(BuildConfig.FLAVOR);
        Object systemService = getSystemService("power");
        if (systemService != null) {
            PowerManager powerManager = (PowerManager) systemService;
            if (this.locationWakeLock == null) {
                this.locationWakeLock = powerManager.newWakeLock(1, "Location wakelock");
                WakeLock wakeLock = this.locationWakeLock;
                if (wakeLock != null) {
                    wakeLock.acquire(TimeUnit.SECONDS.toMillis(60));
                    return;
                }
                return;
            }
            return;
        }
        throw new C0724k("null cannot be cast to non-null type android.os.PowerManager");
    }

    private final void releaseBackgroundLocationWakelock() {
        WakeLock wakeLock = this.locationWakeLock;
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock = this.locationWakeLock;
            if (wakeLock != null) {
                wakeLock.release();
            }
        }
        this.locationWakeLock = (WakeLock) null;
    }

    public final void onEventMainThread(ApplicationStartEvent applicationStartEvent) {
        C0700j.m2715b(applicationStartEvent, "event");
        cancelLocationReportingTask();
        if (ParkingManager.INSTANCE.getActiveParking() != null) {
            requestLocationUpdates();
        }
    }

    public final void onEventMainThread(ApplicationStopEvent applicationStopEvent) {
        C0700j.m2715b(applicationStopEvent, "event");
        removeLocationUpdates();
        scheduleLocationReportingTask();
    }
}
