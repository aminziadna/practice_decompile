package ru.gg.scooby.ui.input;

import android.widget.EditText;
import com.p090c.p091a.C1046a;
import p042b.p047e.p049b.C0700j;

/* compiled from: PhoneTextWatcher.kt */
public final class PhoneTextWatcher extends C1046a {
    public static final Companion Companion = new Companion();
    public static final String RU_PHONE_NUMBER_MASK = "+7 ([000]) [000]-[0000]";
    private final EditText editText;

    /* compiled from: PhoneTextWatcher.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public PhoneTextWatcher(EditText editText) {
        C0700j.m2715b(editText, "editText");
        super(RU_PHONE_NUMBER_MASK, false, editText, null, null);
        this.editText = editText;
    }

    public final EditText getEditText() {
        return this.editText;
    }
}
