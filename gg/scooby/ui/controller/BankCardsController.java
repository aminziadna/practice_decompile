package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
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
import io.p181b.p197g.C2517a;
import java.util.List;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p043a.C3033j;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.AcquiringCredentialsProvider;
import ru.gg.scooby.manager.BankCardsManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.ui.adapter.BankCardsAdapter;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.custom.MiddleItemsDecorator;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.skooby.R;
import ru.tinkoff.acquiring.sdk.AttachCardFormActivity;
import ru.tinkoff.acquiring.sdk.C2765g;
import ru.tinkoff.acquiring.sdk.C2766h;

/* compiled from: BankCardsController.kt */
public final class BankCardsController extends BaseController {
    public static final int ATTACH_REQUEST_CODE = 101;
    public static final Companion Companion = new Companion();
    public BankCardsAdapter adapter;
    @BindView
    public View blockPrimaryCard;
    @BindView
    public RecyclerView cardsList;
    @BindView
    public View emptyView;
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public View listContainer;
    @BindView
    public TextView screenTitle;
    @BindView
    public TextView textPrimaryCard;

    /* compiled from: BankCardsController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: BankCardsController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.BankCardsController$a */
    static final class C4620a extends C3038k implements C0690b<C2766h, C0727n> {
        final /* synthetic */ BankCardsController this$0;

        C4620a(BankCardsController bankCardsController) {
            this.this$0 = bankCardsController;
            super(1);
        }

        /* renamed from: a */
        public final void m20491a(C2766h c2766h) {
            C0818i router = this.this$0.getRouter();
            C0700j.m2711a((Object) c2766h, "it");
            String b = c2766h.m11387b();
            C0700j.m2711a((Object) b, "it.cardId");
            router.m3151b(C0820k.m3183a((C0809d) new BankCardEditController(b)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
        }
    }

    /* compiled from: BankCardsController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.BankCardsController$b */
    static final class C4621b extends C3038k implements C0690b<List<? extends C2766h>, C0727n> {
        final /* synthetic */ BankCardsController this$0;

        C4621b(BankCardsController bankCardsController) {
            this.this$0 = bankCardsController;
            super(1);
        }

        /* renamed from: a */
        public final void m20493a(List<? extends C2766h> list) {
            C0700j.m2715b(list, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            this.this$0.updateScreenState(list);
        }
    }

    /* compiled from: BankCardsController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.BankCardsController$c */
    static final class C4622c extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ BankCardsController this$0;

        C4622c(BankCardsController bankCardsController) {
            this.this$0 = bankCardsController;
            super(1);
        }

        /* renamed from: a */
        public final void m20495a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
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

    public final RecyclerView getCardsList() {
        RecyclerView recyclerView = this.cardsList;
        if (recyclerView == null) {
            C0700j.m2716b("cardsList");
        }
        return recyclerView;
    }

    public final void setCardsList(RecyclerView recyclerView) {
        C0700j.m2715b(recyclerView, "<set-?>");
        this.cardsList = recyclerView;
    }

    public final View getBlockPrimaryCard() {
        View view = this.blockPrimaryCard;
        if (view == null) {
            C0700j.m2716b("blockPrimaryCard");
        }
        return view;
    }

    public final void setBlockPrimaryCard(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.blockPrimaryCard = view;
    }

    public final TextView getTextPrimaryCard() {
        TextView textView = this.textPrimaryCard;
        if (textView == null) {
            C0700j.m2716b("textPrimaryCard");
        }
        return textView;
    }

    public final void setTextPrimaryCard(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textPrimaryCard = textView;
    }

    public final BankCardsAdapter getAdapter() {
        BankCardsAdapter bankCardsAdapter = this.adapter;
        if (bankCardsAdapter == null) {
            C0700j.m2716b("adapter");
        }
        return bankCardsAdapter;
    }

    public final void setAdapter(BankCardsAdapter bankCardsAdapter) {
        C0700j.m2715b(bankCardsAdapter, "<set-?>");
        this.adapter = bankCardsAdapter;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_bank_cards, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…_cards, container, false)");
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
        view.setText(R.string.profile_bank_cards);
        view = this.blockPrimaryCard;
        if (view == null) {
            C0700j.m2716b("blockPrimaryCard");
        }
        view.setVisibility(8);
        view = this.emptyView;
        if (view == null) {
            C0700j.m2716b("emptyView");
        }
        view.setVisibility(8);
        view = this.listContainer;
        if (view == null) {
            C0700j.m2716b("listContainer");
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
        RecyclerView recyclerView = this.cardsList;
        if (recyclerView == null) {
            C0700j.m2716b("cardsList");
        }
        Object from = LayoutInflater.from(recyclerView.getContext());
        C0700j.m2711a(from, "LayoutInflater.from(cardsList.context)");
        this.adapter = new BankCardsAdapter(from);
        BankCardsAdapter bankCardsAdapter = this.adapter;
        if (bankCardsAdapter == null) {
            C0700j.m2716b("adapter");
        }
        C2517a.m10349a(bankCardsAdapter.getClickListenerSubject(), null, null, new C4620a(this), 3, null);
        RecyclerView recyclerView2 = this.cardsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("cardsList");
        }
        recyclerView2.setHasFixedSize(true);
        recyclerView2 = this.cardsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("cardsList");
        }
        BankCardsAdapter bankCardsAdapter2 = this.adapter;
        if (bankCardsAdapter2 == null) {
            C0700j.m2716b("adapter");
        }
        recyclerView2.setAdapter(bankCardsAdapter2);
        recyclerView2 = this.cardsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("cardsList");
        }
        RecyclerView recyclerView3 = this.cardsList;
        if (recyclerView3 == null) {
            C0700j.m2716b("cardsList");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        recyclerView2 = this.cardsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("cardsList");
        }
        recyclerView3 = this.cardsList;
        if (recyclerView3 == null) {
            C0700j.m2716b("cardsList");
        }
        Object drawable = recyclerView3.getResources().getDrawable(R.drawable.bg_divider_with_padding);
        C0700j.m2711a(drawable, "cardsList.resources.getD….bg_divider_with_padding)");
        recyclerView2.m20860a((C0595h) new MiddleItemsDecorator(drawable));
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        loadCards();
    }

    public final void loadCards() {
        ControllerExKt.showProgress$default(this, null, 1, null);
        C2517a.m10349a(BankCardsManager.INSTANCE.loadCards(), new C4622c(this), null, new C4621b(this), 2, null);
    }

    public final void updateScreenState(List<? extends C2766h> list) {
        C0700j.m2715b(list, "cards");
        View view;
        LayoutParams layoutParams;
        MarginLayoutParams marginLayoutParams;
        View view2;
        BankCardsAdapter bankCardsAdapter;
        switch (list.size()) {
            case 0:
                list = this.blockPrimaryCard;
                if (list == null) {
                    C0700j.m2716b("blockPrimaryCard");
                }
                list.setVisibility(8);
                list = this.emptyView;
                if (list == null) {
                    C0700j.m2716b("emptyView");
                }
                list.setVisibility(0);
                list = this.listContainer;
                if (list == null) {
                    C0700j.m2716b("listContainer");
                }
                list.setVisibility(8);
                list = this.adapter;
                if (list == null) {
                    C0700j.m2716b("adapter");
                }
                list.updateItems(C3033j.m13044a());
                return;
            case 1:
                view = this.blockPrimaryCard;
                if (view == null) {
                    C0700j.m2716b("blockPrimaryCard");
                }
                view.setVisibility(8);
                view = this.emptyView;
                if (view == null) {
                    C0700j.m2716b("emptyView");
                }
                view.setVisibility(8);
                view = this.listContainer;
                if (view == null) {
                    C0700j.m2716b("listContainer");
                }
                view.setVisibility(0);
                view = this.listContainer;
                if (view == null) {
                    C0700j.m2716b("listContainer");
                }
                layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    marginLayoutParams = (MarginLayoutParams) layoutParams;
                    view2 = this.listContainer;
                    if (view2 == null) {
                        C0700j.m2716b("listContainer");
                    }
                    marginLayoutParams.topMargin = view2.getResources().getDimensionPixelSize(R.dimen.cars_content_big_margin_top);
                    bankCardsAdapter = this.adapter;
                    if (bankCardsAdapter == null) {
                        C0700j.m2716b("adapter");
                    }
                    bankCardsAdapter.updateItems(list);
                    return;
                }
                throw new C0724k("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            default:
                String a;
                C2766h b = BankCardsManager.INSTANCE.getCardManager().m11409b(Settings.INSTANCE.getPrimaryCardId());
                if (b != null) {
                    a = b.m11386a();
                } else {
                    a = null;
                }
                View view3 = this.blockPrimaryCard;
                if (view3 == null) {
                    C0700j.m2716b("blockPrimaryCard");
                }
                view3.setVisibility(0);
                view3 = this.emptyView;
                if (view3 == null) {
                    C0700j.m2716b("emptyView");
                }
                view3.setVisibility(8);
                TextView textView = this.textPrimaryCard;
                if (textView == null) {
                    C0700j.m2716b("textPrimaryCard");
                }
                textView.setText(a);
                view = this.listContainer;
                if (view == null) {
                    C0700j.m2716b("listContainer");
                }
                view.setVisibility(0);
                view = this.listContainer;
                if (view == null) {
                    C0700j.m2716b("listContainer");
                }
                layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    marginLayoutParams = (MarginLayoutParams) layoutParams;
                    view2 = this.listContainer;
                    if (view2 == null) {
                        C0700j.m2716b("listContainer");
                    }
                    marginLayoutParams.topMargin = view2.getResources().getDimensionPixelSize(R.dimen.cars_content_small_margin_top);
                    bankCardsAdapter = this.adapter;
                    if (bankCardsAdapter == null) {
                        C0700j.m2716b("adapter");
                    }
                    bankCardsAdapter.updateItems(list);
                    return;
                }
                throw new C0724k("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }

    @OnClick
    public final void onAddButtonClick() {
        Object a = new C2765g(AcquiringCredentialsProvider.INSTANCE.getTERMINAL_KEY(), AcquiringCredentialsProvider.INSTANCE.getPASSWORD(), AcquiringCredentialsProvider.INSTANCE.getPUBLIC_KEY()).m11385a(AcquiringCredentialsProvider.INSTANCE.getCUSTOMER_ID(), AcquiringCredentialsProvider.INSTANCE.getCHECK_TYPE(), true, null).m11383a(R.style.AttachCardAcquiringTheme);
        C0700j.m2711a(a, "AttachCardFormStarter(Ac…AttachCardAcquiringTheme)");
        Intent a2 = a.m11382a();
        a2.setClass(getActivity(), AttachCardFormActivity.class);
        startActivityForResult(a2, 101);
    }

    @OnClick
    public final void onPrimaryCardClick() {
        getRouter().m3151b(C0820k.m3183a((C0809d) new SelectPrimaryBankCardController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 101 && i2 == -1 && intent != null) {
            i = intent.getStringExtra("card_id");
            if (i != 0) {
                if ((((CharSequence) Settings.INSTANCE.getPrimaryCardId()).length() == 0 ? 1 : 0) != 0) {
                    Settings.INSTANCE.setPrimaryCardId(i);
                }
            }
        }
    }
}
