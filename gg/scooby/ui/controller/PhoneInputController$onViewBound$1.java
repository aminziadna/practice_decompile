package ru.gg.scooby.ui.controller;

import android.view.KeyEvent;
import p042b.C0724k;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.custom.PinKeyboard.Listener;

/* compiled from: PhoneInputController.kt */
public final class PhoneInputController$onViewBound$1 implements Listener {
    final /* synthetic */ PhoneInputController this$0;

    PhoneInputController$onViewBound$1(PhoneInputController phoneInputController) {
        this.this$0 = phoneInputController;
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        C0700j.m2715b(keyEvent, "keyEvent");
        String obj = this.this$0.getPhoneEditText().getText().toString();
        if (keyEvent.getKeyCode() == 28) {
            if ((((CharSequence) obj).length() > null ? true : null) != null) {
                keyEvent = this.this$0.getPhoneEditText();
                int length = obj.length() - 1;
                if (obj != null) {
                    Object substring = obj.substring(0, length);
                    C0700j.m2711a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    keyEvent.setText((CharSequence) substring);
                    this.this$0.getPhoneEditText().setSelection(obj.length() - 1);
                    return;
                }
                throw new C0724k("null cannot be cast to non-null type java.lang.String");
            }
            return;
        }
        this.this$0.getPhoneEditText().append(String.valueOf(keyEvent.getDisplayLabel()));
    }
}
