package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import com.bluelinelabs.conductor.C0809d.C0807a;
import com.bluelinelabs.conductor.C0809d.C0808b;
import p042b.C0727n;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.ui.web.WebRedirectController;
import ru.gg.scooby.util.BundleBuilder;
import ru.gg.scooby.util.Log;
import ru.skooby.R;

/* compiled from: WebUrlController.kt */
public final class WebUrlController extends BaseController {
    public static final Companion Companion = new Companion();
    public static final String KEY_TITLE = "KEY_TITLE";
    public static final String KEY_URL = "KEY_URL";
    private boolean pageLoaded;
    @BindView
    public Toolbar toolbar;
    @BindView
    public WebView webview;

    /* compiled from: WebUrlController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: WebUrlController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.WebUrlController$a */
    static final class C4667a extends C3038k implements C0689a<C0727n> {
        final /* synthetic */ WebUrlController this$0;

        C4667a(WebUrlController webUrlController) {
            this.this$0 = webUrlController;
            super(0);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            m20585b();
            return C0727n.f2066a;
        }

        /* renamed from: b */
        public final void m20585b() {
            this.this$0.setPageLoaded(true);
        }
    }

    public WebUrlController(String str, String str2) {
        C0700j.m2715b(str, "url");
        C0700j.m2715b(str2, "title");
        this(new BundleBuilder(new Bundle()).putString(KEY_URL, str).putString(KEY_TITLE, str2).build());
    }

    public WebUrlController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
        setHasOptionsMenu(true);
        setRetainViewMode(C0808b.RETAIN_DETACH);
    }

    public final WebView getWebview() {
        WebView webView = this.webview;
        if (webView == null) {
            C0700j.m2716b("webview");
        }
        return webView;
    }

    public final void setWebview(WebView webView) {
        C0700j.m2715b(webView, "<set-?>");
        this.webview = webView;
    }

    public final Toolbar getToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        return toolbar;
    }

    public final void setToolbar(Toolbar toolbar) {
        C0700j.m2715b(toolbar, "<set-?>");
        this.toolbar = toolbar;
    }

    public final boolean getPageLoaded() {
        return this.pageLoaded;
    }

    public final void setPageLoaded(boolean z) {
        this.pageLoaded = z;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_web_url, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…eb_url, container, false)");
        return inflate;
    }

    protected View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        this.pageLoaded = false;
        layoutInflater = super.onCreateView(layoutInflater, viewGroup);
        Activity activity = getActivity();
        addLifecycleListener((C0807a) new StatusBarColorHelper(activity != null ? activity.getWindow() : null, layoutInflater, layoutInflater.getResources().getColor(R.color.white_alternative), false, 8, null));
        return layoutInflater;
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        initAppBar();
        if (this.pageLoaded == null) {
            view = WebRedirectController.INSTANCE;
            WebView webView = this.webview;
            if (webView == null) {
                C0700j.m2716b("webview");
            }
            Object string = getArgs().getString(KEY_URL);
            C0700j.m2711a(string, "args.getString(KEY_URL)");
            view.loadUrl(webView, string, new C4667a(this));
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        C0700j.m2715b(menu, "menu");
        C0700j.m2715b(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_web_url_controller, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0700j.m2715b(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            getRouter().m3169l();
            return true;
        } else if (itemId != R.id.open_in_browser) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            Object parse = Uri.parse(getArgs().getString(KEY_URL));
            C0700j.m2711a(parse, "Uri.parse(args.getString(KEY_URL))");
            ControllerExKt.startActivityForUri(this, parse);
            return true;
        }
    }

    private final void initAppBar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        toolbar.setTitle((CharSequence) getArgs().getString(KEY_TITLE));
        toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        ControllerExKt.setActionBar(this, toolbar);
        C0092a actionBar = ControllerExKt.getActionBar(this);
        if (actionBar != null) {
            actionBar.mo141b(true);
        }
        actionBar = ControllerExKt.getActionBar(this);
        if (actionBar != null) {
            actionBar.mo137a(true);
        }
        actionBar = ControllerExKt.getActionBar(this);
        if (actionBar != null) {
            actionBar.mo134a((int) R.drawable.abc_ic_ab_back_material);
        }
    }

    protected void onActivityResumed(Activity activity) {
        C0700j.m2715b(activity, "activity");
        super.onActivityResumed(activity);
        if (this.webview != null) {
            activity = this.webview;
            if (activity == null) {
                C0700j.m2716b("webview");
            }
            activity.onResume();
            return;
        }
        Log.e$default(Log.INSTANCE, "webview is not initialized", false, 2, null);
    }

    protected void onActivityPaused(Activity activity) {
        C0700j.m2715b(activity, "activity");
        super.onActivityPaused(activity);
        if (this.webview != null) {
            activity = this.webview;
            if (activity == null) {
                C0700j.m2716b("webview");
            }
            activity.onPause();
            return;
        }
        Log.e$default(Log.INSTANCE, "webview is not initialized", false, 2, null);
    }
}
