package ru.tinkoff.acquiring.sdk.p217b.p218a;

/* compiled from: AttachCellType */
/* renamed from: ru.tinkoff.acquiring.sdk.b.a.b */
public enum C2747b {
    TITLE,
    DESCRIPTION,
    PAYMENT_CARD_REQUISITES,
    EMAIL,
    ATTACH_BUTTON,
    SECURE_LOGOS,
    EMPTY_FLEXIBLE_SPACE,
    EMPTY_16DP,
    EMPTY_8DP;

    /* renamed from: a */
    public static int[] m11329a(C2747b... c2747bArr) {
        int[] iArr = new int[c2747bArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = c2747bArr[i].ordinal();
        }
        return iArr;
    }

    /* renamed from: a */
    public static C2747b[] m11330a(int[] iArr) {
        C2747b[] values = C2747b.values();
        C2747b[] c2747bArr = new C2747b[iArr.length];
        for (int i = 0; i < c2747bArr.length; i++) {
            c2747bArr[i] = values[iArr[i]];
        }
        return c2747bArr;
    }
}
