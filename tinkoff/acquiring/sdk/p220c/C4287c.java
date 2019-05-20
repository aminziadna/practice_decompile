package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: AddCardRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.c */
public final class C4287c extends C2754a {
    /* renamed from: c */
    private String f12888c;
    /* renamed from: d */
    private String f12889d;

    public C4287c() {
        super("AddCard");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("CustomerKey", this.f12888c, a);
        m11352a("CheckType", this.f12889d, a);
        return a;
    }

    /* renamed from: d */
    public String m18325d() {
        return this.f12888c;
    }

    /* renamed from: c */
    void m18324c(String str) {
        this.f12888c = str;
    }

    /* renamed from: e */
    public String m18327e() {
        return this.f12889d;
    }

    /* renamed from: d */
    void m18326d(String str) {
        this.f12889d = str;
    }
}
