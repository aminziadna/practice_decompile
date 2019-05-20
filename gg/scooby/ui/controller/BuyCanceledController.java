package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.snackbar.Snackbar;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.CancelReason;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.skooby.R;

/* compiled from: BuyCanceledController.kt */
public final class BuyCanceledController extends BaseController {
    private int clickedViewId;
    @BindView
    public Toolbar toolbar;

    /* compiled from: BuyCanceledController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.BuyCanceledController$a */
    static final class C4623a extends C3038k implements C0690b<C2342r<Void>, C0727n> {
        final /* synthetic */ BuyCanceledController this$0;

        C4623a(BuyCanceledController buyCanceledController) {
            this.this$0 = buyCanceledController;
            super(1);
        }

        /* renamed from: a */
        public final void m20497a(C2342r<Void> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            this.this$0.getRouter().m3169l();
            ParkingManager.refreshParkingStatus$default(ParkingManager.INSTANCE, false, null, 3, null);
        }
    }

    /* compiled from: BuyCanceledController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.BuyCanceledController$b */
    static final class C4624b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ BuyCanceledController this$0;

        C4624b(BuyCanceledController buyCanceledController) {
            this.this$0 = buyCanceledController;
            super(1);
        }

        /* renamed from: a */
        public final void m20499a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    public BuyCanceledController() {
        setHasOptionsMenu(true);
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

    public final int getClickedViewId() {
        return this.clickedViewId;
    }

    public final void setClickedViewId(int i) {
        this.clickedViewId = i;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_buy_canceled, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…nceled, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        initAppBar();
    }

    public final void initAppBar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        Resources resources = getResources();
        toolbar.setTitle((CharSequence) resources != null ? resources.getString(R.string.cancel_reason) : null);
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

    @OnClick
    public final void onReasonClick(View view) {
        C0700j.m2715b(view, "clickView");
        View view2 = getView();
        if (view2 == null) {
            C0700j.m2709a();
        }
        Snackbar.m15345a(view2, (int) R.string.thanks_for_your_feedback, -1).mo1269f();
        this.clickedViewId = view.getId();
        view = ParkingManager.INSTANCE.getActiveParking();
        if (view != null) {
            view = view.getParking();
            if (view != null) {
                view = view.getId();
                if (view != null) {
                    long longValue = ((Number) view).longValue();
                    view = CancelReason.Companion.byId(this.clickedViewId);
                    Analytics analytics = Analytics.INSTANCE;
                    ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
                    if (activeParking == null) {
                        C0700j.m2709a();
                    }
                    Parking parking = activeParking.getParking();
                    ParkingAdvert activeParking2 = ParkingManager.INSTANCE.getActiveParking();
                    if (activeParking2 == null) {
                        C0700j.m2709a();
                    }
                    analytics.cancelTrip(parking, activeParking2.getType(), view);
                    ControllerExKt.showProgress$default(this, null, 1, null);
                    Object a = ApiManager.INSTANCE.cancelParking(longValue, view).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                    C0700j.m2711a(a, "ApiManager.cancelParking…dSchedulers.mainThread())");
                    C2517a.m10349a(a, (C0690b) new C4624b(this), null, (C0690b) new C4623a(this), 2, null);
                }
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0700j.m2715b(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getRouter().m3169l();
        return true;
    }
}
