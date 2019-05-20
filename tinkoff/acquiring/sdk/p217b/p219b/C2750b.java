package ru.tinkoff.acquiring.sdk.p217b.p219b;

/* compiled from: PayCellType */
/* renamed from: ru.tinkoff.acquiring.sdk.b.b.b */
public enum C2750b {
    PRODUCT_TITLE,
    PRODUCT_DESCRIPTION,
    AMOUNT,
    PAYMENT_CARD_REQUISITES,
    EMAIL,
    PAY_BUTTON,
    SECURE_LOGOS,
    EMPTY_FLEXIBLE_SPACE,
    EMPTY_16DP,
    EMPTY_8DP;

    /* renamed from: a */
    public static int[] m11335a(C2750b... c2750bArr) {
        int[] iArr = new int[c2750bArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = c2750bArr[i].ordinal();
        }
        return iArr;
    }

    /* renamed from: a */
    public static C2750b[] m11336a(int[] iArr) {
        C2750b[] values = C2750b.values();
        C2750b[] c2750bArr = new C2750b[iArr.length];
        for (int i = 0; i < c2750bArr.length; i++) {
            c2750bArr[i] = values[iArr[i]];
        }
        return c2750bArr;
    }
}
