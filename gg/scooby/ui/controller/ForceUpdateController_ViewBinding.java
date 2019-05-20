package ru.gg.scooby.ui.controller;

import android.view.View;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class ForceUpdateController_ViewBinding implements Unbinder {
    private ForceUpdateController target;
    private View view7f0900a6;

    public ForceUpdateController_ViewBinding(final ForceUpdateController forceUpdateController, View view) {
        this.target = forceUpdateController;
        view = C0730b.m2750a(view, R.id.btn_update, "method 'onUpdateClick'");
        this.view7f0900a6 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ ForceUpdateController_ViewBinding f12746c;

            /* renamed from: a */
            public void mo1911a(View view) {
                forceUpdateController.onUpdateClick();
            }
        });
    }

    public void unbind() {
        if (this.target != null) {
            this.target = null;
            this.view7f0900a6.setOnClickListener(null);
            this.view7f0900a6 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
