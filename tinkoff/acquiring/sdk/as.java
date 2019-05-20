package ru.tinkoff.acquiring.sdk;

import android.content.Intent;
import java.util.HashMap;
import ru.tinkoff.acquiring.sdk.p217b.p219b.C2749a;
import ru.tinkoff.acquiring.sdk.p217b.p219b.C2750b;

/* compiled from: PayFormStarter */
public class as {
    /* renamed from: a */
    private Intent f8387a;
    /* renamed from: b */
    private final String f8388b;
    /* renamed from: c */
    private final String f8389c;
    /* renamed from: d */
    private final String f8390d;

    public as(String str, String str2, String str3) {
        this.f8388b = str;
        this.f8389c = str2;
        this.f8390d = str3;
    }

    /* renamed from: a */
    public as m11317a(String str, an anVar, String str2, String str3, String str4, String str5, boolean z, boolean z2) {
        this.f8387a = new Intent();
        this.f8387a.putExtra("order_id", str);
        this.f8387a.putExtra("amount", anVar);
        this.f8387a.putExtra("title", str2);
        this.f8387a.putExtra("description", str3);
        this.f8387a.putExtra("card_id", str4);
        this.f8387a.putExtra("email", str5);
        this.f8387a.putExtra("keyboard", z2);
        this.f8387a.putExtra("recurrent_payment", z);
        this.f8387a.putExtra("terminal_key", this.f8388b);
        this.f8387a.putExtra("password", this.f8389c);
        this.f8387a.putExtra("public_key", this.f8390d);
        this.f8387a.putExtra("design_configuration", C2750b.m11335a(C2749a.f8430a));
        return this;
    }

    /* renamed from: a */
    public as m11316a(String str) {
        m11313b();
        this.f8387a.putExtra("customer_key", str);
        return this;
    }

    /* renamed from: a */
    public as m11318a(HashMap<String, String> hashMap) {
        m11313b();
        this.f8387a.putExtra("data_value", hashMap);
        return this;
    }

    /* renamed from: a */
    public as m11315a(int i) {
        m11313b();
        this.f8387a.putExtra("theme", i);
        return this;
    }

    /* renamed from: a */
    public as m11319a(ab abVar) {
        m11313b();
        this.f8387a.putExtra("card_scanner", abVar);
        return this;
    }

    /* renamed from: a */
    public Intent m11314a() {
        m11313b();
        return this.f8387a;
    }

    /* renamed from: b */
    private void m11313b() {
        if (this.f8387a == null) {
            throw new IllegalStateException("Use prepare() method for initialization");
        }
    }
}
