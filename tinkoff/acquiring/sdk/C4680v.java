package ru.tinkoff.acquiring.sdk;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
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
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.C2968d;
import androidx.p037h.C0521o;
import com.google.android.gms.common.api.C1292f;
import com.google.android.gms.common.api.C1292f.C1289a;
import com.google.android.gms.p122e.C1423c;
import com.google.android.gms.p123f.C1444b;
import com.google.android.gms.p123f.C1447d;
import com.google.android.gms.p123f.C1449e;
import com.google.android.gms.p123f.C1451g;
import com.google.android.gms.p123f.C1454i;
import com.google.android.gms.p123f.C1458m;
import com.google.android.gms.p123f.C1460n;
import com.google.android.gms.p123f.C1460n.C4707a.C1459a;
import com.google.android.gms.p123f.C3454f;
import com.google.android.gms.p123f.C3455k;
import io.card.payment.BuildConfig;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import ru.tinkoff.acquiring.sdk.ax.C2736b;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2743i;
import ru.tinkoff.acquiring.sdk.p217b.p219b.C2749a;
import ru.tinkoff.acquiring.sdk.p217b.p219b.C2750b;
import ru.tinkoff.acquiring.sdk.p220c.C4302r;
import ru.tinkoff.acquiring.sdk.p222e.C2761a;
import ru.tinkoff.acquiring.sdk.views.BankKeyboard;
import ru.tinkoff.acquiring.sdk.views.EditCardView;

/* compiled from: EnterCardFragment */
/* renamed from: ru.tinkoff.acquiring.sdk.v */
public class C4680v extends C2968d implements ac, ad, aq {
    /* renamed from: a */
    private TextView f14147a;
    private View ad;
    private C1292f ae;
    private C4307c af;
    private C4325x ag;
    private Pattern ah = Patterns.EMAIL_ADDRESS;
    private BankKeyboard ai;
    private C2812y aj;
    private C2787a ak;
    private boolean al;
    private int am;
    private int an;
    private String ao;
    private String ap;
    private at aq;
    private C3455k ar;
    /* renamed from: b */
    private TextView f14148b;
    /* renamed from: c */
    private EditText f14149c;
    /* renamed from: d */
    private EditCardView f14150d;
    /* renamed from: e */
    private TextView f14151e;
    /* renamed from: f */
    private TextView f14152f;
    /* renamed from: g */
    private TextView f14153g;
    /* renamed from: h */
    private Button f14154h;
    /* renamed from: i */
    private View f14155i;

    /* compiled from: EnterCardFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.v$3 */
    class C27833 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4680v f8537a;

        C27833(C4680v c4680v) {
            this.f8537a = c4680v;
        }

        public void onClick(View view) {
            C1451g g = this.f8537a.an();
            if (g != null) {
                C1444b.m5614a(this.f8537a.ar.m15085a(g), this.f8537a.m12446l(), 5);
            }
        }
    }

    /* compiled from: EnterCardFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.v$6 */
    class C27856 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C4680v f8544a;

        C27856(C4680v c4680v) {
            this.f8544a = c4680v;
        }

        public void run() {
            PayFormActivity payFormActivity = (PayFormActivity) this.f8544a.m12446l();
            if (payFormActivity != null) {
                C2766h[] g = payFormActivity.m22193g();
                C2766h h = payFormActivity.m22194h();
                boolean z = h != null;
                boolean b = this.f8544a.m20679b(payFormActivity);
                View k = this.f8544a.f14155i;
                int i = (g == null || g.length <= 0) ? 8 : 0;
                k.setVisibility(i);
                TextView l = this.f8544a.f14152f;
                C4680v c4680v = this.f8544a;
                l.setText(c4680v.m20656a(c4680v.al, z));
                if (!this.f8544a.al) {
                    this.f8544a.m20665a(h, z, b);
                } else if (z) {
                    this.f8544a.f14150d.setRecurrentPaymentMode(true);
                    this.f8544a.f14150d.setCardNumber(h.m11386a());
                    this.f8544a.as();
                    if (this.f8544a.ai != null) {
                        this.f8544a.ai.hide();
                    }
                } else {
                    if (!(g == null || g.length == 0)) {
                        if (!b) {
                            this.f8544a.f14150d.setRecurrentPaymentMode(false);
                            this.f8544a.m20677b(true);
                            this.f8544a.m20665a(null, false, false);
                        }
                    }
                    this.f8544a.al = false;
                    this.f8544a.f14150d.setRecurrentPaymentMode(false);
                    this.f8544a.m20677b(false);
                    this.f8544a.m20665a(null, false, b);
                }
            }
        }
    }

    /* compiled from: EnterCardFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.v$a */
    protected interface C2787a {
        /* renamed from: a */
        void mo1941a();
    }

    /* compiled from: EnterCardFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.v$4 */
    class C43244 implements C1423c<Boolean> {
        /* renamed from: a */
        final /* synthetic */ C4680v f12959a;

        C43244(C4680v c4680v) {
            this.f12959a = c4680v;
        }

        /* renamed from: a */
        public void mo1105a(com.google.android.gms.p122e.C1427g<java.lang.Boolean> r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/788625466.run(Unknown Source)
*/
            /*
            r1 = this;
            r0 = com.google.android.gms.common.api.C1283b.class;	 Catch:{ b -> 0x001a }
            r2 = r2.mo1179a(r0);	 Catch:{ b -> 0x001a }
            r2 = (java.lang.Boolean) r2;	 Catch:{ b -> 0x001a }
            r2 = r2.booleanValue();	 Catch:{ b -> 0x001a }
            if (r2 == 0) goto L_0x0014;	 Catch:{ b -> 0x001a }
        L_0x000e:
            r2 = r1.f12959a;	 Catch:{ b -> 0x001a }
            r2.al();	 Catch:{ b -> 0x001a }
            goto L_0x001f;	 Catch:{ b -> 0x001a }
        L_0x0014:
            r2 = r1.f12959a;	 Catch:{ b -> 0x001a }
            r2.am();	 Catch:{ b -> 0x001a }
            goto L_0x001f;
        L_0x001a:
            r2 = r1.f12959a;
            r2.am();
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.v.4.a(com.google.android.gms.e.g):void");
        }
    }

    /* renamed from: a */
    public static C4680v m20661a(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("charge_mode", z);
        z = new C4680v();
        z.m12435g(bundle);
        return z;
    }

    /* renamed from: a */
    public void mo2057a(Context context) {
        super.mo2057a(context);
        context = context.getTheme().obtainStyledAttributes(new int[]{C2736b.acqPayAmountPosition, C2736b.acqPayButtonAndIconPosition, C2736b.acqPayWithAmountFormat, C2736b.acqMoneyAmountFormat});
        this.am = context.getInt(0, 0);
        this.an = context.getInt(1, 0);
        this.ao = context.getString(2);
        this.ap = context.getString(3);
        context.recycle();
    }

    /* renamed from: a */
    public View mo2392a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = C2749a.m11331a(layoutInflater, C2750b.m11336a(m12446l().getIntent().getIntArrayExtra("design_configuration"))).m11334a(viewGroup);
        this.f14150d = (EditCardView) a.findViewById(C2740f.ecv_card);
        this.f14152f = (TextView) a.findViewById(C2740f.tv_src_card_label);
        this.f14148b = (TextView) a.findViewById(C2740f.tv_description);
        this.f14147a = (TextView) a.findViewById(C2740f.tv_title);
        this.f14151e = (TextView) a.findViewById(C2740f.tv_amount);
        this.f14153g = (TextView) a.findViewById(C2740f.tv_src_card_choose_btn);
        this.f14154h = (Button) a.findViewById(C2740f.btn_pay);
        this.ad = a.findViewById(C2740f.rl_google_play_button);
        viewGroup = this.ad;
        if (viewGroup != null) {
            viewGroup.setEnabled(null);
        }
        this.f14155i = a.findViewById(C2740f.ll_src_card_chooser);
        this.f14149c = (EditText) a.findViewById(C2740f.et_email);
        viewGroup = m12446l();
        this.ag = new C4325x(this, (ab) viewGroup.getIntent().getSerializableExtra("card_scanner"));
        this.f14150d.setCardSystemIconsHolder(new be(viewGroup));
        this.f14150d.setActions(this.ag);
        if (this.ag.m18496a() == null) {
            this.f14150d.setBtnScanIcon(-1);
        }
        this.ai = (BankKeyboard) a.findViewById(C2740f.acq_keyboard);
        this.aj = (C2812y) viewGroup.getIntent().getParcelableExtra("android_pay_params");
        if (((PayFormActivity) viewGroup).m22195i() != null) {
            m12446l().getWindow().setSoftInputMode(2);
            this.f14150d.disableCopyPaste();
        } else {
            this.ai.hide();
        }
        this.f14153g.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C4680v f8534b;

            public void onClick(View view) {
                if (((PayFormActivity) viewGroup).m22193g() != null) {
                    this.f8534b.ar();
                }
            }
        });
        this.f14155i.setVisibility(8);
        this.al = m12434g().getBoolean("charge_mode");
        if (this.al != null) {
            m20677b(true);
            this.f14150d.setRecurrentPaymentMode(true);
        }
        if (this.am != null) {
            viewGroup = a.findViewById(C2740f.ll_price_layout);
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        }
        m20673b(a);
        return a;
    }

    /* renamed from: d */
    public void mo2063d(Bundle bundle) {
        super.mo2063d(bundle);
        this.af = ((PayFormActivity) m12446l()).mo2593f();
        bundle = m12446l().getIntent();
        CharSequence stringExtra = bundle.getStringExtra("email");
        if (stringExtra != null) {
            EditText editText = this.f14149c;
            if (editText != null) {
                editText.setText(stringExtra);
            }
        }
        stringExtra = bundle.getStringExtra("title");
        TextView textView = this.f14147a;
        if (textView != null) {
            textView.setText(stringExtra);
        }
        stringExtra = bundle.getStringExtra("description");
        textView = this.f14148b;
        if (textView != null) {
            textView.setText(stringExtra);
        }
        an anVar = (an) bundle.getSerializableExtra("amount");
        Object b = anVar != null ? anVar.m11303b() : BuildConfig.FLAVOR;
        String anVar2 = anVar != null ? anVar.toString() : BuildConfig.FLAVOR;
        if (this.am != 0 || this.f14151e == null) {
            if (TextUtils.isEmpty(this.ao)) {
                anVar2 = this.f14154h.getText().toString();
                Button button = this.f14154h;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(anVar2);
                stringBuilder.append(" ");
                stringBuilder.append(b);
                button.setText(stringBuilder.toString());
            } else {
                this.f14154h.setText(String.format(this.ao, new Object[]{anVar2}));
            }
        } else if (TextUtils.isEmpty(this.ap)) {
            this.f14151e.setText(b);
        } else {
            this.f14151e.setText(String.format(this.ap, new Object[]{anVar2}));
        }
        this.f14154h.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C4680v f8536b;

            public void onClick(View view) {
                if (this.f8536b.ai != null) {
                    this.f8536b.ai.hide();
                }
                String c = this.f8536b.aq();
                C4680v c4680v = this.f8536b;
                if (c4680v.m20670a(c4680v.f14150d, c) != null) {
                    PayFormActivity payFormActivity = (PayFormActivity) this.f8536b.m12446l();
                    C2767i a = this.f8536b.m20659a(payFormActivity);
                    payFormActivity.m22196j();
                    C4680v.m20675b(this.f8536b.af, this.f8536b.m20657a(bundle), a, null, c, this.f8536b.al);
                }
            }
        });
        bundle = this.ad;
        if (bundle != null) {
            bundle.setOnClickListener(new C27833(this));
        }
        bundle = this.ak;
        if (bundle != null) {
            bundle.mo1941a();
        }
    }

    /* renamed from: z */
    public void mo2218z() {
        super.mo2218z();
        boolean i = ((PayFormActivity) m12446l()).m22195i();
        BankKeyboard bankKeyboard = this.ai;
        if (bankKeyboard != null && i) {
            bankKeyboard.attachToView(this.f14150d);
            m12446l().getWindow().setSoftInputMode(0);
        }
    }

    /* renamed from: A */
    public void mo2393A() {
        super.mo2393A();
        as();
    }

    /* renamed from: c */
    public void mo2061c() {
        super.mo2061c();
        PayFormActivity payFormActivity = (PayFormActivity) m12446l();
        if (payFormActivity != null || this.aj == null) {
            if (payFormActivity.m22193g() != null) {
                mo2056a();
            }
            if (this.aj != null) {
                aj();
                ak();
            } else {
                am();
            }
            return;
        }
        aj();
        ak();
    }

    /* renamed from: d */
    public void mo2062d() {
        super.mo2062d();
        C1292f c1292f = this.ae;
        if (c1292f != null && c1292f.mo1076d()) {
            this.ae.mo1075c();
        }
    }

    private void aj() {
        this.ae = new C1289a(m12446l()).m5037a(C1460n.f4230a, new C1459a().m5645a(this.aj.m11438c()).m5646a()).m5039b();
        this.ae.mo1072b();
    }

    private void ak() {
        C1449e a = C1449e.m5623a().m5620a(5).m5620a(4).m5622b(1).m5622b(2).m5621a();
        this.ar = C1460n.m5647a(m12446l(), new C1459a().m5645a(this.aj.m11438c()).m5646a());
        this.ar.m15084a(a).mo1171a(new C43244(this));
    }

    private void al() {
        View view = this.ad;
        if (view != null) {
            view.setEnabled(true);
        }
    }

    private void am() {
        View y = m12462y();
        if (y != null) {
            View findViewById = y.findViewById(C2740f.fl_android_pay_placeholder);
            C0521o.m2115a((ViewGroup) y.findViewById(C2740f.pay_buttons_layout));
            findViewById.setVisibility(8);
        }
    }

    private C1451g an() {
        m12446l().getIntent().getStringExtra("description");
        C1458m a = C1458m.m5641a().m5637a(3).m5638a(ao()).m5640b("RUB").m5639a();
        C1447d a2 = C1447d.m5619a().m5617a(Arrays.asList(new Integer[]{Integer.valueOf(5), Integer.valueOf(4)})).m5618a();
        return C1451g.m5631a().m5627a(a).m5624a(1).m5624a(2).m5628a(this.aj.m11436a()).m5630b(this.aj.m11437b()).m5625a(a2).m5626a(C1454i.m5636a().m5633a(1).m5634a("gatewayMerchantId", this.af.m18452a()).m5634a("gateway", "tinkoff").m5635a()).m5629a();
    }

    private String ao() {
        return new BigDecimal(((an) m12446l().getIntent().getSerializableExtra("amount")).m11302a()).setScale(2, 6).toString();
    }

    /* renamed from: b */
    private void m20677b(boolean z) {
        if (z) {
            this.f14150d.setEnabled(false);
            this.f14150d.setFocusable(false);
            this.f14150d.clearFocus();
            this.f14150d.setFullCardNumberModeEnable(false);
            this.f14150d.setCardHint(m12390a(C2743i.acq_recurrent_mode_card_hint));
            return;
        }
        this.f14150d.setEnabled(true);
        this.f14150d.setFocusable(true);
        this.f14150d.setFullCardNumberModeEnable(true);
        z = this.f14150d;
        z.setCardHint(z.getCardNumberHint());
    }

    /* renamed from: b */
    private void m20673b(View view) {
        ViewGroup viewGroup = (LinearLayout) view.findViewById(C2740f.ll_container_layout);
        View findViewById = view.findViewById(C2740f.pay_buttons_layout);
        View findViewById2 = view.findViewById(C2740f.space);
        view = view.findViewById(C2740f.iv_secure_icons);
        switch (this.an) {
            case 0:
                return;
            case 1:
                viewGroup.removeView(findViewById);
                viewGroup.addView(findViewById);
                return;
            case 2:
                viewGroup.removeView(view);
                m20674b(viewGroup, findViewById2);
                viewGroup.removeView(findViewById);
                viewGroup.addView(view);
                m20662a(viewGroup, findViewById2);
                viewGroup.addView(findViewById);
                return;
            case 3:
                viewGroup.removeView(view);
                m20674b(viewGroup, findViewById2);
                viewGroup.removeView(findViewById);
                viewGroup.addView(view);
                viewGroup.addView(findViewById);
                return;
            case 4:
                m20674b(viewGroup, findViewById2);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m20662a(ViewGroup viewGroup, View view) {
        if (view != null) {
            viewGroup.addView(view);
        }
    }

    /* renamed from: b */
    private void m20674b(ViewGroup viewGroup, View view) {
        if (view != null) {
            viewGroup.removeView(view);
        }
    }

    private ak ap() {
        String language = m12450n().getConfiguration().locale.getLanguage();
        if (language == null || !language.toLowerCase().startsWith("ru")) {
            return ak.ENGLISH;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m20670a(EditCardView editCardView, String str) {
        editCardView = editCardView.isFilledAndCorrect() == null ? C2743i.acq_invalid_card : m20678b(str) == null ? C2743i.acq_invalid_email : null;
        if (editCardView == null) {
            return true;
        }
        Toast.makeText(m12446l(), editCardView, 0).show();
        return false;
    }

    /* renamed from: b */
    private boolean m20678b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.ah.matcher(str).matches() == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private C4302r m20657a(Intent intent) {
        C4302r c4302r = new C4302r(intent.getStringExtra("password"), intent.getStringExtra("terminal_key"));
        String stringExtra = intent.getStringExtra("order_id");
        String stringExtra2 = intent.getStringExtra("customer_key");
        String stringExtra3 = intent.getStringExtra("title");
        if (stringExtra3 != null && stringExtra3.length() > 20) {
            stringExtra3 = stringExtra3.substring(0, 20);
        }
        an anVar = (an) intent.getSerializableExtra("amount");
        c4302r.m18418a(stringExtra).m18423b(stringExtra2).m18427c(stringExtra3).m18417a(anVar.m11302a()).m18422a(intent.getBooleanExtra("recurrent_payment", false));
        ak ap = ap();
        if (ap != null) {
            c4302r.m18429d(ap.toString());
        }
        ay ayVar = (ay) intent.getSerializableExtra("receipt_value");
        if (ayVar != null) {
            c4302r.m18421a(ayVar);
        }
        List list = (List) intent.getSerializableExtra("receipts_value");
        List list2 = (List) intent.getSerializableExtra("shops_value");
        if (list2 != null) {
            c4302r.m18419a(list2, list);
        }
        Map map = (Map) intent.getSerializableExtra("data_value");
        if (map != null) {
            c4302r.m18420a(map);
        }
        if (this.aq != null) {
            map = new HashMap();
            map.put("recurringType", "12");
            map.put("failMapiSessionId", Long.toString(this.aq.m11320a().longValue()));
            c4302r.m18424b(map);
            this.aq = null;
        }
        return c4302r;
    }

    /* renamed from: a */
    private C2767i m20659a(PayFormActivity payFormActivity) {
        payFormActivity = payFormActivity.m22194h();
        if (this.al) {
            return new C2767i(payFormActivity.m11389d());
        }
        if (payFormActivity == null) {
            return new C2767i(this.f14150d.getCardNumber(), this.f14150d.getExpireDate(), this.f14150d.getCvc());
        }
        return new C2767i(payFormActivity.m11387b(), this.f14150d.getCvc());
    }

    private String aq() {
        EditText editText = this.f14149c;
        if (editText == null) {
            return null;
        }
        String trim = editText.getText().toString().trim();
        if (trim.isEmpty()) {
            trim = null;
        }
        return trim;
    }

    private void ar() {
        ((PayFormActivity) m12446l()).m22200n();
    }

    /* renamed from: a */
    public void mo2216a(int i, int i2, Intent intent) {
        if (this.ag.m18498a(i, intent)) {
            m20663a(this.ag.m18495a(intent));
        } else if (this.ag.m18497a(i, i2)) {
            m20663a(this.ag.m18499b(intent));
        } else if (this.ag.m18500b(i, i2)) {
            Toast.makeText(m12442j(), C2743i.acq_nfc_scan_failed, null).show();
        } else {
            if (i2 == -1 && i == 5) {
                ((PayFormActivity) m12446l()).m22196j();
            }
            int intExtra = intent != null ? intent.getIntExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", -1) : -1;
            if (i == 5 && i2 == -1) {
                m20672b(intent);
            } else if (i == 5 && i2 != 0) {
                m20683d(intExtra);
            }
            super.mo2216a(i, i2, intent);
        }
    }

    /* renamed from: b */
    private void m20672b(Intent intent) {
        intent = C3454f.m15081b(intent).m15082a().m5632a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GPay token: ");
        stringBuilder.append(intent);
        ai.m11290a(stringBuilder.toString());
        String trim = C2761a.m11370b(intent.getBytes(), 0).trim();
        String aq = aq();
        if (m20678b(aq) == null) {
            Toast.makeText(m12446l(), C2743i.acq_invalid_email, 0).show();
            return;
        }
        PayFormActivity payFormActivity = (PayFormActivity) m12446l();
        payFormActivity.m22196j();
        C4680v.m20675b(this.af, m20657a(payFormActivity.getIntent()), null, trim, aq, this.al);
    }

    /* renamed from: a */
    private void m20663a(ae aeVar) {
        this.al = false;
        this.f14150d.setRecurrentPaymentMode(false);
        m20677b(false);
        m20665a(null, false, true);
        this.f14150d.setCardNumber(aeVar.mo1954a());
        this.f14150d.setExpireDate(aeVar.mo1955b());
    }

    /* renamed from: d */
    private void m20683d(int i) {
        ar.f8385a.obtainMessage(4).sendToTarget();
    }

    /* renamed from: b */
    private static void m20675b(C4307c c4307c, C4302r c4302r, C2767i c2767i, String str, String str2, boolean z) {
        final C4302r c4302r2 = c4302r;
        final boolean z2 = z;
        final String str3 = str;
        final C4307c c4307c2 = c4307c;
        final C2767i c2767i2 = c2767i;
        final String str4 = str2;
        new Thread(new Runnable() {
            public void run() {
                try {
                    bg a;
                    C4302r c4302r = c4302r2;
                    boolean z = z2 && str3 == null;
                    c4302r.m18425b(z);
                    Long a2 = c4307c2.m18451a(c4302r2);
                    ar.f8385a.obtainMessage(2, a2).sendToTarget();
                    if (z2) {
                        if (str3 == null) {
                            at a3 = c4307c2.m18454a(a2.longValue(), c2767i2.m11391a());
                            if (a3.m11322c()) {
                                C2777r.f8527a.obtainMessage(0).sendToTarget();
                                return;
                            } else {
                                ar.f8385a.obtainMessage(3, a3).sendToTarget();
                                return;
                            }
                        }
                    }
                    if (str3 == null) {
                        a = c4307c2.m18457a(a2.longValue(), c2767i2, str4);
                    } else {
                        a = c4307c2.m18456a(a2.longValue(), str3, str4);
                    }
                    if (a.m11345f()) {
                        C2777r.f8527a.obtainMessage(3, a).sendToTarget();
                    } else {
                        C2777r.f8527a.obtainMessage(0).sendToTarget();
                    }
                } catch (Exception e) {
                    Message obtainMessage;
                    Throwable cause = e.getCause();
                    if (cause == null || !(cause instanceof ap)) {
                        obtainMessage = C2777r.f8527a.obtainMessage(2, e);
                    } else {
                        obtainMessage = C2777r.f8527a.obtainMessage(5);
                    }
                    obtainMessage.sendToTarget();
                }
            }
        }).start();
    }

    /* renamed from: a */
    public void mo2056a() {
        m12446l().runOnUiThread(new C27856(this));
    }

    /* renamed from: a */
    public void mo2399a(at atVar) {
        this.al = false;
        this.aq = atVar;
        final PayFormActivity payFormActivity = (PayFormActivity) m12446l();
        if (!TextUtils.isEmpty(atVar.m11321b())) {
            payFormActivity.m22180a(atVar.m11321b());
        }
        new Builder(payFormActivity).setTitle(C2743i.acq_complete_payment).setPositiveButton(C2743i.acq_complete_payment_ok, new DialogInterface.OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C4680v f8546b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface = payFormActivity.m22194h();
                i = this.f8546b.m12462y().findViewById(C2740f.fl_android_pay_placeholder);
                i.setVisibility(4);
                i.setEnabled(false);
                this.f8546b.f14155i.setVisibility(4);
                this.f8546b.f14155i.setEnabled(false);
                this.f8546b.f14150d.setRecurrentPaymentMode(false);
                this.f8546b.f14150d.setCardNumber(dialogInterface.m11386a());
                this.f8546b.f14150d.dispatchFocus();
            }
        }).setCancelable(false).show();
    }

    /* renamed from: a */
    private void m20665a(C2766h c2766h, boolean z, boolean z2) {
        this.f14150d.setSavedCardState(z);
        if (z && c2766h != null) {
            this.f14150d.setCardNumber(c2766h.m11386a());
        } else if (z2) {
            this.f14150d.clear();
        } else {
            this.f14150d.dispatchFocus();
        }
    }

    /* renamed from: b */
    private boolean m20679b(PayFormActivity payFormActivity) {
        return payFormActivity.m22198l().m11430a(101) != null ? true : null;
    }

    /* renamed from: a */
    private String m20656a(boolean z, boolean z2) {
        if (z2) {
            return m12390a((int) C2743i.acq_saved_card_label);
        }
        if (z) {
            return BuildConfig.FLAVOR;
        }
        return m12390a((int) C2743i.acq_new_card_label);
    }

    private void as() {
        View currentFocus = m12446l().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) currentFocus.getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public boolean ai() {
        boolean i = ((PayFormActivity) m12446l()).m22195i();
        BankKeyboard bankKeyboard = this.ai;
        return (bankKeyboard == null || !i) ? false : bankKeyboard.hide();
    }

    /* renamed from: a */
    protected final void m20699a(C2787a c2787a) {
        this.ak = c2787a;
    }
}
