package ru.tinkoff.acquiring.sdk;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import ru.tinkoff.acquiring.sdk.ax.C2743i;

/* compiled from: DialogsManager */
/* renamed from: ru.tinkoff.acquiring.sdk.u */
class C2780u {
    /* renamed from: a */
    private final Context f8530a;
    /* renamed from: b */
    private ProgressDialog f8531b;
    /* renamed from: c */
    private AlertDialog f8532c;

    /* compiled from: DialogsManager */
    /* renamed from: ru.tinkoff.acquiring.sdk.u$1 */
    class C27791 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2780u f8529a;

        C27791(C2780u c2780u) {
            this.f8529a = c2780u;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    C2780u(Context context) {
        this.f8530a = context;
    }

    /* renamed from: a */
    void m11423a(String str, String str2) {
        m11424a(str, str2, new C27791(this));
    }

    /* renamed from: a */
    void m11424a(String str, String str2, OnClickListener onClickListener) {
        m11425b();
        this.f8532c = new Builder(this.f8530a).setMessage(str2).setTitle(str).setCancelable(null).setNeutralButton(C2743i.acq_dialog_dismiss_btn, onClickListener).create();
        this.f8532c.show();
    }

    /* renamed from: a */
    void m11422a(String str) {
        m11425b();
        this.f8531b = new ProgressDialog(this.f8530a);
        this.f8531b.setMessage(str);
        this.f8531b.setCancelable(false);
        this.f8531b.show();
    }

    /* renamed from: a */
    void m11421a() {
        ProgressDialog progressDialog = this.f8531b;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /* renamed from: b */
    void m11425b() {
        ProgressDialog progressDialog = this.f8531b;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        AlertDialog alertDialog = this.f8532c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* renamed from: c */
    boolean m11426c() {
        ProgressDialog progressDialog = this.f8531b;
        return progressDialog != null && progressDialog.isShowing();
    }
}
