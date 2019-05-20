package ru.tinkoff.acquiring.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.C4746d;
import androidx.fragment.app.C2968d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.tinkoff.acquiring.sdk.C4680v.C2787a;
import ru.tinkoff.acquiring.sdk.ax.C2736b;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;
import ru.tinkoff.acquiring.sdk.ax.C2743i;
import ru.tinkoff.acquiring.sdk.p221d.C2756a;
import ru.tinkoff.acquiring.sdk.views.BankKeyboard;

public class PayFormActivity extends C4746d implements af {
    /* renamed from: a */
    private C2809w f14634a = new C2809w();
    /* renamed from: b */
    private Long f14635b;
    /* renamed from: c */
    private C2780u f14636c;
    /* renamed from: d */
    private C4307c f14637d;
    /* renamed from: e */
    private C2772l f14638e;
    /* renamed from: f */
    private C2766h[] f14639f;
    /* renamed from: g */
    private C2766h f14640g;
    /* renamed from: h */
    private boolean f14641h;
    /* renamed from: i */
    private boolean f14642i;
    /* renamed from: j */
    private boolean f14643j;

    /* renamed from: ru.tinkoff.acquiring.sdk.PayFormActivity$2 */
    class C27292 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PayFormActivity f8359a;

        C27292(PayFormActivity payFormActivity) {
            this.f8359a = payFormActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8359a.setResult(0);
            this.f8359a.finish();
        }
    }

    /* renamed from: a */
    public static as m22169a(String str, String str2, String str3) {
        return new as(str, str2, str3);
    }

    /* renamed from: f */
    public C4307c mo2593f() {
        return this.f14637d;
    }

    /* renamed from: d */
    C2772l m22190d() {
        return this.f14638e;
    }

    /* renamed from: g */
    C2766h[] m22193g() {
        return this.f14639f;
    }

    /* renamed from: h */
    C2766h m22194h() {
        return this.f14640g;
    }

    /* renamed from: b */
    void m22188b(C2766h c2766h) {
        this.f14640g = c2766h;
    }

    /* renamed from: i */
    boolean m22195i() {
        return this.f14641h;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("theme", 0);
        if (intExtra != 0) {
            setTheme(intExtra);
        }
        this.f14634a.m11432a(bundle);
        setRequestedOrientation(1);
        setContentView(C2741g.acq_activity);
        getSupportActionBar().mo137a(true);
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(C2736b.acqPayFormTitle, typedValue, true);
        setTitle(getResources().getString(typedValue.resourceId));
        this.f14636c = new C2780u(this);
        String stringExtra = intent.getStringExtra("terminal_key");
        String stringExtra2 = intent.getStringExtra("password");
        String stringExtra3 = intent.getStringExtra("public_key");
        this.f14643j = intent.getBooleanExtra("charge_mode", false);
        this.f14637d = new C4307c(stringExtra, stringExtra2, stringExtra3);
        this.f14638e = new C2772l(this.f14637d);
        this.f14641h = intent.getBooleanExtra("keyboard", false);
        if (bundle == null) {
            this.f14642i = false;
            if (intent.hasExtra("extra_payment_info") != null) {
                m22172q();
                return;
            } else if (intent.hasExtra("extra_three_ds") != null) {
                m22173r();
                return;
            } else {
                m22199m();
                if (m22202p() != null) {
                    String stringExtra4 = intent.getStringExtra("customer_key");
                    m22196j();
                    m22170a(stringExtra4, this.f14638e);
                    return;
                }
                return;
            }
        }
        this.f14639f = new C2775o().m11415a(bundle.getBundle("cards"));
        bundle = bundle.getInt("card_idx", -1);
        if (bundle != -1) {
            this.f14640g = this.f14639f[bundle];
        }
    }

    /* renamed from: q */
    private void m22172q() {
        Bundle bundleExtra = getIntent().getBundleExtra("extra_payment_info");
        C2766h[] a = new C2775o().m11415a(getIntent().getBundleExtra("extra_card_data"));
        final at a2 = new au().m11323a(bundleExtra);
        m22199m();
        C2968d a3 = m22176a(false);
        getSupportFragmentManager().mo425a().mo408a(C2740f.content_frame, a3).mo413b();
        mo2597a(a);
        a3.m20699a(new C2787a(this) {
            /* renamed from: b */
            final /* synthetic */ PayFormActivity f12885b;

            /* renamed from: a */
            public void mo1941a() {
                this.f12885b.mo2595a(a2);
            }
        });
    }

    /* renamed from: r */
    private void m22173r() {
        mo2589a(new bf().m11339a(getIntent().getBundleExtra("extra_three_ds")));
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f14634a.m11433b(bundle);
        bundle.putBundle("cards", new C2775o().m11414a(this.f14639f));
        if (this.f14640g != null && this.f14639f != null) {
            int i = 0;
            while (true) {
                C2766h[] c2766hArr = this.f14639f;
                if (i >= c2766hArr.length) {
                    return;
                }
                if (this.f14640g == c2766hArr[i]) {
                    bundle.putInt("card_idx", i);
                    return;
                }
                i++;
            }
        }
    }

    protected void onStart() {
        super.onStart();
        ar.f8385a.m11311a(this);
        C2777r.f8527a.m11416a(this);
    }

    protected void onStop() {
        super.onStop();
        this.f14636c.m11425b();
        ar.f8385a.m11312b(this);
        C2777r.f8527a.m11417b(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C2968d a = getSupportFragmentManager().mo423a(C2740f.content_frame);
        if (a != null) {
            a.mo2216a(i, i2, intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m22174s();
        return true;
    }

    /* renamed from: a */
    public void mo2585a() {
        m22197k();
        Intent intent = new Intent();
        intent.putExtra("payment_id", this.f14635b);
        setResult(-1, intent);
        if (m22202p()) {
            this.f14638e.m11410c(getIntent().getStringExtra("customer_key"));
        }
        finish();
    }

    /* renamed from: b */
    public void mo2590b() {
        setResult(0);
        finish();
    }

    /* renamed from: j */
    public void m22196j() {
        if (!this.f14636c.m11426c()) {
            this.f14636c.m11422a(getString(C2743i.acq_progress_dialog_text));
        }
    }

    /* renamed from: k */
    public void m22197k() {
        this.f14636c.m11421a();
    }

    /* renamed from: a */
    public void mo2588a(Throwable th) {
        m22197k();
        if (th instanceof C2751b) {
            Toast.makeText(this, th.getMessage(), 1).show();
        }
        Intent intent = new Intent();
        intent.putExtra("error", th);
        setResult(BankKeyboard.KEYBOARD_SHOW_DELAY_MILLIS, intent);
        finish();
    }

    /* renamed from: a */
    public void mo2589a(bg bgVar) {
        m22197k();
        getSupportFragmentManager().mo425a().mo408a(C2740f.content_frame, m22186b(bgVar)).mo413b();
    }

    /* renamed from: a */
    public void mo2586a(Exception exception) {
        exception = exception.getMessage();
        if (TextUtils.isEmpty(exception)) {
            exception = getString(C2743i.acq_default_error_message);
        }
        this.f14636c.m11423a(getString(C2743i.acq_default_error_title), exception);
    }

    /* renamed from: e */
    public void mo2592e() {
        this.f14636c.m11424a(getString(C2743i.acq_default_error_title), getString(C2743i.acq_network_error_message), new C27292(this));
        m22197k();
    }

    /* renamed from: a */
    public void mo2597a(C2766h[] c2766hArr) {
        m22197k();
        boolean booleanExtra = getIntent().getBooleanExtra("use_first_saved_card", true);
        this.f14639f = m22171b(c2766hArr);
        if (!this.f14642i && this.f14640g == null && c2766hArr != null && c2766hArr.length > null) {
            c2766hArr = getIntent().getStringExtra("card_id");
            if (c2766hArr != null) {
                this.f14640g = this.f14638e.m11409b(c2766hArr);
            }
            if (booleanExtra) {
                c2766hArr = this.f14639f;
                if (c2766hArr.length > 0 && this.f14640g == null) {
                    this.f14640g = c2766hArr[0];
                }
            }
        }
        this.f14642i = true;
        c2766hArr = getSupportFragmentManager().mo423a(C2740f.content_frame);
        if (c2766hArr != null && (c2766hArr instanceof ac)) {
            ((ac) c2766hArr).mo2056a();
        }
    }

    /* renamed from: a */
    public void mo2596a(C2766h c2766h) {
        this.f14638e.m11410c(getIntent().getStringExtra("customer_key"));
        if (this.f14640g == c2766h) {
            this.f14640g = null;
        }
        C2766h[] c2766hArr = this.f14639f;
        if (c2766hArr.length == 1 && c2766hArr[0] == c2766h) {
            this.f14639f = new C2766h[0];
        } else {
            List arrayList = new ArrayList(Arrays.asList(this.f14639f));
            arrayList.remove(c2766h);
            c2766h = new C2766h[arrayList.size()];
            arrayList.toArray(c2766h);
            this.f14639f = c2766h;
        }
        mo2597a(this.f14639f);
    }

    /* renamed from: a */
    public void mo2594a(Long l) {
        this.f14635b = l;
    }

    /* renamed from: a */
    public void mo2595a(at atVar) {
        m22197k();
        C2968d a = getSupportFragmentManager().mo423a(C2740f.content_frame);
        if (a != null && (a instanceof ad)) {
            ((ad) a).mo2399a(atVar);
        }
    }

    /* renamed from: c */
    public void mo2598c() {
        m22197k();
        this.f14636c.m11423a(getString(C2743i.acq_default_error_title), getString(C2743i.acq_default_error_message));
    }

    /* renamed from: a */
    public void m22180a(String str) {
        str = this.f14638e.m11409b(str);
        if (str != null) {
            this.f14640g = str;
        }
    }

    public void onBackPressed() {
        C2968d a = getSupportFragmentManager().mo423a(C2740f.content_frame);
        if (!(a instanceof aq) || !((aq) a).ai()) {
            m22174s();
        }
    }

    /* renamed from: l */
    public C2809w m22198l() {
        return this.f14634a;
    }

    /* renamed from: b */
    protected bh m22186b(bg bgVar) {
        return bh.m20616c(new bf().m11338a(bgVar));
    }

    /* renamed from: a */
    protected C4680v m22176a(boolean z) {
        return C4680v.m20661a(z);
    }

    /* renamed from: a */
    protected C4679j m22175a(String str, boolean z) {
        return C4679j.m20640a(str, z);
    }

    /* renamed from: m */
    void m22199m() {
        getSupportFragmentManager().mo425a().mo408a(C2740f.content_frame, m22176a(this.f14643j)).mo413b();
    }

    /* renamed from: n */
    void m22200n() {
        getSupportFragmentManager().mo425a().mo408a(C2740f.content_frame, m22175a(getIntent().getStringExtra("customer_key"), this.f14643j)).mo411a("choose_card").mo413b();
    }

    /* renamed from: o */
    void m22201o() {
        getSupportFragmentManager().mo427a("choose_card", 1);
    }

    /* renamed from: a */
    static void m22170a(final String str, final C2772l c2772l) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    ar.f8385a.obtainMessage(0, c2772l.m11408a(str)).sendToTarget();
                } catch (Throwable e) {
                    Throwable cause = e.getCause();
                    if (cause == null) {
                        ai.m11291a(e);
                        ar.f8385a.obtainMessage(0, new C2766h[0]).sendToTarget();
                    } else if (cause instanceof C2751b) {
                        C2756a a = ((C2751b) cause).m11337a();
                        if (a == null || !"7".equals(a.m11364b())) {
                            C2777r.f8527a.obtainMessage(2, cause).sendToTarget();
                        } else {
                            ar.f8385a.obtainMessage(0, new C2766h[0]).sendToTarget();
                        }
                    } else if (cause instanceof ap) {
                        C2777r.f8527a.obtainMessage(5).sendToTarget();
                    } else {
                        ai.m11291a(cause);
                        ar.f8385a.obtainMessage(0, new C2766h[0]).sendToTarget();
                    }
                }
            }
        }).start();
    }

    /* renamed from: p */
    public boolean m22202p() {
        return getIntent().getStringExtra("customer_key") != null;
    }

    /* renamed from: s */
    private void m22174s() {
        if (getSupportFragmentManager().mo430c() == 0) {
            setResult(0);
        }
        super.onBackPressed();
    }

    /* renamed from: b */
    private C2766h[] m22171b(C2766h[] c2766hArr) {
        if (!this.f14643j) {
            return c2766hArr;
        }
        ArrayList arrayList = new ArrayList();
        for (C2766h c2766h : c2766hArr) {
            if (!TextUtils.isEmpty(c2766h.m11389d())) {
                arrayList.add(c2766h);
            }
        }
        return (C2766h[]) arrayList.toArray(new C2766h[arrayList.size()]);
    }
}
