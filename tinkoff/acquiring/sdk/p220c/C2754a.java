package ru.tinkoff.acquiring.sdk.p220c;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: AcquiringRequest */
/* renamed from: ru.tinkoff.acquiring.sdk.c.a */
public class C2754a {
    /* renamed from: a */
    public static final String[] f8471a = new String[]{"DATA", "Receipt", "Receipts", "Shops"};
    /* renamed from: b */
    public static final Set<String> f8472b = new HashSet(Arrays.asList(f8471a));
    /* renamed from: c */
    private String f8473c;
    /* renamed from: d */
    private String f8474d;
    /* renamed from: e */
    private final String f8475e;

    C2754a(String str) {
        this.f8475e = str;
    }

    /* renamed from: a */
    public Map<String, Object> mo1949a() {
        Map<String, Object> hashMap = new HashMap();
        m11352a("TerminalKey", this.f8473c, hashMap);
        m11352a("Token", this.f8474d, hashMap);
        return hashMap;
    }

    /* renamed from: b */
    public Set<String> mo1953b() {
        return f8472b;
    }

    /* renamed from: a */
    void m11351a(String str) {
        this.f8473c = str;
    }

    /* renamed from: b */
    void m11354b(String str) {
        this.f8474d = str;
    }

    /* renamed from: c */
    public String m11355c() {
        return this.f8475e;
    }

    /* renamed from: a */
    protected void m11352a(String str, Object obj, Map<String, Object> map) {
        if (!(str == null || obj == null)) {
            if (map != null) {
                map.put(str, obj);
            }
        }
    }
}
