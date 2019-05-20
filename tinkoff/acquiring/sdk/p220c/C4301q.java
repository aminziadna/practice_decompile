package ru.tinkoff.acquiring.sdk.p220c;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.tinkoff.acquiring.sdk.ay;

/* compiled from: InitRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.q */
public final class C4301q extends C2754a {
    /* renamed from: c */
    private Long f12914c;
    /* renamed from: d */
    private String f12915d;
    /* renamed from: e */
    private String f12916e;
    /* renamed from: f */
    private String f12917f;
    /* renamed from: g */
    private String f12918g;
    /* renamed from: h */
    private String f12919h;
    /* renamed from: i */
    private String f12920i;
    /* renamed from: j */
    private String f12921j;
    /* renamed from: k */
    private ay f12922k;
    /* renamed from: l */
    private List<ay> f12923l;
    /* renamed from: m */
    private List<Object> f12924m;
    /* renamed from: n */
    private Map<String, String> f12925n;
    /* renamed from: o */
    private boolean f12926o;

    public C4301q() {
        super("Init");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map a = super.mo1949a();
        m11352a("Amount", this.f12914c.toString(), a);
        m11352a("OrderId", this.f12915d, a);
        m11352a("CustomerKey", this.f12916e, a);
        m11352a("Description", this.f12917f, a);
        m11352a("PayForm", this.f12918g, a);
        m11352a("Recurrent", this.f12919h, a);
        m11352a("Language", this.f12920i, a);
        m11352a("PayType", this.f12921j, a);
        m11352a("Receipt", this.f12922k, a);
        m11352a("Receipts", this.f12923l, a);
        m11352a("Shops", this.f12924m, a);
        m18401c(a);
        return a;
    }

    /* renamed from: d */
    public Long m18411d() {
        return this.f12914c;
    }

    /* renamed from: a */
    void m18403a(Long l) {
        this.f12914c = l;
    }

    /* renamed from: e */
    public String m18413e() {
        return this.f12915d;
    }

    /* renamed from: c */
    void m18410c(String str) {
        this.f12915d = str;
    }

    /* renamed from: d */
    void m18412d(String str) {
        this.f12916e = str;
    }

    /* renamed from: e */
    void m18414e(String str) {
        this.f12918g = str;
    }

    /* renamed from: a */
    void m18407a(boolean z) {
        this.f12919h = z ? "Y" : false;
    }

    /* renamed from: f */
    void m18415f(String str) {
        this.f12920i = str;
    }

    /* renamed from: a */
    void m18406a(ay ayVar) {
        this.f12922k = ayVar;
    }

    /* renamed from: a */
    void m18404a(List<Object> list, List<ay> list2) {
        this.f12923l = list2;
        this.f12924m = list;
    }

    /* renamed from: a */
    void m18405a(Map<String, String> map) {
        this.f12925n = map;
    }

    /* renamed from: b */
    void m18408b(Map<String, String> map) {
        if (map != null) {
            if (this.f12925n == null) {
                this.f12925n = new HashMap();
            }
            this.f12925n.putAll(map);
        }
    }

    /* renamed from: b */
    void m18409b(boolean z) {
        this.f12926o = z;
    }

    /* renamed from: c */
    private void m18401c(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        Map map2 = this.f12925n;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        hashMap.put("chargeFlag", Boolean.toString(this.f12926o));
        map.put("DATA", hashMap);
    }
}
