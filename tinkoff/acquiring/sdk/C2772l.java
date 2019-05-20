package ru.tinkoff.acquiring.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ru.tinkoff.acquiring.sdk.p221d.C4309c;

/* compiled from: CardManager */
/* renamed from: ru.tinkoff.acquiring.sdk.l */
public class C2772l {
    /* renamed from: a */
    private static Map<String, C2766h[]> f8515a = new HashMap();
    /* renamed from: b */
    private C4307c f8516b;

    public C2772l(C4307c c4307c) {
        this.f8516b = c4307c;
    }

    /* renamed from: a */
    public C2766h[] m11408a(String str) {
        C2766h[] c2766hArr = (C2766h[]) f8515a.get(str);
        if (c2766hArr != null) {
            return c2766hArr;
        }
        Object a = m11406a(this.f8516b.m18460a(str));
        f8515a.put(str, a);
        return a;
    }

    /* renamed from: b */
    public C2766h m11409b(String str) {
        for (C2766h[] c2766hArr : f8515a.values()) {
            for (C2766h c2766h : (C2766h[]) r0.next()) {
                if (str.equals(c2766h.m11387b())) {
                    return c2766h;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public C4309c m11407a(String str, String str2, C2767i c2767i, String str3, Map<String, String> map) {
        return this.f8516b.m18458a(this.f8516b.m18461b(str, str2), c2767i, str3, map);
    }

    /* renamed from: c */
    public void m11410c(String str) {
        f8515a.remove(str);
    }

    /* renamed from: a */
    private C2766h[] m11406a(C2766h[] c2766hArr) {
        ArrayList arrayList = new ArrayList();
        for (C2766h c2766h : c2766hArr) {
            if (c2766h.m11388c() == C2773m.ACTIVE) {
                arrayList.add(c2766h);
            }
        }
        return (C2766h[]) arrayList.toArray(new C2766h[arrayList.size()]);
    }
}
