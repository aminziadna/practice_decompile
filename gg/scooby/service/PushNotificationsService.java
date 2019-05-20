package ru.gg.scooby.service;

import com.google.firebase.messaging.C4500d;
import com.google.firebase.messaging.FirebaseMessagingService;
import java.util.Map;
import java.util.Map.Entry;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ApplicationHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.util.Log;
import ru.gg.scooby.util.NotificationUtils;
import ru.skooby.R;

/* compiled from: PushNotificationsService.kt */
public final class PushNotificationsService extends FirebaseMessagingService {
    public static final Companion Companion = new Companion();
    public static final String TYPE_ADV_STATUS_CHANGE = "adv_status_change";

    /* compiled from: PushNotificationsService.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public void onMessageReceived(C4500d c4500d) {
        Map a;
        super.onMessageReceived(c4500d);
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("message type ");
        stringBuilder.append(c4500d != null ? c4500d.m19848b() : null);
        log.dTrace(stringBuilder.toString());
        log = Log.INSTANCE;
        stringBuilder = new StringBuilder();
        stringBuilder.append("message priority = ");
        stringBuilder.append(c4500d != null ? Integer.valueOf(c4500d.m19850d()) : null);
        stringBuilder.append(" original = ");
        stringBuilder.append(c4500d != null ? Integer.valueOf(c4500d.m19849c()) : null);
        log.dTrace(stringBuilder.toString());
        if (c4500d != null) {
            a = c4500d.m19847a();
            if (a != null) {
                for (Entry entry : a.entrySet()) {
                    Log log2 = Log.INSTANCE;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append((String) entry.getKey());
                    stringBuilder2.append(" = ");
                    stringBuilder2.append((String) entry.getValue());
                    log2.dTrace(stringBuilder2.toString());
                }
            }
        }
        if (ApplicationHelper.INSTANCE.isAppInForeground()) {
            Object obj;
            Object e;
            NotificationUtils notificationUtils;
            String a2;
            if (c4500d != null) {
                a = c4500d.m19847a();
                if (a != null) {
                    obj = (String) a.get("action");
                    if (C0700j.m2713a(obj, TYPE_ADV_STATUS_CHANGE)) {
                        ParkingManager.refreshParkingStatus$default(ParkingManager.INSTANCE, false, null, 3, null);
                    }
                    if (c4500d != null) {
                        e = c4500d.m19851e();
                        if (e != null) {
                            log = Log.INSTANCE;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("notification title = ");
                            C0700j.m2711a(e, "it");
                            stringBuilder.append(e.m6263a());
                            log.dTrace(stringBuilder.toString());
                            log = Log.INSTANCE;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("notification body = ");
                            stringBuilder.append(e.m6264b());
                            log.dTrace(stringBuilder.toString());
                            notificationUtils = NotificationUtils.INSTANCE;
                            a2 = e.m6263a();
                            if (a2 != null) {
                                a2 = getResources().getString(R.string.notification_app_name);
                                C0700j.m2711a((Object) a2, "resources.getString(R.st…ng.notification_app_name)");
                            }
                            c4500d = e.m6264b();
                            if (c4500d != null) {
                                c4500d = getResources().getString(R.string.order_status_change);
                                C0700j.m2711a((Object) c4500d, "resources.getString(R.string.order_status_change)");
                            }
                            notificationUtils.sendOrderUpdateNotification(a2, c4500d);
                        }
                    }
                }
            }
            obj = null;
            if (C0700j.m2713a(obj, TYPE_ADV_STATUS_CHANGE)) {
                ParkingManager.refreshParkingStatus$default(ParkingManager.INSTANCE, false, null, 3, null);
            }
            if (c4500d != null) {
                e = c4500d.m19851e();
                if (e != null) {
                    log = Log.INSTANCE;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("notification title = ");
                    C0700j.m2711a(e, "it");
                    stringBuilder.append(e.m6263a());
                    log.dTrace(stringBuilder.toString());
                    log = Log.INSTANCE;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("notification body = ");
                    stringBuilder.append(e.m6264b());
                    log.dTrace(stringBuilder.toString());
                    notificationUtils = NotificationUtils.INSTANCE;
                    a2 = e.m6263a();
                    if (a2 != null) {
                        a2 = getResources().getString(R.string.notification_app_name);
                        C0700j.m2711a((Object) a2, "resources.getString(R.st…ng.notification_app_name)");
                    }
                    c4500d = e.m6264b();
                    if (c4500d != null) {
                        c4500d = getResources().getString(R.string.order_status_change);
                        C0700j.m2711a((Object) c4500d, "resources.getString(R.string.order_status_change)");
                    }
                    notificationUtils.sendOrderUpdateNotification(a2, c4500d);
                }
            }
        }
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("token = ");
        stringBuilder.append(str);
        log.dTrace(stringBuilder.toString());
        if (str != null) {
            UserManager.INSTANCE.updateDeviceIdToken(str);
        }
    }
}
