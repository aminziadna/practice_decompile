package ru.gg.scooby;

import android.content.Context;
import p042b.p047e.p049b.C0700j;

/* compiled from: ContextProvider.kt */
public final class ContextProvider {
    public static final ContextProvider INSTANCE = new ContextProvider();
    public static Context context;

    private ContextProvider() {
    }

    public final Context getContext() {
        Context context = context;
        if (context == null) {
            C0700j.m2716b("context");
        }
        return context;
    }

    public final void setContext(Context context) {
        C0700j.m2715b(context, "<set-?>");
        context = context;
    }
}
