package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class FinancesController_ViewBinding implements Unbinder {
    private FinancesController target;
    private View view7f090081;
    private View view7f090085;

    public FinancesController_ViewBinding(final FinancesController financesController, View view) {
        this.target = financesController;
        financesController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        financesController.emptyView = C0730b.m2750a(view, R.id.empty_view, "field 'emptyView'");
        financesController.screenTitle = (TextView) C0730b.m2751a(view, R.id.text_screen_title, "field 'screenTitle'", TextView.class);
        financesController.listContainer = C0730b.m2750a(view, R.id.list_container, "field 'listContainer'");
        financesController.templatesList = (RecyclerView) C0730b.m2751a(view, R.id.list_templates, "field 'templatesList'", RecyclerView.class);
        financesController.balanceText = (TextView) C0730b.m2751a(view, R.id.text_balance, "field 'balanceText'", TextView.class);
        View a = C0730b.m2750a(view, R.id.btn_back, "method 'onBackClick'");
        this.view7f090085 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ FinancesController_ViewBinding f12742c;

            /* renamed from: a */
            public void mo1911a(View view) {
                financesController.onBackClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_add, "method 'onAddButtonClick'");
        this.view7f090081 = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ FinancesController_ViewBinding f12744c;

            /* renamed from: a */
            public void mo1911a(View view) {
                financesController.onAddButtonClick();
            }
        });
    }

    public void unbind() {
        FinancesController financesController = this.target;
        if (financesController != null) {
            this.target = null;
            financesController.imageAvatar = null;
            financesController.emptyView = null;
            financesController.screenTitle = null;
            financesController.listContainer = null;
            financesController.templatesList = null;
            financesController.balanceText = null;
            this.view7f090085.setOnClickListener(null);
            this.view7f090085 = null;
            this.view7f090081.setOnClickListener(null);
            this.view7f090081 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
