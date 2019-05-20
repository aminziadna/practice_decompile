package ru.tinkoff.acquiring.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.C2968d;
import ru.tinkoff.acquiring.sdk.ao.C2734a;
import ru.tinkoff.acquiring.sdk.ax.C2736b;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;

/* compiled from: LoopConfirmationFragment */
public class am extends C2968d {
    /* renamed from: a */
    private Button f14129a;
    /* renamed from: b */
    private int f14130b;

    /* renamed from: b */
    public static am m20605b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("request_key", str);
        str = new am();
        str.m12435g(bundle);
        return str;
    }

    /* renamed from: a */
    public void mo2057a(Context context) {
        super.mo2057a(context);
        context = context.getTheme().obtainStyledAttributes(new int[]{C2736b.acqPayButtonAndIconPosition});
        this.f14130b = context.getInt(0, 0);
        context.recycle();
    }

    /* renamed from: a */
    public View mo2392a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2741g.acq_fragment_loop_confirmation, viewGroup, false);
        m20606b(inflate);
        m20608c(inflate);
        return inflate;
    }

    /* renamed from: b */
    private void m20606b(View view) {
        final EditText editText = (EditText) view.findViewById(C2740f.et_amount);
        TextWatcher c2734a = new C2734a(editText);
        c2734a.m11306a(3);
        editText.addTextChangedListener(c2734a);
        this.f14129a = (Button) view.findViewById(C2740f.btn_check);
        this.f14129a.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ am f8374b;

            public void onClick(android.view.View r5) {
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
                r4 = this;
                r5 = r4.f8374b;
                r5 = r5.m12446l();
                r5 = (ru.tinkoff.acquiring.sdk.AttachCardFormActivity) r5;
                r0 = r0;	 Catch:{ Exception -> 0x0042 }
                r0 = r0.getText();	 Catch:{ Exception -> 0x0042 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0042 }
                r0 = ru.tinkoff.acquiring.sdk.ao.m11310c(r0);	 Catch:{ Exception -> 0x0042 }
                r1 = new java.math.BigDecimal;	 Catch:{ Exception -> 0x0042 }
                r1.<init>(r0);	 Catch:{ Exception -> 0x0042 }
                r0 = ru.tinkoff.acquiring.sdk.an.m11298a(r1);	 Catch:{ Exception -> 0x0042 }
                r0 = r0.m11302a();	 Catch:{ Exception -> 0x0042 }
                r0 = java.lang.Long.valueOf(r0);	 Catch:{ Exception -> 0x0042 }
                r5.m22163c();
                r5 = r5.mo2593f();
                r1 = r4.f8374b;
                r1 = r1.m12434g();
                r2 = "request_key";
                r1 = r1.getString(r2);
                r2 = r0.longValue();
                ru.tinkoff.acquiring.sdk.am.m20607b(r5, r1, r2);
                return;
            L_0x0042:
                r0 = ru.tinkoff.acquiring.sdk.ax.C2743i.acq_attaching_card_loop_parse_error;
                r1 = 0;
                r5 = android.widget.Toast.makeText(r5, r0, r1);
                r5.show();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tinkoff.acquiring.sdk.am.1.onClick(android.view.View):void");
            }
        });
    }

    /* renamed from: b */
    private static void m20607b(final C4307c c4307c, final String str, final long j) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    C2764f.f8487a.obtainMessage(0, c4307c.m18453a(str, Long.valueOf(j))).sendToTarget();
                    C2777r.f8527a.obtainMessage(0).sendToTarget();
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

    /* renamed from: c */
    private void m20608c(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C2740f.ll_container_layout);
        View findViewById = view.findViewById(C2740f.space);
        view = view.findViewById(C2740f.iv_secure_icons);
        switch (this.f14130b) {
            case 0:
                return;
            case 1:
                linearLayout.removeView(this.f14129a);
                linearLayout.addView(this.f14129a);
                return;
            case 2:
                linearLayout.removeView(view);
                linearLayout.removeView(findViewById);
                linearLayout.removeView(this.f14129a);
                linearLayout.addView(view);
                linearLayout.addView(findViewById);
                linearLayout.addView(this.f14129a);
                return;
            case 3:
                linearLayout.removeView(view);
                linearLayout.removeView(findViewById);
                linearLayout.removeView(this.f14129a);
                linearLayout.addView(view);
                linearLayout.addView(this.f14129a);
                return;
            case 4:
                linearLayout.removeView(findViewById);
                return;
            default:
                return;
        }
    }
}
