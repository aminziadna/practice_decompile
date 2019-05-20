package ru.tinkoff.acquiring.sdk.nfc;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.core.content.C0317a;
import io.card.payment.BuildConfig;
import java.io.Serializable;
import ru.tinkoff.acquiring.sdk.C4323s;
import ru.tinkoff.acquiring.sdk.ax.C2737c;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;
import ru.tinkoff.acquiring.sdk.ax.C2743i;
import ru.tinkoff.p213a.p216b.C2712j;
import ru.tinkoff.p213a.p216b.C2713k;
import ru.tinkoff.p213a.p216b.C4278a;

public class AsdkNfcScanActivity extends C4278a {

    /* renamed from: ru.tinkoff.acquiring.sdk.nfc.AsdkNfcScanActivity$1 */
    class C27741 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ AsdkNfcScanActivity f8521a;

        C27741(AsdkNfcScanActivity asdkNfcScanActivity) {
            this.f8521a = asdkNfcScanActivity;
        }

        public void onClick(View view) {
            this.f8521a.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2741g.acq_activity_nfc);
        ((Button) findViewById(C2740f.acq_btn_close)).setOnClickListener(new C27741(this));
        m20647e();
    }

    /* renamed from: a */
    public void mo2396a(String str, String str2) {
        Serializable c4323s = new C4323s(str, str2, BuildConfig.FLAVOR);
        str = new Intent();
        str.putExtra("card_extra", c4323s);
        setResult(-1, str);
        finish();
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    /* renamed from: a */
    public String mo2395a() {
        return getString(C2743i.acq_nfc_is_disable);
    }

    /* renamed from: b */
    public String mo2397b() {
        return getString(C2743i.acq_nfc_need_enable);
    }

    /* renamed from: a */
    public void mo1932a(Exception exception) {
        m20648f();
    }

    /* renamed from: a */
    public void mo1934a(C2713k c2713k) {
        m20648f();
    }

    /* renamed from: a */
    public void mo1933a(C2712j c2712j) {
        m20648f();
    }

    /* renamed from: e */
    private void m20647e() {
        View findViewById = findViewById(C2740f.acq_view_root);
        int color = ((ColorDrawable) findViewById.getBackground()).getColor();
        if (color == C0317a.m1287c(this, C2737c.acq_colorNfcBackground)) {
            findViewById.setBackgroundColor(color & -855638017);
        }
    }

    /* renamed from: f */
    private void m20648f() {
        setResult(256);
        finish();
    }
}
