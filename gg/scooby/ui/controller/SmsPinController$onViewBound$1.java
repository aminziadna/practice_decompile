package ru.gg.scooby.ui.controller;

import android.view.KeyEvent;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.ui.custom.PinKeyboard.Listener;

/* compiled from: SmsPinController.kt */
public final class SmsPinController$onViewBound$1 implements Listener {
    final /* synthetic */ SmsPinController this$0;

    SmsPinController$onViewBound$1(SmsPinController smsPinController) {
        this.this$0 = smsPinController;
    }

    public void onKeyPressed(KeyEvent keyEvent) {
        C0700j.m2715b(keyEvent, "keyEvent");
        if (keyEvent.getKeyCode() == 28) {
            this.this$0.getSmsPinView().clearLastDigit();
        } else {
            this.this$0.getSmsPinView().append(keyEvent.getDisplayLabel());
        }
        this.this$0.updateButtonsState();
    }
}
