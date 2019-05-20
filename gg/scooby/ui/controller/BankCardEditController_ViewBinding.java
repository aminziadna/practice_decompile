package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class BankCardEditController_ViewBinding implements Unbinder {
    private BankCardEditController target;
    private View view7f09008d;

    public BankCardEditController_ViewBinding(final BankCardEditController bankCardEditController, View view) {
        this.target = bankCardEditController;
        bankCardEditController.textCardNumber = (TextView) C0730b.m2751a(view, R.id.text_value, "field 'textCardNumber'", TextView.class);
        bankCardEditController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        view = C0730b.m2750a(view, R.id.btn_delete, "method 'onDelete'");
        this.view7f09008d = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BankCardEditController_ViewBinding f12692c;

            /* renamed from: a */
            public void mo1911a(View view) {
                bankCardEditController.onDelete();
            }
        });
    }

    public void unbind() {
        BankCardEditController bankCardEditController = this.target;
        if (bankCardEditController != null) {
            this.target = null;
            bankCardEditController.textCardNumber = null;
            bankCardEditController.toolbar = null;
            this.view7f09008d.setOnClickListener(null);
            this.view7f09008d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
