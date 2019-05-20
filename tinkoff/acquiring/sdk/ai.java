package ru.tinkoff.acquiring.sdk;

/* compiled from: Journal */
public abstract class ai {
    /* renamed from: a */
    private static al f8367a = new ah();
    /* renamed from: b */
    private static boolean f8368b = false;
    /* renamed from: c */
    private static boolean f8369c = false;

    /* renamed from: a */
    public static void m11292a(boolean z) {
        f8368b = z;
    }

    /* renamed from: b */
    public static boolean m11293b() {
        return f8369c;
    }

    /* renamed from: a */
    public static void m11290a(CharSequence charSequence) {
        if (f8368b) {
            f8367a.mo1945a(charSequence);
        }
    }

    /* renamed from: a */
    public static void m11291a(Throwable th) {
        if (f8368b) {
            f8367a.mo1946a(th);
        }
    }
}
