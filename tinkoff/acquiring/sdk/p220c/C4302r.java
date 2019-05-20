package ru.tinkoff.acquiring.sdk.p220c;

import java.util.List;
import java.util.Map;
import ru.tinkoff.acquiring.sdk.ay;

/* compiled from: InitRequestBuilder */
/* renamed from: ru.tinkoff.acquiring.sdk.c.r */
public final class C4302r extends C2755b<C4301q> {
    /* renamed from: a */
    private C4301q f12927a = new C4301q();

    /* renamed from: a */
    protected /* synthetic */ C2754a mo1950a() {
        return mo1952d();
    }

    public C4302r(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public C4302r m18417a(long j) {
        this.f12927a.m18403a(Long.valueOf(j));
        return this;
    }

    /* renamed from: a */
    public C4302r m18418a(String str) {
        this.f12927a.m18410c(str);
        return this;
    }

    /* renamed from: b */
    public C4302r m18423b(String str) {
        this.f12927a.m18412d(str);
        return this;
    }

    /* renamed from: c */
    public C4302r m18427c(String str) {
        this.f12927a.m18414e(str);
        return this;
    }

    /* renamed from: a */
    public C4302r m18422a(boolean z) {
        this.f12927a.m18407a(z);
        return this;
    }

    /* renamed from: d */
    public C4302r m18429d(String str) {
        this.f12927a.m18415f(str);
        return this;
    }

    /* renamed from: a */
    public C4302r m18421a(ay ayVar) {
        this.f12927a.m18406a(ayVar);
        return this;
    }

    /* renamed from: a */
    public C4302r m18419a(List<Object> list, List<ay> list2) {
        this.f12927a.m18404a(list, list2);
        return this;
    }

    /* renamed from: a */
    public C4302r m18420a(Map<String, String> map) {
        this.f12927a.m18405a((Map) map);
        return this;
    }

    /* renamed from: b */
    public C4302r m18424b(Map<String, String> map) {
        this.f12927a.m18408b((Map) map);
        return this;
    }

    /* renamed from: b */
    public C4302r m18425b(boolean z) {
        this.f12927a.m18409b(z);
        return this;
    }

    /* renamed from: b */
    protected void mo1951b() {
        m11360a(this.f12927a.m18413e(), "Order ID");
        m11358a(this.f12927a.m18411d(), "Amount");
    }

    /* renamed from: d */
    protected C4301q mo1952d() {
        return this.f12927a;
    }
}
