package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: GetCardListRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.m */
public final class C4297m extends C2754a {
    /* renamed from: c */
    private String f12910c;

    public C4297m() {
        super("GetCardList");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("CustomerKey", this.f12910c, a);
        return a;
    }

    /* renamed from: d */
    public String m18389d() {
        return this.f12910c;
    }

    /* renamed from: c */
    void m18388c(String str) {
        this.f12910c = str;
    }
}
