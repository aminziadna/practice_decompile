package ru.gg.scooby.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.core.app.C0294h.C0292c;
import io.card.payment.BuildConfig;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.ui.activity.MainActivity;
import ru.skooby.R;

/* compiled from: NotificationUtils.kt */
public final class NotificationUtils {
    public static final NotificationUtils INSTANCE = new NotificationUtils();
    public static final int ONGOING_NOTIFICATION_ID = 1;
    public static final int ORDER_UPDATE_NOTIFICATION_ID = 2;

    private NotificationUtils() {
    }

    public final Notification createOngoingNotification(Context context) {
        C0700j.m2715b(context, "context");
        Object b = new C0292c(context, getNotificationChannelId(context)).m1157a((int) R.drawable.ic_push_small).m1162a((CharSequence) context.getString(R.string.notification_app_name)).m1168b((CharSequence) context.getString(R.string.order_in_progress)).m1164a(true).m1159a(PendingIntent.getActivity(context, 1, new Intent(context, MainActivity.class), 134217728)).m1165b();
        C0700j.m2711a(b, "NotificationCompat.Build…\n                .build()");
        return b;
    }

    public final void sendOrderUpdateNotification(String str, String str2) {
        C0700j.m2715b(str, "title");
        C0700j.m2715b(str2, "message");
        Context context = ContextProvider.INSTANCE.getContext();
        str = new C0292c(context, getNotificationChannelId(context)).m1157a((int) R.drawable.ic_push_small).m1162a((CharSequence) str).m1168b((CharSequence) str2).m1166b(-1).m1159a(PendingIntent.getActivity(context, 2, new Intent(context, MainActivity.class), 134217728)).m1165b();
        str2 = context.getSystemService("notification");
        if (str2 != null) {
            ((NotificationManager) str2).notify(2, str);
            return;
        }
        throw new C0724k("null cannot be cast to non-null type android.app.NotificationManager");
    }

    private final String getNotificationChannelId(Context context) {
        if (VERSION.SDK_INT < 26) {
            return BuildConfig.FLAVOR;
        }
        String str = "default";
        String str2 = BuildConfig.FLAVOR;
        NotificationChannel notificationChannel = new NotificationChannel(str, "Skooby", 3);
        notificationChannel.setDescription(str2);
        context = context.getSystemService("notification");
        if (context != null) {
            ((NotificationManager) context).createNotificationChannel(notificationChannel);
            return str;
        }
        throw new C0724k("null cannot be cast to non-null type android.app.NotificationManager");
    }
}
