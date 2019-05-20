package ru.tinkoff.acquiring.sdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import androidx.fragment.app.C2968d;
import ru.tinkoff.acquiring.sdk.ax.C2735a;
import ru.tinkoff.acquiring.sdk.ax.C2743i;
import ru.tinkoff.acquiring.sdk.nfc.AsdkNfcScanActivity;
import ru.tinkoff.acquiring.sdk.views.EditCardView;
import ru.tinkoff.acquiring.sdk.views.EditCardView.Actions;

/* compiled from: FullCardScanner */
/* renamed from: ru.tinkoff.acquiring.sdk.x */
public class C4325x implements Actions {
    /* renamed from: a */
    private final C2968d f12960a;
    /* renamed from: b */
    private final ab f12961b;

    /* renamed from: a */
    public boolean m18497a(int i, int i2) {
        return i == 2964 && i2 == -1;
    }

    /* renamed from: b */
    public boolean m18500b(int i, int i2) {
        return i == 2964 && i2 == 256;
    }

    public void onUpdate(EditCardView editCardView) {
    }

    public C4325x(C2968d c2968d, ab abVar) {
        this.f12960a = c2968d;
        if (abVar != null) {
            this.f12961b = abVar;
        } else {
            this.f12961b = null;
        }
    }

    public void onPressScanCard(EditCardView editCardView) {
        final Activity l = this.f12960a.m12446l();
        boolean a = m18491a(l);
        boolean b = m18493b();
        if (a && b) {
            Builder builder = new Builder(l);
            builder.setItems(l.getResources().getStringArray(C2735a.acq_scan_types), new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C4325x f8549b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == 0) {
                        this.f8549b.m18494c();
                    } else if (i == 1) {
                        this.f8549b.m18492b(l);
                    }
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        } else if (b) {
            m18494c();
        } else if (a) {
            m18492b(l);
        } else {
            Toast.makeText(l, C2743i.acq_no_scan_providers, 0).show();
        }
    }

    /* renamed from: a */
    public boolean m18496a() {
        if (!m18491a(this.f12960a.m12446l())) {
            if (!m18493b()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m18498a(int i, Intent intent) {
        return (i != 4123 || intent == null || this.f12961b.mo1943a(intent) == 0) ? false : true;
    }

    /* renamed from: a */
    public ae m18495a(Intent intent) {
        return this.f12961b.mo1944b(intent);
    }

    /* renamed from: b */
    public ae m18499b(Intent intent) {
        return (ae) intent.getSerializableExtra("card_extra");
    }

    /* renamed from: a */
    private boolean m18491a(Activity activity) {
        return activity.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    /* renamed from: b */
    private boolean m18493b() {
        return this.f12961b != null;
    }

    /* renamed from: c */
    private void m18494c() {
        this.f12961b.mo1942a(this.f12960a, 4123);
    }

    /* renamed from: b */
    private void m18492b(Activity activity) {
        this.f12960a.startActivityForResult(new Intent(activity, AsdkNfcScanActivity.class), 2964);
    }
}
