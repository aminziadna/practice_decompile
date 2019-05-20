package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.google.android.material.snackbar.Snackbar;
import io.card.payment.BuildConfig;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p185b.C2468b;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p042b.p053i.C4773o;
import p165d.C2342r;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.field.FieldId;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.network.ApiService;
import ru.gg.scooby.ui.input.field.SimpleTextField;
import ru.gg.scooby.ui.input.form.Form;
import ru.gg.scooby.ui.input.validator.TextValidator;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.BundleBuilder;
import ru.skooby.R;

/* compiled from: ProfileNameController.kt */
public final class ProfileNameController extends BaseController {
    public static final String ARG_NAME = "ARG_NAME";
    public static final String ARG_OPERATION_TYPE = "ARG_OPERATION_TYPE";
    public static final Companion Companion = new Companion();
    public static final int OPERATION_CREATE = 0;
    public static final int OPERATION_EDIT = 1;
    private Form form;
    @BindView
    public TextView nameText;
    @BindView
    public TextView submitButton;
    private C2468b subscription;
    @BindView
    public Toolbar toolbar;

    /* compiled from: ProfileNameController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: ProfileNameController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileNameController$a */
    static final class C2691a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ ProfileNameController f8314a;

        C2691a(ProfileNameController profileNameController) {
            this.f8314a = profileNameController;
        }

        public final void onClick(View view) {
            this.f8314a.saveUserName();
        }
    }

    /* compiled from: ProfileNameController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileNameController$b */
    static final class C4649b extends C3038k implements C0690b<C2342r<Void>, C0727n> {
        final /* synthetic */ String $name;
        final /* synthetic */ ProfileNameController this$0;

        C4649b(ProfileNameController profileNameController, String str) {
            this.this$0 = profileNameController;
            this.$name = str;
            super(1);
        }

        /* renamed from: a */
        public final void m20549a(C2342r<Void> c2342r) {
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
                UserManager.INSTANCE.updateName(this.$name);
                this.this$0.showNextScreen();
                View view = this.this$0.getView();
                if (view == null) {
                    C0700j.m2709a();
                }
                Snackbar.m15345a(view, (int) R.string.changes_saved, -1).mo1269f();
                return;
            }
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view2 = this.this$0.getView();
            if (view2 == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view2, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: ProfileNameController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.ProfileNameController$c */
    static final class C4650c extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ ProfileNameController this$0;

        C4650c(ProfileNameController profileNameController) {
            this.this$0 = profileNameController;
            super(1);
        }

        /* renamed from: a */
        public final void m20551a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    public ProfileNameController() {
        this(0, null, 3, null);
    }

    public ProfileNameController(int i, String str) {
        C0700j.m2715b(str, "name");
        super(new BundleBuilder(new Bundle()).putString(ARG_NAME, str).putInt("ARG_OPERATION_TYPE", i).build());
        setHasOptionsMenu(1);
    }

    public /* synthetic */ ProfileNameController(int i, String str, int i2, C0697g c0697g) {
        if ((i2 & 1) != null) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            str = BuildConfig.FLAVOR;
        }
        this(i, str);
    }

    public final TextView getNameText() {
        TextView textView = this.nameText;
        if (textView == null) {
            C0700j.m2716b("nameText");
        }
        return textView;
    }

    public final void setNameText(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.nameText = textView;
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

    public final C2468b getSubscription() {
        return this.subscription;
    }

    public final void setSubscription(C2468b c2468b) {
        this.subscription = c2468b;
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
        Object inflate = layoutInflater.inflate(R.layout.controller_profile_name, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…e_name, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        view = this.nameText;
        if (view == null) {
            C0700j.m2716b("nameText");
        }
        view.setText(getArgs().getString(ARG_NAME));
        view = this.submitButton;
        if (view == null) {
            C0700j.m2716b("submitButton");
        }
        view.setOnClickListener(new C2691a(this));
        initAppBar();
        initForm();
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

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        C0700j.m2715b(menu, "menu");
        C0700j.m2715b(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_profile_name_controller, menu);
        menu.findItem(R.id.skip).setVisible(getArgs().getInt("ARG_OPERATION_TYPE") == null ? true : null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0700j.m2715b(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId != 16908332 && itemId != R.id.skip) {
            return super.onOptionsItemSelected(menuItem);
        }
        showNextScreen();
        return true;
    }

    public final void saveUserName() {
        Form form = this.form;
        if (form != null) {
            if (form.validate()) {
                ControllerExKt.showProgress$default(this, null, 1, null);
                TextView textView = this.nameText;
                if (textView == null) {
                    C0700j.m2716b("nameText");
                }
                Object text = textView.getText();
                C0700j.m2711a(text, "nameText.text");
                String obj = C4773o.m22222a(text).toString();
                ApiService service = ApiManager.INSTANCE.getService();
                String phone = UserManager.INSTANCE.getPhone();
                TextView textView2 = this.nameText;
                if (textView2 == null) {
                    C0700j.m2716b("nameText");
                }
                Object text2 = textView2.getText();
                C0700j.m2711a(text2, "nameText.text");
                text2 = service.updateUserName(phone, C4773o.m22222a(text2).toString()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                C0700j.m2711a(text2, "ApiManager.service.updat…dSchedulers.mainThread())");
                this.subscription = C2517a.m10349a(text2, new C4650c(this), null, new C4649b(this, obj), 2, null);
            }
        }
    }

    public final void showNextScreen() {
        Activity activity = getActivity();
        if (activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                window.setSoftInputMode(32);
            }
        }
        if (getArgs().getInt("ARG_OPERATION_TYPE") == 1) {
            getRouter().m3169l();
            return;
        }
        UserManager.INSTANCE.setAskToSetName(false);
        Object router = getRouter();
        C0700j.m2711a(router, "router");
        Object a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b());
        C0700j.m2711a(a, "RouterTransaction.with(S…orizontalChangeHandler())");
        C0819j.m3181a(router, a);
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
            Object string = resources.getString(R.string.profile_name);
            C0700j.m2711a(string, "resources!!.getString(R.string.profile_name)");
            TextView textView = this.nameText;
            if (textView == null) {
                C0700j.m2716b("nameText");
            }
            form.add(fieldId, new SimpleTextField(string, textView, TextValidator.Companion.getINSTANCE(), false, 8, null));
        }
    }

    private final void initAppBar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        Resources resources = getResources();
        toolbar.setTitle((CharSequence) resources != null ? resources.getString(R.string.profile) : null);
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

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        super.onDetach(view);
        view = this.subscription;
        if (view != null) {
            view.mo1727a();
        }
    }
}
