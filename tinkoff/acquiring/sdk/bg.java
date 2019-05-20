package ru.tinkoff.acquiring.sdk;

/* compiled from: ThreeDsData */
public class bg {
    /* renamed from: a */
    public static final bg f8460a = new bg();
    /* renamed from: b */
    private final Long f8461b;
    /* renamed from: c */
    private final String f8462c;
    /* renamed from: d */
    private final String f8463d;
    /* renamed from: e */
    private final String f8464e;
    /* renamed from: f */
    private final String f8465f;
    /* renamed from: g */
    private final boolean f8466g;

    private bg() {
        this.f8466g = false;
        this.f8461b = null;
        this.f8462c = null;
        this.f8463d = null;
        this.f8464e = null;
        this.f8465f = null;
    }

    public bg(Long l, String str, String str2, String str3) {
        this.f8466g = true;
        this.f8461b = l;
        this.f8462c = null;
        this.f8463d = str;
        this.f8464e = str2;
        this.f8465f = str3;
    }

    public bg(String str, String str2, String str3, String str4) {
        this.f8466g = true;
        this.f8461b = null;
        this.f8462c = str;
        this.f8463d = str2;
        this.f8464e = str3;
        this.f8465f = str4;
    }

    /* renamed from: a */
    public Long m11340a() {
        return this.f8461b;
    }

    /* renamed from: b */
    public String m11341b() {
        return this.f8462c;
    }

    /* renamed from: c */
    public String m11342c() {
        return this.f8463d;
    }

    /* renamed from: d */
    public String m11343d() {
        return this.f8464e;
    }

    /* renamed from: e */
    public String m11344e() {
        return this.f8465f;
    }

    /* renamed from: f */
    public boolean m11345f() {
        return this.f8466g;
    }

    /* renamed from: g */
    public boolean m11346g() {
        return this.f8461b != null && this.f8462c == null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Data: ");
        stringBuilder.append(this.f8461b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f8463d);
        stringBuilder.append(", ");
        stringBuilder.append(this.f8464e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f8465f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f8466g);
        stringBuilder.append(";");
        return stringBuilder.toString();
    }
}
