package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.PinKeyboard;
import ru.gg.scooby.ui.custom.SmsPinView;
import ru.skooby.R;

public final class SmsPinController_ViewBinding implements Unbinder {
    private SmsPinController target;

    public SmsPinController_ViewBinding(SmsPinController smsPinController, View view) {
        this.target = smsPinController;
        smsPinController.pinKeyboard = (PinKeyboard) C0730b.m2751a(view, R.id.pin_keyboard, "field 'pinKeyboard'", PinKeyboard.class);
        smsPinController.smsPinView = (SmsPinView) C0730b.m2751a(view, R.id.sms_pin_view, "field 'smsPinView'", SmsPinView.class);
        smsPinController.sendCodeAgainButton = (TextView) C0730b.m2751a(view, R.id.btn_send_again, "field 'sendCodeAgainButton'", TextView.class);
        smsPinController.nextButton = (TextView) C0730b.m2751a(view, R.id.btn_next, "field 'nextButton'", TextView.class);
        smsPinController.subtitleText = (TextView) C0730b.m2751a(view, R.id.text_subtitle, "field 'subtitleText'", TextView.class);
        smsPinController.backButton = C0730b.m2750a(view, R.id.btn_back, "field 'backButton'");
    }

    public void unbind() {
        SmsPinController smsPinController = this.target;
        if (smsPinController != null) {
            this.target = null;
            smsPinController.pinKeyboard = null;
            smsPinController.smsPinView = null;
            smsPinController.sendCodeAgainButton = null;
            smsPinController.nextButton = null;
            smsPinController.subtitleText = null;
            smsPinController.backButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
