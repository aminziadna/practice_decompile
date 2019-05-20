package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class BankCardsController_ViewBinding implements Unbinder {
    private BankCardsController target;
    private View view7f090068;
    private View view7f090081;
    private View view7f090085;
    private View view7f0900dc;

    public BankCardsController_ViewBinding(final BankCardsController bankCardsController, View view) {
        this.target = bankCardsController;
        bankCardsController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        View a = C0730b.m2750a(view, R.id.empty_view, "field 'emptyView' and method 'onAddButtonClick'");
        bankCardsController.emptyView = a;
        this.view7f0900dc = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BankCardsController_ViewBinding f12694c;

            /* renamed from: a */
            public void mo1911a(View view) {
                bankCardsController.onAddButtonClick();
            }
        });
        bankCardsController.screenTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'screenTitle'", TextView.class);
        bankCardsController.listContainer = C0730b.m2750a(view, R.id.list_container, "field 'listContainer'");
        bankCardsController.cardsList = (RecyclerView) C0730b.m2751a(view, R.id.list_cards, "field 'cardsList'", RecyclerView.class);
        a = C0730b.m2750a(view, R.id.block_primary_card, "field 'blockPrimaryCard' and method 'onPrimaryCardClick'");
        bankCardsController.blockPrimaryCard = a;
        this.view7f090068 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BankCardsController_ViewBinding f12696c;

            /* renamed from: a */
            public void mo1911a(View view) {
                bankCardsController.onPrimaryCardClick();
            }
        });
        bankCardsController.textPrimaryCard = (TextView) C0730b.m2751a(view, R.id.text_primary_card, "field 'textPrimaryCard'", TextView.class);
        a = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BankCardsController_ViewBinding f12698c;

            /* renamed from: a */
            public void mo1911a(View view) {
                bankCardsController.onBackClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_add, "method 'onAddButtonClick'");
        this.view7f090081 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ BankCardsController_ViewBinding f12700c;

            /* renamed from: a */
            public void mo1911a(View view) {
                bankCardsController.onAddButtonClick();
            }
        });
    }

    public void unbind() {
        BankCardsController bankCardsController = this.target;
        if (bankCardsController != null) {
            this.target = null;
            bankCardsController.imageAvatar = null;
            bankCardsController.emptyView = null;
            bankCardsController.screenTitle = null;
            bankCardsController.listContainer = null;
            bankCardsController.cardsList = null;
            bankCardsController.blockPrimaryCard = null;
            bankCardsController.textPrimaryCard = null;
            this.view7f0900dc.setOnClickListener(null);
            this.view7f0900dc = null;
            this.view7f090068.setOnClickListener(null);
            this.view7f090068 = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            this.view7f090081.setOnClickListener(null);
            this.view7f090081 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
