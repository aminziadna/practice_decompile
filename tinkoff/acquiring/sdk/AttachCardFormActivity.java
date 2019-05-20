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
import ru.tinkoff.acquiring.sdk.ax.C2736b;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;
import ru.tinkoff.acquiring.sdk.ax.C2743i;
import ru.tinkoff.acquiring.sdk.views.BankKeyboard;

public class AttachCardFormActivity extends C4746d implements C4326z {
    /* renamed from: a */
    private C2780u f14630a;
    /* renamed from: b */
    private C4307c f14631b;
    /* renamed from: c */
    private boolean f14632c;
    /* renamed from: d */
    private String f14633d;

    /* renamed from: ru.tinkoff.acquiring.sdk.AttachCardFormActivity$1 */
    class C27281 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ AttachCardFormActivity f8358a;

        C27281(AttachCardFormActivity attachCardFormActivity) {
            this.f8358a = attachCardFormActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8358a.setResult(0);
            this.f8358a.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        m22151a(intent);
        this.f14630a = new C2780u(this);
        this.f14631b = m22152b(intent);
        this.f14632c = intent.getBooleanExtra("keyboard", false);
        if (bundle == null) {
            m22154j();
        }
    }

    protected void onStart() {
        super.onStart();
        C2777r.f8527a.m11416a(this);
        C2764f.f8487a.m11379a(this);
    }

    protected void onStop() {
        super.onStop();
        this.f14630a.m11425b();
        C2777r.f8527a.m11417b(this);
        C2764f.f8487a.m11380b(this);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        m22153i();
        return true;
    }

    /* renamed from: a */
    public void mo2585a() {
        m22164d();
        Intent intent = new Intent();
        intent.putExtra("card_id", this.f14633d);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: b */
    public void mo2590b() {
        setResult(0);
        finish();
    }

    /* renamed from: c */
    public void m22163c() {
        this.f14630a.m11422a(getString(C2743i.acq_progress_dialog_attach_card_text));
    }

    /* renamed from: d */
    public void m22164d() {
        this.f14630a.m11421a();
    }

    /* renamed from: a */
    public void mo2588a(Throwable th) {
        m22164d();
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
        m22164d();
        C2968d bhVar = new bh();
        Bundle bundle = new Bundle();
        bundle.putBundle("extra_3ds", new bf().m11338a(bgVar));
        bhVar.m12435g(bundle);
        getSupportFragmentManager().mo425a().mo408a(C2740f.content_frame, bhVar).mo413b();
    }

    /* renamed from: a */
    public void mo2586a(Exception exception) {
        exception = exception.getMessage();
        if (TextUtils.isEmpty(exception)) {
            exception = getString(C2743i.acq_default_error_message);
        }
        this.f14630a.m11423a(getString(C2743i.acq_default_error_title), exception);
    }

    /* renamed from: e */
    public void mo2592e() {
        this.f14630a.m11424a(getString(C2743i.acq_default_error_title), getString(C2743i.acq_network_error_message), new C27281(this));
        m22164d();
    }

    /* renamed from: a */
    public void mo2587a(String str) {
        this.f14633d = str;
    }

    /* renamed from: b */
    public void mo2591b(String str) {
        m22164d();
        getSupportFragmentManager().mo425a().mo408a(C2740f.content_frame, m22162c(str)).mo411a("loop_confirmation").mo413b();
    }

    public void onBackPressed() {
        C2968d a = getSupportFragmentManager().mo423a(C2740f.content_frame);
        if (!(a instanceof aq) || !((aq) a).ai()) {
            m22153i();
        }
    }

    /* renamed from: f */
    public C4307c mo2593f() {
        return this.f14631b;
    }

    /* renamed from: c */
    protected am m22162c(String str) {
        return am.m20605b(str);
    }

    /* renamed from: g */
    protected C4678e m22167g() {
        return C4678e.m20619a();
    }

    /* renamed from: h */
    boolean m22168h() {
        return this.f14632c;
    }

    /* renamed from: a */
    private void m22151a(Intent intent) {
        intent = intent.getIntExtra("theme", 0);
        if (intent != null) {
            setTheme(intent);
        }
        setRequestedOrientation(1);
        setContentView(C2741g.acq_activity);
        getSupportActionBar().mo137a(true);
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(C2736b.acqPayFormTitle, typedValue, true);
        setTitle(getResources().getString(typedValue.resourceId));
    }

    /* renamed from: b */
    private C4307c m22152b(Intent intent) {
        return new C4307c(intent.getStringExtra("terminal_key"), intent.getStringExtra("password"), intent.getStringExtra("public_key"));
    }

    /* renamed from: i */
    private void m22153i() {
        if (getSupportFragmentManager().mo430c() == 0) {
            setResult(0);
        }
        super.onBackPressed();
    }

    /* renamed from: j */
    private void m22154j() {
        getSupportFragmentManager().mo425a().mo408a(C2740f.content_frame, m22167g()).mo413b();
    }
}
