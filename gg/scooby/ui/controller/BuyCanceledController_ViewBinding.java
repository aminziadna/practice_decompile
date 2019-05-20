package ru.gg.scooby.ui.controller;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class BuyCanceledController_ViewBinding implements Unbinder {
    private BuyCanceledController target;
    private View view7f090053;
    private View view7f090058;
    private View view7f090064;
    private View view7f090065;

    public BuyCanceledController_ViewBinding(final BuyCanceledController buyCanceledController, View view) {
        this.target = buyCanceledController;
        buyCanceledController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        View a = C0730b.m2750a(view, R.id.block_cant_find_seller, "method 'onReasonClick'");
        this.view7f090058 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BuyCanceledController_ViewBinding f12702c;

            /* renamed from: a */
            public void mo1911a(View view) {
                buyCanceledController.onReasonClick(view);
            }
        });
        a = C0730b.m2750a(view, R.id.block_other_car_parked, "method 'onReasonClick'");
        this.view7f090065 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BuyCanceledController_ViewBinding f12704c;

            /* renamed from: a */
            public void mo1911a(View view) {
                buyCanceledController.onReasonClick(view);
            }
        });
        a = C0730b.m2750a(view, R.id.block_another_place, "method 'onReasonClick'");
        this.view7f090053 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BuyCanceledController_ViewBinding f12706c;

            /* renamed from: a */
            public void mo1911a(View view) {
                buyCanceledController.onReasonClick(view);
            }
        });
        view = C0730b.m2750a(view, R.id.block_other, "method 'onReasonClick'");
        this.view7f090064 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BuyCanceledController_ViewBinding f12708c;

            /* renamed from: a */
            public void mo1911a(View view) {
                buyCanceledController.onReasonClick(view);
            }
        });
    }

    public void unbind() {
        BuyCanceledController buyCanceledController = this.target;
        if (buyCanceledController != null) {
            this.target = null;
            buyCanceledController.toolbar = null;
            this.view7f090058.setOnClickListener(null);
            this.view7f090058 = null;
            this.view7f090065.setOnClickListener(null);
            this.view7f090065 = null;
            this.view7f090053.setOnClickListener(null);
            this.view7f090053 = null;
            this.view7f090064.setOnClickListener(null);
            this.view7f090064 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
