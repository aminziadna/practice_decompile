package ru.gg.scooby;

import p000a.p001a.p002a.C0005c;
import p042b.p047e.p049b.C0700j;

/* compiled from: Bus.kt */
public final class Bus {
    public static final Bus INSTANCE = new Bus();
    private static final int PRIORITY_HIGH = 1;
    private static final int PRIORITY_NORMAL = 0;
    private static final C0005c instance;

    static {
        Object a = C0005c.m3a().m27c(false).m26b(true).m24a(true).m23a();
        C0700j.m2711a(a, "EventBus\n               ….installDefaultEventBus()");
        instance = a;
        C0005c.f13a = "EventBus";
    }

    private Bus() {
    }

    public final int getPRIORITY_NORMAL() {
        return PRIORITY_NORMAL;
    }

    public final int getPRIORITY_HIGH() {
        return PRIORITY_HIGH;
    }

    public final void register(Object obj) {
        C0700j.m2715b(obj, "subscriber");
        instance.m17a(obj, PRIORITY_NORMAL);
    }

    public final void register(Object obj, int i) {
        C0700j.m2715b(obj, "subscriber");
        instance.m17a(obj, i);
    }

    public final void registerSticky(Object obj) {
        C0700j.m2715b(obj, "subscriber");
        instance.m16a(obj);
    }

    public final void unregister(Object obj) {
        C0700j.m2715b(obj, "subscriber");
        instance.m19b(obj);
    }

    public final void send(Object obj) {
        C0700j.m2715b(obj, "event");
        instance.m20c(obj);
    }

    public final void sendSticky(Object obj) {
        C0700j.m2715b(obj, "event");
        instance.m22e(obj);
    }

    public final void cancel(Object obj) {
        C0700j.m2715b(obj, "event");
        instance.m21d(obj);
    }
}
