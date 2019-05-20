package ru.gg.scooby.ui.input;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import io.card.payment.BuildConfig;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p042b.p053i.C0721e;

/* compiled from: SpacesFilter.kt */
public final class SpacesFilter implements InputFilter {
    private final Runnable onSpaceEnteredCallback;

    public SpacesFilter() {
        this(null, 1, null);
    }

    public SpacesFilter(Runnable runnable) {
        this.onSpaceEnteredCallback = runnable;
    }

    public /* synthetic */ SpacesFilter(Runnable runnable, int i, C0697g c0697g) {
        if ((i & 1) != 0) {
            runnable = null;
        }
        this(runnable);
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        C0700j.m2715b(spanned, "dest");
        charSequence = charSequence != null ? charSequence.subSequence(i, i2).toString() : null;
        if (TextUtils.isEmpty(charSequence) != 0) {
            return null;
        }
        charSequence = String.valueOf(charSequence);
        i = new C0721e("\\s").m2743a(charSequence, BuildConfig.FLAVOR);
        if (charSequence.length() <= i.length()) {
            return null;
        }
        charSequence = this.onSpaceEnteredCallback;
        if (charSequence != null) {
            charSequence.run();
        }
        return (CharSequence) i;
    }
}
