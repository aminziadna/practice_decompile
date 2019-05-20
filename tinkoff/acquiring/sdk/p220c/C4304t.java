package ru.tinkoff.acquiring.sdk.p220c;

/* compiled from: RemoveCardRequestBuilder */
/* renamed from: ru.tinkoff.acquiring.sdk.c.t */
public final class C4304t extends C2755b<C4303s> {
    /* renamed from: a */
    private C4303s f12930a = new C4303s();

    /* renamed from: a */
    protected /* synthetic */ C2754a mo1950a() {
        return mo1952d();
    }

    public C4304t(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public C4304t m18436a(String str) {
        this.f12930a.m18431c(str);
        return this;
    }

    /* renamed from: b */
    public C4304t m18437b(String str) {
        this.f12930a.m18433d(str);
        return this;
    }

    /* renamed from: d */
    protected C4303s mo1952d() {
        return this.f12930a;
    }

    /* renamed from: b */
    protected void mo1951b() {
        m11360a(this.f12930a.m18432d(), "Card id");
        m11360a(this.f12930a.m18434e(), "Customer key");
    }
}
