package ru.tinkoff.p213a.p216b;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: EasyStream */
/* renamed from: ru.tinkoff.a.b.e */
class C2707e extends OutputStream {
    /* renamed from: a */
    byte[] f8334a;
    /* renamed from: b */
    int f8335b;

    public void close() {
    }

    public C2707e(int i) {
        this.f8335b = 0;
        this.f8334a = new byte[i];
    }

    public C2707e() {
        this(42);
    }

    /* renamed from: a */
    public void m11201a(byte b) {
        int i = this.f8335b;
        byte[] bArr = this.f8334a;
        if (i < bArr.length) {
            bArr[i] = b;
            this.f8335b = i + 1;
            return;
        }
        throw new IOException("stream was teared");
    }

    public void write(int i) {
        m11201a((byte) ((i >> 24) & 255));
        m11201a((byte) ((i >> 16) & 255));
        m11201a((byte) ((i >> 8) & 255));
        m11201a((byte) (i & 255));
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        while (i < i2) {
            m11201a(bArr[i]);
            i++;
        }
    }

    /* renamed from: a */
    public byte[] m11202a() {
        int i = this.f8335b;
        Object obj = new byte[i];
        System.arraycopy(this.f8334a, 0, obj, 0, i);
        return obj;
    }
}
