package ru.gg.scooby.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.app.C4746d;
import androidx.appcompat.widget.Toolbar;
import com.bluelinelabs.conductor.C0805c;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import java.util.HashMap;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.manager.RecentManager;
import ru.gg.scooby.ui.ActionBarProvider;
import ru.gg.scooby.ui.controller.RootController;
import ru.skooby.R;

/* compiled from: MainActivity.kt */
public final class MainActivity extends C4746d implements ActionBarProvider {
    public static final Companion Companion = new Companion();
    public static final int REQ_CODE_FROM_GALLERY = 3;
    public static final int REQ_CODE_TAKE_PHOTO = 2;
    public static final int REQ_CODE_VOICE_RECOGNITION = 1;
    public static final int REQ_PERMISSION_LOCATION = 4;
    private HashMap _$_findViewCache;
    public C0818i router;

    /* compiled from: MainActivity.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public final C0818i getRouter() {
        C0818i c0818i = this.router;
        if (c0818i == null) {
            C0700j.m2716b("router");
        }
        return c0818i;
    }

    public final void setRouter(C0818i c0818i) {
        C0700j.m2715b(c0818i, "<set-?>");
        this.router = c0818i;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        Object a = C0805c.m3110a(this, (ViewGroup) findViewById(R.id.container), bundle);
        C0700j.m2711a(a, "Conductor.attachRouter(t…iner, savedInstanceState)");
        this.router = a;
        bundle = this.router;
        if (bundle == null) {
            C0700j.m2716b("router");
        }
        if (bundle.m3173p() == null) {
            bundle = this.router;
            if (bundle == null) {
                C0700j.m2716b("router");
            }
            bundle.m3163d(C0820k.m3183a((C0809d) new RootController()));
        }
    }

    protected void onPause() {
        super.onPause();
        RecentManager.INSTANCE.save();
    }

    public void onBackPressed() {
        C0818i c0818i = this.router;
        if (c0818i == null) {
            C0700j.m2716b("router");
        }
        if (!c0818i.m3168k()) {
            super.onBackPressed();
        }
    }

    public C0092a getToolbar() {
        return getSupportActionBar();
    }

    public void setToolbar(Toolbar toolbar) {
        C0700j.m2715b(toolbar, "toolbar");
        setSupportActionBar(toolbar);
    }
}
