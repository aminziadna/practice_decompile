package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: ChargeRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.g */
public final class C4291g extends C2754a {
    /* renamed from: c */
    private Long f12896c;
    /* renamed from: d */
    private String f12897d;

    public C4291g() {
        super("Charge");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("PaymentId", this.f12896c.toString(), a);
        m11352a("RebillId", this.f12897d, a);
        return a;
    }

    /* renamed from: d */
    public Long m18351d() {
        return this.f12896c;
    }

    /* renamed from: a */
    void m18349a(Long l) {
        this.f12896c = l;
    }

    /* renamed from: e */
    public String m18352e() {
        return this.f12897d;
    }

    /* renamed from: c */
    void m18350c(String str) {
        this.f12897d = str;
    }
}
