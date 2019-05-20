package ru.tinkoff.acquiring.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PayFormHandler */
class ar extends Handler {
    /* renamed from: a */
    static ar f8385a = new ar();
    /* renamed from: b */
    private Set<af> f8386b = new HashSet();

    public ar() {
        super(Looper.getMainLooper());
    }

    /* renamed from: a */
    public void m11311a(af afVar) {
        this.f8386b.add(afVar);
    }

    /* renamed from: b */
    public void m11312b(af afVar) {
        this.f8386b.remove(afVar);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                for (af a : this.f8386b) {
                    a.mo2597a((C2766h[]) message.obj);
                }
                return;
            case 1:
                for (af a2 : this.f8386b) {
                    a2.mo2596a((C2766h) message.obj);
                }
                return;
            case 2:
                for (af a22 : this.f8386b) {
                    a22.mo2594a((Long) message.obj);
                }
                return;
            case 3:
                for (af a222 : this.f8386b) {
                    a222.mo2595a((at) message.obj);
                }
                return;
            case 4:
                for (af c : this.f8386b) {
                    c.mo2598c();
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
