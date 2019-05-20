package ru.tinkoff.acquiring.sdk.p221d;

import com.google.gson.p141a.C1687c;
import ru.tinkoff.acquiring.sdk.av;
import ru.tinkoff.acquiring.sdk.bg;

/* compiled from: AttachCardResponse */
/* renamed from: ru.tinkoff.acquiring.sdk.d.c */
public class C4309c extends C2756a {
    /* renamed from: a */
    private transient bg f12938a;
    @C1687c(a = "ACSUrl")
    private String acsUrl;
    @C1687c(a = "CardId")
    private String cardId;
    @C1687c(a = "CustomerKey")
    private String customerKey;
    @C1687c(a = "MD")
    private String md;
    @C1687c(a = "PaReq")
    private String paReq;
    @C1687c(a = "RebillId")
    private String rebillId;
    @C1687c(a = "RequestKey")
    private String requestKey;
    @C1687c(a = "Status")
    private av status;

    /* renamed from: e */
    public String m18465e() {
        return this.requestKey;
    }

    /* renamed from: f */
    public String m18466f() {
        return this.cardId;
    }

    /* renamed from: g */
    public av m18467g() {
        return this.status;
    }

    /* renamed from: h */
    public bg m18468h() {
        if (this.f12938a == null) {
            if (this.status == av.THREE_DS_CHECKING) {
                this.f12938a = new bg(this.requestKey, this.acsUrl, this.md, this.paReq);
            } else {
                this.f12938a = bg.f8460a;
            }
        }
        return this.f12938a;
    }
}
