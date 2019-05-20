package ru.tinkoff.acquiring.sdk.p221d;

import com.google.gson.p141a.C1687c;
import java.io.Serializable;

/* compiled from: AcquiringResponse */
/* renamed from: ru.tinkoff.acquiring.sdk.d.a */
public class C2756a implements Serializable {
    @C1687c(a = "Details")
    private String details;
    @C1687c(a = "ErrorCode")
    private String errorCode;
    @C1687c(a = "Message")
    private String message;
    @C1687c(a = "Success")
    private boolean success;
    @C1687c(a = "TerminalKey")
    private String terminalKey;

    protected C2756a(String str, boolean z) {
        this.errorCode = str;
        this.success = z;
    }

    /* renamed from: a */
    public boolean m11363a() {
        return this.success;
    }

    /* renamed from: b */
    public String m11364b() {
        return this.errorCode;
    }

    /* renamed from: c */
    public String m11365c() {
        return this.message;
    }

    /* renamed from: d */
    public String m11366d() {
        return this.details;
    }
}
