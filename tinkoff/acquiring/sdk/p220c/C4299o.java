package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: GetStateRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.o */
public final class C4299o extends C2754a {
    /* renamed from: c */
    private Long f12912c;

    public C4299o() {
        super("GetState");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("PaymentId", this.f12912c.toString(), a);
        return a;
    }

    /* renamed from: d */
    public Long m18396d() {
        return this.f12912c;
    }

    /* renamed from: a */
    void m18395a(Long l) {
        this.f12912c = l;
    }
}
