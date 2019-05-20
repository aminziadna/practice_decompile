package ru.gg.scooby.ui.controller.panel;

import ru.gg.scooby.ui.dialog.PricePickerDialog.Listener;
import ru.gg.scooby.util.PriceExKt;

/* compiled from: SellPlacePanelController.kt */
public final class SellPlacePanelController$onPriceEdit$1 implements Listener {
    final /* synthetic */ SellPlacePanelController this$0;

    SellPlacePanelController$onPriceEdit$1(SellPlacePanelController sellPlacePanelController) {
        this.this$0 = sellPlacePanelController;
    }

    public void onPriceSet(int i) {
        this.this$0.getParking().setPrice(PriceExKt.toRawPrice(i));
        this.this$0.updatePrice();
    }
}
