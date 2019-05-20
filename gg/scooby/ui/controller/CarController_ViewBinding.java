package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class CarController_ViewBinding implements Unbinder {
    private CarController target;
    private View view7f090056;
    private View view7f09005c;
    private View view7f090061;
    private View view7f090063;
    private View view7f0900a3;

    public CarController_ViewBinding(final CarController carController, View view) {
        this.target = carController;
        carController.textBrand = (TextView) C0730b.m2751a(view, R.id.text_brand, "field 'textBrand'", TextView.class);
        carController.textModel = (TextView) C0730b.m2751a(view, R.id.text_model, "field 'textModel'", TextView.class);
        carController.textNumber = (TextView) C0730b.m2751a(view, R.id.text_number, "field 'textNumber'", TextView.class);
        carController.textColor = (TextView) C0730b.m2751a(view, R.id.text_color, "field 'textColor'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_submit, "field 'submitButton' and method 'onSubmitClick'");
        carController.submitButton = (TextView) C0730b.m2753b(a, R.id.btn_submit, "field 'submitButton'", TextView.class);
        this.view7f0900a3 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CarController_ViewBinding f12712c;

            /* renamed from: a */
            public void mo1911a(View view) {
                carController.onSubmitClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_model, "field 'blockModel' and method 'onModelClick'");
        carController.blockModel = a;
        this.view7f090061 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CarController_ViewBinding f12714c;

            /* renamed from: a */
            public void mo1911a(View view) {
                carController.onModelClick();
            }
        });
        carController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        a = C0730b.m2750a(view, R.id.block_brand, "method 'onBrandClick'");
        this.view7f090056 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CarController_ViewBinding f12716c;

            /* renamed from: a */
            public void mo1911a(View view) {
                carController.onBrandClick();
            }
        });
        a = C0730b.m2750a(view, R.id.block_number, "method 'onNumberClick'");
        this.view7f090063 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CarController_ViewBinding f12718c;

            /* renamed from: a */
            public void mo1911a(View view) {
                carController.onNumberClick();
            }
        });
        view = C0730b.m2750a(view, R.id.block_color, "method 'onColorClick'");
        this.view7f09005c = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ CarController_ViewBinding f12720c;

            /* renamed from: a */
            public void mo1911a(View view) {
                carController.onColorClick();
            }
        });
    }

    public void unbind() {
        CarController carController = this.target;
        if (carController != null) {
            this.target = null;
            carController.textBrand = null;
            carController.textModel = null;
            carController.textNumber = null;
            carController.textColor = null;
            carController.submitButton = null;
            carController.blockModel = null;
            carController.toolbar = null;
            this.view7f0900a3.setOnClickListener(null);
            this.view7f0900a3 = null;
            this.view7f090061.setOnClickListener(null);
            this.view7f090061 = null;
            this.view7f090056.setOnClickListener(null);
            this.view7f090056 = null;
            this.view7f090063.setOnClickListener(null);
            this.view7f090063 = null;
            this.view7f09005c.setOnClickListener(null);
            this.view7f09005c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
