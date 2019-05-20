package ru.gg.scooby.ui.input.field;

import android.text.Editable;
import android.text.TextWatcher;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.input.validator.ValidationCode;

/* compiled from: TextField.kt */
public final class TextField$setupClearErrorTextWatcher$1 implements TextWatcher {
    final /* synthetic */ TextField this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0700j.m2715b(charSequence, "s");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        C0700j.m2715b(charSequence, "s");
    }

    TextField$setupClearErrorTextWatcher$1(TextField textField) {
        this.this$0 = textField;
    }

    public void afterTextChanged(Editable editable) {
        C0700j.m2715b(editable, "s");
        if (this.this$0.isClearErrorOnTextChange() != null && this.this$0.hasError() != null) {
            this.this$0.setError(ValidationCode.Ok);
        }
    }
}
