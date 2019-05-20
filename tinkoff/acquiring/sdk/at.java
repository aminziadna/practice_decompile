package ru.tinkoff.acquiring.sdk;

/* compiled from: PaymentInfo */
public class at {
    /* renamed from: a */
    private final String f8391a;
    /* renamed from: b */
    private final Long f8392b;
    /* renamed from: c */
    private final Long f8393c;
    /* renamed from: d */
    private final String f8394d;
    /* renamed from: e */
    private final String f8395e;

    public at(String str, Long l, Long l2, String str2, String str3) {
        this.f8391a = str;
        this.f8392b = l;
        this.f8393c = l2;
        this.f8394d = str2;
        this.f8395e = str3;
    }

    /* renamed from: a */
    public Long m11320a() {
        return this.f8392b;
    }

    /* renamed from: b */
    public String m11321b() {
        return this.f8394d;
    }

    /* renamed from: c */
    public boolean m11322c() {
        return "0".equals(this.f8395e);
    }
}
