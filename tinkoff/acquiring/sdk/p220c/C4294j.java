package ru.tinkoff.acquiring.sdk.p220c;

/* compiled from: FinishAuthorizeRequestBuilder */
/* renamed from: ru.tinkoff.acquiring.sdk.c.j */
public final class C4294j extends C2755b<C4293i> {
    /* renamed from: a */
    private C4293i f12907a = new C4293i();

    /* renamed from: a */
    protected /* synthetic */ C2754a mo1950a() {
        return mo1952d();
    }

    public C4294j(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public C4294j m18373a(Long l) {
        this.f12907a.m18359a(l);
        return this;
    }

    /* renamed from: a */
    public C4294j m18375a(boolean z) {
        this.f12907a.m18360a(z);
        return this;
    }

    /* renamed from: a */
    public C4294j m18374a(String str) {
        this.f12907a.m18362c(str);
        return this;
    }

    /* renamed from: b */
    public C4294j m18376b(String str) {
        this.f12907a.m18366e(str);
        this.f12907a.m18368f("GooglePay");
        return this;
    }

    /* renamed from: c */
    public C4294j m18378c(String str) {
        this.f12907a.m18364d(str);
        return this;
    }

    /* renamed from: b */
    protected void mo1951b() {
        m11358a(this.f12907a.m18367f(), "Payment ID");
        if (this.f12907a.m18370h() != null) {
            m11360a(this.f12907a.m18370h(), "EncryptedPaymentData");
            m11360a(this.f12907a.m18371i(), "Source");
        } else if (this.f12907a.m18365e() == null) {
            m11360a(this.f12907a.m18369g(), "Card data");
        } else {
            m11360a(this.f12907a.m18365e(), "CardId");
            m11360a(this.f12907a.m18363d(), "CVV");
        }
    }

    /* renamed from: d */
    protected C4293i mo1952d() {
        return this.f12907a;
    }
}
