package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.skooby.R;

public final class DevSettingsController_ViewBinding implements Unbinder {
    private DevSettingsController target;
    private View view7f090089;
    private View view7f0900b4;
    private View view7f090191;

    public DevSettingsController_ViewBinding(final DevSettingsController devSettingsController, View view) {
        this.target = devSettingsController;
        View a = C0730b.m2750a(view, R.id.spinner_environment, "field 'spinnerEnvironment' and method 'onEnvironmentItemClick'");
        devSettingsController.spinnerEnvironment = (Spinner) C0730b.m2753b(a, R.id.spinner_environment, "field 'spinnerEnvironment'", Spinner.class);
        this.view7f090191 = a;
        ((AdapterView) a).setOnItemSelectedListener(new OnItemSelectedListener(this) {
            /* renamed from: b */
            final /* synthetic */ DevSettingsController_ViewBinding f8296b;

            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                devSettingsController.onEnvironmentItemClick(i);
            }
        });
        a = C0730b.m2750a(view, R.id.btn_change_server, "field 'buttonChangeServer' and method 'onChangeServerClick'");
        devSettingsController.buttonChangeServer = a;
        this.view7f090089 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ DevSettingsController_ViewBinding f12740c;

            /* renamed from: a */
            public void mo1911a(View view) {
                devSettingsController.onChangeServerClick();
            }
        });
        devSettingsController.toolbar = (Toolbar) C0730b.m2751a(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        view = C0730b.m2750a(view, R.id.checkbox_reduced_prices, "field 'reducedPricesCheckbox' and method 'onReducedPricesCheckedChanged'");
        devSettingsController.reducedPricesCheckbox = (CheckBox) C0730b.m2753b(view, R.id.checkbox_reduced_prices, "field 'reducedPricesCheckbox'", CheckBox.class);
        this.view7f0900b4 = view;
        ((CompoundButton) view).setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            /* renamed from: b */
            final /* synthetic */ DevSettingsController_ViewBinding f8298b;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                devSettingsController.onReducedPricesCheckedChanged(z);
            }
        });
    }

    public void unbind() {
        DevSettingsController devSettingsController = this.target;
        if (devSettingsController != null) {
            this.target = null;
            devSettingsController.spinnerEnvironment = null;
            devSettingsController.buttonChangeServer = null;
            devSettingsController.toolbar = null;
            devSettingsController.reducedPricesCheckbox = null;
            ((AdapterView) this.view7f090191).setOnItemSelectedListener(null);
            this.view7f090191 = null;
            this.view7f090089.setOnClickListener(null);
            this.view7f090089 = null;
            ((CompoundButton) this.view7f0900b4).setOnCheckedChangeListener(null);
            this.view7f0900b4 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
