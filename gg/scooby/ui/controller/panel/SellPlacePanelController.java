package ru.gg.scooby.ui.controller.panel;

import android.app.TimePickerDialog;
import android.content.res.Resources;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0809d.C0808b;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0815f;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0820k;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.C1985l;
import com.mapbox.mapboxsdk.maps.C1985l.C1964c;
import com.mapbox.mapboxsdk.maps.MapView;
import io.p181b.C4050f;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p185b.C2468b;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.Calendar;
import java.util.Iterator;
import p042b.C0687c;
import p042b.C0704e;
import p042b.C0724k;
import p042b.C0727n;
import p042b.p043a.C4684f;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0698h;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C0701o;
import p042b.p047e.p049b.C3038k;
import p042b.p047e.p049b.C4749n;
import p042b.p051g.C3045e;
import p165d.C2342r;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.Car;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.network.GeocoderManager;
import ru.gg.scooby.ui.address.SelectAddressListener;
import ru.gg.scooby.ui.changehandler.MapHorizontalChangeHandler;
import ru.gg.scooby.ui.controller.BaseController;
import ru.gg.scooby.ui.controller.ControllerExKt;
import ru.gg.scooby.ui.controller.IMapView;
import ru.gg.scooby.ui.controller.IMapView.DefaultImpls;
import ru.gg.scooby.ui.controller.MyCarsController;
import ru.gg.scooby.ui.controller.MyCarsController.PickListener;
import ru.gg.scooby.ui.controller.SearchAddressController;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.dialog.PricePickerDialog;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.BundleBuilder;
import ru.gg.scooby.util.DateUtils;
import ru.gg.scooby.util.Log;
import ru.gg.scooby.util.PriceExKt;
import ru.gg.scooby.util.UIUtils;
import ru.skooby.R;

/* compiled from: SellPlacePanelController.kt */
public final class SellPlacePanelController extends BaseController implements C1964c, SelectAddressListener, PickListener {
    static final /* synthetic */ C3045e[] $$delegatedProperties = new C3045e[]{C0701o.m2720a(new C4749n(C0701o.m2719a(SellPlacePanelController.class), "priceDescriptions", "getPriceDescriptions()[Ljava/lang/String;")), C0701o.m2720a(new C4749n(C0701o.m2719a(SellPlacePanelController.class), "priceValues", "getPriceValues()[I"))};
    public static final String ARG_TYPE = "ARG_TYPE";
    public static final Companion Companion = new Companion();
    public static final int TYPE_CREATE = 0;
    public static final int TYPE_EDIT = 1;
    @BindView
    public View containerActions;
    private C2468b geocoderSubscription;
    @BindView
    public AvatarImageView imageAvatar;
    private Parking parking;
    private final C0687c priceDescriptions$delegate;
    private PricePickerDialog priceDialog;
    private final C0687c priceValues$delegate;
    @BindView
    public View progressAddress;
    @BindView
    public TextView publishButton;
    private View sellPlaceMarker;
    @BindView
    public TextView textAddress;
    @BindView
    public TextView textCarTitle;
    @BindView
    public TextView textPriceSubtitle;
    @BindView
    public TextView textPriceTitle;
    @BindView
    public TextView textTimeSubtitle;
    @BindView
    public TextView textTimeTitle;

    /* compiled from: SellPlacePanelController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: SellPlacePanelController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.SellPlacePanelController$a */
    static final class C4670a extends C3038k implements C0690b<Address, C0727n> {
        final /* synthetic */ SellPlacePanelController this$0;

        C4670a(SellPlacePanelController sellPlacePanelController) {
            this.this$0 = sellPlacePanelController;
            super(1);
        }

        /* renamed from: a */
        public final void m20591a(Address address) {
            this.this$0.getProgressAddress().setVisibility(8);
            this.this$0.getTextAddress().setVisibility(0);
            this.this$0.getParking().setAddress(address != null ? address.getAddressLine(0) : null);
            this.this$0.updateAddress();
        }
    }

    /* compiled from: SellPlacePanelController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.SellPlacePanelController$b */
    static final class C4671b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ SellPlacePanelController this$0;

        C4671b(SellPlacePanelController sellPlacePanelController) {
            this.this$0 = sellPlacePanelController;
            super(1);
        }

        /* renamed from: a */
        public final void m20593a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.INSTANCE.m11189e(th, false);
            this.this$0.getProgressAddress().setVisibility(8);
            this.this$0.getTextAddress().setVisibility(0);
            this.this$0.getParking().setAddress((String) null);
            this.this$0.updateAddress();
        }
    }

    /* compiled from: SellPlacePanelController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.SellPlacePanelController$c */
    static final class C4672c extends C3038k implements C0690b<C2342r<? extends Object>, C0727n> {
        final /* synthetic */ SellPlacePanelController this$0;

        C4672c(SellPlacePanelController sellPlacePanelController) {
            this.this$0 = sellPlacePanelController;
            super(1);
        }

        /* renamed from: a */
        public final void m20595a(C2342r<? extends Object> c2342r) {
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            C0700j.m2711a((Object) c2342r, "it");
            if (c2342r.m9826c()) {
                this.this$0.showNextScreen();
            } else {
                ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage(), 0, 0, 6, null);
            }
        }
    }

    /* compiled from: SellPlacePanelController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.SellPlacePanelController$d */
    static final class C4673d extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ SellPlacePanelController this$0;

        C4673d(SellPlacePanelController sellPlacePanelController) {
            this.this$0 = sellPlacePanelController;
            super(1);
        }

        /* renamed from: a */
        public final void m20597a(Throwable th) {
            C0700j.m2715b(th, "it");
            ControllerExKt.hideProgress$default(this.this$0, null, 1, null);
            ControllerExKt.showSnackbar$default(this.this$0, ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage(), 0, 0, 6, null);
        }
    }

    /* compiled from: SellPlacePanelController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.SellPlacePanelController$e */
    static final class C4674e extends C3038k implements C0689a<String[]> {
        /* renamed from: a */
        public static final C4674e f14126a = new C4674e();

        C4674e() {
            super(0);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            return m20599b();
        }

        /* renamed from: b */
        public final String[] m20599b() {
            return ContextProvider.INSTANCE.getContext().getResources().getStringArray(PricePickerDialog.Companion.getPRICE_DESCRIPTIONS_RES());
        }
    }

    /* compiled from: SellPlacePanelController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.panel.SellPlacePanelController$f */
    static final class C4675f extends C3038k implements C0689a<int[]> {
        /* renamed from: a */
        public static final C4675f f14127a = new C4675f();

        C4675f() {
            super(0);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            return m20601b();
        }

        /* renamed from: b */
        public final int[] m20601b() {
            return ContextProvider.INSTANCE.getContext().getResources().getIntArray(PricePickerDialog.Companion.getPRICE_VALUES_RES());
        }
    }

    public SellPlacePanelController() {
        this(0, 1, null);
    }

    public final String[] getPriceDescriptions() {
        C0687c c0687c = this.priceDescriptions$delegate;
        C3045e c3045e = $$delegatedProperties[0];
        return (String[]) c0687c.mo625a();
    }

    public final int[] getPriceValues() {
        C0687c c0687c = this.priceValues$delegate;
        C3045e c3045e = $$delegatedProperties[1];
        return (int[]) c0687c.mo625a();
    }

    public SellPlacePanelController(int i) {
        super(new BundleBuilder(null, 1, null).putInt("ARG_TYPE", i).build());
        this.priceDescriptions$delegate = C0704e.m2726a(C4674e.f14126a);
        this.priceValues$delegate = C0704e.m2726a(C4675f.f14127a);
        setRetainViewMode(C0808b.RETAIN_DETACH);
        long j = -1;
        Car defaultCar;
        Long id;
        if (getArgs().getInt("ARG_TYPE") == 0) {
            r0.parking = new Parking(null, 0.0d, 0.0d, PriceExKt.toRawPrice(PricePickerDialog.Companion.getRECOMMENDED_PRICE()), null, 0, null, 0, 247, null);
            r0.parking.setTimeLong(DateUtils.INSTANCE.timeRoundedByMinutes(5).getTimeInMillis());
            Parking parking = r0.parking;
            User user = UserManager.INSTANCE.getUser();
            if (user != null) {
                defaultCar = user.getDefaultCar();
                if (defaultCar != null) {
                    id = defaultCar.getId();
                    if (id != null) {
                        j = id.longValue();
                    }
                }
            }
            parking.setCarId(j);
            return;
        }
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking == null) {
            C0700j.m2709a();
        }
        r0.parking = activeParking.getParking();
        parking = r0.parking;
        ParkingAdvert activeParking2 = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking2 != null) {
            defaultCar = activeParking2.getCar();
            if (defaultCar != null) {
                id = defaultCar.getId();
                if (id != null) {
                    j = id.longValue();
                }
            }
        }
        parking.setCarId(j);
    }

    public /* synthetic */ SellPlacePanelController(int i, int i2, C0697g c0697g) {
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

    public final TextView getTextAddress() {
        TextView textView = this.textAddress;
        if (textView == null) {
            C0700j.m2716b("textAddress");
        }
        return textView;
    }

    public final void setTextAddress(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textAddress = textView;
    }

    public final View getProgressAddress() {
        View view = this.progressAddress;
        if (view == null) {
            C0700j.m2716b("progressAddress");
        }
        return view;
    }

    public final void setProgressAddress(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.progressAddress = view;
    }

    public final TextView getTextPriceTitle() {
        TextView textView = this.textPriceTitle;
        if (textView == null) {
            C0700j.m2716b("textPriceTitle");
        }
        return textView;
    }

    public final void setTextPriceTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textPriceTitle = textView;
    }

    public final TextView getTextPriceSubtitle() {
        TextView textView = this.textPriceSubtitle;
        if (textView == null) {
            C0700j.m2716b("textPriceSubtitle");
        }
        return textView;
    }

    public final void setTextPriceSubtitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textPriceSubtitle = textView;
    }

    public final TextView getTextTimeTitle() {
        TextView textView = this.textTimeTitle;
        if (textView == null) {
            C0700j.m2716b("textTimeTitle");
        }
        return textView;
    }

    public final void setTextTimeTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textTimeTitle = textView;
    }

    public final TextView getTextTimeSubtitle() {
        TextView textView = this.textTimeSubtitle;
        if (textView == null) {
            C0700j.m2716b("textTimeSubtitle");
        }
        return textView;
    }

    public final void setTextTimeSubtitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textTimeSubtitle = textView;
    }

    public final TextView getTextCarTitle() {
        TextView textView = this.textCarTitle;
        if (textView == null) {
            C0700j.m2716b("textCarTitle");
        }
        return textView;
    }

    public final void setTextCarTitle(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.textCarTitle = textView;
    }

    public final View getContainerActions() {
        View view = this.containerActions;
        if (view == null) {
            C0700j.m2716b("containerActions");
        }
        return view;
    }

    public final void setContainerActions(View view) {
        C0700j.m2715b(view, "<set-?>");
        this.containerActions = view;
    }

    public final TextView getPublishButton() {
        TextView textView = this.publishButton;
        if (textView == null) {
            C0700j.m2716b("publishButton");
        }
        return textView;
    }

    public final void setPublishButton(TextView textView) {
        C0700j.m2715b(textView, "<set-?>");
        this.publishButton = textView;
    }

    public final View getSellPlaceMarker() {
        return this.sellPlaceMarker;
    }

    public final void setSellPlaceMarker(View view) {
        this.sellPlaceMarker = view;
    }

    public final C2468b getGeocoderSubscription() {
        return this.geocoderSubscription;
    }

    public final void setGeocoderSubscription(C2468b c2468b) {
        this.geocoderSubscription = c2468b;
    }

    public final C1985l getMap() {
        C0809d parentController = getParentController();
        if (parentController != null) {
            return ((IMapView) parentController).getMap();
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.IMapView");
    }

    public final MapView getMapView() {
        C0809d parentController = getParentController();
        if (parentController != null) {
            return ((IMapView) parentController).getMapView();
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.IMapView");
    }

    public final IMapView getImapView() {
        C0809d parentController = getParentController();
        if (parentController != null) {
            return (IMapView) parentController;
        }
        throw new C0724k("null cannot be cast to non-null type ru.gg.scooby.ui.controller.IMapView");
    }

    public final Parking getParking() {
        return this.parking;
    }

    public final void setParking(Parking parking) {
        C0700j.m2715b(parking, "<set-?>");
        this.parking = parking;
    }

    public final PricePickerDialog getPriceDialog() {
        return this.priceDialog;
    }

    public final void setPriceDialog(PricePickerDialog pricePickerDialog) {
        this.priceDialog = pricePickerDialog;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_sell_panel, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…_panel, container, false)");
        return inflate;
    }

    public void onViewBound(View view) {
        String avatarUrl;
        C0700j.m2715b(view, "view");
        super.onViewBound(view);
        geocodeLocation();
        view = this.publishButton;
        if (view == null) {
            C0700j.m2716b("publishButton");
        }
        view.setText(C0700j.m2713a(getArgs().get("ARG_TYPE"), Integer.valueOf(0)) ? R.string.publish : R.string.save);
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
        updatePrice();
        updateTime();
        updateCar();
        view = getMap();
        if (view != null) {
            view.m7577a((C1964c) this);
        }
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        super.onDetach(view);
        view = this.geocoderSubscription;
        if (view != null) {
            view.mo1727a();
        }
        view = getMap();
        if (view != null) {
            view.m7590b((C1964c) this);
        }
        view = this.priceDialog;
        if (view != null) {
            view.dismiss();
        }
    }

    public void onCameraIdle() {
        geocodeLocation();
    }

    public void onCarSelected(long j) {
        this.parking.setCarId(j);
        updateCar();
    }

    @OnClick
    public final void onClose() {
        getRouter().m3169l();
    }

    @OnClick
    public final void onAddressEdit() {
        SearchAddressController searchAddressController = new SearchAddressController();
        searchAddressController.setTargetController(this);
        C0809d parentController = getParentController();
        if (parentController != null) {
            C0818i router = parentController.getRouter();
            if (router != null) {
                router.m3151b(C0820k.m3183a((C0809d) searchAddressController).m3184a((C0814e) new MapHorizontalChangeHandler()).m3189b(new MapHorizontalChangeHandler()));
            }
        }
    }

    public void onAddressSelected(Address address) {
        C0700j.m2715b(address, "address");
        this.parking.setAddress(address.getAddressLine(0));
        this.parking.setLat(address.getLatitude());
        this.parking.setLng(address.getLongitude());
        IMapView imapView = getImapView();
        if (imapView != null) {
            DefaultImpls.updateLocation$default(imapView, new LatLng(address.getLatitude(), address.getLongitude()), false, 2, null);
        }
        updateAddress();
    }

    protected void onChangeStarted(C0814e c0814e, C0815f c0815f) {
        C0700j.m2715b(c0814e, "changeHandler");
        C0700j.m2715b(c0815f, "changeType");
        super.onChangeStarted(c0814e, c0815f);
        if (c0815f == C0815f.POP_EXIT) {
            removeSellPlaceMarker();
        }
    }

    protected void onChangeEnded(C0814e c0814e, C0815f c0815f) {
        C0700j.m2715b(c0814e, "changeHandler");
        C0700j.m2715b(c0815f, "changeType");
        super.onChangeEnded(c0814e, c0815f);
        if (c0815f == C0815f.PUSH_ENTER) {
            addSellPlaceMarker();
        }
    }

    @OnClick
    public final void onTimeEdit() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.parking.getTimeLong());
        Object view = getView();
        if (view == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a(view, "view!!");
        new TimePickerDialog(view.getContext(), new SellPlacePanelController$onTimeEdit$dialog$1(this), instance.get(11), instance.get(12), true).show();
    }

    @OnClick
    public final void onPriceEdit() {
        PricePickerDialog pricePickerDialog = this.priceDialog;
        if (pricePickerDialog != null) {
            pricePickerDialog.dismiss();
        }
        Object view = getView();
        if (view == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a(view, "view!!");
        view = view.getContext();
        C0700j.m2711a(view, "view!!.context");
        this.priceDialog = new PricePickerDialog(view, (int) this.parking.getNormalizedPrice());
        pricePickerDialog = this.priceDialog;
        if (pricePickerDialog != null) {
            pricePickerDialog.setListener(new SellPlacePanelController$onPriceEdit$1(this));
        }
        pricePickerDialog = this.priceDialog;
        if (pricePickerDialog != null) {
            pricePickerDialog.show();
        }
    }

    @OnClick
    public final void onCarEdit() {
        C0809d parentController = getParentController();
        if (parentController != null) {
            C0818i router = parentController.getRouter();
            if (router != null) {
                MyCarsController myCarsController = new MyCarsController(1);
                myCarsController.setTargetController(this);
                router.m3151b(C0820k.m3183a((C0809d) myCarsController).m3184a((C0814e) new MapHorizontalChangeHandler()).m3189b(new MapHorizontalChangeHandler()));
            }
        }
    }

    @OnClick
    public final void onPublish() {
        if (validateForm()) {
            C4050f sellParking;
            ControllerExKt.showProgress$default(this, null, 1, null);
            if (C0700j.m2713a(getArgs().get("ARG_TYPE"), Integer.valueOf(0))) {
                Analytics.INSTANCE.sellNew(this.parking);
                sellParking = ApiManager.INSTANCE.sellParking(this.parking.toSellObject());
            } else {
                Analytics.INSTANCE.sellUpdate(this.parking);
                ApiManager apiManager = ApiManager.INSTANCE;
                Long id = this.parking.getId();
                if (id == null) {
                    C0700j.m2709a();
                }
                sellParking = apiManager.updateParking(id.longValue(), this.parking.toSellObject());
            }
            Object a = sellParking.m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
            C0700j.m2711a(a, "observable.subscribeOn(S…dSchedulers.mainThread())");
            C2517a.m10349a(a, new C4673d(this), null, new C4672c(this), 2, null);
        }
    }

    public final boolean validateForm() {
        if (!(this.parking.getAddress() == null || this.parking.getLat() == C0698h.f2043a.m2705a())) {
            if (this.parking.getLng() != C0698h.f2043a.m2705a()) {
                if (this.parking.getCarId() >= 0) {
                    return true;
                }
                ControllerExKt.showSnackbar$default(this, R.string.sell_choose_car, 0, 0, 6, null);
                return false;
            }
        }
        ControllerExKt.showSnackbar$default(this, R.string.sell_choose_address, 0, 0, 6, null);
        return false;
    }

    public final void updateTime() {
        TextView textView = this.textTimeTitle;
        if (textView == null) {
            C0700j.m2716b("textTimeTitle");
        }
        textView.setText(DateUtils.INSTANCE.toTime(this.parking.getTimeLong()));
        textView = this.textTimeSubtitle;
        if (textView == null) {
            C0700j.m2716b("textTimeSubtitle");
        }
        textView.setText(DateUtils.INSTANCE.relativeStringDate(this.parking.getTimeLong()));
    }

    public final void updatePrice() {
        TextView textView = this.textPriceTitle;
        if (textView == null) {
            C0700j.m2716b("textPriceTitle");
        }
        textView.setText(getPriceDescriptions()[C4684f.m20933a(getPriceValues(), (int) this.parking.getNormalizedPrice())]);
        textView = this.textPriceSubtitle;
        if (textView == null) {
            C0700j.m2716b("textPriceSubtitle");
        }
        textView.setVisibility(this.parking.getPrice() == PriceExKt.toRawPrice(PricePickerDialog.Companion.getRECOMMENDED_PRICE()) ? 0 : 8);
    }

    public final void updateCar() {
        Object obj;
        Iterator it = UserManager.INSTANCE.getCars().iterator();
        Object obj2;
        do {
            String str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Long id = ((Car) obj).getId();
            long carId = this.parking.getCarId();
            if (id != null) {
                if (id.longValue() == carId) {
                    obj2 = 1;
                    continue;
                }
            }
            obj2 = null;
            continue;
        } while (obj2 == null);
        Car car = (Car) obj;
        if (car != null) {
            TextView textView = this.textCarTitle;
            if (textView == null) {
                C0700j.m2716b("textCarTitle");
            }
            textView.setText(car.getCommonCarName());
            return;
        }
        SellPlacePanelController sellPlacePanelController = this;
        TextView textView2 = sellPlacePanelController.textCarTitle;
        if (textView2 == null) {
            C0700j.m2716b("textCarTitle");
        }
        Resources resources = getResources();
        if (resources != null) {
            str = resources.getString(R.string.sell_add_new_auto);
        }
        textView2.setText(str);
    }

    public final void updateAddress() {
        TextView textView = this.textAddress;
        if (textView == null) {
            C0700j.m2716b("textAddress");
        }
        textView.setText(this.parking.getAddress());
    }

    public final void geocodeLocation() {
        C2468b c2468b = this.geocoderSubscription;
        if (c2468b != null) {
            c2468b.mo1727a();
        }
        C1985l map = getMap();
        if (map != null) {
            CameraPosition p = map.m7609p();
            if (p != null) {
                LatLng latLng = p.target;
                if (latLng != null) {
                    this.parking.setLat(latLng.m7217a());
                    this.parking.setLng(latLng.m7220b());
                    View view = this.progressAddress;
                    if (view == null) {
                        C0700j.m2716b("progressAddress");
                    }
                    view.setVisibility(0);
                    TextView textView = this.textAddress;
                    if (textView == null) {
                        C0700j.m2716b("textAddress");
                    }
                    textView.setVisibility(8);
                    Object a = GeocoderManager.INSTANCE.geocodeLocation(latLng.m7217a(), latLng.m7220b()).m17712a(2).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
                    C0700j.m2711a(a, "GeocoderManager.geocodeL…dSchedulers.mainThread())");
                    c2468b = C2517a.m10349a(a, new C4671b(this), null, new C4670a(this), 2, null);
                    this.geocoderSubscription = c2468b;
                }
            }
        }
        c2468b = null;
        this.geocoderSubscription = c2468b;
    }

    public final void addSellPlaceMarker() {
        View view = getView();
        this.sellPlaceMarker = LayoutInflater.from(view != null ? view.getContext() : null).inflate(R.layout.view_location_pin, getMapView(), false);
        view = this.sellPlaceMarker;
        if (view == null) {
            C0700j.m2709a();
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            View view2 = this.containerActions;
            if (view2 == null) {
                C0700j.m2716b("containerActions");
            }
            int y = (int) (view2.getY() / ((float) 2));
            Resources resources = getResources();
            if (resources == null) {
                C0700j.m2709a();
            }
            layoutParams2.topMargin = y - resources.getDimensionPixelSize(R.dimen.location_pin_extra_margin);
            view2 = this.sellPlaceMarker;
            if (view2 != null) {
                view2.setLayoutParams(layoutParams2);
            }
            MapView mapView = getMapView();
            if (mapView != null) {
                mapView.addView(this.sellPlaceMarker);
                return;
            }
            return;
        }
        throw new C0724k("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void removeSellPlaceMarker() {
        View view = this.sellPlaceMarker;
        if (view != null) {
            UIUtils.INSTANCE.removeFromSuperview(view);
            this.sellPlaceMarker = (View) null;
        }
    }

    public final void showNextScreen() {
        if (getArgs().getInt("ARG_TYPE") == 1) {
            getRouter().m3169l();
        }
    }
}
