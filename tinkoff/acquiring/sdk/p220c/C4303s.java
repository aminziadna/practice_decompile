package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: RemoveCardRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.s */
public final class C4303s extends C2754a {
    /* renamed from: c */
    private String f12928c;
    /* renamed from: d */
    private String f12929d;

    public C4303s() {
        super("RemoveCard");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("CardId", this.f12928c, a);
        m11352a("CustomerKey", this.f12929d, a);
        return a;
    }

    /* renamed from: d */
    public String m18432d() {
        return this.f12928c;
    }

    /* renamed from: c */
    void m18431c(String str) {
        this.f12928c = str;
    }

    /* renamed from: e */
    public String m18434e() {
        return this.f12929d;
    }

    /* renamed from: d */
    void m18433d(String str) {
        this.f12929d = str;
    }
}
