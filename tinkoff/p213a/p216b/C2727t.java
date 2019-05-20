package ru.tinkoff.p213a.p216b;

import io.card.payment.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.tinkoff.p213a.p214a.C2702a;

/* compiled from: Tags */
/* renamed from: ru.tinkoff.a.b.t */
public class C2727t {
    /* renamed from: a */
    public static final C2726b f8357a = new C46771();

    /* compiled from: Tags */
    /* renamed from: ru.tinkoff.a.b.t$b */
    public interface C2726b {
        /* renamed from: a */
        <T> T mo1939a(String str);

        /* renamed from: a */
        String mo1940a();
    }

    /* compiled from: Tags */
    /* renamed from: ru.tinkoff.a.b.t$a */
    public static class C4283a implements C2726b {
        /* renamed from: a */
        String f12880a;
        /* renamed from: b */
        Map<String, C2726b> f12881b = new HashMap();

        /* renamed from: a */
        public String mo1940a() {
            return this.f12880a;
        }

        /* renamed from: a */
        public <T> T mo1939a(String str) {
            if (this.f12880a.equals(str)) {
                return this;
            }
            T t = null;
            for (C2726b a : this.f12881b.values()) {
                t = a.mo1939a(str);
                if (t != null) {
                    break;
                }
            }
            return t;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(this.f12880a);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: Tags */
    /* renamed from: ru.tinkoff.a.b.t$c */
    public static class C4284c implements C2726b {
        /* renamed from: a */
        String f12882a;
        /* renamed from: b */
        byte[] f12883b;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(this.f12882a);
            stringBuilder.append(": ");
            stringBuilder.append(this.f12883b);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        /* renamed from: a */
        public String mo1940a() {
            return this.f12882a;
        }

        /* renamed from: a */
        public <T> T mo1939a(String str) {
            return this.f12882a.equals(str) != null ? this.f12883b : null;
        }
    }

    /* compiled from: Tags */
    /* renamed from: ru.tinkoff.a.b.t$1 */
    static class C46771 extends C4284c {
        C46771() {
            this.a = " empty_data";
        }
    }

    /* renamed from: a */
    private static int m11238a(int i, int i2) {
        return i | (i2 << 30);
    }

    /* renamed from: b */
    private static int m11248b(int i) {
        return i & 65535;
    }

    /* renamed from: c */
    private static int m11252c(int i) {
        return i >>> 30;
    }

    /* renamed from: c */
    public static int m11253c(long j) {
        return (int) (j & 255);
    }

    /* renamed from: d */
    public static boolean m11255d(long j) {
        return ((j >> 56) & 32) == 32;
    }

    /* renamed from: a */
    public static C2726b m11243a(byte[] bArr) {
        return bArr == null ? f8357a : (C2726b) C2727t.m11242a(bArr, 0, bArr.length).get(0);
    }

    /* renamed from: a */
    public static byte[] m11246a(byte[] bArr, C2725r c2725r) {
        List<byte[]> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            long a = C2727t.m11239a(bArr, i);
            i += C2727t.m11253c(a);
            int b = C2727t.m11249b(bArr, i);
            i += C2727t.m11252c(b);
            Object a2 = c2725r.mo1938a(C2727t.m11240a(a), C2727t.m11248b(b));
            i2 += a2.length;
            arrayList.add(a2);
        }
        bArr = new C2707e(i2);
        for (byte[] write : arrayList) {
            bArr.write(write);
        }
        return bArr.m11202a();
    }

    /* renamed from: a */
    private static List<C2726b> m11242a(byte[] bArr, int i, int i2) {
        List<C2726b> arrayList = new ArrayList();
        while (i < i2) {
            Object c4283a;
            long a = C2727t.m11239a(bArr, i);
            String a2 = C2727t.m11240a(a);
            i += C2727t.m11253c(a);
            int b = C2727t.m11249b(bArr, i);
            int b2 = C2727t.m11248b(b);
            i += C2727t.m11252c(b);
            if (C2727t.m11255d(a)) {
                c4283a = new C4283a();
                c4283a.f12880a = a2;
                for (C2726b c2726b : C2727t.m11242a(bArr, i, i + b2)) {
                    c4283a.f12881b.put(c2726b.mo1940a(), c2726b);
                }
            } else {
                c4283a = new C4284c();
                c4283a.f12882a = a2;
                Object obj = new byte[b2];
                System.arraycopy(bArr, i, obj, 0, b2);
                c4283a.f12883b = obj;
            }
            arrayList.add(c4283a);
            i += b2;
        }
        return arrayList;
    }

    /* renamed from: a */
    private static long m11239a(byte[] bArr, int i) {
        Object obj = (bArr[i] & 31) == 31 ? 1 : null;
        if (obj == null) {
            return C2727t.m11250b(new byte[]{r0});
        }
        int i2 = 1;
        while (obj != null) {
            obj = (bArr[i + i2] & 128) == 128 ? 1 : null;
            i2++;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return C2727t.m11250b(bArr2);
    }

    /* renamed from: b */
    private static int m11249b(byte[] bArr, int i) {
        byte b = bArr[i];
        if ((b & 128) != 128) {
            return C2727t.m11238a(b & 127, 1);
        }
        int i2 = b & 127;
        if (i2 == 0) {
            throw new C2713k("ISO/IEC 7816 does not use the indefinite lengths");
        } else if (i2 <= 3) {
            int i3 = 0;
            for (int i4 = 1; i4 <= i2; i4++) {
                i3 = (i3 << 8) | (bArr[i4 + i] & 255);
            }
            return C2727t.m11238a(i3, i2 + 1);
        } else {
            throw new C2713k("too large data for emv");
        }
    }

    /* renamed from: a */
    public static byte[] m11247a(byte[] bArr, byte[] bArr2) {
        Object a = C2727t.m11245a(bArr2.length);
        Object obj = new byte[((bArr.length + a.length) + bArr2.length)];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        System.arraycopy(a, 0, obj, bArr.length, a.length);
        System.arraycopy(bArr2, 0, obj, bArr.length + a.length, bArr2.length);
        return obj;
    }

    /* renamed from: a */
    public static byte[] m11245a(int i) {
        if (i < 128) {
            return new byte[]{(byte) i};
        } else if (i < 256) {
            return new byte[]{(byte) -127, (byte) i};
        } else {
            return new byte[]{(byte) -126, (byte) ((i >>> 8) & 255), (byte) (i & 255)};
        }
    }

    /* renamed from: b */
    public static long m11250b(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < bArr.length; i++) {
            j |= (((long) bArr[i]) & 255) << (56 - (i * 8));
        }
        return j | ((long) (bArr.length & 255));
    }

    /* renamed from: a */
    public static String m11240a(long j) {
        return C2705b.m11197a(C2727t.m11251b(j));
    }

    /* renamed from: b */
    public static byte[] m11251b(long j) {
        int i = (int) (j & 255);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) ((j >>> (56 - (i2 * 8))) & 255));
        }
        return bArr;
    }

    /* renamed from: c */
    public static boolean m11254c(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int i2 = bArr[i] & 255;
            if (i2 >= 32) {
                if (i2 <= 127) {
                    i++;
                }
            }
            return false;
        }
        return 1;
    }

    /* renamed from: a */
    public static String m11241a(C2726b c2726b, C2710h c2710h) {
        Appendable stringBuilder = new StringBuilder();
        C2727t.m11244a(c2710h, stringBuilder, c2726b, 0);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static void m11244a(C2710h c2710h, Appendable appendable, C2726b c2726b, int i) {
        int i2 = 0;
        while (i2 < i) {
            try {
                appendable.append("--");
                i2++;
            } catch (Throwable e) {
                C2702a.m11195a("Tags", "print", e);
                return;
            }
        }
        String a = c2726b.mo1940a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        if (c2710h == null) {
            a = BuildConfig.FLAVOR;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" (");
            stringBuilder2.append(c2710h.m11205a(a));
            stringBuilder2.append(")");
            a = stringBuilder2.toString();
        }
        stringBuilder.append(a);
        appendable.append(stringBuilder.toString());
        if (c2726b instanceof C4284c) {
            byte[] bArr = ((C4284c) c2726b).f12883b;
            if (bArr != null) {
                if (C2727t.m11254c(bArr) != null) {
                    c2726b = new String(bArr);
                } else {
                    c2726b = new StringBuilder();
                    c2726b.append("hex:");
                    c2726b.append(C2705b.m11197a(bArr));
                    c2726b = c2726b.toString();
                }
                c2710h = new StringBuilder();
                c2710h.append(": ");
                c2710h.append(c2726b);
                appendable.append(c2710h.toString());
            }
            appendable.append("\n");
            return;
        }
        appendable.append("\n");
        for (C2726b a2 : ((C4283a) c2726b).f12881b.values()) {
            C2727t.m11244a(c2710h, appendable, a2, i + 1);
        }
    }
}
