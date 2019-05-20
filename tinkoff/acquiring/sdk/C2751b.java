package ru.tinkoff.acquiring.sdk;

import io.card.payment.BuildConfig;
import ru.tinkoff.acquiring.sdk.p221d.C2756a;

/* compiled from: AcquiringApiException */
/* renamed from: ru.tinkoff.acquiring.sdk.b */
public class C2751b extends Exception {
    private C2756a response;

    public C2751b(C2756a c2756a, String str) {
        super(str);
        this.response = c2756a;
    }

    public C2751b(C2756a c2756a) {
        super(BuildConfig.FLAVOR);
        this.response = c2756a;
    }

    /* renamed from: a */
    public C2756a m11337a() {
        return this.response;
    }
}
