package ru.tinkoff.acquiring.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.C2968d;
import java.net.URLEncoder;
import ru.tinkoff.acquiring.sdk.ax.C2740f;
import ru.tinkoff.acquiring.sdk.ax.C2741g;
import ru.tinkoff.acquiring.sdk.p221d.C4312f;

/* compiled from: ThreeDsFragment */
public class bh extends C2968d {
    /* renamed from: a */
    private WebView f14131a;
    /* renamed from: b */
    private bg f14132b;
    /* renamed from: c */
    private C4307c f14133c;
    /* renamed from: d */
    private String f14134d;

    /* compiled from: ThreeDsFragment */
    /* renamed from: ru.tinkoff.acquiring.sdk.bh$a */
    private class C2753a extends WebViewClient {
        /* renamed from: a */
        boolean f8469a;
        /* renamed from: b */
        final /* synthetic */ bh f8470b;

        private C2753a(bh bhVar) {
            this.f8470b = bhVar;
            this.f8469a = null;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (str.contains("cancel.do")) {
                this.f8469a = true;
                Activity activity = (Activity) webView.getContext();
                activity.setResult(0);
                activity.finish();
            }
            if (this.f8470b.f14134d.equals(str) != null) {
                webView.setVisibility(4);
                if (this.f8469a == null) {
                    bh.m20614b(this.f8470b.f14133c, this.f8470b.f14132b);
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* renamed from: c */
    public static bh m20616c(Bundle bundle) {
        bh bhVar = new bh();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("extra_3ds", bundle);
        bhVar.m12435g(bundle2);
        return bhVar;
    }

    /* renamed from: a */
    public View mo2392a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C2741g.acq_fragment_3ds, viewGroup, false);
        this.f14131a = (WebView) layoutInflater.findViewById(C2740f.wv_3ds);
        this.f14131a.setWebViewClient(new C2753a());
        this.f14131a.getSettings().setDomStorageEnabled(true);
        this.f14131a.getSettings().setJavaScriptEnabled(true);
        this.f14131a.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.f14132b = new bf().m11339a(m12434g().getBundle("extra_3ds"));
        return layoutInflater;
    }

    /* renamed from: d */
    public void mo2063d(Bundle bundle) {
        super.mo2063d(bundle);
        this.f14133c = ((aa) m12446l()).mo2593f();
        bundle = this.f14132b.m11342c();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f14133c.m18463c("Submit3DSAuthorization"));
        stringBuilder.append("/");
        stringBuilder.append("Submit3DSAuthorization");
        this.f14134d = stringBuilder.toString();
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append("PaReq=");
            stringBuilder.append(URLEncoder.encode(this.f14132b.m11344e(), "UTF-8"));
            stringBuilder.append("&MD=");
            stringBuilder.append(URLEncoder.encode(this.f14132b.m11343d(), "UTF-8"));
            stringBuilder.append("&TermUrl=");
            stringBuilder.append(URLEncoder.encode(this.f14134d, "UTF-8"));
            this.f14131a.postUrl(bundle, stringBuilder.toString().getBytes());
        } catch (Bundle bundle2) {
            throw new C2757d(bundle2);
        }
    }

    /* renamed from: b */
    private static void m20614b(final C4307c c4307c, final bg bgVar) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    StringBuilder stringBuilder;
                    if (bgVar.m11346g()) {
                        av a = c4307c.m18455a(bgVar.m11340a().longValue());
                        if (a != av.CONFIRMED) {
                            if (a != av.AUTHORIZED) {
                                C2777r c2777r = C2777r.f8527a;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("PaymentState = ");
                                stringBuilder.append(a);
                                c2777r.obtainMessage(2, new C2757d(new IllegalStateException(stringBuilder.toString()))).sendToTarget();
                                return;
                            }
                        }
                        C2777r.f8527a.obtainMessage(0).sendToTarget();
                        return;
                    }
                    C4312f b = c4307c.m18462b(bgVar.m11341b());
                    av e = b.m18471e();
                    if (e == av.COMPLETED) {
                        C2764f.f8487a.obtainMessage(0, b.m18472f()).sendToTarget();
                        C2777r.f8527a.obtainMessage(0).sendToTarget();
                        return;
                    }
                    C2777r c2777r2 = C2777r.f8527a;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("PaymentState = ");
                    stringBuilder.append(e);
                    c2777r2.obtainMessage(2, new C2757d(new IllegalStateException(stringBuilder.toString()))).sendToTarget();
                } catch (Exception e2) {
                    C2777r.f8527a.obtainMessage(2, e2).sendToTarget();
                }
            }
        }).start();
    }
}
