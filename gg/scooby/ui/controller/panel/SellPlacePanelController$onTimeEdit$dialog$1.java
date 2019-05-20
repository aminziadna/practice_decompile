package ru.gg.scooby.ui.controller.panel;

import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;
import ru.gg.scooby.util.DateUtils;

/* compiled from: SellPlacePanelController.kt */
public final class SellPlacePanelController$onTimeEdit$dialog$1 implements OnTimeSetListener {
    final /* synthetic */ SellPlacePanelController this$0;

    SellPlacePanelController$onTimeEdit$dialog$1(SellPlacePanelController sellPlacePanelController) {
        this.this$0 = sellPlacePanelController;
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.this$0.getParking().setTimeLong(DateUtils.INSTANCE.todayOrTomorrowByHourAndMinutes(i, i2).getTimeInMillis());
        this.this$0.updateTime();
    }
}
