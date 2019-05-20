package ru.tinkoff.acquiring.sdk;

import io.card.payment.BuildConfig;
import java.security.PublicKey;
import ru.tinkoff.acquiring.sdk.p222e.C2763b;

/* compiled from: CardData */
/* renamed from: ru.tinkoff.acquiring.sdk.i */
public class C2767i {
    /* renamed from: a */
    private String f8493a;
    /* renamed from: b */
    private String f8494b;
    /* renamed from: c */
    private String f8495c;
    /* renamed from: d */
    private String f8496d;
    /* renamed from: e */
    private String f8497e;

    public C2767i(String str, String str2, String str3) {
        this.f8493a = str;
        this.f8494b = str2;
        this.f8495c = str3;
    }

    public C2767i(String str, String str2) {
        this.f8495c = str2;
        this.f8496d = str;
    }

    public C2767i(String str) {
        this.f8497e = str;
    }

    /* renamed from: a */
    public String m11392a(PublicKey publicKey) {
        String format;
        m11390b();
        if (this.f8496d != null) {
            format = String.format("%s=%s;%s=%s", new Object[]{"CardId", this.f8496d, "CVV", this.f8495c});
        } else {
            format = this.f8494b.replaceAll("\\D", BuildConfig.FLAVOR);
            format = String.format("%s=%s;%s=%s;%s=%s", new Object[]{"PAN", this.f8493a, "ExpDate", format, "CVV", this.f8495c});
        }
        return C2778t.m11419a(C2778t.m11420a(format, publicKey));
    }

    /* renamed from: a */
    public String m11391a() {
        return this.f8497e;
    }

    /* renamed from: b */
    private void m11390b() {
        String str;
        if (this.f8496d == null) {
            if (!C2763b.m11375a(this.f8493a)) {
                str = "number";
            } else if (!C2763b.m11377c(this.f8494b)) {
                str = "expiration date";
            }
            if (!C2763b.m11376b(this.f8495c) && r0 == null) {
                str = "security code";
            }
            if (str == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot encode card data. Wrong ");
                stringBuilder.append(str);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        str = null;
        str = "security code";
        if (str == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Cannot encode card data. Wrong ");
            stringBuilder2.append(str);
            throw new IllegalStateException(stringBuilder2.toString());
        }
    }
}
