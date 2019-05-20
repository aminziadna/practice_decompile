package ru.gg.scooby.ui.controller;

import android.view.KeyEvent;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.custom.PinKeyboard.Listener;

/* compiled from: PinController.kt */
public final class PinController$onViewBound$2 implements Listener {
    final /* synthetic */ PinController this$0;

    PinController$onViewBound$2(PinController pinController) {
        this.this$0 = pinController;
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        C0700j.m2715b(keyEvent, "keyEvent");
        if (keyEvent.getKeyCode() == 28) {
            this.this$0.getSmsPinView().clearLastDigit();
        } else {
            this.this$0.getSmsPinView().append(keyEvent.getDisplayLabel());
        }
        this.this$0.processEnteredPin();
        this.this$0.updateButtonsState();
    }
}
