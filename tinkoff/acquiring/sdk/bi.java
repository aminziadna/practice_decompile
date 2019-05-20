package ru.tinkoff.acquiring.sdk;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.Closeable;

/* compiled from: Utils */
class bi {
    /* renamed from: a */
    public static void m11347a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                ai.m11291a(e);
            }
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    public static void m11348a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Throwable e) {
                ai.m11291a(e);
            }
        }
    }

    /* renamed from: a */
    public static void m11349a(Object... objArr) {
        for (Object obj : objArr) {
            if (obj instanceof Closeable) {
                m11347a((Closeable) obj);
            } else if (VERSION.SDK_INT < 19 || !(obj instanceof AutoCloseable)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("close not supported for ");
                stringBuilder.append(obj == null ? "null" : obj.getClass().getCanonicalName());
                ai.m11291a(new UnsupportedOperationException(new IllegalArgumentException(stringBuilder.toString())));
            } else {
                m11348a((AutoCloseable) obj);
            }
        }
    }
}
