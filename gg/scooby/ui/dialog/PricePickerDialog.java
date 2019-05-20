package ru.gg.scooby.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;
import androidx.appcompat.app.C4333c;
import p042b.p043a.C4684f;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.settings.DevSettings;
import ru.skooby.R;

/* compiled from: PricePickerDialog.kt */
public final class PricePickerDialog extends C4333c implements OnClickListener {
    public static final Companion Companion = new Companion();
    private Listener listener;
    private NumberPicker numberPicker;
    private int selectedPrice;

    /* compiled from: PricePickerDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int getRECOMMENDED_PRICE() {
            return DevSettings.INSTANCE.getReducedPrices() ? 1 : 100;
        }

        public final int getPRICE_VALUES_RES() {
            return DevSettings.INSTANCE.getReducedPrices() ? R.array.price_values_reduced : R.array.price_values;
        }

        public final int getPRICE_DESCRIPTIONS_RES() {
            return DevSettings.INSTANCE.getReducedPrices() ? R.array.price_descriptions_reduced : R.array.price_descriptions;
        }
    }

    /* compiled from: PricePickerDialog.kt */
    public interface Listener {
        void onPriceSet(int i);
    }

    public PricePickerDialog(Context context, int i) {
        C0700j.m2715b(context, "context");
        super(context);
        this.selectedPrice = i;
        setTitle((int) R.string.sell_choose_price);
        OnClickListener onClickListener = this;
        setButton(-1, (CharSequence) context.getString(17039370), onClickListener);
        setButton(-2, (CharSequence) context.getString(17039360), onClickListener);
    }

    public /* synthetic */ PricePickerDialog(Context context, int i, int i2, C0697g c0697g) {
        if ((i2 & 2) != 0) {
            i = Companion.getRECOMMENDED_PRICE();
        }
        this(context, i);
    }

    public final int getSelectedPrice() {
        return this.selectedPrice;
    }

    public final void setSelectedPrice(int i) {
        this.selectedPrice = i;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    public final NumberPicker getNumberPicker() {
        return this.numberPicker;
    }

    public final void setNumberPicker(NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    protected void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_price_picker, null, false);
        Object context = getContext();
        C0700j.m2711a(context, "context");
        String[] stringArray = context.getResources().getStringArray(Companion.getPRICE_DESCRIPTIONS_RES());
        Object context2 = getContext();
        C0700j.m2711a(context2, "context");
        context2 = context2.getResources().getIntArray(Companion.getPRICE_VALUES_RES());
        this.numberPicker = (NumberPicker) inflate.findViewById(R.id.number_picker);
        NumberPicker numberPicker = this.numberPicker;
        if (numberPicker != null) {
            numberPicker.setDisplayedValues((String[]) null);
        }
        NumberPicker numberPicker2 = this.numberPicker;
        if (numberPicker2 != null) {
            numberPicker2.setMinValue(0);
        }
        NumberPicker numberPicker3 = this.numberPicker;
        if (numberPicker3 != null) {
            numberPicker3.setMaxValue(stringArray.length - 1);
        }
        numberPicker3 = this.numberPicker;
        if (numberPicker3 != null) {
            numberPicker3.setDisplayedValues(stringArray);
        }
        numberPicker3 = this.numberPicker;
        if (numberPicker3 != null) {
            C0700j.m2711a(context2, "valuesInt");
            numberPicker3.setValue(C4684f.m20933a((int[]) context2, this.selectedPrice));
        }
        numberPicker3 = this.numberPicker;
        if (numberPicker3 != null) {
            numberPicker3.setWrapSelectorWheel(true);
        }
        setView(inflate);
        super.onCreate(bundle);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            Object context = getContext();
            C0700j.m2711a(context, "context");
            dialogInterface = context.getResources().getIntArray(Companion.getPRICE_VALUES_RES());
            i = this.listener;
            if (i != 0) {
                NumberPicker numberPicker = this.numberPicker;
                if (numberPicker == null) {
                    C0700j.m2709a();
                }
                i.onPriceSet(dialogInterface[numberPicker.getValue()]);
            }
        }
    }
}
