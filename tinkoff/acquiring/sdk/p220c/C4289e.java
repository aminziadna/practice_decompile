package ru.tinkoff.acquiring.sdk.p220c;

import java.util.HashMap;
import java.util.Map;

/* compiled from: AttachCardRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.e */
public final class C4289e extends C2754a {
    /* renamed from: c */
    private String f12891c;
    /* renamed from: d */
    private String f12892d;
    /* renamed from: e */
    private String f12893e;
    /* renamed from: f */
    private Map<String, String> f12894f;

    public C4289e() {
        super("AttachCard");
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> a = super.mo1949a();
        m11352a("CardData", this.f12891c, a);
        m11352a("RequestKey", this.f12892d, a);
        m18333b(a);
        return a;
    }

    /* renamed from: d */
    public String m18337d() {
        return this.f12891c;
    }

    /* renamed from: c */
    void m18336c(String str) {
        this.f12891c = str;
    }

    /* renamed from: e */
    public String m18339e() {
        return this.f12892d;
    }

    /* renamed from: d */
    void m18338d(String str) {
        this.f12892d = str;
    }

    /* renamed from: e */
    void m18340e(String str) {
        this.f12893e = str;
    }

    /* renamed from: a */
    void m18335a(Map<String, String> map) {
        this.f12894f = map;
    }

    /* renamed from: b */
    private void m18333b(Map<String, Object> map) {
        if (this.f12894f == null) {
            String str = this.f12893e;
            if (str == null || str.length() == 0) {
                return;
            }
        }
        HashMap hashMap = new HashMap();
        Map map2 = this.f12894f;
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        hashMap.put("Email", this.f12893e);
        map.put("DATA", hashMap);
    }
}
