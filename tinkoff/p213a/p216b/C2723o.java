package ru.tinkoff.p213a.p216b;

/* compiled from: NfcResponse */
/* renamed from: ru.tinkoff.a.b.o */
public class C2723o {
    /* renamed from: a */
    int f8354a;
    /* renamed from: b */
    short f8355b;
    /* renamed from: c */
    byte[] f8356c;

    /* renamed from: a */
    public static C2723o m11231a(byte[] bArr, int i) {
        StringBuilder stringBuilder;
        if (bArr == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("bytes is null, for request code ");
            stringBuilder.append(i);
            throw new C2713k(new NullPointerException(stringBuilder.toString()));
        } else if (bArr.length >= 2) {
            C2723o c2723o = new C2723o();
            c2723o.f8354a = i;
            c2723o.f8355b = (short) 0;
            c2723o.f8355b = (short) (c2723o.f8355b | ((bArr[bArr.length - 2] & 255) << 8));
            c2723o.f8355b = (short) (c2723o.f8355b | (bArr[bArr.length - 1] & 255));
            if (bArr.length > 2) {
                c2723o.f8356c = new byte[(bArr.length - 2)];
                System.arraycopy(bArr, 0, c2723o.f8356c, 0, bArr.length - 2);
            }
            return c2723o;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("incorrect response status ");
            stringBuilder.append(C2705b.m11197a(bArr));
            stringBuilder.append(", for request code ");
            stringBuilder.append(i);
            throw new C2713k(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    public String m11232a() {
        r0 = new byte[2];
        short s = this.f8355b;
        r0[0] = (byte) ((s >> 8) & 255);
        r0[1] = (byte) (s & 255);
        return C2705b.m11197a(r0);
    }

    /* renamed from: b */
    public boolean m11233b() {
        return this.f8355b == (short) -28672;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ data=");
        byte[] bArr = this.f8356c;
        if (bArr == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(C2705b.m11197a(bArr));
        }
        stringBuilder.append(", status=");
        stringBuilder.append(m11232a());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
