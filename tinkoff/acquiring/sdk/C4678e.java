package ru.tinkoff.acquiring.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.C2968d;
import java.util.Map;
import ru.tinkoff.acquiring.sdk.ax.C2736b;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2743i;
import ru.tinkoff.acquiring.sdk.p217b.p218a.C2746a;
import ru.tinkoff.acquiring.sdk.p217b.p218a.C2747b;
import ru.tinkoff.acquiring.sdk.p221d.C4309c;
import ru.tinkoff.acquiring.sdk.views.BankKeyboard;
import ru.tinkoff.acquiring.sdk.views.EditCardView;

/* compiled from: AttachCardFormFragment */
/* renamed from: ru.tinkoff.acquiring.sdk.e */
public class C4678e extends C2968d implements aq {
    /* renamed from: a */
    private EditCardView f14135a;
    /* renamed from: b */
    private Button f14136b;
    /* renamed from: c */
    private EditText f14137c;
    /* renamed from: d */
    private BankKeyboard f14138d;
    /* renamed from: e */
    private C4325x f14139e;
    /* renamed from: f */
    private C2772l f14140f;
    /* renamed from: g */
    private int f14141g;

    /* compiled from: AttachCardFormFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.e$1 */
    class C27581 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4678e f8478a;

        C27581(C4678e c4678e) {
            this.f8478a = c4678e;
        }

        public void onClick(View view) {
            if (this.f8478a.f14138d != null) {
                this.f8478a.f14138d.hide();
            }
            AttachCardFormActivity attachCardFormActivity = (AttachCardFormActivity) this.f8478a.m12446l();
            String b = this.f8478a.ak();
            C4678e c4678e = this.f8478a;
            if (c4678e.m20625a(c4678e.f14135a, b)) {
                attachCardFormActivity.m22163c();
                C4678e.m20629b(this.f8478a.f14140f, attachCardFormActivity.getIntent(), new C2767i(this.f8478a.f14135a.getCardNumber(), this.f8478a.f14135a.getExpireDate(), this.f8478a.f14135a.getCvc()), b);
            }
        }
    }

    /* renamed from: a */
    public static C4678e m20619a() {
        Bundle bundle = new Bundle();
        C4678e c4678e = new C4678e();
        c4678e.m12435g(bundle);
        return c4678e;
    }

    /* renamed from: a */
    public void mo2057a(Context context) {
        super.mo2057a(context);
        context = context.getTheme().obtainStyledAttributes(new int[]{C2736b.acqPayButtonAndIconPosition});
        this.f14141g = context.getInt(0, 0);
        context.recycle();
    }

    /* renamed from: a */
    public View mo2392a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = C2746a.m11325a(layoutInflater, C2747b.m11330a(m12446l().getIntent().getIntArrayExtra("design_configuration"))).m11328a(viewGroup);
        m20627b(a);
        this.f14140f = new C2772l(((AttachCardFormActivity) m12446l()).mo2593f());
        this.f14139e = new C4325x(this, (ab) m12446l().getIntent().getSerializableExtra("card_scanner"));
        this.f14135a.setCardSystemIconsHolder(new be(m12446l()));
        this.f14135a.setActions(this.f14139e);
        if (this.f14139e.m18496a() == null) {
            this.f14135a.setBtnScanIcon(-1);
        }
        if (((AttachCardFormActivity) m12446l()).m22168h() != null) {
            m12446l().getWindow().setSoftInputMode(2);
            this.f14135a.disableCopyPaste();
        } else {
            this.f14138d.hide();
        }
        m20631c(a);
        this.f14136b.setOnClickListener(new C27581(this));
        return a;
    }

    /* renamed from: a */
    public void mo2216a(int i, int i2, Intent intent) {
        if (this.f14139e.m18498a(i, intent)) {
            m20622a(this.f14139e.m18495a(intent));
        } else if (this.f14139e.m18497a(i, i2)) {
            m20622a(this.f14139e.m18499b(intent));
        } else if (this.f14139e.m18500b(i, i2)) {
            Toast.makeText(m12442j(), C2743i.acq_nfc_scan_failed, null).show();
        } else {
            super.mo2216a(i, i2, intent);
        }
    }

    /* renamed from: z */
    public void mo2218z() {
        super.mo2218z();
        boolean h = ((AttachCardFormActivity) m12446l()).m22168h();
        BankKeyboard bankKeyboard = this.f14138d;
        if (bankKeyboard != null && h) {
            bankKeyboard.attachToView(this.f14135a);
            m12446l().getWindow().setSoftInputMode(0);
        }
    }

    /* renamed from: A */
    public void mo2393A() {
        super.mo2393A();
        aj();
    }

    public boolean ai() {
        boolean h = ((AttachCardFormActivity) m12446l()).m22168h();
        BankKeyboard bankKeyboard = this.f14138d;
        return (bankKeyboard == null || !h) ? false : bankKeyboard.hide();
    }

    /* renamed from: b */
    private static void m20629b(final C2772l c2772l, final Intent intent, final C2767i c2767i, final String str) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    C4309c a = c2772l.m11407a(intent.getStringExtra("customer_key"), intent.getStringExtra("check_type"), c2767i, str, (Map) intent.getSerializableExtra("data"));
                    av g = a.m18467g();
                    if (g == null) {
                        C2764f.f8487a.obtainMessage(0, a.m18466f()).sendToTarget();
                        C2777r.f8527a.obtainMessage(0).sendToTarget();
                    } else if (g == av.THREE_DS_CHECKING) {
                        C2777r.f8527a.obtainMessage(3, a.m18468h()).sendToTarget();
                    } else if (g == av.LOOP_CHECKING) {
                        C2764f.f8487a.obtainMessage(1, a.m18465e()).sendToTarget();
                    }
                } catch (Exception e) {
                    Throwable cause = e.getCause();
                    if (cause == null || !(cause instanceof ap)) {
                        C2777r.f8527a.obtainMessage(2, e).sendToTarget();
                    } else {
                        C2777r.f8527a.obtainMessage(5).sendToTarget();
                    }
                }
            }
        }).start();
    }

    /* renamed from: b */
    private void m20627b(View view) {
        this.f14135a = (EditCardView) view.findViewById(C2740f.ecv_card);
        this.f14137c = (EditText) view.findViewById(C2740f.et_email);
        this.f14136b = (Button) view.findViewById(C2740f.btn_attach);
        this.f14138d = (BankKeyboard) view.findViewById(C2740f.acq_keyboard);
        view = m12446l().getIntent().getStringExtra("email");
        if (view != null) {
            EditText editText = this.f14137c;
            if (editText != null) {
                editText.setText(view);
            }
        }
    }

    /* renamed from: a */
    private void m20622a(ae aeVar) {
        this.f14135a.setCardNumber(aeVar.mo1954a());
        this.f14135a.setExpireDate(aeVar.mo1955b());
    }

    /* renamed from: c */
    private void m20631c(View view) {
        ViewGroup viewGroup = (LinearLayout) view.findViewById(C2740f.ll_container_layout);
        View findViewById = view.findViewById(C2740f.space);
        view = view.findViewById(C2740f.iv_secure_icons);
        switch (this.f14141g) {
            case 0:
                return;
            case 1:
                viewGroup.removeView(this.f14136b);
                viewGroup.addView(this.f14136b);
                return;
            case 2:
                viewGroup.removeView(view);
                m20628b(viewGroup, findViewById);
                viewGroup.removeView(this.f14136b);
                viewGroup.addView(view);
                m20621a(viewGroup, findViewById);
                viewGroup.addView(this.f14136b);
                return;
            case 3:
                viewGroup.removeView(view);
                m20628b(viewGroup, findViewById);
                viewGroup.removeView(this.f14136b);
                viewGroup.addView(view);
                viewGroup.addView(this.f14136b);
                return;
            case 4:
                m20628b(viewGroup, findViewById);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m20621a(ViewGroup viewGroup, View view) {
        if (view != null) {
            viewGroup.addView(view);
        }
    }

    /* renamed from: b */
    private void m20628b(ViewGroup viewGroup, View view) {
        if (view != null) {
            viewGroup.removeView(view);
        }
    }

    private void aj() {
        View currentFocus = m12446l().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) currentFocus.getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private String ak() {
        EditText editText = this.f14137c;
        if (editText == null) {
            return null;
        }
        String trim = editText.getText().toString().trim();
        if (trim.isEmpty()) {
            trim = null;
        }
        return trim;
    }

    /* renamed from: a */
    private boolean m20625a(EditCardView editCardView, String str) {
        if (editCardView.isFilledAndCorrect() == null) {
            Toast.makeText(m12446l(), C2743i.acq_invalid_card, 0).show();
            return false;
        } else if (TextUtils.isEmpty(str) != null || Patterns.EMAIL_ADDRESS.matcher(str).matches() != null) {
            return true;
        } else {
            Toast.makeText(m12446l(), C2743i.acq_invalid_email, 0).show();
            return false;
        }
    }
}
