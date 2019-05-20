package ru.gg.scooby.ui.controller;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import p042b.C0724k;
import p042b.p043a.C4684f;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.settings.DevSettings;
import ru.gg.scooby.settings.Environment;
import ru.skooby.R;

/* compiled from: DevSettingsController.kt */
public final class DevSettingsController extends BaseController {
    @BindView
    public View buttonChangeServer;
    @BindView
    public CheckBox reducedPricesCheckbox;
    @BindView
    public Spinner spinnerEnvironment;
    private Environment tempEnvironment;
    @BindView
    public Toolbar toolbar;

    public final Spinner getSpinnerEnvironment() {
        Spinner spinner = this.spinnerEnvironment;
        if (spinner == null) {
            C0700j.m2716b("spinnerEnvironment");
        }
        return spinner;
    }

    public final void setSpinnerEnvironment(Spinner spinner) {
        C0700j.m2715b(spinner, "<set-?>");
        this.spinnerEnvironment = spinner;
    }

    public final View getButtonChangeServer() {
        View view = this.buttonChangeServer;
        if (view == null) {
            C0700j.m2716b("buttonChangeServer");
        }
        return view;
    }

    public final void setButtonChangeServer(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.buttonChangeServer = view;
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

    public final CheckBox getReducedPricesCheckbox() {
        CheckBox checkBox = this.reducedPricesCheckbox;
        if (checkBox == null) {
            C0700j.m2716b("reducedPricesCheckbox");
        }
        return checkBox;
    }

    public final void setReducedPricesCheckbox(CheckBox checkBox) {
        C0700j.m2715b(checkBox, "<set-?>");
        this.reducedPricesCheckbox = checkBox;
    }

    public final Environment getTempEnvironment() {
        return this.tempEnvironment;
    }

    public final void setTempEnvironment(Environment environment) {
        this.tempEnvironment = environment;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_dev_settings, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…ttings, container, false)");
        return inflate;
    }

    private final void initAppBar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        Resources resources = getResources();
        toolbar.setTitle((CharSequence) resources != null ? resources.getString(R.string.profile_dev_settings) : null);
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
    public final void onChangeServerClick() {
        Environment environment = this.tempEnvironment;
        if (environment != null) {
            DevSettings.INSTANCE.setEnvironment(environment);
        }
        UserManager.INSTANCE.logout();
        ApiManager.INSTANCE.recreateAdapterAndService();
        Object router = getRouter();
        C0700j.m2711a(router, "router");
        Object a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b());
        C0700j.m2711a(a, "RouterTransaction.with(S…orizontalChangeHandler())");
        C0819j.m3181a(router, a);
    }

    @OnItemSelected
    public final void onEnvironmentItemClick(int i) {
        Spinner spinner = this.spinnerEnvironment;
        if (spinner == null) {
            C0700j.m2716b("spinnerEnvironment");
        }
        i = spinner.getAdapter().getItem(i);
        if (i != 0) {
            this.tempEnvironment = (Environment) i;
            updateChangeServerButtonVisibility();
            return;
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.settings.Environment");
    }

    @OnCheckedChanged
    public final void onReducedPricesCheckedChanged(boolean z) {
        DevSettings.INSTANCE.setReducedPrices(z);
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Environment[] values = Environment.values();
        ArrayAdapter arrayAdapter = new ArrayAdapter(view.getContext(), 17367048, values);
        arrayAdapter.setDropDownViewResource(17367049);
        view = this.spinnerEnvironment;
        if (view == null) {
            C0700j.m2716b("spinnerEnvironment");
        }
        view.setAdapter(arrayAdapter);
        this.tempEnvironment = DevSettings.INSTANCE.getEnvironment();
        updateChangeServerButtonVisibility();
        view = this.spinnerEnvironment;
        if (view == null) {
            C0700j.m2716b("spinnerEnvironment");
        }
        view.setSelection(C4684f.m20936b(values, this.tempEnvironment));
        view = this.reducedPricesCheckbox;
        if (view == null) {
            C0700j.m2716b("reducedPricesCheckbox");
        }
        view.setChecked(DevSettings.INSTANCE.getReducedPrices());
        initAppBar();
    }

    public final void updateChangeServerButtonVisibility() {
        View view = this.buttonChangeServer;
        if (view == null) {
            C0700j.m2716b("buttonChangeServer");
        }
        view.setVisibility(DevSettings.INSTANCE.getEnvironment() == this.tempEnvironment ? 8 : 0);
    }
}
