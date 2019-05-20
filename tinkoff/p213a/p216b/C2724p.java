package ru.tinkoff.p213a.p216b;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: NfcUtils */
/* renamed from: ru.tinkoff.a.b.p */
public class C2724p {
    /* renamed from: a */
    public static void m11234a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(VERSION.SDK_INT >= 16 ? "android.settings.NFC_SETTINGS" : "android.settings.WIRELESS_SETTINGS"), i);
    }
}
