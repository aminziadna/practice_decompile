package ru.tinkoff.acquiring.sdk;

import java.security.PublicKey;
import java.util.Map;
import ru.tinkoff.acquiring.sdk.p220c.C4287c;
import ru.tinkoff.acquiring.sdk.p220c.C4288d;
import ru.tinkoff.acquiring.sdk.p220c.C4289e;
import ru.tinkoff.acquiring.sdk.p220c.C4290f;
import ru.tinkoff.acquiring.sdk.p220c.C4291g;
import ru.tinkoff.acquiring.sdk.p220c.C4292h;
import ru.tinkoff.acquiring.sdk.p220c.C4293i;
import ru.tinkoff.acquiring.sdk.p220c.C4294j;
import ru.tinkoff.acquiring.sdk.p220c.C4295k;
import ru.tinkoff.acquiring.sdk.p220c.C4296l;
import ru.tinkoff.acquiring.sdk.p220c.C4297m;
import ru.tinkoff.acquiring.sdk.p220c.C4298n;
import ru.tinkoff.acquiring.sdk.p220c.C4299o;
import ru.tinkoff.acquiring.sdk.p220c.C4300p;
import ru.tinkoff.acquiring.sdk.p220c.C4301q;
import ru.tinkoff.acquiring.sdk.p220c.C4302r;
import ru.tinkoff.acquiring.sdk.p220c.C4303s;
import ru.tinkoff.acquiring.sdk.p220c.C4304t;
import ru.tinkoff.acquiring.sdk.p220c.C4305u;
import ru.tinkoff.acquiring.sdk.p220c.C4306v;
import ru.tinkoff.acquiring.sdk.p221d.C4309c;
import ru.tinkoff.acquiring.sdk.p221d.C4312f;

/* compiled from: AcquiringSdk */
/* renamed from: ru.tinkoff.acquiring.sdk.c */
public class C4307c extends ai {
    /* renamed from: a */
    private final C2731a f12934a;
    /* renamed from: b */
    private final String f12935b;
    /* renamed from: c */
    private final String f12936c;
    /* renamed from: d */
    private final PublicKey f12937d;

    public C4307c(String str, String str2, PublicKey publicKey) {
        this.f12935b = str;
        this.f12936c = str2;
        this.f12937d = publicKey;
        this.f12934a = new C2731a();
    }

    public C4307c(String str, String str2, String str3) {
        this(str, str2, new az(str3));
    }

    public C4307c(String str, String str2, aj ajVar) {
        this(str, str2, ajVar.mo1947a());
    }

    /* renamed from: a */
    public String m18452a() {
        return this.f12935b;
    }

    /* renamed from: a */
    public Long m18451a(C4302r c4302r) {
        return m18450a((C4301q) c4302r.m11362c());
    }

    /* renamed from: a */
    public bg m18457a(long j, C2767i c2767i, String str) {
        try {
            return this.f12934a.m11269a((C4293i) new C4294j(this.f12936c, this.f12935b).m18373a(Long.valueOf(j)).m18375a(str != null).m18374a(c2767i.m11392a(this.f12937d)).m18378c(str).m11362c()).m18470e();
        } catch (C2751b e) {
            j = e;
            throw new C2757d(j);
        } catch (ap e2) {
            j = e2;
            throw new C2757d(j);
        }
    }

    /* renamed from: a */
    public bg m18456a(long j, String str, String str2) {
        try {
            return this.f12934a.m11269a((C4293i) new C4294j(this.f12936c, this.f12935b).m18373a(Long.valueOf(j)).m18376b(str).m18375a(str2 != null).m18378c(str2).m11362c()).m18470e();
        } catch (C2751b e) {
            j = e;
            throw new C2757d(j);
        } catch (ap e2) {
            j = e2;
            throw new C2757d(j);
        }
    }

    /* renamed from: a */
    public C2766h[] m18460a(String str) {
        try {
            str = this.f12934a.m11271a((C4297m) new C4298n(this.f12936c, this.f12935b).m18391a(str).m11362c());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GetCardListResponse ");
            stringBuilder.append(str);
            ai.m11290a(stringBuilder.toString());
            return str.m18473e();
        } catch (C2751b e) {
            str = e;
            throw new C2757d(str);
        } catch (ap e2) {
            str = e2;
            throw new C2757d(str);
        }
    }

    /* renamed from: a */
    public at m18454a(long j, String str) {
        try {
            return this.f12934a.m11268a((C4291g) new C4292h(this.f12936c, this.f12935b).m18354a(Long.valueOf(j)).m18355a(str).m11362c()).m18469e();
        } catch (C2751b e) {
            j = e;
            throw new C2757d(j);
        } catch (ap e2) {
            j = e2;
            throw new C2757d(j);
        }
    }

    /* renamed from: a */
    public av m18455a(long j) {
        try {
            return this.f12934a.m11272a((C4299o) new C4300p(this.f12936c, this.f12935b).m18398a(Long.valueOf(j)).m11362c()).m18474e();
        } catch (C2751b e) {
            j = e;
            throw new C2757d(j);
        } catch (ap e2) {
            j = e2;
            throw new C2757d(j);
        }
    }

    /* renamed from: a */
    public boolean m18459a(String str, String str2) {
        try {
            return this.f12934a.m11274a((C4303s) new C4304t(this.f12936c, this.f12935b).m18437b(str).m18436a(str2).m11362c()).m11363a();
        } catch (C2751b e) {
            str = e;
            throw new C2757d(str);
        } catch (ap e2) {
            str = e2;
            throw new C2757d(str);
        }
    }

    /* renamed from: b */
    public String m18461b(String str, String str2) {
        try {
            return this.f12934a.m11266a((C4287c) new C4288d(this.f12936c, this.f12935b).m18329a(str).m18330b(str2).m11362c()).m18464e();
        } catch (C2751b e) {
            str = e;
            throw new C2757d(str);
        } catch (ap e2) {
            str = e2;
            throw new C2757d(str);
        }
    }

    /* renamed from: a */
    public C4309c m18458a(String str, C2767i c2767i, String str2, Map<String, String> map) {
        try {
            return this.f12934a.m11267a((C4289e) new C4290f(this.f12936c, this.f12935b).m18344b(str).m18342a(c2767i.m11392a(this.f12937d)).m18346c(str2).m18343a((Map) map).m11362c());
        } catch (C2751b e) {
            str = e;
            throw new C2757d(str);
        } catch (ap e2) {
            str = e2;
            throw new C2757d(str);
        }
    }

    /* renamed from: b */
    public C4312f m18462b(String str) {
        try {
            return this.f12934a.m11270a((C4295k) new C4296l(this.f12936c, this.f12935b).m18384a(str).m11362c());
        } catch (C2751b e) {
            str = e;
            throw new C2757d(str);
        } catch (ap e2) {
            str = e2;
            throw new C2757d(str);
        }
    }

    /* renamed from: a */
    public String m18453a(String str, Long l) {
        try {
            return this.f12934a.m11275a((C4305u) new C4306v(this.f12936c, this.f12935b).m18447a(str).m18446a(l).m11362c()).m18476e();
        } catch (C2751b e) {
            str = e;
            throw new C2757d(str);
        } catch (ap e2) {
            str = e2;
            throw new C2757d(str);
        }
    }

    /* renamed from: c */
    public String m18463c(String str) {
        return C2731a.m11258a(str);
    }

    /* renamed from: a */
    private Long m18450a(C4301q c4301q) {
        try {
            return this.f12934a.m11273a(c4301q).m18475e();
        } catch (C2751b e) {
            c4301q = e;
            throw new C2757d(c4301q);
        } catch (ap e2) {
            c4301q = e2;
            throw new C2757d(c4301q);
        }
    }
}
