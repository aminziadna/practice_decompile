package ru.tinkoff.p213a.p216b;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import ru.tinkoff.p213a.p216b.C2727t.C2726b;

/* compiled from: CardParseStrategy */
/* renamed from: ru.tinkoff.a.b.c */
public class C4279c implements C2709g<Bundle> {
    /* renamed from: a */
    private static final List<byte[]> f12874a = new ArrayList();
    /* renamed from: b */
    private C2710h f12875b;
    /* renamed from: c */
    private C2708f f12876c;
    /* renamed from: d */
    private C2725r f12877d = new C4281q();

    /* renamed from: a */
    private android.os.Bundle m18277a(java.util.List<int[]> r10, ru.tinkoff.p213a.p216b.C2711i r11, java.lang.StringBuilder r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:45:0x011c in {7, 17, 20, 23, 27, 32, 37, 42, 44} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
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
        r9 = this;
        r0 = "Read result:";
        r9.m18279a(r12, r0);
        r10 = r10.iterator();
        r0 = 0;
        r1 = r0;
        r2 = r1;
    L_0x000c:
        r3 = r10.hasNext();
        r4 = 0;
        r5 = 1;
        if (r3 == 0) goto L_0x00af;
    L_0x0014:
        r3 = r10.next();
        r3 = (int[]) r3;
        r6 = r3[r4];
        r3 = r3[r5];
        r3 = ru.tinkoff.p213a.p216b.C2722n.m11225a(r6, r3);	 Catch:{ IOException -> 0x00af }
        r9.m18280a(r12, r3);	 Catch:{ IOException -> 0x00af }
        r3 = r11.mo2390a(r3);	 Catch:{ IOException -> 0x00af }
        r6 = r9.f12876c;	 Catch:{ IOException -> 0x00af }
        r9.m18281a(r12, r3, r6);	 Catch:{ IOException -> 0x00af }
        r6 = r3.m11233b();	 Catch:{ IOException -> 0x00af }
        if (r6 != 0) goto L_0x0035;	 Catch:{ IOException -> 0x00af }
    L_0x0034:
        goto L_0x000c;	 Catch:{ IOException -> 0x00af }
    L_0x0035:
        r3 = r3.f8356c;	 Catch:{ IOException -> 0x00af }
        r3 = ru.tinkoff.p213a.p216b.C2727t.m11243a(r3);	 Catch:{ IOException -> 0x00af }
        r6 = r9.f12875b;	 Catch:{ IOException -> 0x00af }
        r9.m18282a(r12, r3, r6);	 Catch:{ IOException -> 0x00af }
        r6 = "5A";	 Catch:{ IOException -> 0x00af }
        r6 = r3.mo1939a(r6);	 Catch:{ IOException -> 0x00af }
        r6 = (byte[]) r6;	 Catch:{ IOException -> 0x00af }
        if (r6 == 0) goto L_0x007f;	 Catch:{ IOException -> 0x00af }
    L_0x004a:
        r7 = r6.length;	 Catch:{ IOException -> 0x00af }
        r8 = 5;	 Catch:{ IOException -> 0x00af }
        if (r7 <= r8) goto L_0x007f;	 Catch:{ IOException -> 0x00af }
    L_0x004e:
        r7 = "5F24";	 Catch:{ IOException -> 0x00af }
        r7 = r3.mo1939a(r7);	 Catch:{ IOException -> 0x00af }
        r7 = (byte[]) r7;	 Catch:{ IOException -> 0x00af }
        if (r7 == 0) goto L_0x007f;	 Catch:{ IOException -> 0x00af }
    L_0x0058:
        r8 = r7.length;	 Catch:{ IOException -> 0x00af }
        if (r8 <= r5) goto L_0x007f;	 Catch:{ IOException -> 0x00af }
    L_0x005b:
        r10 = ru.tinkoff.p213a.p216b.C2705b.m11197a(r6);	 Catch:{ IOException -> 0x00af }
        r11 = "F";	 Catch:{ IOException -> 0x00af }
        r3 = "";	 Catch:{ IOException -> 0x00af }
        r10 = r10.replaceAll(r11, r3);	 Catch:{ IOException -> 0x00af }
        r11 = ru.tinkoff.p213a.p216b.C2705b.m11197a(r7);	 Catch:{ IOException -> 0x00af }
        r11 = r9.m18278a(r11);	 Catch:{ IOException -> 0x00af }
        r3 = "Result read from Application Primary Card Number and Application Expiration Date";	 Catch:{ IOException -> 0x00af }
        r9.m18279a(r12, r3);	 Catch:{ IOException -> 0x00af }
        r3 = r12.toString();	 Catch:{ IOException -> 0x00af }
        r6 = "5A";	 Catch:{ IOException -> 0x00af }
        r10 = r9.m18290a(r10, r11, r3, r6);	 Catch:{ IOException -> 0x00af }
        return r10;	 Catch:{ IOException -> 0x00af }
    L_0x007f:
        r6 = "57";	 Catch:{ IOException -> 0x00af }
        r6 = r3.mo1939a(r6);	 Catch:{ IOException -> 0x00af }
        r6 = (byte[]) r6;	 Catch:{ IOException -> 0x00af }
        if (r6 == 0) goto L_0x008d;	 Catch:{ IOException -> 0x00af }
    L_0x0089:
        r1 = ru.tinkoff.p213a.p216b.C2705b.m11197a(r6);	 Catch:{ IOException -> 0x00af }
    L_0x008d:
        r6 = "9F6B";	 Catch:{ IOException -> 0x00af }
        r6 = r3.mo1939a(r6);	 Catch:{ IOException -> 0x00af }
        r6 = (byte[]) r6;	 Catch:{ IOException -> 0x00af }
        if (r6 == 0) goto L_0x009d;	 Catch:{ IOException -> 0x00af }
    L_0x0097:
        r7 = new java.lang.String;	 Catch:{ IOException -> 0x00af }
        r7.<init>(r6);	 Catch:{ IOException -> 0x00af }
        r0 = r7;	 Catch:{ IOException -> 0x00af }
    L_0x009d:
        r6 = "56";	 Catch:{ IOException -> 0x00af }
        r3 = r3.mo1939a(r6);	 Catch:{ IOException -> 0x00af }
        r3 = (byte[]) r3;	 Catch:{ IOException -> 0x00af }
        if (r3 == 0) goto L_0x000c;	 Catch:{ IOException -> 0x00af }
    L_0x00a7:
        r6 = new java.lang.String;	 Catch:{ IOException -> 0x00af }
        r6.<init>(r3);	 Catch:{ IOException -> 0x00af }
        r2 = r6;
        goto L_0x000c;
    L_0x00af:
        if (r1 == 0) goto L_0x00cf;
    L_0x00b1:
        r10 = r9.m18287b(r1);
        if (r10 == 0) goto L_0x00cf;
    L_0x00b7:
        r11 = "Result read from Track2Equivalent";
        r9.m18279a(r12, r11);
        r11 = r10[r4];
        r10 = r10[r5];
        r10 = r9.m18278a(r10);
        r12 = r12.toString();
        r0 = "57";
        r10 = r9.m18290a(r11, r10, r12, r0);
        return r10;
    L_0x00cf:
        if (r0 == 0) goto L_0x00ef;
    L_0x00d1:
        r10 = r9.m18288c(r0);
        if (r10 == 0) goto L_0x00ef;
    L_0x00d7:
        r11 = "Result read from Track2";
        r9.m18279a(r12, r11);
        r11 = r10[r4];
        r10 = r10[r5];
        r10 = r9.m18278a(r10);
        r12 = r12.toString();
        r0 = "9F6B";
        r10 = r9.m18290a(r11, r10, r12, r0);
        return r10;
    L_0x00ef:
        if (r2 == 0) goto L_0x010f;
    L_0x00f1:
        r10 = r9.m18289d(r2);
        if (r10 == 0) goto L_0x010f;
    L_0x00f7:
        r11 = "Result read from Track1";
        r9.m18279a(r12, r11);
        r11 = r10[r4];
        r10 = r10[r5];
        r10 = r9.m18278a(r10);
        r12 = r12.toString();
        r0 = "56";
        r10 = r9.m18290a(r11, r10, r12, r0);
        return r10;
    L_0x010f:
        r10 = new ru.tinkoff.a.b.j;
        r10.<init>();
        r11 = r12.toString();
        r10.m11207a(r11);
        throw r10;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.a.b.c.a(java.util.List, ru.tinkoff.a.b.i, java.lang.StringBuilder):android.os.Bundle");
    }

    /* renamed from: b */
    public /* synthetic */ Object mo1937b(C2711i c2711i) {
        return m18291a(c2711i);
    }

    static {
        f12874a.add(C2705b.m11198a("A000000003101001"));
        f12874a.add(C2705b.m11198a("A0000000042010"));
    }

    /* renamed from: a */
    public void m18293a(C2710h c2710h) {
        this.f12875b = c2710h;
    }

    /* renamed from: a */
    public void m18292a(C2708f c2708f) {
        this.f12876c = c2708f;
    }

    /* renamed from: a */
    public android.os.Bundle m18291a(ru.tinkoff.p213a.p216b.C2711i r5) {
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
        r4 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r4.m18283a(r5, r0);
        if (r1 == 0) goto L_0x0010;
    L_0x000b:
        r1 = r4.m18285a(r1, r5, r0);
        goto L_0x002f;
    L_0x0010:
        r1 = 0;
        r2 = f12874a;
        r2 = r2.iterator();
    L_0x0017:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x002b;
    L_0x001d:
        r3 = r2.next();
        r3 = (byte[]) r3;
        r1 = r4.m18285a(r3, r5, r0);	 Catch:{ j -> 0x0017 }
        r2 = 1;
        r2 = r1;
        r1 = 1;
        goto L_0x002c;
    L_0x002b:
        r2 = 0;
    L_0x002c:
        if (r1 == 0) goto L_0x0038;
    L_0x002e:
        r1 = r2;
    L_0x002f:
        r1 = r4.m18286b(r1, r5, r0);
        r5 = r4.m18277a(r1, r5, r0);
        return r5;
    L_0x0038:
        r5 = new ru.tinkoff.a.b.j;
        r0 = "no suitable application id in fallback list";
        r5.<init>(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.a.b.c.a(ru.tinkoff.a.b.i):android.os.Bundle");
    }

    /* renamed from: a */
    private byte[] m18283a(C2711i c2711i, StringBuilder stringBuilder) {
        m18279a(stringBuilder, "Select File:");
        C2722n a = C2722n.m11226a("2PAY.SYS.DDF01");
        a.m11229a(0);
        m18280a(stringBuilder, a);
        C2723o a2 = c2711i.mo2390a(a);
        m18281a(stringBuilder, a2, this.f12876c);
        if (a2.m11233b()) {
            C2726b a3 = C2727t.m11243a(a2.f8356c);
            m18282a(stringBuilder, a3, this.f12875b);
            byte[] bArr = (byte[]) a3.mo1939a("4F");
            if (bArr != null) {
                return bArr;
            }
        }
        a = C2722n.m11226a("1PAY.SYS.DDF01");
        a.m11229a(0);
        m18280a(stringBuilder, a);
        C2723o a4 = c2711i.mo2390a(a);
        m18281a(stringBuilder, a4, this.f12876c);
        if (!a4.m11233b()) {
            return null;
        }
        C2726b a5 = C2727t.m11243a(a4.f8356c);
        m18282a(stringBuilder, a5, this.f12875b);
        return (byte[]) a5.mo1939a("4F");
    }

    /* renamed from: a */
    private byte[] m18285a(byte[] bArr, C2711i c2711i, StringBuilder stringBuilder) {
        m18279a(stringBuilder, "Select Application:");
        C2722n a = C2722n.m11227a(bArr);
        a.m11229a(0);
        m18280a(stringBuilder, a);
        C2723o a2 = c2711i.mo2390a(a);
        m18281a(stringBuilder, a2, this.f12876c);
        if (a2.m11233b() != null) {
            C2726b a3 = C2727t.m11243a(a2.f8356c);
            m18282a(stringBuilder, a3, this.f12875b);
            return (byte[]) a3.mo1939a("9F38");
        }
        bArr = a2.f8355b;
        bArr = new C2712j();
        bArr.m11207a(stringBuilder.toString());
        throw bArr;
    }

    /* renamed from: b */
    private List<int[]> m18286b(byte[] bArr, C2711i c2711i, StringBuilder stringBuilder) {
        m18279a(stringBuilder, "Get records for read: ");
        List<int[]> arrayList = new ArrayList();
        C2722n b = C2722n.m11228b(m18284a(bArr));
        m18280a(stringBuilder, b);
        C2723o a = c2711i.mo2390a(b);
        m18281a(stringBuilder, a, this.f12876c);
        if (a.m11233b() != null) {
            C2726b a2 = C2727t.m11243a(a.f8356c);
            m18282a(stringBuilder, a2, this.f12875b);
            bArr = (byte[]) a2.mo1939a("94");
            if (bArr != null) {
                for (c2711i = null; c2711i <= bArr.length - 4; c2711i += 4) {
                    stringBuilder = (bArr[c2711i] & 255) >>> 3;
                    int i = bArr[c2711i + 2] & 255;
                    for (int i2 = bArr[c2711i + 1] & 255; i2 <= i; i2++) {
                        arrayList.add(new int[]{stringBuilder, i2});
                    }
                }
                return arrayList;
            }
        }
        for (bArr = 1; bArr < 10; bArr++) {
            for (c2711i = true; c2711i < 30; c2711i++) {
                arrayList.add(new int[]{bArr, c2711i});
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private byte[] m18284a(byte[] bArr) {
        if (bArr == null) {
            return new byte[]{(byte) -125, (byte) 0};
        }
        return C2727t.m11247a(new byte[]{(byte) -125}, C2727t.m11246a(bArr, this.f12877d));
    }

    /* renamed from: a */
    protected Bundle m18290a(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("card_number", str);
        bundle.putString("expire_date", str2);
        bundle.putString("report", str3);
        bundle.putString("tag", str4);
        return bundle;
    }

    /* renamed from: a */
    private void m18279a(StringBuilder stringBuilder, String str) {
        stringBuilder.append(str);
        stringBuilder.append("\n");
    }

    /* renamed from: a */
    private void m18280a(StringBuilder stringBuilder, C2722n c2722n) {
        stringBuilder.append(c2722n.toString());
        stringBuilder.append("\n");
    }

    /* renamed from: a */
    private void m18281a(StringBuilder stringBuilder, C2723o c2723o, C2708f c2708f) {
        if (c2708f != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("response: ");
            stringBuilder2.append(c2708f.m11203a(c2723o.m11232a()));
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("\n");
        }
    }

    /* renamed from: a */
    private void m18282a(StringBuilder stringBuilder, C2726b c2726b, C2710h c2710h) {
        stringBuilder.append(C2727t.m11241a(c2726b, c2710h));
        stringBuilder.append("\n\n");
    }

    /* renamed from: a */
    private String m18278a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(2, 4));
        stringBuilder.append("/");
        stringBuilder.append(str.substring(0, 2));
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private String[] m18287b(String str) {
        int indexOf = str.indexOf(68);
        if (indexOf <= 11 || indexOf >= 25) {
            return null;
        }
        return new String[]{str.substring(0, indexOf), str.substring(indexOf + 1, indexOf + 5)};
    }

    /* renamed from: c */
    private String[] m18288c(String str) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = -1;
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if (Character.isDigit(charAt) && r3 == -1) {
                i4 = i3;
            }
            if (Character.isDigit(charAt) || r3 == -1) {
                i3++;
            } else {
                if (charAt == '=') {
                    i2 = i3 + 5;
                    if (i2 <= str.length() - 1) {
                        i = i3 + 1;
                        int i5 = i3;
                        i3 = i2;
                        i2 = i5;
                        if ((((i4 | i2) | i) | i3) < 0) {
                            return null;
                        }
                        return new String[]{str.substring(i4, i2), str.substring(i, i3)};
                    }
                }
                return null;
            }
        }
        i3 = -1;
        i = -1;
        if ((((i4 | i2) | i) | i3) < 0) {
            return null;
        }
        return new String[]{str.substring(i4, i2), str.substring(i, i3)};
    }

    /* renamed from: d */
    private String[] m18289d(String str) {
        int length = str.length();
        int i = 0;
        while (!Character.isDigit(str.charAt(i))) {
            i++;
            if (i == length) {
                return null;
            }
        }
        int i2 = i;
        while (Character.isDigit(str.charAt(i2))) {
            i2++;
            if (i2 == length) {
                return null;
            }
        }
        int i3 = i2;
        while (!Character.isDigit(str.charAt(i3))) {
            i3++;
            if (i3 == length) {
                return null;
            }
        }
        if (i3 + 4 > length) {
            return null;
        }
        return new String[]{str.substring(i, i2), str.substring(i3, i3 + 4)};
    }
}
