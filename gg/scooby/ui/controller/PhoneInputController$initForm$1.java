package ru.gg.scooby.ui.controller;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PhoneInputController.kt */
public final class PhoneInputController$initForm$1 implements TextWatcher {
    final /* synthetic */ PhoneInputController this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    PhoneInputController$initForm$1(PhoneInputController phoneInputController) {
        this.this$0 = phoneInputController;
    }

    public void afterTextChanged(Editable editable) {
        this.this$0.updateButtonsState();
    }
}
