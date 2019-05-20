package ru.tinkoff.acquiring.sdk.p221d;

import com.google.gson.p141a.C1687c;
import ru.tinkoff.acquiring.sdk.C2757d;
import ru.tinkoff.acquiring.sdk.av;
import ru.tinkoff.acquiring.sdk.bg;

/* compiled from: FinishAuthorizeResponse */
/* renamed from: ru.tinkoff.acquiring.sdk.d.e */
public final class C4311e extends C2756a {
    /* renamed from: a */
    private transient bg f12940a;
    @C1687c(a = "ACSUrl")
    private String acsUrl;
    @C1687c(a = "Amount")
    private Long amount;
    @C1687c(a = "MD")
    private String md;
    @C1687c(a = "OrderId")
    private String orderId;
    @C1687c(a = "PaReq")
    private String paReq;
    @C1687c(a = "PaymentId")
    private Long paymentId;
    @C1687c(a = "Status")
    private av status;

    /* renamed from: e */
    public bg m18470e() {
        if (this.f12940a == null) {
            if (this.status != av.CONFIRMED) {
                if (this.status != av.AUTHORIZED) {
                    if (this.status == av.THREE_DS_CHECKING) {
                        this.f12940a = new bg(this.paymentId, this.acsUrl, this.md, this.paReq);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("incorrect PaymentStatus ");
                        stringBuilder.append(this.status);
                        throw new C2757d(new IllegalStateException(stringBuilder.toString()));
                    }
                }
            }
            this.f12940a = bg.f8460a;
        }
        return this.f12940a;
    }
}
