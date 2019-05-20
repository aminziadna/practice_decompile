package ru.tinkoff.acquiring.sdk.p220c;

/* compiled from: ChargeRequestBuilder */
/* renamed from: ru.tinkoff.acquiring.sdk.c.h */
public final class C4292h extends C2755b<C4291g> {
    /* renamed from: a */
    private C4291g f12898a = new C4291g();

    /* renamed from: a */
    protected /* synthetic */ C2754a mo1950a() {
        return mo1952d();
    }

    public C4292h(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public C4292h m18354a(Long l) {
        this.f12898a.m18349a(l);
        return this;
    }

    /* renamed from: a */
    public C4292h m18355a(String str) {
        this.f12898a.m18350c(str);
        return this;
    }

    /* renamed from: b */
    protected void mo1951b() {
        m11358a(this.f12898a.m18351d(), "Payment ID");
        m11360a(this.f12898a.m18352e(), "Rebill ID");
    }

    /* renamed from: d */
    protected C4291g mo1952d() {
        return this.f12898a;
    }
}
