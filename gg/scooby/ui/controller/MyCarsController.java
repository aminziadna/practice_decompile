package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import io.p181b.p197g.C2517a;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p043a.C3033j;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.ui.adapter.CarsAdapter;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.custom.MiddleItemsDecorator;
import ru.gg.scooby.util.BundleBuilder;
import ru.skooby.R;

/* compiled from: MyCarsController.kt */
public final class MyCarsController extends BaseController {
    public static final String ARG_TYPE = "ARG_TYPE";
    public static final Companion Companion = new Companion();
    public static final int OPERATION_PICK = 1;
    public static final int OPERATION_VIEW = 0;
    public CarsAdapter adapter;
    @BindView
    public View blockPrimaryCar;
    @BindView
    public RecyclerView carsList;
    @BindView
    public View emptyView;
    @BindView
    public AvatarImageView imageAvatar;
    @BindView
    public View listContainer;
    @BindView
    public TextView screenTitle;
    @BindView
    public TextView textPrimaryCar;

    /* compiled from: MyCarsController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: MyCarsController.kt */
    public interface PickListener {
        void onCarSelected(long j);
    }

    /* compiled from: MyCarsController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MyCarsController$b */
    static final class C2680b implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MyCarsController f8302a;

        C2680b(MyCarsController myCarsController) {
            this.f8302a = myCarsController;
        }

        public final void onClick(View view) {
            if (C0700j.m2713a(this.f8302a.getArgs().get("ARG_TYPE"), Integer.valueOf(0)) != null) {
                this.f8302a.getRouter().m3151b(C0820k.m3183a((C0809d) new SelectPrimaryCarController()).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
                return;
            }
            view = UserManager.INSTANCE.getUser();
            if (view != null) {
                view = view.getDefaultCar();
                if (view != null) {
                    view = view.getId();
                    if (view != null) {
                        long longValue = ((Number) view).longValue();
                        view = this.f8302a.getTargetController();
                        if (view != null) {
                            ((PickListener) view).onCarSelected(longValue);
                        } else {
                            throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.MyCarsController.PickListener");
                        }
                    }
                }
            }
            this.f8302a.getRouter().m3169l();
        }
    }

    /* compiled from: MyCarsController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MyCarsController$a */
    static final class C4635a extends C3038k implements C0690b<Car, C0727n> {
        final /* synthetic */ MyCarsController this$0;

        C4635a(MyCarsController myCarsController) {
            this.this$0 = myCarsController;
            super(1);
        }

        /* renamed from: a */
        public final void m20521a(Car car) {
            if (C0700j.m2713a(this.this$0.getArgs().get("ARG_TYPE"), Integer.valueOf(0))) {
                this.this$0.getRouter().m3151b(C0820k.m3183a((C0809d) new CarController(1, car)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
                return;
            }
            car = car.getId();
            if (car != null) {
                long longValue = ((Number) car).longValue();
                car = this.this$0.getTargetController();
                if (car != null) {
                    ((PickListener) car).onCarSelected(longValue);
                } else {
                    throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.MyCarsController.PickListener");
                }
            }
            this.this$0.getRouter().m3169l();
        }
    }

    public MyCarsController() {
        this(0, 1, null);
    }

    public MyCarsController(int i) {
        super(new BundleBuilder(null, 1, null).putInt("ARG_TYPE", i).build());
    }

    public /* synthetic */ MyCarsController(int i, int i2, C0697g c0697g) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        this(i);
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

    public final View getBlockPrimaryCar() {
        View view = this.blockPrimaryCar;
        if (view == null) {
            C0700j.m2716b("blockPrimaryCar");
        }
        return view;
    }

    public final void setBlockPrimaryCar(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.blockPrimaryCar = view;
    }

    public final TextView getTextPrimaryCar() {
        TextView textView = this.textPrimaryCar;
        if (textView == null) {
            C0700j.m2716b("textPrimaryCar");
        }
        return textView;
    }

    public final void setTextPrimaryCar(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textPrimaryCar = textView;
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
        Object inflate = layoutInflater.inflate(R.layout.controller_my_cars, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…y_cars, container, false)");
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
        view.setText(R.string.profile_my_cars);
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
        initList();
        view = this.blockPrimaryCar;
        if (view == null) {
            C0700j.m2716b("blockPrimaryCar");
        }
        view.setOnClickListener(new C2680b(this));
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
        C2517a.m10349a(carsAdapter.getClickListenerSubject(), null, null, new C4635a(this), 3, null);
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

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        updateScreenState();
    }

    public final void updateScreenState() {
        View view;
        CarsAdapter carsAdapter;
        LayoutParams layoutParams;
        MarginLayoutParams marginLayoutParams;
        View view2;
        switch (UserManager.INSTANCE.getCars().size()) {
            case 0:
                view = this.blockPrimaryCar;
                if (view == null) {
                    C0700j.m2716b("blockPrimaryCar");
                }
                view.setVisibility(8);
                view = this.emptyView;
                if (view == null) {
                    C0700j.m2716b("emptyView");
                }
                view.setVisibility(0);
                view = this.listContainer;
                if (view == null) {
                    C0700j.m2716b("listContainer");
                }
                view.setVisibility(8);
                carsAdapter = this.adapter;
                if (carsAdapter == null) {
                    C0700j.m2716b("adapter");
                }
                carsAdapter.updateItems(C3033j.m13044a());
                return;
            case 1:
                view = this.blockPrimaryCar;
                if (view == null) {
                    C0700j.m2716b("blockPrimaryCar");
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
                    carsAdapter = this.adapter;
                    if (carsAdapter == null) {
                        C0700j.m2716b("adapter");
                    }
                    carsAdapter.updateItems(UserManager.INSTANCE.getCars());
                    return;
                }
                throw new C0724k("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            default:
                String primaryCarName;
                view = this.blockPrimaryCar;
                if (view == null) {
                    C0700j.m2716b("blockPrimaryCar");
                }
                view.setVisibility(0);
                view = this.emptyView;
                if (view == null) {
                    C0700j.m2716b("emptyView");
                }
                view.setVisibility(8);
                TextView textView = this.textPrimaryCar;
                if (textView == null) {
                    C0700j.m2716b("textPrimaryCar");
                }
                User user = UserManager.INSTANCE.getUser();
                if (user != null) {
                    Car defaultCar = user.getDefaultCar();
                    if (defaultCar != null) {
                        primaryCarName = defaultCar.getPrimaryCarName();
                        textView.setText(primaryCarName);
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
                        if (layoutParams == null) {
                            marginLayoutParams = (MarginLayoutParams) layoutParams;
                            view2 = this.listContainer;
                            if (view2 == null) {
                                C0700j.m2716b("listContainer");
                            }
                            marginLayoutParams.topMargin = view2.getResources().getDimensionPixelSize(R.dimen.cars_content_small_margin_top);
                            carsAdapter = this.adapter;
                            if (carsAdapter == null) {
                                C0700j.m2716b("adapter");
                            }
                            carsAdapter.updateItems(UserManager.INSTANCE.getCars());
                            return;
                        }
                        throw new C0724k("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                }
                primaryCarName = null;
                textView.setText(primaryCarName);
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
                if (layoutParams == null) {
                    throw new C0724k("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                marginLayoutParams = (MarginLayoutParams) layoutParams;
                view2 = this.listContainer;
                if (view2 == null) {
                    C0700j.m2716b("listContainer");
                }
                marginLayoutParams.topMargin = view2.getResources().getDimensionPixelSize(R.dimen.cars_content_small_margin_top);
                carsAdapter = this.adapter;
                if (carsAdapter == null) {
                    C0700j.m2716b("adapter");
                }
                carsAdapter.updateItems(UserManager.INSTANCE.getCars());
                return;
        }
    }

    @OnClick
    public final void onBackClick() {
        getRouter().m3169l();
    }

    @OnClick
    public final void onAddButtonClick() {
        getRouter().m3151b(C0820k.m3183a((C0809d) new CarController(0, null, 2, null)).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }
}
