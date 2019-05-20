package ru.tinkoff.acquiring.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* compiled from: AttachCardFormHandler */
/* renamed from: ru.tinkoff.acquiring.sdk.f */
public class C2764f extends Handler {
    /* renamed from: a */
    static C2764f f8487a = new C2764f();
    /* renamed from: b */
    private Set<C4326z> f8488b = new HashSet();

    public C2764f() {
        super(Looper.getMainLooper());
    }

    /* renamed from: a */
    public void m11379a(C4326z c4326z) {
        this.f8488b.add(c4326z);
    }

    /* renamed from: b */
    public void m11380b(C4326z c4326z) {
        this.f8488b.remove(c4326z);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                for (C4326z a : this.f8488b) {
                    a.mo2587a((String) message.obj);
                }
                return;
            case 1:
                for (C4326z a2 : this.f8488b) {
                    a2.mo2591b((String) message.obj);
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
