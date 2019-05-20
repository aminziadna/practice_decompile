package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C0595h;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.List;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.TemplatesManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.PaymentTemplate;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.ui.adapter.TemplatesAdapter;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.custom.MiddleItemsDecorator;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.skooby.R;

/* compiled from: FinancesController.kt */
public final class FinancesController extends BaseController {
    public TemplatesAdapter adapter;
    @BindView
    public TextView balanceText;
    @BindView
    public View emptyView;
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public View listContainer;
    @BindView
    public TextView screenTitle;
    @BindView
    public RecyclerView templatesList;

    /* compiled from: FinancesController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.FinancesController$a */
    static final class C4630a extends C3038k implements C0690b<List<? extends PaymentTemplate>, C0727n> {
        final /* synthetic */ FinancesController this$0;

        C4630a(FinancesController financesController) {
            this.this$0 = financesController;
            super(1);
        }

        /* renamed from: a */
        public final void m20511a(List<PaymentTemplate> list) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            TemplatesAdapter adapter = this.this$0.getAdapter();
            C0700j.m2711a((Object) list, "it");
            adapter.updateItems(list);
            if (list.isEmpty() != null) {
                this.this$0.getEmptyView().setVisibility(0);
                this.this$0.getListContainer().setVisibility(8);
                return;
            }
            this.this$0.getEmptyView().setVisibility(8);
            this.this$0.getListContainer().setVisibility(0);
        }
    }

    /* compiled from: FinancesController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.FinancesController$b */
    static final class C4631b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ FinancesController this$0;

        C4631b(FinancesController financesController) {
            this.this$0 = financesController;
            super(1);
        }

        /* renamed from: a */
        public final void m20513a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: FinancesController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.FinancesController$c */
    static final class C4632c extends C3038k implements C0690b<PaymentTemplate, C0727n> {
        final /* synthetic */ FinancesController this$0;

        C4632c(FinancesController financesController) {
            this.this$0 = financesController;
            super(1);
        }

        /* renamed from: a */
        public final void m20515a(PaymentTemplate paymentTemplate) {
            C0818i router = this.this$0.getRouter();
            C0700j.m2711a((Object) paymentTemplate, "it");
            router.m3151b(C0820k.m3183a((C0809d) new PaymentCheckController(paymentTemplate)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
        }
    }

    public final AvatarImageView getImageAvatar() {
        AvatarImageView avatarImageView = this.imageAvatar;
        if (avatarImageView == null) {
            C0700j.m2716b("imageAvatar");
        }
        return avatarImageView;
    }

    public final void setImageAvatar(AvatarImageView avatarImageView) {
        C0700j.m2715b(avatarImageView, "<set-?>");
        this.imageAvatar = avatarImageView;
    }

    public final View getEmptyView() {
        View view = this.emptyView;
        if (view == null) {
            C0700j.m2716b("emptyView");
        }
        return view;
    }

    public final void setEmptyView(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.emptyView = view;
    }

    public final TextView getScreenTitle() {
        TextView textView = this.screenTitle;
        if (textView == null) {
            C0700j.m2716b("screenTitle");
        }
        return textView;
    }

    public final void setScreenTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.screenTitle = textView;
    }

    public final View getListContainer() {
        View view = this.listContainer;
        if (view == null) {
            C0700j.m2716b("listContainer");
        }
        return view;
    }

    public final void setListContainer(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.listContainer = view;
    }

    public final RecyclerView getTemplatesList() {
        RecyclerView recyclerView = this.templatesList;
        if (recyclerView == null) {
            C0700j.m2716b("templatesList");
        }
        return recyclerView;
    }

    public final void setTemplatesList(RecyclerView recyclerView) {
        C0700j.m2715b(recyclerView, "<set-?>");
        this.templatesList = recyclerView;
    }

    public final TextView getBalanceText() {
        TextView textView = this.balanceText;
        if (textView == null) {
            C0700j.m2716b("balanceText");
        }
        return textView;
    }

    public final void setBalanceText(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.balanceText = textView;
    }

    public final TemplatesAdapter getAdapter() {
        TemplatesAdapter templatesAdapter = this.adapter;
        if (templatesAdapter == null) {
            C0700j.m2716b("adapter");
        }
        return templatesAdapter;
    }

    public final void setAdapter(TemplatesAdapter templatesAdapter) {
        C0700j.m2715b(templatesAdapter, "<set-?>");
        this.adapter = templatesAdapter;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_finances, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…nances, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        String str = null;
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.profile_status_bar), false, 8, null));
        view = this.screenTitle;
        if (view == null) {
            C0700j.m2716b("screenTitle");
        }
        view.setText(R.string.profile_finances);
        view = this.balanceText;
        if (view == null) {
            C0700j.m2716b("balanceText");
        }
        view.setText(UserManager.INSTANCE.getBalanceWithCurrency());
        view = this.listContainer;
        if (view == null) {
            C0700j.m2716b("listContainer");
        }
        view.setVisibility(8);
        view = this.emptyView;
        if (view == null) {
            C0700j.m2716b("emptyView");
        }
        view.setVisibility(8);
        initList();
        view = this.imageAvatar;
        if (view == null) {
            C0700j.m2716b("imageAvatar");
        }
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                str = profile.getAvatarUrl();
            }
        }
        view.setTargetImageUrl(str);
    }

    public final void initList() {
        RecyclerView recyclerView = this.templatesList;
        if (recyclerView == null) {
            C0700j.m2716b("templatesList");
        }
        Object from = LayoutInflater.from(recyclerView.getContext());
        C0700j.m2711a(from, "LayoutInflater.from(templatesList.context)");
        this.adapter = new TemplatesAdapter(from);
        TemplatesAdapter templatesAdapter = this.adapter;
        if (templatesAdapter == null) {
            C0700j.m2716b("adapter");
        }
        C2517a.m10349a(templatesAdapter.getClickListenerSubject(), null, null, new C4632c(this), 3, null);
        RecyclerView recyclerView2 = this.templatesList;
        if (recyclerView2 == null) {
            C0700j.m2716b("templatesList");
        }
        recyclerView2.setHasFixedSize(true);
        recyclerView2 = this.templatesList;
        if (recyclerView2 == null) {
            C0700j.m2716b("templatesList");
        }
        TemplatesAdapter templatesAdapter2 = this.adapter;
        if (templatesAdapter2 == null) {
            C0700j.m2716b("adapter");
        }
        recyclerView2.setAdapter(templatesAdapter2);
        recyclerView2 = this.templatesList;
        if (recyclerView2 == null) {
            C0700j.m2716b("templatesList");
        }
        RecyclerView recyclerView3 = this.templatesList;
        if (recyclerView3 == null) {
            C0700j.m2716b("templatesList");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        recyclerView2 = this.templatesList;
        if (recyclerView2 == null) {
            C0700j.m2716b("templatesList");
        }
        recyclerView3 = this.templatesList;
        if (recyclerView3 == null) {
            C0700j.m2716b("templatesList");
        }
        Object drawable = recyclerView3.getResources().getDrawable(R.drawable.bg_divider_with_padding);
        C0700j.m2711a(drawable, "templatesList.resources.….bg_divider_with_padding)");
        recyclerView2.m20860a((C0595h) new MiddleItemsDecorator(drawable));
    }

    public final void fillAdapter() {
        TemplatesAdapter templatesAdapter = this.adapter;
        if (templatesAdapter == null) {
            C0700j.m2716b("adapter");
        }
        if (templatesAdapter.getItemCount() == 0) {
            ControllerExKt.showProgress$default(this, null, 1, null);
        }
        Object a = TemplatesManager.INSTANCE.getTemplates().m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "TemplatesManager.getTemp…dSchedulers.mainThread())");
        C2517a.m10349a(a, new C4631b(this), null, new C4630a(this), 2, null);
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        fillAdapter();
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }

    @OnClick
    public final void onAddButtonClick() {
        getRouter().m3151b(C0820k.m3183a((C0809d) new CreateTemplateController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }
}
