package ru.gg.scooby.ui.controller;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.C0092a;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0809d.C0808b;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.bluelinelabs.conductor.p065a.C4409b;
import com.google.android.material.snackbar.Snackbar;
import io.card.payment.BuildConfig;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import p042b.C0727n;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.ScreenFlowController;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Color;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.UIUtilsKt;
import ru.skooby.R;

/* compiled from: CarController.kt */
public final class CarController extends BaseController implements CarAttributeListener {
    public static final String ARG_CAR = "ARG_CAR";
    public static final String ARG_TYPE = "ARG_TYPE";
    public static final Companion Companion = new Companion();
    public static final int OPERATION_CREATE = 0;
    public static final int OPERATION_REGISTRATION = 2;
    public static final int OPERATION_UPDATE = 1;
    @BindView
    public View blockModel;
    public Car car;
    private Car originalCar;
    @BindView
    public TextView submitButton;
    @BindView
    public TextView textBrand;
    @BindView
    public TextView textColor;
    @BindView
    public TextView textModel;
    @BindView
    public TextView textNumber;
    @BindView
    public Toolbar toolbar;

    /* compiled from: CarController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: CarController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.CarController$a */
    static final class C4626a extends C3038k implements C0690b<C2342r<? extends Object>, C0727n> {
        final /* synthetic */ CarController this$0;

        C4626a(CarController carController) {
            this.this$0 = carController;
            super(1);
        }

        /* renamed from: a */
        public final void m20503a(C2342r<? extends Object> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                UserManager.INSTANCE.refreshUserFromBackend();
                this.this$0.showNextScreen();
                return;
            }
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), -1).mo1269f();
        }
    }

    /* compiled from: CarController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.CarController$b */
    static final class C4627b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ CarController this$0;

        C4627b(CarController carController) {
            this.this$0 = carController;
            super(1);
        }

        /* renamed from: a */
        public final void m20505a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            View view = this.this$0.getView();
            if (view == null) {
                C0700j.m2709a();
            }
            Snackbar.m15345a(view, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), -1).mo1269f();
        }
    }

    public CarController(int i, Car car) {
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_TYPE", i);
        if (car != null) {
            bundle.putParcelable(ARG_CAR, car);
        }
        this(bundle);
    }

    public /* synthetic */ CarController(int i, Car car, int i2, C0697g c0697g) {
        if ((i2 & 2) != 0) {
            car = null;
        }
        this(i, car);
    }

    public CarController(Bundle bundle) {
        C0700j.m2715b(bundle, "bundle");
        super(bundle);
        setHasOptionsMenu(true);
        setRetainViewMode(C0808b.RETAIN_DETACH);
    }

    public final TextView getTextBrand() {
        TextView textView = this.textBrand;
        if (textView == null) {
            C0700j.m2716b("textBrand");
        }
        return textView;
    }

    public final void setTextBrand(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textBrand = textView;
    }

    public final TextView getTextModel() {
        TextView textView = this.textModel;
        if (textView == null) {
            C0700j.m2716b("textModel");
        }
        return textView;
    }

    public final void setTextModel(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textModel = textView;
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

    public final TextView getTextColor() {
        TextView textView = this.textColor;
        if (textView == null) {
            C0700j.m2716b("textColor");
        }
        return textView;
    }

    public final void setTextColor(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textColor = textView;
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

    public final View getBlockModel() {
        View view = this.blockModel;
        if (view == null) {
            C0700j.m2716b("blockModel");
        }
        return view;
    }

    public final void setBlockModel(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.blockModel = view;
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

    public final Car getCar() {
        Car car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        return car;
    }

    public final void setCar(Car car) {
        C0700j.m2715b(car, "<set-?>");
        this.car = car;
    }

    public final Car getOriginalCar() {
        return this.originalCar;
    }

    public final void setOriginalCar(Car car) {
        this.originalCar = car;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_car, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…er_car, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        initAppBar();
        Car car = (Car) getArgs().getParcelable(ARG_CAR);
        if (car != null) {
            view = Car.copy$default(car, null, null, null, null, null, 31, null);
            if (view != null) {
                this.car = view;
                this.originalCar = (Car) getArgs().getParcelable(ARG_CAR);
            }
        }
        View car2 = new Car(null, null, null, null, null, 31, null);
        this.car = view;
        this.originalCar = (Car) getArgs().getParcelable(ARG_CAR);
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        super.onAttach(view);
        view = getActivity();
        if (view != null) {
            view = view.getWindow();
            if (view != null) {
                view.setSoftInputMode(32);
            }
        }
        updateFormState();
    }

    public void onAttributeSelected(int i, Object obj) {
        C0700j.m2715b(obj, "value");
        switch (i) {
            case 0:
                obj = (String) obj;
                i = this.car;
                if (i == 0) {
                    C0700j.m2716b("car");
                }
                if ((C0700j.m2713a(obj, i.getBrand()) ^ 1) != 0) {
                    i = this.car;
                    if (i == 0) {
                        C0700j.m2716b("car");
                    }
                    i.setModel(BuildConfig.FLAVOR);
                }
                i = this.car;
                if (i == 0) {
                    C0700j.m2716b("car");
                }
                i.setBrand(obj);
                break;
            case 1:
                i = this.car;
                if (i == 0) {
                    C0700j.m2716b("car");
                }
                i.setModel((String) obj);
                break;
            case 2:
                i = this.car;
                if (i == 0) {
                    C0700j.m2716b("car");
                }
                i.setColor((Color) obj);
                break;
            case 3:
                i = this.car;
                if (i == 0) {
                    C0700j.m2716b("car");
                }
                i.setNumber((String) obj);
                break;
            default:
                break;
        }
        updateFormState();
    }

    public final void updateFormState() {
        TextView textView = this.textBrand;
        if (textView == null) {
            C0700j.m2716b("textBrand");
        }
        Car car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        textView.setText(car.getBrand());
        textView = this.textModel;
        if (textView == null) {
            C0700j.m2716b("textModel");
        }
        car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        textView.setText(car.getModel());
        textView = this.textNumber;
        if (textView == null) {
            C0700j.m2716b("textNumber");
        }
        car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        textView.setText(car.getNumber());
        textView = this.textColor;
        if (textView == null) {
            C0700j.m2716b("textColor");
        }
        car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        Color color = car.getColor();
        textView.setText(color != null ? color.getName() : null);
        View view = this.blockModel;
        if (view == null) {
            C0700j.m2716b("blockModel");
        }
        car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        UIUtilsKt.setEnabledWithOpacity(view, ((CharSequence) car.getBrand()).length() > 0);
        updateSubmitButtonState();
    }

    public final void updateSubmitButtonState() {
        TextView textView;
        if (getArgs().getInt("ARG_TYPE") == 1) {
            Object obj = this.car;
            if (obj == null) {
                C0700j.m2716b("car");
            }
            if ((C0700j.m2713a(obj, this.originalCar) ^ 1) != 0) {
                textView = this.submitButton;
                if (textView == null) {
                    C0700j.m2716b("submitButton");
                }
                textView.setBackgroundResource(R.drawable.btn_big_blue);
                textView = this.submitButton;
                if (textView == null) {
                    C0700j.m2716b("submitButton");
                }
                textView.setText(R.string.save);
            } else {
                textView = this.submitButton;
                if (textView == null) {
                    C0700j.m2716b("submitButton");
                }
                textView.setBackgroundResource(R.drawable.btn_big_red);
                textView = this.submitButton;
                if (textView == null) {
                    C0700j.m2716b("submitButton");
                }
                textView.setText(R.string.delete);
            }
        } else {
            textView = this.submitButton;
            if (textView == null) {
                C0700j.m2716b("submitButton");
            }
            textView.setText(R.string.add);
        }
        textView = this.submitButton;
        if (textView == null) {
            C0700j.m2716b("submitButton");
        }
        View view = textView;
        Car car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        UIUtilsKt.setEnabledWithOpacity(view, car.isFilled());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        C0700j.m2715b(menu, "menu");
        C0700j.m2715b(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_car_controller, menu);
        menu.findItem(R.id.skip).setVisible(getArgs().getInt("ARG_TYPE") == 2 ? true : null);
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

    private final void initAppBar() {
        CharSequence charSequence;
        Toolbar toolbar = this.toolbar;
        if (toolbar == null) {
            C0700j.m2716b("toolbar");
        }
        String str = null;
        Resources resources;
        if (C0700j.m2713a(getArgs().get("ARG_TYPE"), Integer.valueOf(1))) {
            resources = getResources();
            if (resources != null) {
                str = resources.getString(R.string.cars_edit_car);
            }
            charSequence = str;
        } else {
            resources = getResources();
            if (resources != null) {
                str = resources.getString(R.string.cars_add_car);
            }
            charSequence = str;
        }
        toolbar.setTitle(charSequence);
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

    public final void showNextScreen() {
        if (getArgs().getInt("ARG_TYPE") == 2) {
            String name;
            Car car;
            Object router;
            Object a;
            UserManager.INSTANCE.setAskToSetCar(false);
            Analytics analytics = Analytics.INSTANCE;
            User user = UserManager.INSTANCE.getUser();
            if (user != null) {
                Profile profile = user.getProfile();
                if (profile != null) {
                    name = profile.getName();
                    if (name != null) {
                        car = this.car;
                        if (car == null) {
                            C0700j.m2716b("car");
                        }
                        analytics.profileInfoAdd(name, car);
                        router = getRouter();
                        C0700j.m2711a(router, "router");
                        a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b());
                        C0700j.m2711a(a, "RouterTransaction.with(S…orizontalChangeHandler())");
                        C0819j.m3181a(router, a);
                        return;
                    }
                }
            }
            name = BuildConfig.FLAVOR;
            car = this.car;
            if (car == null) {
                C0700j.m2716b("car");
            }
            analytics.profileInfoAdd(name, car);
            router = getRouter();
            C0700j.m2711a(router, "router");
            a = C0820k.m3183a(ScreenFlowController.INSTANCE.getNextScreenController()).m3189b(new C4409b()).m3184a((C0814e) new C4409b());
            C0700j.m2711a(a, "RouterTransaction.with(S…orizontalChangeHandler())");
            C0819j.m3181a(router, a);
            return;
        }
        getRouter().m3169l();
    }

    @OnClick
    public final void onBrandClick() {
        C0818i router = getRouter();
        CarAttributeListController carAttributeListController = new CarAttributeListController(0, null, 2, null);
        carAttributeListController.setTargetController(this);
        router.m3151b(C0820k.m3183a((C0809d) carAttributeListController).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onModelClick() {
        C0818i router = getRouter();
        Car car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        CarAttributeListController carAttributeListController = new CarAttributeListController(1, car.getBrand());
        carAttributeListController.setTargetController(this);
        router.m3151b(C0820k.m3183a((C0809d) carAttributeListController).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onNumberClick() {
        C0818i router = getRouter();
        Car car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        CarNumberController carNumberController = new CarNumberController(car.getNumber());
        carNumberController.setTargetController(this);
        router.m3151b(C0820k.m3183a((C0809d) carNumberController).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onColorClick() {
        C0818i router = getRouter();
        CarAttributeListController carAttributeListController = new CarAttributeListController(2, null, 2, null);
        carAttributeListController.setTargetController(this);
        router.m3151b(C0820k.m3183a((C0809d) carAttributeListController).m3184a((C0814e) new C4409b()).m3189b(new C4409b()));
    }

    @OnClick
    public final void onSubmitClick() {
        Analytics analytics;
        Car car;
        ApiManager apiManager;
        C4050f updateCar;
        Object a;
        ControllerExKt.showProgress$default(this, null, 1, null);
        if (getArgs().getInt("ARG_TYPE") != 0) {
            if (getArgs().getInt("ARG_TYPE") != 2) {
                Object obj = this.car;
                if (obj == null) {
                    C0700j.m2716b("car");
                }
                if ((1 ^ C0700j.m2713a(obj, this.originalCar)) != 0) {
                    analytics = Analytics.INSTANCE;
                    car = this.car;
                    if (car == null) {
                        C0700j.m2716b("car");
                    }
                    analytics.updateCar(car);
                    apiManager = ApiManager.INSTANCE;
                    car = this.car;
                    if (car == null) {
                        C0700j.m2716b("car");
                    }
                    updateCar = apiManager.updateCar(car);
                } else {
                    analytics = Analytics.INSTANCE;
                    car = this.car;
                    if (car == null) {
                        C0700j.m2716b("car");
                    }
                    analytics.deleteCar(car);
                    apiManager = ApiManager.INSTANCE;
                    car = this.car;
                    if (car == null) {
                        C0700j.m2716b("car");
                    }
                    Long id = car.getId();
                    if (id == null) {
                        C0700j.m2709a();
                    }
                    updateCar = apiManager.deleteCar(id.longValue());
                }
                a = updateCar.m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                C0700j.m2711a(a, "observable\n             …dSchedulers.mainThread())");
                C2517a.m10349a(a, new C4627b(this), null, new C4626a(this), 2, null);
            }
        }
        analytics = Analytics.INSTANCE;
        car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        analytics.addCar(car);
        apiManager = ApiManager.INSTANCE;
        car = this.car;
        if (car == null) {
            C0700j.m2716b("car");
        }
        updateCar = apiManager.addCar(car);
        a = updateCar.m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "observable\n             …dSchedulers.mainThread())");
        C2517a.m10349a(a, new C4627b(this), null, new C4626a(this), 2, null);
    }
}
