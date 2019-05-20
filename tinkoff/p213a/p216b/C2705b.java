package ru.tinkoff.p213a.p216b;

/* compiled from: Bytes */
/* renamed from: ru.tinkoff.a.b.b */
public class C2705b {
    /* renamed from: a */
    private static final char[] f8331a = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    private static int m11196a(char c) {
        return ('0' > c || c > '9') ? ('A' > c || c > 'F') ? ('a' > c || c > 'f') ? -1 : (c - 97) + 10 : (c - 65) + 10 : c - 48;
    }

    /* renamed from: a */
    public static byte[] m11198a(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:13:0x0060 in {7, 9, 10, 12} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
        r1 = r0 % 2;
        if (r1 != 0) goto L_0x0049;
    L_0x0008:
        r1 = r0 / 2;
        r1 = new byte[r1];
        r2 = 0;
    L_0x000d:
        if (r2 >= r0) goto L_0x0048;
    L_0x000f:
        r3 = r6.charAt(r2);
        r3 = ru.tinkoff.p213a.p216b.C2705b.m11196a(r3);
        r4 = r2 + 1;
        r4 = r6.charAt(r4);
        r4 = ru.tinkoff.p213a.p216b.C2705b.m11196a(r4);
        r5 = -1;
        if (r3 == r5) goto L_0x0031;
    L_0x0024:
        if (r4 == r5) goto L_0x0031;
    L_0x0026:
        r5 = r2 / 2;
        r3 = r3 * 16;
        r3 = r3 + r4;
        r3 = (byte) r3;
        r1[r5] = r3;
        r2 = r2 + 2;
        goto L_0x000d;
    L_0x0031:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "contains illegal character for hexBinary: ";
        r1.append(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x0048:
        return r1;
    L_0x0049:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "hexBinary needs to be even-length: ";
        r1.append(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.a.b.b.a(java.lang.String):byte[]");
    }

    /* renamed from: a */
    public static String m11197a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(f8331a[(b >> 4) & 15]);
            stringBuilder.append(f8331a[b & 15]);
        }
        return stringBuilder.toString();
    }
}
