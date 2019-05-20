package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import com.bluelinelabs.conductor.C0809d;
import io.card.payment.BuildConfig;
import p042b.C0724k;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.model.field.FieldId;
import ru.gg.scooby.ui.input.field.SimpleTextField;
import ru.gg.scooby.ui.input.form.Form;
import ru.gg.scooby.util.BundleBuilder;
import ru.skooby.R;

/* compiled from: CarNumberController.kt */
public final class CarNumberController extends BaseController {
    public static final String ARG_NUMBER = "ARG_NUMBER";
    public static final Companion Companion = new Companion();
    private Form form;
    @BindView
    public TextView submitButton;
    @BindView
    public TextView textNumber;
    @BindView
    public Toolbar toolbar;

    /* compiled from: CarNumberController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: CarNumberController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.CarNumberController$a */
    static final class C2674a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CarNumberController f8293a;

        C2674a(CarNumberController carNumberController) {
            this.f8293a = carNumberController;
        }

        public final void onClick(View view) {
            this.f8293a.validateAndSave();
        }
    }

    public CarNumberController() {
        this(null, 1, null);
    }

    public CarNumberController(String str) {
        C0700j.m2715b(str, "number");
        super(new BundleBuilder(new Bundle()).putString(ARG_NUMBER, str).build());
        setHasOptionsMenu(true);
    }

    public /* synthetic */ CarNumberController(String str, int i, C0697g c0697g) {
        if ((i & 1) != 0) {
            str = BuildConfig.FLAVOR;
        }
        this(str);
    }

    public final TextView getTextNumber() {
        TextView textView = this.textNumber;
        if (textView == null) {
            C0700j.m2716b("textNumber");
        }
        return textView;
    }

    public final void setTextNumber(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textNumber = textView;
    }

    public final TextView getSubmitButton() {
        TextView textView = this.submitButton;
        if (textView == null) {
            C0700j.m2716b("submitButton");
        }
        return textView;
    }

    public final void setSubmitButton(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.submitButton = textView;
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

    public final Form getForm() {
        return this.form;
    }

    public final void setForm(Form form) {
        this.form = form;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_car_number, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…number, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        view = this.textNumber;
        if (view == null) {
            C0700j.m2716b("textNumber");
        }
        view.setText(getArgs().getString(ARG_NUMBER));
        view = this.submitButton;
        if (view == null) {
            C0700j.m2716b("submitButton");
        }
        view.setOnClickListener(new C2674a(this));
        initForm();
        initAppBar();
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        view = getActivity();
        if (view != null) {
            view = view.getWindow();
            if (view != null) {
                view.setSoftInputMode(16);
            }
        }
    }

    public final void validateAndSave() {
        Form form = this.form;
        if (form != null) {
            if (form.validate()) {
                Activity activity = getActivity();
                if (activity != null) {
                    Window window = activity.getWindow();
                    if (window != null) {
                        window.setSoftInputMode(32);
                    }
                }
                C0809d targetController = getTargetController();
                if (targetController != null) {
                    CarAttributeListener carAttributeListener = (CarAttributeListener) targetController;
                    TextView textView = this.textNumber;
                    if (textView == null) {
                        C0700j.m2716b("textNumber");
                    }
                    carAttributeListener.onAttributeSelected(3, textView.getText().toString());
                    getRouter().m3169l();
                    return;
                }
                throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.CarAttributeListener");
            }
        }
    }

    public final void initForm() {
        this.form = new Form();
        Form form = this.form;
        if (form != null) {
            FieldId fieldId = FieldId.Name;
            Resources resources = getResources();
            if (resources == null) {
                C0700j.m2709a();
            }
            Object string = resources.getString(R.string.cars_number);
            C0700j.m2711a(string, "resources!!.getString(R.string.cars_number)");
            TextView textView = this.textNumber;
            if (textView == null) {
                C0700j.m2716b("textNumber");
            }
            form.add(fieldId, new SimpleTextField(string, textView, null, false, 12, null));
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

    private final void initAppBar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        Resources resources = getResources();
        toolbar.setTitle((CharSequence) resources != null ? resources.getString(R.string.cars_number_hint) : null);
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
}
