package ru.tinkoff.p213a.p216b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import ru.tinkoff.p213a.p216b.C2721m.C2718a;
import ru.tinkoff.p213a.p216b.C2721m.C2719b;

/* compiled from: BaseNfcActivity */
/* renamed from: ru.tinkoff.a.b.a */
public abstract class C4278a extends Activity implements C2718a, C2719b {
    /* renamed from: a */
    protected C4280l f12873a;

    /* compiled from: BaseNfcActivity */
    /* renamed from: ru.tinkoff.a.b.a$1 */
    class C27031 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4278a f8329a;

        C27031(C4278a c4278a) {
            this.f8329a = c4278a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8329a.finish();
        }
    }

    /* compiled from: BaseNfcActivity */
    /* renamed from: ru.tinkoff.a.b.a$2 */
    class C27042 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4278a f8330a;

        C27042(C4278a c4278a) {
            this.f8330a = c4278a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C2724p.m11234a(this.f8330a, 0);
        }
    }

    /* renamed from: a */
    public abstract String mo2395a();

    /* renamed from: a */
    public void mo1932a(Exception exception) {
    }

    /* renamed from: a */
    public abstract void mo2396a(String str, String str2);

    /* renamed from: a */
    public void mo1933a(C2712j c2712j) {
    }

    /* renamed from: a */
    public void mo1934a(C2713k c2713k) {
    }

    /* renamed from: b */
    public abstract String mo2397b();

    /* renamed from: c */
    public void mo1935c() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12873a = new C4280l(this, this);
        this.f12873a.m11222a((C2719b) this);
    }

    /* renamed from: a */
    public void mo1931a(Bundle bundle) {
        mo2396a(bundle.getString("card_number"), bundle.getString("expire_date"));
    }

    /* renamed from: d */
    public void mo1936d() {
        m18267e();
    }

    /* renamed from: e */
    private void m18267e() {
        new Builder(this).setTitle(mo2395a()).setMessage(mo2397b()).setPositiveButton(17039370, new C27042(this)).setNegativeButton(17039360, new C27031(this)).show();
    }
}
