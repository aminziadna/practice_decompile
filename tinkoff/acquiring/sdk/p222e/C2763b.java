package ru.tinkoff.acquiring.sdk.p222e;

import java.util.regex.Pattern;

/* compiled from: CardValidator */
/* renamed from: ru.tinkoff.acquiring.sdk.e.b */
public class C2763b {
    /* renamed from: a */
    private static final int[] f8486a = new int[]{16, 18, 19, 22};

    /* compiled from: CardValidator */
    /* renamed from: ru.tinkoff.acquiring.sdk.e.b$a */
    public static class C2762a {
        /* renamed from: a */
        public static boolean m11373a(CharSequence charSequence, String str) {
            return Pattern.compile(str).matcher(charSequence).matches();
        }
    }

    /* renamed from: a */
    public static boolean m11375a(String str) {
        boolean z = false;
        if (C2763b.m11374a((CharSequence) str) || C2762a.m11373a(str, "[0]{1,}")) {
            return false;
        }
        Object obj = null;
        for (int i : f8486a) {
            if (str.length() == i) {
                obj = 1;
            }
        }
        if (!(obj == null || C2763b.m11378d(str) == null)) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m11376b(String str) {
        if (C2763b.m11374a((CharSequence) str)) {
            return null;
        }
        return C2762a.m11373a(str, "^[0-9]{3}$");
    }

    /* renamed from: c */
    public static boolean m11377c(java.lang.String r6) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r0 = ru.tinkoff.acquiring.sdk.p222e.C2763b.m11374a(r6);
        r1 = 0;
        if (r0 != 0) goto L_0x004f;
    L_0x0007:
        r0 = r6.length();
        r2 = 5;
        if (r0 == r2) goto L_0x000f;
    L_0x000e:
        goto L_0x004f;
    L_0x000f:
        r0 = 2;
        r3 = r6.substring(r1, r0);	 Catch:{ NumberFormatException -> 0x004e }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x004e }
        r4 = 3;	 Catch:{ NumberFormatException -> 0x004e }
        r6 = r6.substring(r4, r2);	 Catch:{ NumberFormatException -> 0x004e }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x004e }
        r2 = 1;
        if (r3 < r2) goto L_0x004d;
    L_0x0024:
        r4 = 12;
        if (r3 > r4) goto L_0x004d;
    L_0x0028:
        r4 = java.util.Calendar.getInstance();
        r5 = r4.get(r2);
        r5 = java.lang.Integer.toString(r5);
        r5 = r5.substring(r0);
        r0 = r4.get(r0);
        r0 = r0 + r2;
        r4 = java.lang.Integer.parseInt(r5);
        if (r6 != r4) goto L_0x0046;
    L_0x0043:
        if (r3 < r0) goto L_0x0046;
    L_0x0045:
        return r2;
    L_0x0046:
        if (r6 <= r4) goto L_0x004d;
    L_0x0048:
        r4 = r4 + 20;
        if (r6 > r4) goto L_0x004d;
    L_0x004c:
        return r2;
    L_0x004d:
        return r1;
    L_0x004e:
        return r1;
    L_0x004f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.e.b.c(java.lang.String):boolean");
    }

    /* renamed from: d */
    private static boolean m11378d(java.lang.String r6) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
        /*
        r0 = r6.length();
        r1 = 1;
        r0 = r0 - r1;
        r2 = 0;
        r3 = 0;
    L_0x0008:
        if (r0 < 0) goto L_0x0032;
    L_0x000a:
        r4 = r0 + 1;
        r4 = r6.substring(r0, r4);	 Catch:{ NumberFormatException -> 0x0031 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0031 }
        r5 = r6.length();
        r5 = r5 - r0;
        r5 = r5 % 2;
        if (r5 != 0) goto L_0x001f;
    L_0x001d:
        r5 = 1;
        goto L_0x0020;
    L_0x001f:
        r5 = 0;
    L_0x0020:
        if (r5 == 0) goto L_0x002d;
    L_0x0022:
        r4 = r4 * 2;
        r5 = 9;
        if (r4 <= r5) goto L_0x002b;
    L_0x0028:
        r4 = r4 % 10;
        r4 = r4 + r1;
    L_0x002b:
        r3 = r3 + r4;
        goto L_0x002e;
    L_0x002d:
        r3 = r3 + r4;
    L_0x002e:
        r0 = r0 + -1;
        goto L_0x0008;
    L_0x0031:
        return r2;
    L_0x0032:
        r3 = r3 % 10;
        if (r3 != 0) goto L_0x0037;
    L_0x0036:
        goto L_0x0038;
    L_0x0037:
        r1 = 0;
    L_0x0038:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.e.b.d(java.lang.String):boolean");
    }

    /* renamed from: a */
    private static boolean m11374a(CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.length() != null) {
                return null;
            }
        }
        return true;
    }
}
