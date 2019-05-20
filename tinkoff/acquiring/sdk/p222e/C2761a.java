package ru.tinkoff.acquiring.sdk.p222e;

/* compiled from: Base64 */
/* renamed from: ru.tinkoff.acquiring.sdk.e.a */
public class C2761a {
    /* renamed from: a */
    static final /* synthetic */ boolean f8485a = (C2761a.class.desiredAssertionStatus() ^ 1);

    /* compiled from: Base64 */
    /* renamed from: ru.tinkoff.acquiring.sdk.e.a$a */
    static abstract class C2760a {
        /* renamed from: a */
        public byte[] f8483a;
        /* renamed from: b */
        public int f8484b;

        C2760a() {
        }
    }

    /* compiled from: Base64 */
    /* renamed from: ru.tinkoff.acquiring.sdk.e.a$b */
    static class C4318b extends C2760a {
        /* renamed from: c */
        private static final int[] f12942c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: d */
        private static final int[] f12943d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: e */
        private int f12944e;
        /* renamed from: f */
        private int f12945f;
        /* renamed from: g */
        private final int[] f12946g;

        public C4318b(int i, byte[] bArr) {
            this.a = bArr;
            this.f12946g = (i & 8) == 0 ? f12942c : f12943d;
            this.f12944e = 0;
            this.f12945f = 0;
        }

        /* renamed from: a */
        public boolean m18477a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.f12944e;
            if (i3 == 6) {
                return false;
            }
            i2 += i;
            int i4 = this.f12945f;
            byte[] bArr2 = this.a;
            int[] iArr = this.f12946g;
            int i5 = 0;
            while (i < i2) {
                int i6;
                if (i3 == 0) {
                    while (true) {
                        i6 = i + 4;
                        if (i6 <= i2) {
                            i4 = (((iArr[bArr[i] & 255] << 18) | (iArr[bArr[i + 1] & 255] << 12)) | (iArr[bArr[i + 2] & 255] << 6)) | iArr[bArr[i + 3] & 255];
                            if (i4 >= 0) {
                                bArr2[i5 + 2] = (byte) i4;
                                bArr2[i5 + 1] = (byte) (i4 >> 8);
                                bArr2[i5] = (byte) (i4 >> 16);
                                i5 += 3;
                                i = i6;
                            }
                        }
                        if (i >= i2) {
                            if (z) {
                                this.f12944e = i3;
                                this.f12945f = i4;
                                this.b = i5;
                                return true;
                            }
                            switch (i3) {
                                case 0:
                                    break;
                                case 1:
                                    this.f12944e = 6;
                                    return false;
                                case 2:
                                    i = i5 + 1;
                                    bArr2[i5] = (byte) (i4 >> 4);
                                    i5 = i;
                                    break;
                                case 3:
                                    i = i5 + 1;
                                    bArr2[i5] = (byte) (i4 >> 10);
                                    i5 = i + 1;
                                    bArr2[i] = (byte) (i4 >> 2);
                                    break;
                                case 4:
                                    this.f12944e = 6;
                                    return false;
                                default:
                                    break;
                            }
                            this.f12944e = i3;
                            this.b = i5;
                            return true;
                        }
                    }
                }
                i6 = i + 1;
                i = iArr[bArr[i] & 255];
                switch (i3) {
                    case 0:
                        if (i < 0) {
                            if (i == -1) {
                                break;
                            }
                            this.f12944e = 6;
                            return false;
                        }
                        i3++;
                        i4 = i;
                        break;
                    case 1:
                        if (i < 0) {
                            if (i == -1) {
                                break;
                            }
                            this.f12944e = 6;
                            return false;
                        }
                        i3++;
                        i4 = i | (i4 << 6);
                        break;
                    case 2:
                        if (i < 0) {
                            if (i != -2) {
                                if (i == -1) {
                                    break;
                                }
                                this.f12944e = 6;
                                return false;
                            }
                            i = i5 + 1;
                            bArr2[i5] = (byte) (i4 >> 4);
                            i5 = i;
                            i3 = 4;
                            break;
                        }
                        i3++;
                        i4 = i | (i4 << 6);
                        break;
                    case 3:
                        if (i < 0) {
                            if (i != -2) {
                                if (i == -1) {
                                    break;
                                }
                                this.f12944e = 6;
                                return false;
                            }
                            bArr2[i5 + 1] = (byte) (i4 >> 2);
                            bArr2[i5] = (byte) (i4 >> 10);
                            i5 += 2;
                            i3 = 5;
                            break;
                        }
                        i |= i4 << 6;
                        bArr2[i5 + 2] = (byte) i;
                        bArr2[i5 + 1] = (byte) (i >> 8);
                        bArr2[i5] = (byte) (i >> 16);
                        i5 += 3;
                        i4 = i;
                        i3 = 0;
                        break;
                    case 4:
                        if (i != -2) {
                            if (i == -1) {
                                break;
                            }
                            this.f12944e = 6;
                            return false;
                        }
                        i3++;
                        break;
                    case 5:
                        if (i == -1) {
                            break;
                        }
                        this.f12944e = 6;
                        return false;
                    default:
                        break;
                }
                i = i6;
            }
            if (z) {
                switch (i3) {
                    case 0:
                        break;
                    case 1:
                        this.f12944e = 6;
                        return false;
                    case 2:
                        i = i5 + 1;
                        bArr2[i5] = (byte) (i4 >> 4);
                        i5 = i;
                        break;
                    case 3:
                        i = i5 + 1;
                        bArr2[i5] = (byte) (i4 >> 10);
                        i5 = i + 1;
                        bArr2[i] = (byte) (i4 >> 2);
                        break;
                    case 4:
                        this.f12944e = 6;
                        return false;
                    default:
                        break;
                }
                this.f12944e = i3;
                this.b = i5;
                return true;
            }
            this.f12944e = i3;
            this.f12945f = i4;
            this.b = i5;
            return true;
        }
    }

    /* compiled from: Base64 */
    /* renamed from: ru.tinkoff.acquiring.sdk.e.a$c */
    static class C4319c extends C2760a {
        /* renamed from: g */
        static final /* synthetic */ boolean f12947g = (C2761a.class.desiredAssertionStatus() ^ 1);
        /* renamed from: h */
        private static final byte[] f12948h = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        /* renamed from: i */
        private static final byte[] f12949i = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        /* renamed from: c */
        int f12950c;
        /* renamed from: d */
        public final boolean f12951d;
        /* renamed from: e */
        public final boolean f12952e;
        /* renamed from: f */
        public final boolean f12953f;
        /* renamed from: j */
        private final byte[] f12954j;
        /* renamed from: k */
        private int f12955k;
        /* renamed from: l */
        private final byte[] f12956l;

        public C4319c(int i, byte[] bArr) {
            this.a = bArr;
            boolean z = true;
            this.f12951d = (i & 1) == null ? 1 : null;
            this.f12952e = (i & 2) == null ? 1 : null;
            if ((i & 4) == null) {
                z = false;
            }
            this.f12953f = z;
            this.f12956l = (i & 8) == 0 ? f12948h : f12949i;
            this.f12954j = new byte[2];
            this.f12950c = 0;
            this.f12955k = this.f12952e != 0 ? 19 : -1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public boolean m18478a(byte[] r18, int r19, int r20, boolean r21) {
            /*
            r17 = this;
            r0 = r17;
            r1 = r0.f12956l;
            r2 = r0.a;
            r3 = r0.f12955k;
            r4 = r20 + r19;
            r5 = r0.f12950c;
            r6 = -1;
            r7 = 0;
            r8 = 1;
            switch(r5) {
                case 0: goto L_0x004f;
                case 1: goto L_0x0030;
                case 2: goto L_0x0013;
                default: goto L_0x0012;
            };
        L_0x0012:
            goto L_0x004f;
        L_0x0013:
            r5 = r19 + 1;
            if (r5 > r4) goto L_0x004f;
        L_0x0017:
            r9 = r0.f12954j;
            r10 = r9[r7];
            r10 = r10 & 255;
            r10 = r10 << 16;
            r9 = r9[r8];
            r9 = r9 & 255;
            r9 = r9 << 8;
            r9 = r9 | r10;
            r10 = r18[r19];
            r10 = r10 & 255;
            r9 = r9 | r10;
            r0.f12950c = r7;
            r10 = r5;
            r5 = r9;
            goto L_0x0052;
        L_0x0030:
            r5 = r19 + 2;
            if (r5 > r4) goto L_0x004f;
        L_0x0034:
            r5 = r0.f12954j;
            r5 = r5[r7];
            r5 = r5 & 255;
            r5 = r5 << 16;
            r9 = r19 + 1;
            r10 = r18[r19];
            r10 = r10 & 255;
            r10 = r10 << 8;
            r5 = r5 | r10;
            r10 = r9 + 1;
            r9 = r18[r9];
            r9 = r9 & 255;
            r5 = r5 | r9;
            r0.f12950c = r7;
            goto L_0x0052;
        L_0x004f:
            r10 = r19;
            r5 = -1;
        L_0x0052:
            r11 = 4;
            r12 = 13;
            r13 = 10;
            r14 = 2;
            if (r5 == r6) goto L_0x008f;
        L_0x005a:
            r6 = r5 >> 18;
            r6 = r6 & 63;
            r6 = r1[r6];
            r2[r7] = r6;
            r6 = r5 >> 12;
            r6 = r6 & 63;
            r6 = r1[r6];
            r2[r8] = r6;
            r6 = r5 >> 6;
            r6 = r6 & 63;
            r6 = r1[r6];
            r2[r14] = r6;
            r5 = r5 & 63;
            r5 = r1[r5];
            r6 = 3;
            r2[r6] = r5;
            r3 = r3 + -1;
            if (r3 != 0) goto L_0x008d;
        L_0x007d:
            r3 = r0.f12953f;
            if (r3 == 0) goto L_0x0085;
        L_0x0081:
            r3 = 5;
            r2[r11] = r12;
            goto L_0x0086;
        L_0x0085:
            r3 = 4;
        L_0x0086:
            r5 = r3 + 1;
            r2[r3] = r13;
            r3 = 19;
            goto L_0x0090;
        L_0x008d:
            r5 = 4;
            goto L_0x0090;
        L_0x008f:
            r5 = 0;
        L_0x0090:
            r6 = r10 + 3;
            if (r6 > r4) goto L_0x00e8;
        L_0x0094:
            r15 = r18[r10];
            r15 = r15 & 255;
            r15 = r15 << 16;
            r16 = r10 + 1;
            r9 = r18[r16];
            r9 = r9 & 255;
            r9 = r9 << 8;
            r9 = r9 | r15;
            r10 = r10 + 2;
            r10 = r18[r10];
            r10 = r10 & 255;
            r9 = r9 | r10;
            r10 = r9 >> 18;
            r10 = r10 & 63;
            r10 = r1[r10];
            r2[r5] = r10;
            r10 = r5 + 1;
            r15 = r9 >> 12;
            r15 = r15 & 63;
            r15 = r1[r15];
            r2[r10] = r15;
            r10 = r5 + 2;
            r15 = r9 >> 6;
            r15 = r15 & 63;
            r15 = r1[r15];
            r2[r10] = r15;
            r10 = r5 + 3;
            r9 = r9 & 63;
            r9 = r1[r9];
            r2[r10] = r9;
            r5 = r5 + 4;
            r3 = r3 + -1;
            if (r3 != 0) goto L_0x00e6;
        L_0x00d4:
            r3 = r0.f12953f;
            if (r3 == 0) goto L_0x00dd;
        L_0x00d8:
            r3 = r5 + 1;
            r2[r5] = r12;
            goto L_0x00de;
        L_0x00dd:
            r3 = r5;
        L_0x00de:
            r5 = r3 + 1;
            r2[r3] = r13;
            r10 = r6;
            r3 = 19;
            goto L_0x0090;
        L_0x00e6:
            r10 = r6;
            goto L_0x0090;
        L_0x00e8:
            if (r21 == 0) goto L_0x01de;
        L_0x00ea:
            r6 = r0.f12950c;
            r9 = r10 - r6;
            r15 = r4 + -1;
            if (r9 != r15) goto L_0x013c;
        L_0x00f2:
            if (r6 <= 0) goto L_0x00fa;
        L_0x00f4:
            r6 = r0.f12954j;
            r6 = r6[r7];
            r7 = 1;
            goto L_0x0100;
        L_0x00fa:
            r6 = r10 + 1;
            r9 = r18[r10];
            r10 = r6;
            r6 = r9;
        L_0x0100:
            r6 = r6 & 255;
            r6 = r6 << r11;
            r9 = r0.f12950c;
            r9 = r9 - r7;
            r0.f12950c = r9;
            r7 = r5 + 1;
            r9 = r6 >> 6;
            r9 = r9 & 63;
            r9 = r1[r9];
            r2[r5] = r9;
            r5 = r7 + 1;
            r6 = r6 & 63;
            r1 = r1[r6];
            r2[r7] = r1;
            r1 = r0.f12951d;
            if (r1 == 0) goto L_0x0128;
        L_0x011e:
            r1 = r5 + 1;
            r6 = 61;
            r2[r5] = r6;
            r5 = r1 + 1;
            r2[r1] = r6;
        L_0x0128:
            r1 = r0.f12952e;
            if (r1 == 0) goto L_0x01c2;
        L_0x012c:
            r1 = r0.f12953f;
            if (r1 == 0) goto L_0x0135;
        L_0x0130:
            r1 = r5 + 1;
            r2[r5] = r12;
            goto L_0x0136;
        L_0x0135:
            r1 = r5;
        L_0x0136:
            r5 = r1 + 1;
            r2[r1] = r13;
            goto L_0x01c2;
        L_0x013c:
            r9 = r10 - r6;
            r11 = r4 + -2;
            if (r9 != r11) goto L_0x01aa;
        L_0x0142:
            if (r6 <= r8) goto L_0x014a;
        L_0x0144:
            r6 = r0.f12954j;
            r6 = r6[r7];
            r7 = 1;
            goto L_0x0150;
        L_0x014a:
            r6 = r10 + 1;
            r9 = r18[r10];
            r10 = r6;
            r6 = r9;
        L_0x0150:
            r6 = r6 & 255;
            r6 = r6 << r13;
            r9 = r0.f12950c;
            if (r9 <= 0) goto L_0x015e;
        L_0x0157:
            r9 = r0.f12954j;
            r11 = r7 + 1;
            r7 = r9[r7];
            goto L_0x0165;
        L_0x015e:
            r9 = r10 + 1;
            r10 = r18[r10];
            r11 = r7;
            r7 = r10;
            r10 = r9;
        L_0x0165:
            r7 = r7 & 255;
            r7 = r7 << r14;
            r6 = r6 | r7;
            r7 = r0.f12950c;
            r7 = r7 - r11;
            r0.f12950c = r7;
            r7 = r5 + 1;
            r9 = r6 >> 12;
            r9 = r9 & 63;
            r9 = r1[r9];
            r2[r5] = r9;
            r5 = r7 + 1;
            r9 = r6 >> 6;
            r9 = r9 & 63;
            r9 = r1[r9];
            r2[r7] = r9;
            r7 = r5 + 1;
            r6 = r6 & 63;
            r1 = r1[r6];
            r2[r5] = r1;
            r1 = r0.f12951d;
            if (r1 == 0) goto L_0x0195;
        L_0x018e:
            r1 = r7 + 1;
            r5 = 61;
            r2[r7] = r5;
            goto L_0x0196;
        L_0x0195:
            r1 = r7;
        L_0x0196:
            r5 = r0.f12952e;
            if (r5 == 0) goto L_0x01a8;
        L_0x019a:
            r5 = r0.f12953f;
            if (r5 == 0) goto L_0x01a3;
        L_0x019e:
            r5 = r1 + 1;
            r2[r1] = r12;
            r1 = r5;
        L_0x01a3:
            r5 = r1 + 1;
            r2[r1] = r13;
            r1 = r5;
        L_0x01a8:
            r5 = r1;
            goto L_0x01c2;
        L_0x01aa:
            r1 = r0.f12952e;
            if (r1 == 0) goto L_0x01c2;
        L_0x01ae:
            if (r5 <= 0) goto L_0x01c2;
        L_0x01b0:
            r1 = 19;
            if (r3 == r1) goto L_0x01c2;
        L_0x01b4:
            r1 = r0.f12953f;
            if (r1 == 0) goto L_0x01bd;
        L_0x01b8:
            r1 = r5 + 1;
            r2[r5] = r12;
            goto L_0x01be;
        L_0x01bd:
            r1 = r5;
        L_0x01be:
            r5 = r1 + 1;
            r2[r1] = r13;
        L_0x01c2:
            r1 = f12947g;
            if (r1 != 0) goto L_0x01d1;
        L_0x01c6:
            r1 = r0.f12950c;
            if (r1 != 0) goto L_0x01cb;
        L_0x01ca:
            goto L_0x01d1;
        L_0x01cb:
            r1 = new java.lang.AssertionError;
            r1.<init>();
            throw r1;
        L_0x01d1:
            r1 = f12947g;
            if (r1 != 0) goto L_0x0209;
        L_0x01d5:
            if (r10 != r4) goto L_0x01d8;
        L_0x01d7:
            goto L_0x0209;
        L_0x01d8:
            r1 = new java.lang.AssertionError;
            r1.<init>();
            throw r1;
        L_0x01de:
            r1 = r4 + -1;
            if (r10 != r1) goto L_0x01ef;
        L_0x01e2:
            r1 = r0.f12954j;
            r2 = r0.f12950c;
            r4 = r2 + 1;
            r0.f12950c = r4;
            r4 = r18[r10];
            r1[r2] = r4;
            goto L_0x0209;
        L_0x01ef:
            r4 = r4 - r14;
            if (r10 != r4) goto L_0x0209;
        L_0x01f2:
            r1 = r0.f12954j;
            r2 = r0.f12950c;
            r4 = r2 + 1;
            r0.f12950c = r4;
            r4 = r18[r10];
            r1[r2] = r4;
            r2 = r0.f12950c;
            r4 = r2 + 1;
            r0.f12950c = r4;
            r10 = r10 + r8;
            r4 = r18[r10];
            r1[r2] = r4;
        L_0x0209:
            r0.b = r5;
            r0.f12955k = r3;
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.e.a.c.a(byte[], int, int, boolean):boolean");
        }
    }

    /* renamed from: a */
    public static byte[] m11367a(String str, int i) {
        return C2761a.m11368a(str.getBytes(), i);
    }

    /* renamed from: a */
    public static byte[] m11368a(byte[] bArr, int i) {
        return C2761a.m11369a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m11369a(byte[] bArr, int i, int i2, int i3) {
        C4318b c4318b = new C4318b(i3, new byte[((i2 * 3) / 4)]);
        if (c4318b.m18477a(bArr, i, i2, 1) == null) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c4318b.b == c4318b.a.length) {
            return c4318b.a;
        } else {
            bArr = new byte[c4318b.b];
            System.arraycopy(c4318b.a, 0, bArr, 0, c4318b.b);
            return bArr;
        }
    }

    /* renamed from: b */
    public static String m11370b(byte[] bArr, int i) {
        try {
            return new String(C2761a.m11372c(bArr, i), "US-ASCII");
        } catch (byte[] bArr2) {
            throw new AssertionError(bArr2);
        }
    }

    /* renamed from: c */
    public static byte[] m11372c(byte[] bArr, int i) {
        return C2761a.m11371b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m11371b(byte[] bArr, int i, int i2, int i3) {
        C4319c c4319c = new C4319c(i3, null);
        i3 = (i2 / 3) * 4;
        if (!c4319c.f12951d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i3 += 2;
                    break;
                case 2:
                    i3 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i3 += 4;
        }
        if (c4319c.f12952e && i2 > 0) {
            i3 += (((i2 - 1) / 57) + 1) * (c4319c.f12953f ? 2 : 1);
        }
        c4319c.a = new byte[i3];
        c4319c.m18478a(bArr, i, i2, true);
        if (f8485a == null) {
            if (c4319c.b != i3) {
                throw new AssertionError();
            }
        }
        return c4319c.a;
    }

    private C2761a() {
    }
}
