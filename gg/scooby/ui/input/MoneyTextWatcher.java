package ru.gg.scooby.ui.input;

import android.widget.EditText;
import com.p090c.p091a.C1046a;
import p042b.p043a.C0675i;
import p042b.p047e.p049b.C0700j;

/* compiled from: MoneyTextWatcher.kt */
public final class MoneyTextWatcher extends C1046a {
    public static final Companion Companion = new Companion();
    public static final String RU_MONEY_DECIMAL_MASK = "[009999999],[00]";
    public static final String RU_MONEY_MASK = "[009999999]";
    private final EditText editText;

    /* compiled from: MoneyTextWatcher.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public MoneyTextWatcher(EditText editText) {
        C0700j.m2715b(editText, "editText");
        super(RU_MONEY_MASK, false, editText, null, null);
        this.editText = editText;
        setAffineFormats(C0675i.m2667a(RU_MONEY_DECIMAL_MASK));
    }

    public final EditText getEditText() {
        return this.editText;
    }
}
