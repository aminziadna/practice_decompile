package ru.tinkoff.p213a.p216b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import ru.tinkoff.p213a.p216b.C2721m.C2718a;

/* compiled from: NfcAutoRecognizer */
/* renamed from: ru.tinkoff.a.b.l */
public class C4280l extends C2721m {
    /* renamed from: c */
    private Activity f12878c;
    /* renamed from: d */
    private C2715a f12879d;

    /* compiled from: NfcAutoRecognizer */
    /* renamed from: ru.tinkoff.a.b.l$a */
    private class C2715a implements ActivityLifecycleCallbacks {
        /* renamed from: a */
        final /* synthetic */ C4280l f8336a;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private C2715a(C4280l c4280l) {
            this.f8336a = c4280l;
        }

        public void onActivityResumed(Activity activity) {
            if (this.f8336a.f12878c == activity) {
                this.f8336a.m11219a(activity);
                this.f8336a.m11223b(activity);
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f8336a.f12878c == activity) {
                this.f8336a.m11224c(activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f8336a.f12878c == activity) {
                this.f8336a.f12878c.getApplication().unregisterActivityLifecycleCallbacks(this);
                this.f8336a.f12878c = null;
                this.f8336a.f12879d = null;
                this.f8336a.m11218a();
            }
        }
    }

    public C4280l(Activity activity, C2718a c2718a) {
        this(activity, c2718a, null, null);
    }

    public C4280l(Activity activity, C2718a c2718a, C2710h c2710h, C2708f c2708f) {
        super(c2710h, c2708f);
        this.f12878c = activity;
        this.f12879d = new C2715a();
        m11221a(c2718a);
        this.f12878c.getApplication().registerActivityLifecycleCallbacks(this.f12879d);
    }
}
