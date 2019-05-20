package ru.tinkoff.p213a.p216b;

/* compiled from: NfcRequest */
/* renamed from: ru.tinkoff.a.b.n */
public class C2722n {
    /* renamed from: a */
    int f8351a = 0;
    /* renamed from: b */
    int f8352b = -1;
    /* renamed from: c */
    byte[] f8353c;

    /* renamed from: a */
    public static C2722n m11226a(String str) {
        return C2722n.m11227a(str.getBytes());
    }

    /* renamed from: a */
    public static C2722n m11227a(byte[] bArr) {
        C2722n c2722n = new C2722n();
        c2722n.f8351a = 10748928;
        c2722n.f8353c = bArr;
        return c2722n;
    }

    /* renamed from: a */
    public static C2722n m11225a(int i, int i2) {
        C2722n c2722n = new C2722n();
        c2722n.f8351a = 11665408;
        c2722n.f8351a = ((i2 & 255) << 8) | c2722n.f8351a;
        c2722n.f8351a = ((i & 255) << 3) | c2722n.f8351a;
        c2722n.f8351a |= 4;
        c2722n.f8352b = 0;
        return c2722n;
    }

    /* renamed from: b */
    public static C2722n m11228b(byte[] bArr) {
        C2722n c2722n = new C2722n();
        c2722n.f8351a = -2136473600;
        c2722n.f8353c = bArr;
        return c2722n;
    }

    protected C2722n() {
    }

    /* renamed from: a */
    public C2722n m11229a(int i) {
        this.f8352b = i;
        return this;
    }

    /* renamed from: a */
    public byte[] m11230a() {
        byte[] bArr = this.f8353c;
        int i = 0;
        int length = (bArr == null ? 0 : bArr.length + 1) + 4;
        if (this.f8352b >= 0) {
            i = 1;
        }
        C2707e c2707e = new C2707e(length + i);
        try {
            c2707e.write(this.f8351a);
            if (this.f8353c != null) {
                c2707e.m11201a((byte) this.f8353c.length);
                c2707e.write(this.f8353c);
            }
            if (this.f8352b != -1) {
                c2707e.m11201a((byte) (this.f8352b & 255));
            }
            c2707e.close();
            return c2707e.m11202a();
        } catch (Throwable th) {
            c2707e.close();
        }
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.m11230a();	 Catch:{ IOException -> 0x0009 }
        r0 = ru.tinkoff.p213a.p216b.C2705b.m11197a(r0);	 Catch:{ IOException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "NfcRequest malformed, req code: ";
        r0.append(r1);
        r1 = r2.f8351a;
        r0.append(r1);
        r1 = ", data: ";
        r0.append(r1);
        r1 = r2.f8353c;
        r1 = ru.tinkoff.p213a.p216b.C2705b.m11197a(r1);
        r0.append(r1);
        r1 = ", length=";
        r0.append(r1);
        r1 = r2.f8352b;
        r0.append(r1);
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.a.b.n.toString():java.lang.String");
    }
}
