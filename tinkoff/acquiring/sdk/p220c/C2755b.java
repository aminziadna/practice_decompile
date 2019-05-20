package ru.tinkoff.acquiring.sdk.p220c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ru.tinkoff.acquiring.sdk.C2778t;
import ru.tinkoff.acquiring.sdk.ai;

/* compiled from: AcquiringRequestBuilder */
/* renamed from: ru.tinkoff.acquiring.sdk.c.b */
abstract class C2755b<R extends C2754a> {
    /* renamed from: a */
    private final String f8476a;
    /* renamed from: b */
    private final String f8477b;

    /* renamed from: a */
    protected abstract R mo1950a();

    /* renamed from: b */
    protected abstract void mo1951b();

    C2755b(String str, String str2) {
        this.f8476a = str;
        this.f8477b = str2;
    }

    /* renamed from: c */
    public R m11362c() {
        mo1951b();
        C2754a a = mo1950a();
        a.m11351a(this.f8477b);
        a.m11354b(mo1952d());
        return mo1950a();
    }

    /* renamed from: a */
    protected void m11359a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalStateException(String.format("Unable to build request: field '%s' is null", new Object[]{str}));
        }
    }

    /* renamed from: a */
    protected void m11360a(String str, String str2) {
        m11359a((Object) str, str2);
        if (str.trim().isEmpty() != null) {
            throw new IllegalStateException(String.format("Unable to build request: field '%s' is empty", new Object[]{str2}));
        }
    }

    /* renamed from: a */
    protected void m11358a(Long l, String str) {
        m11359a((Object) l, str);
        if (l.longValue() < 0) {
            throw new IllegalStateException(String.format("Unable to build request: field '%s' is negative", new Object[null]));
        }
    }

    /* renamed from: d */
    private String mo1952d() {
        C2754a a = mo1950a();
        Map a2 = a.mo1949a();
        a2.remove("Token");
        a2.put("Password", this.f8476a);
        List<CharSequence> arrayList = new ArrayList(a2.keySet());
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        Set b = a.mo1953b();
        for (CharSequence charSequence : arrayList) {
            if (!b.contains(charSequence)) {
                ai.m11290a(charSequence);
                stringBuilder.append(a2.get(charSequence));
            }
        }
        return C2778t.m11418a(stringBuilder.toString());
    }
}
