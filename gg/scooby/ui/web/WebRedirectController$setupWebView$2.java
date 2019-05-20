package ru.gg.scooby.ui.web;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import p042b.p047e.p048a.C0689a;

/* compiled from: WebRedirectController.kt */
public final class WebRedirectController$setupWebView$2 extends WebViewClient {
    final /* synthetic */ C0689a $onPageLoaded;

    WebRedirectController$setupWebView$2(C0689a c0689a) {
        this.$onPageLoaded = c0689a;
    }

    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        if (VERSION.SDK_INT >= 23 && webView != null) {
            webView.setVisibility(null);
        }
        this.$onPageLoaded.mo2120a();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (VERSION.SDK_INT < 23 && webView != null) {
            webView.setVisibility(null);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.$onPageLoaded.mo2120a();
    }
}
