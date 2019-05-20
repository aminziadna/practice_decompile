package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class CarNumberController_ViewBinding implements Unbinder {
    private CarNumberController target;

    public CarNumberController_ViewBinding(CarNumberController carNumberController, View view) {
        this.target = carNumberController;
        carNumberController.textNumber = (TextView) C0730b.m2751a(view, R.id.text_number, "field 'textNumber'", TextView.class);
        carNumberController.submitButton = (TextView) C0730b.m2751a(view, R.id.btn_submit, "field 'submitButton'", TextView.class);
        carNumberController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public void unbind() {
        CarNumberController carNumberController = this.target;
        if (carNumberController != null) {
            this.target = null;
            carNumberController.textNumber = null;
            carNumberController.submitButton = null;
            carNumberController.toolbar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
