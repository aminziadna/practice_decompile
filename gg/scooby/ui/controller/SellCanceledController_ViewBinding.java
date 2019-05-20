package ru.gg.scooby.ui.controller;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class SellCanceledController_ViewBinding implements Unbinder {
    private SellCanceledController target;
    private View view7f090057;
    private View view7f090064;
    private View view7f090065;

    public SellCanceledController_ViewBinding(final SellCanceledController sellCanceledController, View view) {
        this.target = sellCanceledController;
        sellCanceledController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View a = C0730b.m2750a(view, R.id.block_cant_find_buyer, "method 'onReasonClick'");
        this.view7f090057 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellCanceledController_ViewBinding f12801c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellCanceledController.onReasonClick(view);
            }
        });
        a = C0730b.m2750a(view, R.id.block_other_car_parked, "method 'onReasonClick'");
        this.view7f090065 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellCanceledController_ViewBinding f12803c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellCanceledController.onReasonClick(view);
            }
        });
        view = C0730b.m2750a(view, R.id.block_other, "method 'onReasonClick'");
        this.view7f090064 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ SellCanceledController_ViewBinding f12805c;

            /* renamed from: a */
            public void mo1911a(View view) {
                sellCanceledController.onReasonClick(view);
            }
        });
    }

    public void unbind() {
        SellCanceledController sellCanceledController = this.target;
        if (sellCanceledController != null) {
            this.target = null;
            sellCanceledController.toolbar = null;
            this.view7f090057.setOnClickListener(null);
            this.view7f090057 = null;
            this.view7f090065.setOnClickListener(null);
            this.view7f090065 = null;
            this.view7f090064.setOnClickListener(null);
            this.view7f090064 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
