package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: SubmitRandomAmountRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.u */
public final class C4305u extends C2754a {
    /* renamed from: c */
    private String f12931c;
    /* renamed from: d */
    private Long f12932d;

    public C4305u() {
        super("SubmitRandomAmount");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("RequestKey", this.f12931c, a);
        m11352a("Amount", this.f12932d, a);
        return a;
    }

    /* renamed from: d */
    public String m18443d() {
        return this.f12931c;
    }

    /* renamed from: c */
    void m18442c(String str) {
        this.f12931c = str;
    }

    /* renamed from: e */
    public Long m18444e() {
        return this.f12932d;
    }

    /* renamed from: a */
    void m18441a(Long l) {
        this.f12932d = l;
    }
}
