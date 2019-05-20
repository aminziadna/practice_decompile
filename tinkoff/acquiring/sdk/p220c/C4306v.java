package ru.tinkoff.acquiring.sdk.p220c;

/* compiled from: SubmitRandomAmountRequestBuilder */
/* renamed from: ru.tinkoff.acquiring.sdk.c.v */
public class C4306v extends C2755b<C4305u> {
    /* renamed from: a */
    private final C4305u f12933a = new C4305u();

    /* renamed from: a */
    protected /* synthetic */ C2754a mo1950a() {
        return mo1952d();
    }

    public C4306v(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public C4306v m18447a(String str) {
        this.f12933a.m18442c(str);
        return this;
    }

    /* renamed from: a */
    public C4306v m18446a(Long l) {
        this.f12933a.m18441a(l);
        return this;
    }

    /* renamed from: d */
    protected C4305u mo1952d() {
        return this.f12933a;
    }

    /* renamed from: b */
    protected void mo1951b() {
        m11359a((Object) this.f12933a.m18443d(), "RequestKey");
        m11358a(this.f12933a.m18444e(), "Amount");
    }
}
