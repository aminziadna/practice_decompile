package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: GetAddCardStateRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.k */
public class C4295k extends C2754a {
    /* renamed from: c */
    private String f12908c;

    public C4295k() {
        super("GetAddCardState");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("RequestKey", this.f12908c, a);
        return a;
    }

    /* renamed from: d */
    public String m18382d() {
        return this.f12908c;
    }

    /* renamed from: c */
    void m18381c(String str) {
        this.f12908c = str;
    }
}
