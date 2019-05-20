package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.PinKeyboard;
import ru.skooby.R;

public final class PhoneInputController_ViewBinding implements Unbinder {
    private PhoneInputController target;
    private View view7f09008e;

    public PhoneInputController_ViewBinding(final PhoneInputController phoneInputController, View view) {
        this.target = phoneInputController;
        phoneInputController.pinKeyboard = (PinKeyboard) C0730b.m2751a(view, R.id.pin_keyboard, "field 'pinKeyboard'", PinKeyboard.class);
        phoneInputController.phoneEditText = (EditText) C0730b.m2751a(view, R.id.phone_edit_text, "field 'phoneEditText'", EditText.class);
        phoneInputController.nextButton = (TextView) C0730b.m2751a(view, R.id.btn_next, "field 'nextButton'", TextView.class);
        phoneInputController.termsText = (TextView) C0730b.m2751a(view, R.id.text_terms, "field 'termsText'", TextView.class);
        view = C0730b.m2750a(view, R.id.btn_dev_settings, "field 'devSettingsButton' and method 'onDevSettingsClick'");
        phoneInputController.devSettingsButton = (TextView) C0730b.m2753b(view, R.id.btn_dev_settings, "field 'devSettingsButton'", TextView.class);
        this.view7f09008e = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ PhoneInputController_ViewBinding f12770c;

            /* renamed from: a */
            public void mo1911a(View view) {
                phoneInputController.onDevSettingsClick();
            }
        });
    }

    public void unbind() {
        PhoneInputController phoneInputController = this.target;
        if (phoneInputController != null) {
            this.target = null;
            phoneInputController.pinKeyboard = null;
            phoneInputController.phoneEditText = null;
            phoneInputController.nextButton = null;
            phoneInputController.termsText = null;
            phoneInputController.devSettingsButton = null;
            this.view7f09008e.setOnClickListener(null);
            this.view7f09008e = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
