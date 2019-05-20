package ru.tinkoff.acquiring.sdk;

import android.content.Intent;
import ru.tinkoff.acquiring.sdk.p217b.p218a.C2746a;
import ru.tinkoff.acquiring.sdk.p217b.p218a.C2747b;

/* compiled from: AttachCardFormStarter */
/* renamed from: ru.tinkoff.acquiring.sdk.g */
public class C2765g {
    /* renamed from: a */
    private Intent f8489a;
    /* renamed from: b */
    private final String f8490b;
    /* renamed from: c */
    private final String f8491c;
    /* renamed from: d */
    private final String f8492d;

    public C2765g(String str, String str2, String str3) {
        this.f8490b = str;
        this.f8491c = str2;
        this.f8492d = str3;
    }

    /* renamed from: a */
    public C2765g m11385a(String str, C2776q c2776q, boolean z, String str2) {
        return m11384a(str, c2776q.toString(), z, str2);
    }

    /* renamed from: a */
    public C2765g m11384a(String str, String str2, boolean z, String str3) {
        this.f8489a = new Intent();
        this.f8489a.putExtra("customer_key", str);
        this.f8489a.putExtra("check_type", str2);
        this.f8489a.putExtra("keyboard", z);
        this.f8489a.putExtra("email", str3);
        this.f8489a.putExtra("terminal_key", this.f8490b);
        this.f8489a.putExtra("password", this.f8491c);
        this.f8489a.putExtra("public_key", this.f8492d);
        this.f8489a.putExtra("design_configuration", C2747b.m11329a(C2746a.f8416a));
        return this;
    }

    /* renamed from: a */
    public C2765g m11383a(int i) {
        m11381b();
        this.f8489a.putExtra("theme", i);
        return this;
    }

    /* renamed from: a */
    public Intent m11382a() {
        m11381b();
        return this.f8489a;
    }

    /* renamed from: b */
    private void m11381b() {
        if (this.f8489a == null) {
            throw new IllegalStateException("Use prepare() method for initialization");
        }
    }
}
