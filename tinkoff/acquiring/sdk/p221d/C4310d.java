package ru.tinkoff.acquiring.sdk.p221d;

import com.google.gson.p141a.C1687c;
import ru.tinkoff.acquiring.sdk.at;
import ru.tinkoff.acquiring.sdk.av;

/* compiled from: ChargeResponse */
/* renamed from: ru.tinkoff.acquiring.sdk.d.d */
public final class C4310d extends C2756a {
    /* renamed from: a */
    private transient at f12939a;
    @C1687c(a = "Amount")
    private Long amount;
    @C1687c(a = "CardId")
    private String cardId;
    @C1687c(a = "OrderId")
    private String orderId;
    @C1687c(a = "PaymentId")
    private Long paymentId;
    @C1687c(a = "Status")
    private av status;

    /* renamed from: e */
    public at m18469e() {
        if (this.f12939a == null) {
            this.f12939a = new at(this.orderId, this.paymentId, this.amount, this.cardId, m11364b());
        }
        return this.f12939a;
    }
}
