package ru.gg.scooby.util;

import io.p181b.p185b.C2468b;

/* compiled from: DisposableEx.kt */
public final class DisposableExKt {
    public static final void safeDispose(C2468b c2468b) {
        if (c2468b != null && !c2468b.mo1730b()) {
            c2468b.mo1727a();
        }
    }

    public static final boolean isNullOrDisposed(C2468b c2468b) {
        if (c2468b != null) {
            if (c2468b.mo1730b() == null) {
                return null;
            }
        }
        return true;
    }
}
