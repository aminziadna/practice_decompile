package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Map;

/* compiled from: AttachCardRequestBuilder */
/* renamed from: ru.tinkoff.acquiring.sdk.c.f */
public final class C4290f extends C2755b<C4289e> {
    /* renamed from: a */
    private final C4289e f12895a = new C4289e();

    /* renamed from: a */
    protected /* synthetic */ C2754a mo1950a() {
        return mo1952d();
    }

    public C4290f(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public C4290f m18342a(String str) {
        this.f12895a.m18336c(str);
        return this;
    }

    /* renamed from: b */
    public C4290f m18344b(String str) {
        this.f12895a.m18338d(str);
        return this;
    }

    /* renamed from: c */
    public C4290f m18346c(String str) {
        this.f12895a.m18340e(str);
        return this;
    }

    /* renamed from: a */
    public C4290f m18343a(Map<String, String> map) {
        this.f12895a.m18335a(map);
        return this;
    }

    /* renamed from: d */
    protected C4289e mo1952d() {
        return this.f12895a;
    }

    /* renamed from: b */
    protected void mo1951b() {
        m11360a(this.f12895a.m18337d(), "CardData");
        m11360a(this.f12895a.m18339e(), "RequestKey");
    }
}
