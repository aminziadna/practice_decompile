package ru.gg.scooby.ui.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C0595h;
import butterknife.BindView;
import butterknife.OnClick;
import io.p181b.p197g.C2517a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.manager.BankCardsManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.settings.Settings;
import ru.gg.scooby.ui.adapter.BankCardsAdapter;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.custom.MiddleItemsDecorator;
import ru.skooby.R;
import ru.tinkoff.acquiring.sdk.C2766h;

/* compiled from: SelectPrimaryBankCardController.kt */
public final class SelectPrimaryBankCardController extends BaseController {
    public BankCardsAdapter adapter;
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public RecyclerView list;
    @BindView
    public TextView screenTitle;

    /* compiled from: SelectPrimaryBankCardController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SelectPrimaryBankCardController$a */
    static final class C4651a extends C3038k implements C0690b<C2766h, C0727n> {
        final /* synthetic */ SelectPrimaryBankCardController this$0;

        C4651a(SelectPrimaryBankCardController selectPrimaryBankCardController) {
            this.this$0 = selectPrimaryBankCardController;
            super(1);
        }

        /* renamed from: a */
        public final void m20553a(C2766h c2766h) {
            C0700j.m2711a((Object) c2766h, "it");
            c2766h = c2766h.m11387b();
            if (c2766h != null) {
                Settings.INSTANCE.setPrimaryCardId(c2766h);
                this.this$0.getRouter().m3169l();
            }
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

    public final RecyclerView getList() {
        RecyclerView recyclerView = this.list;
        if (recyclerView == null) {
            C0700j.m2716b("list");
        }
        return recyclerView;
    }

    public final void setList(RecyclerView recyclerView) {
        C0700j.m2715b(recyclerView, "<set-?>");
        this.list = recyclerView;
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
        Object inflate = layoutInflater.inflate(R.layout.controller_select_primary_card, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…y_card, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        String avatarUrl;
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        view = this.screenTitle;
        if (view == null) {
            C0700j.m2716b("screenTitle");
        }
        view.setText(R.string.cards_choose);
        initList();
        view = this.imageAvatar;
        if (view == null) {
            C0700j.m2716b("imageAvatar");
        }
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                avatarUrl = profile.getAvatarUrl();
                view.setTargetImageUrl(avatarUrl);
            }
        }
        avatarUrl = null;
        view.setTargetImageUrl(avatarUrl);
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        view = this.adapter;
        if (view == null) {
            C0700j.m2716b("adapter");
        }
        view.updateItems(BankCardsManager.INSTANCE.getCards());
    }

    public final void initList() {
        RecyclerView recyclerView = this.list;
        if (recyclerView == null) {
            C0700j.m2716b("list");
        }
        Object from = LayoutInflater.from(recyclerView.getContext());
        C0700j.m2711a(from, "LayoutInflater.from(list.context)");
        this.adapter = new BankCardsAdapter(from);
        BankCardsAdapter bankCardsAdapter = this.adapter;
        if (bankCardsAdapter == null) {
            C0700j.m2716b("adapter");
        }
        C2517a.m10349a(bankCardsAdapter.getClickListenerSubject(), null, null, new C4651a(this), 3, null);
        RecyclerView recyclerView2 = this.list;
        if (recyclerView2 == null) {
            C0700j.m2716b("list");
        }
        recyclerView2.setHasFixedSize(true);
        recyclerView2 = this.list;
        if (recyclerView2 == null) {
            C0700j.m2716b("list");
        }
        BankCardsAdapter bankCardsAdapter2 = this.adapter;
        if (bankCardsAdapter2 == null) {
            C0700j.m2716b("adapter");
        }
        recyclerView2.setAdapter(bankCardsAdapter2);
        recyclerView2 = this.list;
        if (recyclerView2 == null) {
            C0700j.m2716b("list");
        }
        RecyclerView recyclerView3 = this.list;
        if (recyclerView3 == null) {
            C0700j.m2716b("list");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        recyclerView2 = this.list;
        if (recyclerView2 == null) {
            C0700j.m2716b("list");
        }
        recyclerView3 = this.list;
        if (recyclerView3 == null) {
            C0700j.m2716b("list");
        }
        Object drawable = recyclerView3.getResources().getDrawable(R.drawable.bg_divider_with_padding);
        C0700j.m2711a(drawable, "list.resources.getDrawab….bg_divider_with_padding)");
        recyclerView2.m20860a((C0595h) new MiddleItemsDecorator(drawable));
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }
}
