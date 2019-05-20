package ru.gg.scooby.ui.web;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import p042b.C0727n;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.util.UIUtils;

/* compiled from: WebRedirectController.kt */
public final class WebRedirectController {
    public static final WebRedirectController INSTANCE = new WebRedirectController();

    /* compiled from: WebRedirectController.kt */
    /* renamed from: ru.gg.scooby.ui.web.WebRedirectController$a */
    static final class C2698a implements OnTouchListener {
        /* renamed from: a */
        public static final C2698a f8321a = new C2698a();

        C2698a() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            C0700j.m2711a((Object) motionEvent, "event");
            switch (motionEvent.getAction() & 255) {
                case null:
                case 1:
                    if (view.hasFocus() == null) {
                        motionEvent = UIUtils.INSTANCE;
                        C0700j.m2711a((Object) view, "v");
                        motionEvent.requestFocus(view);
                        break;
                    }
                    break;
                default:
                    break;
            }
            return null;
        }
    }

    private WebRedirectController() {
    }

    public final void loadUrl(WebView webView, String str, C0689a<C0727n> c0689a) {
        C0700j.m2715b(webView, "webView");
        C0700j.m2715b(str, "url");
        C0700j.m2715b(c0689a, "onPageVisible");
        setupWebView(webView, c0689a);
        webView.loadUrl(str);
    }

    private final void setupWebView(WebView webView, C0689a<C0727n> c0689a) {
        Object settings;
        webView.setOnTouchListener(C2698a.f8321a);
        if (VERSION.SDK_INT >= 21) {
            settings = webView.getSettings();
            C0700j.m2711a(settings, "view.settings");
            settings.setMixedContentMode(0);
        }
        settings = webView.getSettings();
        C0700j.m2711a(settings, "view.settings");
        settings.setLoadsImagesAutomatically(true);
        settings = webView.getSettings();
        C0700j.m2711a(settings, "view.settings");
        settings.setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setScrollBarStyle(33554432);
        webView.setScrollbarFadingEnabled(false);
        webView.setWebViewClient(new WebRedirectController$setupWebView$2(c0689a));
        webView.setVisibility(4);
        Object settings2 = webView.getSettings();
        C0700j.m2711a(settings2, "webSettings");
        settings2.setJavaScriptEnabled(true);
        settings2.setLoadWithOverviewMode(true);
        settings2.setRenderPriority(RenderPriority.HIGH);
        settings2.setSupportZoom(true);
    }
}
