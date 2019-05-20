package ru.gg.scooby.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import p042b.p047e.p049b.C0700j;
import ru.skooby.R;

/* compiled from: UIUtils.kt */
public final class UIUtilsKt {
    public static final void setEnabledWithOpacity(View view, boolean z) {
        C0700j.m2715b(view, "receiver$0");
        view.setEnabled(z);
        view.setAlpha(z ? true : true);
    }

    public static final Snackbar setMaxLines(Snackbar snackbar, int i) {
        C0700j.m2715b(snackbar, "receiver$0");
        TextView textView = (TextView) snackbar.m6011e().findViewById(R.id.snackbar_text);
        if (textView != null) {
            textView.setMaxLines(i);
        }
        return snackbar;
    }

    public static /* synthetic */ void setMargins$default(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != null) {
            i = 0;
        }
        if ((i5 & 2) != null) {
            i2 = 0;
        }
        if ((i5 & 4) != null) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        setMargins(view, i, i2, i3, i4);
    }

    public static final void setMargins(View view, int i, int i2, int i3, int i4) {
        C0700j.m2715b(view, "receiver$0");
        LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            layoutParams = null;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.topMargin = i2;
            marginLayoutParams.rightMargin = i3;
            marginLayoutParams.bottomMargin = i4;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
