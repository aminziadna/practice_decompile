package ru.tinkoff.acquiring.sdk;

import com.google.gson.p141a.C1687c;
import java.io.Serializable;

/* compiled from: Card */
/* renamed from: ru.tinkoff.acquiring.sdk.h */
public class C2766h implements Serializable {
    @C1687c(a = "CardId")
    private String cardId;
    @C1687c(a = "Pan")
    private String pan;
    @C1687c(a = "RebillId")
    private String rebillId;
    @C1687c(a = "Status")
    private C2773m status;

    /* renamed from: a */
    public String m11386a() {
        return this.pan;
    }

    /* renamed from: b */
    public String m11387b() {
        return this.cardId;
    }

    /* renamed from: c */
    public C2773m m11388c() {
        return this.status;
    }

    /* renamed from: d */
    public String m11389d() {
        return this.rebillId;
    }
}
