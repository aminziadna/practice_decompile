package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.PinKeyboard;
import ru.gg.scooby.ui.custom.SmsPinView;
import ru.skooby.R;

public final class PinController_ViewBinding implements Unbinder {
    private PinController target;

    public PinController_ViewBinding(PinController pinController, View view) {
        this.target = pinController;
        pinController.pinKeyboard = (PinKeyboard) C0730b.m2751a(view, R.id.pin_keyboard, "field 'pinKeyboard'", PinKeyboard.class);
        pinController.smsPinView = (SmsPinView) C0730b.m2751a(view, R.id.sms_pin_view, "field 'smsPinView'", SmsPinView.class);
        pinController.titleText = (TextView) C0730b.m2751a(view, R.id.text_title, "field 'titleText'", TextView.class);
        pinController.forgotPasswordButton = (TextView) C0730b.m2751a(view, R.id.btn_forgot_password, "field 'forgotPasswordButton'", TextView.class);
    }

    public void unbind() {
        PinController pinController = this.target;
        if (pinController != null) {
            this.target = null;
            pinController.pinKeyboard = null;
            pinController.smsPinView = null;
            pinController.titleText = null;
            pinController.forgotPasswordButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
