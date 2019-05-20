package ru.gg.scooby.util;

import com.google.gson.C1728f;
import com.google.gson.C1729g;
import p042b.p047e.p049b.C0700j;

/* compiled from: GsonMapper.kt */
public final class GsonMapper {
    public static final GsonMapper INSTANCE = new GsonMapper();
    /* renamed from: default */
    private static final C1728f f8322default;

    static {
        Object b = new C1729g().m6462b();
        C0700j.m2711a(b, "builder.create()");
        f8322default = b;
    }

    private GsonMapper() {
    }

    public final C1728f getDefault() {
        return f8322default;
    }
}
