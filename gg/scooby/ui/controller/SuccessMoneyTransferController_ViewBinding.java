package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class SuccessMoneyTransferController_ViewBinding implements Unbinder {
    private SuccessMoneyTransferController target;
    private View view7f090090;

    public SuccessMoneyTransferController_ViewBinding(final SuccessMoneyTransferController successMoneyTransferController, View view) {
        this.target = successMoneyTransferController;
        successMoneyTransferController.textMoney = (TextView) C0730b.m2751a(view, R.id.text_money, "field 'textMoney'", TextView.class);
        view = C0730b.m2750a(view, R.id.btn_finish, "method 'onFinishClick'");
        this.view7f090090 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SuccessMoneyTransferController_ViewBinding f12814c;

            /* renamed from: a */
            public void mo1911a(View view) {
                successMoneyTransferController.onFinishClick();
            }
        });
    }

    public void unbind() {
        SuccessMoneyTransferController successMoneyTransferController = this.target;
        if (successMoneyTransferController != null) {
            this.target = null;
            successMoneyTransferController.textMoney = null;
            this.view7f090090.setOnClickListener(null);
            this.view7f090090 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
