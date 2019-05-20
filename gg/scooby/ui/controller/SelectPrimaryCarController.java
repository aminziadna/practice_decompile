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
import com.google.android.material.snackbar.Snackbar;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.adapter.CarsAdapter;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.custom.MiddleItemsDecorator;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.skooby.R;

/* compiled from: SelectPrimaryCarController.kt */
public final class SelectPrimaryCarController extends BaseController {
    public CarsAdapter adapter;
    @BindView
    public RecyclerView carsList;
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public TextView screenTitle;

    /* compiled from: SelectPrimaryCarController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SelectPrimaryCarController$a */
    static final class C4652a extends C3038k implements C0690b<Car, C0727n> {
        final /* synthetic */ SelectPrimaryCarController this$0;

        C4652a(SelectPrimaryCarController selectPrimaryCarController) {
            this.this$0 = selectPrimaryCarController;
            super(1);
        }

        /* renamed from: a */
        public final void m20555a(Car car) {
            car = car.getId();
            if (car != null) {
                this.this$0.setDefault(((Number) car).longValue());
            }
        }
    }

    /* compiled from: SelectPrimaryCarController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SelectPrimaryCarController$b */
    static final class C4653b extends C3038k implements C0690b<C2342r<? extends Object>, C0727n> {
        final /* synthetic */ SelectPrimaryCarController this$0;

        C4653b(SelectPrimaryCarController selectPrimaryCarController) {
            this.this$0 = selectPrimaryCarController;
            super(1);
        }

        /* renamed from: a */
        public final void m20557a(C2342r<? extends Object> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                this.this$0.getRouter().m3169l();
                View view = this.this$0.getView();
                if (view == null) {
                    C0700j.m2709a();
                }
                Snackbar.m15345a(view, (int) R.string.changes_saved, -1).mo1269f();
                return;
            }
            View view2 = this.this$0.getView();
            if (view2 == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view2, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: SelectPrimaryCarController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.SelectPrimaryCarController$c */
    static final class C4654c extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ SelectPrimaryCarController this$0;

        C4654c(SelectPrimaryCarController selectPrimaryCarController) {
            this.this$0 = selectPrimaryCarController;
            super(1);
        }

        /* renamed from: a */
        public final void m20559a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
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

    public final RecyclerView getCarsList() {
        RecyclerView recyclerView = this.carsList;
        if (recyclerView == null) {
            C0700j.m2716b("carsList");
        }
        return recyclerView;
    }

    public final void setCarsList(RecyclerView recyclerView) {
        C0700j.m2715b(recyclerView, "<set-?>");
        this.carsList = recyclerView;
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

    public final CarsAdapter getAdapter() {
        CarsAdapter carsAdapter = this.adapter;
        if (carsAdapter == null) {
            C0700j.m2716b("adapter");
        }
        return carsAdapter;
    }

    public final void setAdapter(CarsAdapter carsAdapter) {
        C0700j.m2715b(carsAdapter, "<set-?>");
        this.adapter = carsAdapter;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_select_primary_car, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…ry_car, container, false)");
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
        view.setText(R.string.cars_choose_auto);
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
        view.updateItems(UserManager.INSTANCE.getCars());
    }

    public final void initList() {
        RecyclerView recyclerView = this.carsList;
        if (recyclerView == null) {
            C0700j.m2716b("carsList");
        }
        Object from = LayoutInflater.from(recyclerView.getContext());
        C0700j.m2711a(from, "LayoutInflater.from(carsList.context)");
        this.adapter = new CarsAdapter(from);
        CarsAdapter carsAdapter = this.adapter;
        if (carsAdapter == null) {
            C0700j.m2716b("adapter");
        }
        C2517a.m10349a(carsAdapter.getClickListenerSubject(), null, null, new C4652a(this), 3, null);
        RecyclerView recyclerView2 = this.carsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("carsList");
        }
        recyclerView2.setHasFixedSize(true);
        recyclerView2 = this.carsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("carsList");
        }
        CarsAdapter carsAdapter2 = this.adapter;
        if (carsAdapter2 == null) {
            C0700j.m2716b("adapter");
        }
        recyclerView2.setAdapter(carsAdapter2);
        recyclerView2 = this.carsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("carsList");
        }
        RecyclerView recyclerView3 = this.carsList;
        if (recyclerView3 == null) {
            C0700j.m2716b("carsList");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        recyclerView2 = this.carsList;
        if (recyclerView2 == null) {
            C0700j.m2716b("carsList");
        }
        recyclerView3 = this.carsList;
        if (recyclerView3 == null) {
            C0700j.m2716b("carsList");
        }
        Object drawable = recyclerView3.getResources().getDrawable(R.drawable.bg_divider_with_padding);
        C0700j.m2711a(drawable, "carsList.resources.getDr….bg_divider_with_padding)");
        recyclerView2.m20860a((C0595h) new MiddleItemsDecorator(drawable));
    }

    public final void setDefault(long j) {
        ControllerExKt.showProgress$default(this, null, 1, null);
        Object a = ApiManager.INSTANCE.setDefaultCar(j).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "ApiManager.setDefaultCar…dSchedulers.mainThread())");
        C2517a.m10349a(a, (C0690b) new C4654c(this), null, (C0690b) new C4653b(this), 2, null);
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }
}
