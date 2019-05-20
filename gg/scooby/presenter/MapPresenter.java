package ru.gg.scooby.presenter;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Location;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.mapbox.android.p149a.p150a.C1742c;
import com.mapbox.android.p149a.p150a.C1743d;
import com.mapbox.android.p149a.p150a.C1745f;
import com.mapbox.android.p149a.p150a.C1748h;
import com.mapbox.android.p149a.p150a.C1748h.C1747a;
import com.mapbox.android.p149a.p150a.C1749i;
import com.mapbox.mapboxsdk.geometry.C1908a;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.C1985l;
import com.mapbox.mapboxsdk.maps.C2001v;
import io.p181b.p182a.p184b.C2466a;
import io.p181b.p187d.C2483e;
import io.p181b.p197g.C2517a;
import io.p181b.p198h.C2527a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p042b.C0727n;
import p042b.p043a.C4763n;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p048a.C0690b;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C3038k;
import p165d.C2342r;
import ru.gg.scooby.Bus;
import ru.gg.scooby.ContextProvider;
import ru.gg.scooby.analytics.Analytics;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.manager.ParkingManager.BuyerFoundEvent;
import ru.gg.scooby.manager.ParkingManager.BuyerLocationUpdatedEvent;
import ru.gg.scooby.manager.ParkingManager.DisputeEvent;
import ru.gg.scooby.manager.ParkingManager.ParkingActive;
import ru.gg.scooby.manager.ParkingManager.ParkingDisabledEvent;
import ru.gg.scooby.manager.ParkingManager.ParkingEvent;
import ru.gg.scooby.manager.ParkingManager.ParkingFreeEvent;
import ru.gg.scooby.manager.ParkingManager.ParkingInactive;
import ru.gg.scooby.manager.ParkingManager.ParkingPaidEvent;
import ru.gg.scooby.manager.ParkingManager.ParkingReservedEvent;
import ru.gg.scooby.manager.ParkingManager.ParkingUpdated;
import ru.gg.scooby.manager.ParkingManager.PublishParkingEvent;
import ru.gg.scooby.manager.ParkingManager.StatusDisposable;
import ru.gg.scooby.manager.ParkingManager.TripCanceledEvent;
import ru.gg.scooby.manager.ParkingManager.TripSuccessEvent;
import ru.gg.scooby.manager.ParkingManager.UpdateParkingEvent;
import ru.gg.scooby.manager.ParkingManager.WaitingBuyerPayEvent;
import ru.gg.scooby.manager.ParkingManager.WaitingConfirmFromMeEvent;
import ru.gg.scooby.manager.ParkingManager.WaitingConfirmFromOtherSideEvent;
import ru.gg.scooby.model.AdvFilter;
import ru.gg.scooby.model.AdvStatus;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.ParkingsResponse;
import ru.gg.scooby.network.ApiManager;
import ru.gg.scooby.ui.controller.IMapView;
import ru.gg.scooby.ui.controller.IMapView.DefaultImpls;
import ru.gg.scooby.ui.controller.SuccessBuyController.SellEvent;
import ru.gg.scooby.ui.input.validator.ValidationCode;
import ru.gg.scooby.util.LocationUtils;
import ru.gg.scooby.util.LocationUtilsKt;
import ru.gg.scooby.util.Log;
import ru.gg.scooby.util.PriceExKt;

/* compiled from: MapPresenter.kt */
public final class MapPresenter extends BasePresenter implements Callback, C1743d<C1749i> {
    public static final Companion Companion = new Companion();
    private static final LatLng DEFAULT_LOCATION = new LatLng(55.755814d, 37.617635d);
    public static final int MSG_PARKINGS = 0;
    public static final long PARKINGS_LOAD_DELAY = 300;
    private boolean animateNextLocationChange;
    private LatLng buyerLocationToUpdateWhenMapReady;
    private boolean firstLocationFix;
    private final Handler handler = new Handler(this);
    private Location lastLocation;
    private int lastUiParkingStatus;
    private C1742c locationEngine;
    private final C1748h locationRequest;
    private StatusDisposable statusUpdateDisposable;
    private final IMapView view;

    /* compiled from: MapPresenter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final LatLng getDEFAULT_LOCATION() {
            return MapPresenter.DEFAULT_LOCATION;
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$d */
    static final class C4180d<T, R> implements C2483e<T, R> {
        /* renamed from: a */
        final /* synthetic */ MapPresenter f12689a;

        C4180d(MapPresenter mapPresenter) {
            this.f12689a = mapPresenter;
        }

        /* renamed from: a */
        public final C2342r<ParkingsResponse> m18162a(C2342r<ParkingsResponse> c2342r) {
            C0700j.m2715b(c2342r, "it");
            if (LocationUtils.INSTANCE.isLocationPermissionGranted() && LocationUtilsKt.isValidLocation(this.f12689a.getLastLocation())) {
                float[] fArr = new float[1];
                ParkingsResponse parkingsResponse = (ParkingsResponse) c2342r.m9827d();
                if (parkingsResponse != null) {
                    List advList = parkingsResponse.getAdvList();
                    if (advList != null && advList.size() > 1) {
                        C4763n.m22146a(advList, new C2669x948c2509(this, fArr));
                    }
                }
            }
            return c2342r;
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$e */
    static final class C4181e<T, R> implements C2483e<Throwable, C2342r<ParkingsResponse>> {
        /* renamed from: a */
        public static final C4181e f12690a = new C4181e();

        C4181e() {
        }

        /* renamed from: a */
        public final C2342r<ParkingsResponse> m18164a(Throwable th) {
            C0700j.m2715b(th, "it");
            return C2342r.m9821a(new ParkingsResponse((List) new ArrayList()));
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$a */
    static final class C4609a extends C3038k implements C0690b<C2342r<? extends Object>, C0727n> {
        final /* synthetic */ MapPresenter this$0;

        C4609a(MapPresenter mapPresenter) {
            this.this$0 = mapPresenter;
            super(1);
        }

        /* renamed from: a */
        public final void m20469a(C2342r<? extends Object> c2342r) {
            C0700j.m2711a((Object) c2342r, "it");
            if (!c2342r.m9826c() || c2342r.m9827d() == null) {
                this.this$0.getView().hideProgress();
                this.this$0.getView().showSnackbarMessage(ValidationCode.Companion.getCodeByResponse(c2342r).getErrorMessage());
                return;
            }
            ParkingManager.INSTANCE.refreshParkingStatus(false, new C0689a<C0727n>() {
                /* renamed from: a */
                public /* synthetic */ Object mo2120a() {
                    m20467b();
                    return C0727n.f2066a;
                }

                /* renamed from: b */
                public final void m20467b() {
                    this.this$0.getView().hideProgress();
                }
            });
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$b */
    static final class C4610b extends C3038k implements C0690b<Throwable, C0727n> {
        final /* synthetic */ MapPresenter this$0;

        C4610b(MapPresenter mapPresenter) {
            this.this$0 = mapPresenter;
            super(1);
        }

        /* renamed from: a */
        public final void m20471a(Throwable th) {
            C0700j.m2715b(th, "it");
            this.this$0.getView().hideProgress();
            this.this$0.getView().showSnackbarMessage(ValidationCode.Companion.getCodeByThrowable(th).getErrorMessage());
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$c */
    static final class C4611c extends C3038k implements C0689a<C0727n> {
        /* renamed from: a */
        public static final C4611c f14121a = new C4611c();

        C4611c() {
            super(0);
        }

        /* renamed from: b */
        public final void m20473b() {
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            m20473b();
            return C0727n.f2066a;
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$f */
    static final class C4612f extends C3038k implements C0690b<C2342r<ParkingsResponse>, C0727n> {
        final /* synthetic */ MapPresenter this$0;

        C4612f(MapPresenter mapPresenter) {
            this.this$0 = mapPresenter;
            super(1);
        }

        /* renamed from: a */
        public final void m20475a(C2342r<ParkingsResponse> c2342r) {
            ParkingsResponse parkingsResponse = (ParkingsResponse) c2342r.m9827d();
            if (parkingsResponse != null) {
                this.this$0.getView().updateParkings(parkingsResponse.getAdvList());
            }
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$g */
    static final class C4613g extends C3038k implements C0690b<Throwable, C0727n> {
        /* renamed from: a */
        public static final C4613g f14122a = new C4613g();

        C4613g() {
            super(1);
        }

        /* renamed from: a */
        public final void m20477a(Throwable th) {
            C0700j.m2715b(th, "it");
            Log.INSTANCE.m11189e(th, false);
        }
    }

    /* compiled from: MapPresenter.kt */
    /* renamed from: ru.gg.scooby.presenter.MapPresenter$h */
    static final class C4614h extends C3038k implements C0689a<C0727n> {
        final /* synthetic */ MapPresenter this$0;

        C4614h(MapPresenter mapPresenter) {
            this.this$0 = mapPresenter;
            super(0);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            m20479b();
            return C0727n.f2066a;
        }

        /* renamed from: b */
        public final void m20479b() {
            this.this$0.updateWithLastKnownLocation();
        }
    }

    public MapPresenter(IMapView iMapView) {
        C0700j.m2715b(iMapView, "view");
        this.view = iMapView;
        Object a = C1745f.m6487a(ContextProvider.INSTANCE.getContext());
        C0700j.m2711a(a, "LocationEngineProvider.g…(ContextProvider.context)");
        this.locationEngine = a;
        a = new C1747a(0).m6495a(1).m6496a(TimeUnit.SECONDS.toMillis(5)).m6497a();
        C0700j.m2711a(a, "LocationEngineRequest.Bu…\n                .build()");
        this.locationRequest = a;
        if (LocationUtils.INSTANCE.isLocationPermissionGranted() != null) {
            getLastLocation$default(this, null, 1, null);
        }
    }

    public final IMapView getView() {
        return this.view;
    }

    public final C1742c getLocationEngine() {
        return this.locationEngine;
    }

    public final void setLocationEngine(C1742c c1742c) {
        C0700j.m2715b(c1742c, "<set-?>");
        this.locationEngine = c1742c;
    }

    public final boolean getFirstLocationFix() {
        return this.firstLocationFix;
    }

    public final void setFirstLocationFix(boolean z) {
        this.firstLocationFix = z;
    }

    public final boolean getAnimateNextLocationChange() {
        return this.animateNextLocationChange;
    }

    public final void setAnimateNextLocationChange(boolean z) {
        this.animateNextLocationChange = z;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final LatLng getBuyerLocationToUpdateWhenMapReady() {
        return this.buyerLocationToUpdateWhenMapReady;
    }

    public final void setBuyerLocationToUpdateWhenMapReady(LatLng latLng) {
        this.buyerLocationToUpdateWhenMapReady = latLng;
    }

    public final C1748h getLocationRequest() {
        return this.locationRequest;
    }

    public final Location getLastLocation() {
        return this.lastLocation;
    }

    public final void setLastLocation(Location location) {
        this.lastLocation = location;
    }

    public final StatusDisposable getStatusUpdateDisposable() {
        return this.statusUpdateDisposable;
    }

    public final void setStatusUpdateDisposable(StatusDisposable statusDisposable) {
        this.statusUpdateDisposable = statusDisposable;
    }

    public final int getLastUiParkingStatus() {
        return this.lastUiParkingStatus;
    }

    public final void setLastUiParkingStatus(int i) {
        this.lastUiParkingStatus = i;
    }

    @SuppressLint({"MissingPermission"})
    public static /* synthetic */ void getLastLocation$default(MapPresenter mapPresenter, C0689a c0689a, int i, Object obj) {
        if ((i & 1) != 0) {
            c0689a = C4611c.f14121a;
        }
        mapPresenter.getLastLocation(c0689a);
    }

    @SuppressLint({"MissingPermission"})
    public final void getLastLocation(C0689a<C0727n> c0689a) {
        C0700j.m2715b(c0689a, "onSuccess");
        this.locationEngine.mo1366a(new MapPresenter$getLastLocation$2(this, c0689a));
    }

    public final void onMapReady() {
        LatLng latLng;
        IMapView iMapView = this.view;
        if (LocationUtils.INSTANCE.isLocationPermissionGranted() && LocationUtilsKt.isValidLocation(this.lastLocation)) {
            latLng = new LatLng(this.lastLocation);
        } else {
            latLng = DEFAULT_LOCATION;
        }
        DefaultImpls.updateLocation$default(iMapView, latLng, false, 2, null);
        LatLng latLng2 = this.buyerLocationToUpdateWhenMapReady;
        if (latLng2 != null) {
            this.view.updateUserMarkerLocation(latLng2.m7217a(), latLng2.m7220b());
            this.buyerLocationToUpdateWhenMapReady = (LatLng) null;
        }
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            Parking parking = activeParking.getParking();
            if (parking != null) {
                this.view.updateParkingMarkerLocation(parking.getLat(), parking.getLng());
            }
        }
        this.view.updateLayersVisibility();
    }

    public final void onCameraIdle() {
        this.handler.removeMessages(0);
        Handler handler = this.handler;
        handler.sendMessageDelayed(handler.obtainMessage(0), 300);
    }

    public final void onCameraMove() {
        this.handler.removeMessages(0);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C0700j.m2715b(strArr, "permissions");
        C0700j.m2715b(iArr, "grantResults");
        if (i != 4 || LocationUtils.INSTANCE.isLocationPermissionGranted() == 0) {
            this.view.showPermissionDeniedSnackbar();
            return;
        }
        getLastLocation((C0689a) new C4614h(this));
        this.view.onLocationEngineReady(this.locationEngine);
        requestLocationUpdate$default(this, 0, 1, null);
    }

    public final void create() {
        ParkingManager.INSTANCE.retrieveCachedParkingStateAndNotify();
    }

    public final void attach() {
        this.view.updateLayersVisibility();
        this.view.updateAvatar();
        Bus.INSTANCE.register(this);
        if (LocationUtils.INSTANCE.isLocationPermissionGranted()) {
            requestLocationUpdate(this.firstLocationFix ^ true);
            this.view.onLocationEngineReady(this.locationEngine);
        } else {
            this.view.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 4);
        }
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            if (this.lastUiParkingStatus != activeParking.getParking().getStatus()) {
                ParkingManager.sendEventForStatus$default(ParkingManager.INSTANCE, activeParking.toParkingStatus(), null, null, 6, null);
            }
            this.lastUiParkingStatus = activeParking.getParking().getStatus();
            startListenParkingStatus(activeParking.getParking().getStatus());
        }
    }

    public final void detach() {
        this.handler.removeCallbacksAndMessages(null);
        this.locationEngine.mo1368b(this);
        Bus.INSTANCE.unregister(this);
        clearDisposables();
        this.statusUpdateDisposable = (StatusDisposable) null;
    }

    public final void updateWithLastKnownLocation() {
        if (LocationUtilsKt.isValidLocation(this.lastLocation)) {
            this.firstLocationFix = true;
            this.view.updateLocation(new LatLng(this.lastLocation), true);
            IMapView iMapView = this.view;
            Location location = this.lastLocation;
            if (location == null) {
                C0700j.m2709a();
            }
            iMapView.onUserLocationChanged(location);
        }
    }

    public void destroy() {
        super.destroy();
        this.firstLocationFix = false;
        this.locationEngine.mo1368b(this);
    }

    @SuppressLint({"MissingPermission"})
    public static /* synthetic */ void requestLocationUpdate$default(MapPresenter mapPresenter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        mapPresenter.requestLocationUpdate(z);
    }

    @SuppressLint({"MissingPermission"})
    public final void requestLocationUpdate(boolean z) {
        this.animateNextLocationChange = z;
        if (LocationUtils.INSTANCE.isLocationPermissionGranted()) {
            if (!this.firstLocationFix || z) {
                updateWithLastKnownLocation();
            }
            this.locationEngine.mo1367a(this.locationRequest, this, Looper.getMainLooper());
            return;
        }
        this.view.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 4);
    }

    public void onSuccess(C1749i c1749i) {
        if (c1749i != null) {
            c1749i = c1749i.m6506a();
            if (c1749i != null) {
                this.lastLocation = c1749i;
                onLocationChanged(this.lastLocation);
            }
        }
    }

    public void onFailure(Exception exception) {
        C0700j.m2715b(exception, "exception");
        Log.e$default(Log.INSTANCE, (Throwable) exception, false, 2, null);
    }

    public final void onLocationChanged(Location location) {
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("location = ");
        stringBuilder.append(location);
        log.m11183d(stringBuilder.toString());
        if (LocationUtilsKt.isValidLocation(location)) {
            if (ParkingManager.INSTANCE.getActiveParking() == null) {
                if (this.animateNextLocationChange) {
                    this.animateNextLocationChange = false;
                    this.view.updateLocation(new LatLng(location), true);
                }
                this.locationEngine.mo1368b(this);
            }
            this.firstLocationFix = true;
            IMapView iMapView = this.view;
            if (location == null) {
                C0700j.m2709a();
            }
            iMapView.onUserLocationChanged(location);
        }
    }

    public boolean handleMessage(Message message) {
        if (ParkingManager.INSTANCE.getActiveParking() != null) {
            return true;
        }
        message = message != null ? Integer.valueOf(message.what) : null;
        if (message != null) {
            if (message.intValue() == null) {
                loadParkingsForCurrentBounds();
            }
        }
        return true;
    }

    public final void loadParkingsForCurrentBounds() {
        LatLngBounds latLngBounds;
        Object c;
        ru.gg.scooby.model.AdvFilter.Companion companion = AdvFilter.Companion;
        C1985l map = this.view.getMap();
        if (map != null) {
            C2001v n = map.m7607n();
            if (n != null) {
                C1908a a = n.m7762a();
                if (a != null) {
                    latLngBounds = a.f5449e;
                    if (latLngBounds == null) {
                        C0700j.m2709a();
                    }
                    c = ApiManager.INSTANCE.getParkings(companion.fromLatLngBounds(latLngBounds)).m17728b((C2483e) new C4180d(this)).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17733c((C2483e) C4181e.f12690a);
                    C0700j.m2711a(c, "ApiManager.getParkings(f…ponse(mutableListOf())) }");
                    addDisposable(C2517a.m10349a(c, C4613g.f14122a, null, new C4612f(this), 2, null));
                }
            }
        }
        latLngBounds = null;
        if (latLngBounds == null) {
            C0700j.m2709a();
        }
        c = ApiManager.INSTANCE.getParkings(companion.fromLatLngBounds(latLngBounds)).m17728b((C2483e) new C4180d(this)).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a()).m17733c((C2483e) C4181e.f12690a);
        C0700j.m2711a(c, "ApiManager.getParkings(f…ponse(mutableListOf())) }");
        addDisposable(C2517a.m10349a(c, C4613g.f14122a, null, new C4612f(this), 2, null));
    }

    public final void buyParking(ParkingAdvert parkingAdvert) {
        C0700j.m2715b(parkingAdvert, "parking");
        this.view.showProgress();
        Analytics.INSTANCE.buyParking(parkingAdvert.getParking(), parkingAdvert.getCar());
        Object a = ApiManager.INSTANCE.buyParking(parkingAdvert.getParking()).m17729b(C2527a.m10359b()).m17723a(C2466a.m10262a());
        C0700j.m2711a(a, "ApiManager.buyParking(pa…dSchedulers.mainThread())");
        addDisposable(C2517a.m10349a(a, (C0690b) new C4610b(this), null, (C0690b) new C4609a(this), 2, null));
    }

    public final void onAddressSelected(Address address) {
        C0700j.m2715b(address, "address");
        this.animateNextLocationChange = null;
    }

    private final void startListenParkingStatus(int i) {
        StatusDisposable statusDisposable = this.statusUpdateDisposable;
        if (statusDisposable == null || i != statusDisposable.getInitialStatus()) {
            this.statusUpdateDisposable = ParkingManager.INSTANCE.startListenParkingStatus();
            i = this.statusUpdateDisposable;
            if (i != 0) {
                addDisposable(i.getDisposable());
            }
        }
    }

    public final void onEventMainThread(PublishParkingEvent publishParkingEvent) {
        C0700j.m2715b(publishParkingEvent, "event");
        this.view.showParkingPosted();
    }

    public final void onEventMainThread(SellEvent sellEvent) {
        C0700j.m2715b(sellEvent, "event");
        this.view.showSellPlace();
    }

    public final void onEventMainThread(BuyerFoundEvent buyerFoundEvent) {
        C0700j.m2715b(buyerFoundEvent, "event");
        this.view.showBuyerFound();
        this.view.updateLayersVisibility();
    }

    public final void onEventMainThread(TripCanceledEvent tripCanceledEvent) {
        C0700j.m2715b(tripCanceledEvent, "event");
        this.view.showTripCanceled(tripCanceledEvent.getType(), tripCanceledEvent.getParkingStatus());
    }

    public final void onEventMainThread(TripSuccessEvent tripSuccessEvent) {
        C0700j.m2715b(tripSuccessEvent, "event");
        this.view.showTripSuccess(tripSuccessEvent.getType(), PriceExKt.toNormalizedPrice(tripSuccessEvent.getPrice()));
        if (tripSuccessEvent.getType() == 0 && tripSuccessEvent.getPrice() > 0) {
            Analytics.INSTANCE.reportRevenue(PriceExKt.toNormalizedPrice(tripSuccessEvent.getPrice()));
        }
    }

    public final void onEventMainThread(BuyerLocationUpdatedEvent buyerLocationUpdatedEvent) {
        C0700j.m2715b(buyerLocationUpdatedEvent, "event");
        if (this.view.getMap() == null) {
            this.buyerLocationToUpdateWhenMapReady = new LatLng(buyerLocationUpdatedEvent.getLatitude(), buyerLocationUpdatedEvent.getLongitude());
        }
        this.view.updateUserMarkerLocation(buyerLocationUpdatedEvent.getLatitude(), buyerLocationUpdatedEvent.getLongitude());
    }

    @SuppressLint({"MissingPermission"})
    public final void onEventMainThread(ParkingActive parkingActive) {
        C0700j.m2715b(parkingActive, "event");
        this.view.updateLayersVisibility();
        parkingActive = ParkingManager.INSTANCE.getActiveParking();
        if (parkingActive != null) {
            parkingActive = parkingActive.getParking();
            if (parkingActive != null) {
                this.view.updateParkingMarkerLocation(parkingActive.getLat(), parkingActive.getLng());
                if (parkingActive.getStatus() == AdvStatus.ADV_PAID.getCode()) {
                    this.locationEngine.mo1367a(this.locationRequest, this, Looper.getMainLooper());
                }
                startListenParkingStatus(parkingActive.getStatus());
            }
        }
        Log.INSTANCE.dTrace("Parking Active");
    }

    public final void onEventMainThread(ParkingInactive parkingInactive) {
        C0700j.m2715b(parkingInactive, "event");
        this.locationEngine.mo1368b(this);
        this.view.updateLayersVisibility();
        this.view.closeTripScreens();
        Log.INSTANCE.dTrace("Parking Inactive");
    }

    public final void onEventMainThread(ParkingUpdated parkingUpdated) {
        C0700j.m2715b(parkingUpdated, "event");
        parkingUpdated = ParkingManager.INSTANCE.getActiveParking();
        if (parkingUpdated != null) {
            parkingUpdated = parkingUpdated.getParking();
            if (parkingUpdated != null) {
                startListenParkingStatus(parkingUpdated.getStatus());
            }
        }
    }

    public final void onEventMainThread(UpdateParkingEvent updateParkingEvent) {
        C0700j.m2715b(updateParkingEvent, "event");
        updateParkingEvent = ParkingManager.INSTANCE.getActiveParking();
        if (updateParkingEvent != null) {
            updateParkingEvent = updateParkingEvent.getParking();
            if (updateParkingEvent != null) {
                this.view.updateParkingMarkerLocation(updateParkingEvent.getLat(), updateParkingEvent.getLng());
            }
        }
    }

    public final void onEventMainThread(WaitingConfirmFromMeEvent waitingConfirmFromMeEvent) {
        C0700j.m2715b(waitingConfirmFromMeEvent, "event");
        this.view.showWaitingConfirmFromMe();
    }

    public final void onEventMainThread(WaitingConfirmFromOtherSideEvent waitingConfirmFromOtherSideEvent) {
        C0700j.m2715b(waitingConfirmFromOtherSideEvent, "event");
        this.view.showWaitingConfirmFromOtherSide();
    }

    public final void onEventMainThread(WaitingBuyerPayEvent waitingBuyerPayEvent) {
        C0700j.m2715b(waitingBuyerPayEvent, "event");
        this.view.showWaitingPaySeller();
    }

    public final void onEventMainThread(ParkingReservedEvent parkingReservedEvent) {
        C0700j.m2715b(parkingReservedEvent, "event");
        this.view.showWaitingPayBuyer();
    }

    public final void onEventMainThread(ParkingPaidEvent parkingPaidEvent) {
        C0700j.m2715b(parkingPaidEvent, "event");
        this.view.showActiveTrip();
    }

    public final void onEventMainThread(DisputeEvent disputeEvent) {
        C0700j.m2715b(disputeEvent, "event");
        this.view.showDispute(disputeEvent.getType(), disputeEvent.getParkingStatus());
    }

    public final void onEventMainThread(ParkingDisabledEvent parkingDisabledEvent) {
        C0700j.m2715b(parkingDisabledEvent, "event");
        this.view.closeTripScreens();
    }

    public final void onEventMainThread(ParkingFreeEvent parkingFreeEvent) {
        C0700j.m2715b(parkingFreeEvent, "event");
        this.view.showParkingPosted();
    }

    public final void onEventMainThread(ParkingEvent parkingEvent) {
        C0700j.m2715b(parkingEvent, "event");
        parkingEvent = ParkingManager.INSTANCE.getActiveParking();
        if (parkingEvent != null) {
            parkingEvent = parkingEvent.getParking();
            if (parkingEvent != null) {
                parkingEvent = parkingEvent.getStatus();
                this.lastUiParkingStatus = parkingEvent;
            }
        }
        parkingEvent = null;
        this.lastUiParkingStatus = parkingEvent;
    }
}
