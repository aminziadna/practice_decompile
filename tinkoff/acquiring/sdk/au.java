package ru.tinkoff.acquiring.sdk;

import android.os.Bundle;

/* compiled from: PaymentInfoBundlePacker */
public class au {
    /* renamed from: a */
    public at m11323a(Bundle bundle) {
        String string = bundle.getString("extra_order_id");
        long j = bundle.getLong("extra_payment_id");
        long j2 = bundle.getLong("extra_amount");
        String string2 = bundle.getString("extra_card_id");
        String string3 = bundle.getString("extra_error_code");
        return new at(string, Long.valueOf(j), Long.valueOf(j2), string2, string3);
    }
}
