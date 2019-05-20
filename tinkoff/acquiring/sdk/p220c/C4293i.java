package ru.tinkoff.acquiring.sdk.p220c;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: FinishAuthorizeRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.i */
public final class C4293i extends C2754a {
    /* renamed from: c */
    private Long f12899c;
    /* renamed from: d */
    private String f12900d;
    /* renamed from: e */
    private String f12901e;
    /* renamed from: f */
    private String f12902f;
    /* renamed from: g */
    private String f12903g;
    /* renamed from: h */
    private String f12904h;
    /* renamed from: i */
    private String f12905i;
    /* renamed from: j */
    private String f12906j;

    public C4293i() {
        super("FinishAuthorize");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("PaymentId", this.f12899c.toString(), a);
        m11352a("SendEmail", this.f12900d, a);
        m11352a("CardData", this.f12901e, a);
        m11352a("CardId", this.f12903g, a);
        m11352a("CVV", this.f12904h, a);
        m11352a("InfoEmail", this.f12902f, a);
        m11352a("Source", this.f12906j, a);
        m11352a("EncryptedPaymentData", this.f12905i, a);
        return a;
    }

    /* renamed from: b */
    public Set<String> mo1953b() {
        Set<String> hashSet = new HashSet();
        hashSet.add("CardId");
        hashSet.add("CVV");
        return hashSet;
    }

    /* renamed from: d */
    public String m18363d() {
        return this.f12904h;
    }

    /* renamed from: e */
    public String m18365e() {
        return this.f12903g;
    }

    /* renamed from: f */
    public Long m18367f() {
        return this.f12899c;
    }

    /* renamed from: a */
    void m18359a(Long l) {
        this.f12899c = l;
    }

    /* renamed from: a */
    void m18360a(boolean z) {
        this.f12900d = z ? "true" : "false";
    }

    /* renamed from: g */
    public String m18369g() {
        return this.f12901e;
    }

    /* renamed from: c */
    void m18362c(String str) {
        this.f12901e = str;
    }

    /* renamed from: d */
    public void m18364d(String str) {
        this.f12902f = str;
    }

    /* renamed from: h */
    public String m18370h() {
        return this.f12905i;
    }

    /* renamed from: e */
    public void m18366e(String str) {
        this.f12905i = str;
    }

    /* renamed from: i */
    public String m18371i() {
        return this.f12906j;
    }

    /* renamed from: f */
    public void m18368f(String str) {
        this.f12906j = str;
    }
}
