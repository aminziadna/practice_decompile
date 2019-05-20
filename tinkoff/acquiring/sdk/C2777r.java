package ru.tinkoff.acquiring.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CommonSdkHandler */
/* renamed from: ru.tinkoff.acquiring.sdk.r */
public class C2777r extends Handler {
    /* renamed from: a */
    static C2777r f8527a = new C2777r();
    /* renamed from: b */
    private Set<aa> f8528b = new HashSet();

    public C2777r() {
        super(Looper.getMainLooper());
    }

    /* renamed from: a */
    public void m11416a(aa aaVar) {
        this.f8528b.add(aaVar);
    }

    /* renamed from: b */
    public void m11417b(aa aaVar) {
        this.f8528b.remove(aaVar);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                for (aa a : this.f8528b) {
                    a.mo2585a();
                }
                return;
            case 1:
                for (aa a2 : this.f8528b) {
                    a2.mo2590b();
                }
                return;
            case 2:
                for (aa a3 : this.f8528b) {
                    a3.mo2588a((Exception) message.obj);
                }
                return;
            case 3:
                for (aa a32 : this.f8528b) {
                    a32.mo2589a((bg) message.obj);
                }
                return;
            case 4:
                for (aa a322 : this.f8528b) {
                    a322.mo2586a((Exception) message.obj);
                }
                return;
            case 5:
                for (aa a22 : this.f8528b) {
                    a22.mo2592e();
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
