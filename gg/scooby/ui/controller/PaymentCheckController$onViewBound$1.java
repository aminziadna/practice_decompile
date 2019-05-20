package ru.gg.scooby.ui.controller;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: PaymentCheckController.kt */
public final class PaymentCheckController$onViewBound$1 implements TextWatcher {
    final /* synthetic */ PaymentCheckController this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    PaymentCheckController$onViewBound$1(PaymentCheckController paymentCheckController) {
        this.this$0 = paymentCheckController;
    }

    public void afterTextChanged(Editable editable) {
        this.this$0.updateButtonAndCommission();
    }
}
