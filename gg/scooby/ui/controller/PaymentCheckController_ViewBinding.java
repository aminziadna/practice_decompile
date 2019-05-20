package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class PaymentCheckController_ViewBinding implements Unbinder {
    private PaymentCheckController target;
    private View view7f09009f;
    private View view7f0900a5;

    public PaymentCheckController_ViewBinding(final PaymentCheckController paymentCheckController, View view) {
        this.target = paymentCheckController;
        paymentCheckController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        paymentCheckController.textBalance = (TextView) C0730b.m2751a(view, R.id.text_current_balance, "field 'textBalance'", TextView.class);
        paymentCheckController.textWhere = (TextView) C0730b.m2751a(view, R.id.text_where, "field 'textWhere'", TextView.class);
        paymentCheckController.editTextAmount = (EditText) C0730b.m2751a(view, R.id.edit_text_amount, "field 'editTextAmount'", EditText.class);
        paymentCheckController.textCommission = (TextView) C0730b.m2751a(view, R.id.text_commission, "field 'textCommission'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_transfer, "field 'buttonTransfer' and method 'onTransferClick'");
        paymentCheckController.buttonTransfer = (TextView) C0730b.m2753b(a, R.id.btn_transfer, "field 'buttonTransfer'", TextView.class);
        this.view7f0900a5 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ PaymentCheckController_ViewBinding f12765c;

            /* renamed from: a */
            public void mo1911a(View view) {
                paymentCheckController.onTransferClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_remove_template, "method 'onRemoveTemplateClick'");
        this.view7f09009f = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ PaymentCheckController_ViewBinding f12767c;

            /* renamed from: a */
            public void mo1911a(View view) {
                paymentCheckController.onRemoveTemplateClick();
            }
        });
    }

    public void unbind() {
        PaymentCheckController paymentCheckController = this.target;
        if (paymentCheckController != null) {
            this.target = null;
            paymentCheckController.toolbar = null;
            paymentCheckController.textBalance = null;
            paymentCheckController.textWhere = null;
            paymentCheckController.editTextAmount = null;
            paymentCheckController.textCommission = null;
            paymentCheckController.buttonTransfer = null;
            this.view7f0900a5.setOnClickListener(null);
            this.view7f0900a5 = null;
            this.view7f09009f.setOnClickListener(null);
            this.view7f09009f = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
