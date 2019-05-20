package ru.gg.scooby.ui.controller;

import android.view.View;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class WebUrlController_ViewBinding implements Unbinder {
    private WebUrlController target;

    public WebUrlController_ViewBinding(WebUrlController webUrlController, View view) {
        this.target = webUrlController;
        webUrlController.webview = (WebView) C0730b.m2751a(view, R.id.webview, "field 'webview'", WebView.class);
        webUrlController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    }

    public void unbind() {
        WebUrlController webUrlController = this.target;
        if (webUrlController != null) {
            this.target = null;
            webUrlController.webview = null;
            webUrlController.toolbar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
