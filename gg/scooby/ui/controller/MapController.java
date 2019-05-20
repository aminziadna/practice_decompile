package ru.gg.scooby.ui.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.C4333c.C0095a;
import androidx.recyclerview.widget.C4378i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.C0598i;
import androidx.recyclerview.widget.RecyclerView.C0603n;
import butterknife.BindView;
import butterknife.OnClick;
import com.bluelinelabs.conductor.C0809d;
import com.bluelinelabs.conductor.C0809d.C0808b;
import com.bluelinelabs.conductor.C0814e;
import com.bluelinelabs.conductor.C0815f;
import com.bluelinelabs.conductor.C0818i;
import com.bluelinelabs.conductor.C0819j;
import com.bluelinelabs.conductor.C0820k;
import com.google.gson.JsonObject;
import com.mapbox.android.p149a.p150a.C1742c;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Geometry;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.annotations.C1842f;
import com.mapbox.mapboxsdk.annotations.C3641h;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.camera.C1859b;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.C1985l;
import com.mapbox.mapboxsdk.maps.C1985l.C1964c;
import com.mapbox.mapboxsdk.maps.C1985l.C1966e;
import com.mapbox.mapboxsdk.maps.C1985l.C1975n;
import com.mapbox.mapboxsdk.maps.C1985l.C1977p;
import com.mapbox.mapboxsdk.maps.C1990q;
import com.mapbox.mapboxsdk.maps.C2009y;
import com.mapbox.mapboxsdk.maps.C2009y.C2007b;
import com.mapbox.mapboxsdk.maps.C2009y.C2008c;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.p156d.C1870j;
import com.mapbox.mapboxsdk.p156d.C1873l;
import com.mapbox.mapboxsdk.style.layers.C2024c;
import com.mapbox.mapboxsdk.style.layers.C2025d;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.style.sources.Source;
import io.p181b.p187d.C2482d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p042b.C0687c;
import p042b.C0704e;
import p042b.C0723j;
import p042b.C0727n;
import p042b.p043a.C4381k;
import p042b.p043a.C4774r;
import p042b.p043a.ad;
import p042b.p047e.p048a.C0689a;
import p042b.p047e.p049b.C0700j;
import p042b.p047e.p049b.C0701o;
import p042b.p047e.p049b.C3038k;
import p042b.p047e.p049b.C4749n;
import p042b.p051g.C3045e;
import ru.gg.scooby.BuildConfig;
import ru.gg.scooby.helper.StatusBarColorHelper;
import ru.gg.scooby.manager.AcquiringCredentialsProvider;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.manager.UserManager;
import ru.gg.scooby.model.AdvStatus;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.ParkingStatus;
import ru.gg.scooby.model.Profile;
import ru.gg.scooby.model.User;
import ru.gg.scooby.presenter.MapPresenter;
import ru.gg.scooby.ui.address.SelectAddressListener;
import ru.gg.scooby.ui.changehandler.BuyerFoundChangeHandler;
import ru.gg.scooby.ui.changehandler.MapHorizontalChangeHandler;
import ru.gg.scooby.ui.changehandler.MapVerticalChangeHandler;
import ru.gg.scooby.ui.changehandler.SellPlacePanelChangeHandler;
import ru.gg.scooby.ui.changehandler.TripPanelChangeHandler;
import ru.gg.scooby.ui.controller.panel.ActiveTripController;
import ru.gg.scooby.ui.controller.panel.ParkingPostedController;
import ru.gg.scooby.ui.controller.panel.SellPlacePanelController;
import ru.gg.scooby.ui.controller.panel.WaitingConfirmFromMeController;
import ru.gg.scooby.ui.controller.panel.WaitingConfirmOtherSideController;
import ru.gg.scooby.ui.controller.panel.WaitingPayBuyerController;
import ru.gg.scooby.ui.controller.panel.WaitingPaySellerController;
import ru.gg.scooby.ui.controller.popup.BuyerFoundController;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.gg.scooby.ui.custom.CustomLayoutManager;
import ru.gg.scooby.ui.map.MapCenterProvider;
import ru.gg.scooby.ui.map.ParkingBlockAdapter;
import ru.gg.scooby.util.LocationUtils;
import ru.gg.scooby.util.LocationUtilsKt;
import ru.gg.scooby.util.Log;
import ru.gg.scooby.util.PriceExKt;
import ru.gg.scooby.util.UIUtils;
import ru.skooby.R;
import ru.tinkoff.acquiring.sdk.C2751b;
import ru.tinkoff.acquiring.sdk.C2757d;
import ru.tinkoff.acquiring.sdk.PayFormActivity;
import ru.tinkoff.acquiring.sdk.ab;
import ru.tinkoff.acquiring.sdk.an;
import ru.tinkoff.acquiring.sdk.as;
import ru.tinkoff.acquiring.sdk.p235a.p236a.C4286a;
import ru.tinkoff.acquiring.sdk.views.BankKeyboard;

/* compiled from: MapController.kt */
public final class MapController extends ButterKnifeStatefulController implements C1964c, C1966e, C1975n, C1977p, SelectAddressListener, IMapView, MapCenterProvider {
    static final /* synthetic */ C3045e[] $$delegatedProperties = new C3045e[]{C0701o.m2720a(new C4749n(C0701o.m2719a(MapController.class), "childRouter", "getChildRouter()Lcom/bluelinelabs/conductor/Router;"))};
    public static final double ADDRESS_SELECT_ZOOM = 16.0d;
    public static final Companion Companion = new Companion();
    public static final double DEFAULT_ZOOM = 13.0d;
    public static final String MARKER_LAYER = "marker-layer";
    public static final String MARKER_LAYER_TRIP_TARGET = "marker-trip-target-layer";
    public static final String MARKER_LAYER_USER_LOCATION = "marker-user-location-layer";
    public static final String MARKER_PIN_CAR = "pin-car ";
    public static final String MARKER_PIN_LATER = "pin-later";
    public static final String MARKER_PIN_NOW = "pin-now";
    public static final String MARKER_PIN_TRIP_TARGET = "pin-trip-target";
    public static final String MARKER_SOURCE = "marker-source";
    public static final String MARKER_SOURCE_TRIP_TARGET = "marker-trip-target-source";
    public static final String MARKER_SOURCE_USER_LOCATION = "marker-user-location-source";
    public static final int PAY_REQUEST_CODE = 100;
    @BindView
    public MapView _mapView;
    public ParkingBlockAdapter adapter;
    @BindView
    public RecyclerView bottomContainer;
    private final C0687c childRouter$delegate = C0704e.m2726a(new C4633a(this));
    @BindView
    public FrameLayout childRouterContainer;
    private LatLng currentMapCenter;
    @BindView
    public AvatarImageView imageAvatar;
    private C1870j locationComponent;
    private C1985l map;
    @BindView
    public FrameLayout mapContainer;
    private MapView mapView;
    private LatLng myLocationCenter;
    private final MapPresenter presenter = new MapPresenter(this);
    private Marker searchLocationMarker;

    /* compiled from: MapController.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$g */
    static final class C2678g implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MapController f8299a;

        C2678g(MapController mapController) {
            this.f8299a = mapController;
        }

        public final void run() {
            this.f8299a.getPresenter().create();
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$h */
    static final class C2679h implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MapController f8300a;
        /* renamed from: b */
        final /* synthetic */ ParkingAdvert f8301b;

        C2679h(MapController mapController, ParkingAdvert parkingAdvert) {
            this.f8300a = mapController;
            this.f8301b = parkingAdvert;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            C0700j.m2715b(dialogInterface, "dialogInterface");
            this.f8300a.getPresenter().buyParking(this.f8301b);
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$c */
    static final class C4211c implements C1990q {
        /* renamed from: a */
        final /* synthetic */ MapController f12748a;

        C4211c(MapController mapController) {
            this.f12748a = mapController;
        }

        /* renamed from: a */
        public final void mo1914a(C1985l c1985l) {
            LatLng latLng;
            C0700j.m2715b(c1985l, "it");
            this.f12748a.setMap(c1985l);
            c1985l = this.f12748a.getMap();
            if (c1985l != null) {
                c1985l.m7584a(new C2007b().m7774a(BuildConfig.MAPBOX_STYLE), (C2008c) new C2008c() {
                    /* renamed from: a */
                    public final void mo1913a(C2009y c2009y) {
                        C0700j.m2715b(c2009y, "it");
                        if (LocationUtils.INSTANCE.isLocationPermissionGranted() != null) {
                            this.f12748a.enableLocationComponent();
                        }
                        this.f12748a.initMarkerIcons();
                        this.f12748a.initLayers();
                        this.f12748a.getPresenter().onMapReady();
                    }
                });
            }
            c1985l = this.f12748a.getMap();
            if (c1985l != null) {
                c1985l.m7580a((C1975n) this.f12748a);
            }
            c1985l = this.f12748a.getMap();
            if (c1985l != null) {
                c1985l.m7577a((C1964c) this.f12748a);
            }
            c1985l = this.f12748a.getMap();
            if (c1985l != null) {
                c1985l.m7578a((C1966e) this.f12748a);
            }
            c1985l = this.f12748a;
            C1985l map = c1985l.getMap();
            if (map != null) {
                CameraPosition p = map.m7609p();
                if (p != null) {
                    latLng = p.target;
                    c1985l.updateCurrentMapCenter(latLng);
                }
            }
            latLng = null;
            c1985l.updateCurrentMapCenter(latLng);
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$d */
    static final class C4212d<T> implements C2482d<Object> {
        /* renamed from: a */
        final /* synthetic */ MapController f12749a;

        C4212d(MapController mapController) {
            this.f12749a = mapController;
        }

        /* renamed from: a */
        public final void mo1808a(Object obj) {
            this.f12749a.showSellPlace();
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$e */
    static final class C4213e<T> implements C2482d<ParkingAdvert> {
        /* renamed from: a */
        final /* synthetic */ MapController f12750a;

        C4213e(MapController mapController) {
            this.f12750a = mapController;
        }

        /* renamed from: a */
        public final void m18198a(ParkingAdvert parkingAdvert) {
            MapController mapController = this.f12750a;
            C0700j.m2711a((Object) parkingAdvert, "it");
            mapController.showBuyConfirmation(parkingAdvert);
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$f */
    static final class C4214f<T> implements C2482d<Integer> {
        /* renamed from: a */
        final /* synthetic */ MapController f12751a;

        C4214f(MapController mapController) {
            this.f12751a = mapController;
        }

        /* renamed from: a */
        public final void m18199a(Integer num) {
            int itemCount = this.f12751a.getAdapter().getItemCount();
            C0700j.m2711a((Object) num, "it");
            if (C0700j.m2706a(itemCount, num.intValue()) > 0) {
                this.f12751a.getBottomContainer().m20887c(num.intValue());
            }
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$a */
    static final class C4633a extends C3038k implements C0689a<C0818i> {
        final /* synthetic */ MapController this$0;

        C4633a(MapController mapController) {
            this.this$0 = mapController;
            super(0);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            return m20517b();
        }

        /* renamed from: b */
        public final C0818i m20517b() {
            MapController mapController = this.this$0;
            C0818i childRouter = mapController.getChildRouter(mapController.getChildRouterContainer());
            childRouter.m3156c(true);
            return childRouter;
        }
    }

    /* compiled from: MapController.kt */
    /* renamed from: ru.gg.scooby.ui.controller.MapController$b */
    static final class C4634b extends C3038k implements C0689a<C0727n> {
        final /* synthetic */ MapController this$0;

        C4634b(MapController mapController) {
            this.this$0 = mapController;
            super(0);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo2120a() {
            m20519b();
            return C0727n.f2066a;
        }

        /* renamed from: b */
        public final void m20519b() {
            this.this$0.hideProgress();
        }
    }

    public final C0818i getChildRouter() {
        C0687c c0687c = this.childRouter$delegate;
        C3045e c3045e = $$delegatedProperties[0];
        return (C0818i) c0687c.mo625a();
    }

    public boolean onMarkerClick(Marker marker) {
        C0700j.m2715b(marker, "marker");
        return false;
    }

    public MapController() {
        setRetainViewMode(C0808b.RETAIN_DETACH);
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

    public final MapView get_mapView() {
        MapView mapView = this._mapView;
        if (mapView == null) {
            C0700j.m2716b("_mapView");
        }
        return mapView;
    }

    public final void set_mapView(MapView mapView) {
        C0700j.m2715b(mapView, "<set-?>");
        this._mapView = mapView;
    }

    public final RecyclerView getBottomContainer() {
        RecyclerView recyclerView = this.bottomContainer;
        if (recyclerView == null) {
            C0700j.m2716b("bottomContainer");
        }
        return recyclerView;
    }

    public final void setBottomContainer(RecyclerView recyclerView) {
        C0700j.m2715b(recyclerView, "<set-?>");
        this.bottomContainer = recyclerView;
    }

    public final FrameLayout getChildRouterContainer() {
        FrameLayout frameLayout = this.childRouterContainer;
        if (frameLayout == null) {
            C0700j.m2716b("childRouterContainer");
        }
        return frameLayout;
    }

    public final void setChildRouterContainer(FrameLayout frameLayout) {
        C0700j.m2715b(frameLayout, "<set-?>");
        this.childRouterContainer = frameLayout;
    }

    public final FrameLayout getMapContainer() {
        FrameLayout frameLayout = this.mapContainer;
        if (frameLayout == null) {
            C0700j.m2716b("mapContainer");
        }
        return frameLayout;
    }

    public final void setMapContainer(FrameLayout frameLayout) {
        C0700j.m2715b(frameLayout, "<set-?>");
        this.mapContainer = frameLayout;
    }

    public C1985l getMap() {
        return this.map;
    }

    public void setMap(C1985l c1985l) {
        this.map = c1985l;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    public MapView getMapView() {
        MapView mapView = this._mapView;
        if (mapView == null) {
            C0700j.m2716b("_mapView");
        }
        return mapView;
    }

    public final MapPresenter getPresenter() {
        return this.presenter;
    }

    public final ParkingBlockAdapter getAdapter() {
        ParkingBlockAdapter parkingBlockAdapter = this.adapter;
        if (parkingBlockAdapter == null) {
            C0700j.m2716b("adapter");
        }
        return parkingBlockAdapter;
    }

    public final void setAdapter(ParkingBlockAdapter parkingBlockAdapter) {
        C0700j.m2715b(parkingBlockAdapter, "<set-?>");
        this.adapter = parkingBlockAdapter;
    }

    public final C1870j getLocationComponent() {
        return this.locationComponent;
    }

    public final void setLocationComponent(C1870j c1870j) {
        this.locationComponent = c1870j;
    }

    public final Marker getSearchLocationMarker() {
        return this.searchLocationMarker;
    }

    public final void setSearchLocationMarker(Marker marker) {
        this.searchLocationMarker = marker;
    }

    public void setMyLocationCenter(LatLng latLng) {
        this.myLocationCenter = latLng;
    }

    @SuppressLint({"MissingPermission"})
    public LatLng getMyLocationCenter() {
        C1870j c1870j = this.locationComponent;
        if (c1870j != null) {
            Location b = c1870j.m7070b();
            if (b != null) {
                return new LatLng(b);
            }
        }
        MapController mapController = this;
        return (LatLng) null;
    }

    public LatLng getCurrentMapCenter() {
        return this.currentMapCenter;
    }

    public void setCurrentMapCenter(LatLng latLng) {
        this.currentMapCenter = latLng;
    }

    protected View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        C0700j.m2715b(layoutInflater, "inflater");
        C0700j.m2715b(viewGroup, "container");
        Object inflate = layoutInflater.inflate(R.layout.controller_map, viewGroup, false);
        C0700j.m2711a(inflate, "inflater.inflate(R.layou…er_map, container, false)");
        return inflate;
    }

    @SuppressLint({"CheckResult"})
    public void onViewBound(View view, Bundle bundle) {
        C0700j.m2715b(view, "view");
        super.onViewBound(view, bundle);
        Activity activity = getActivity();
        addLifecycleListener(new StatusBarColorHelper(activity != null ? activity.getWindow() : null, view, view.getResources().getColor(R.color.white_alternative), false, 8, null));
        MapView mapView = getMapView();
        if (mapView != null) {
            mapView.m16007a(bundle);
        }
        bundle = getMapView();
        if (bundle != null) {
            bundle.m16014a((C1990q) new C4211c(this));
        }
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.block_item_width) + view.getResources().getDimensionPixelSize(R.dimen.block_items_spacing);
        Object context = view.getContext();
        C0700j.m2711a(context, "view.context");
        bundle = new CustomLayoutManager(context, UIUtils.INSTANCE.getScreenWidth(), dimensionPixelSize);
        RecyclerView recyclerView = this.bottomContainer;
        if (recyclerView == null) {
            C0700j.m2716b("bottomContainer");
        }
        recyclerView.setLayoutManager((C0598i) bundle);
        bundle = new C4378i();
        recyclerView = this.bottomContainer;
        if (recyclerView == null) {
            C0700j.m2716b("bottomContainer");
        }
        bundle.m13016a(recyclerView);
        bundle = this.bottomContainer;
        if (bundle == null) {
            C0700j.m2716b("bottomContainer");
        }
        bundle.m20863a((C0603n) new MapController$onViewBound$2(this));
        Object from = LayoutInflater.from(view.getContext());
        C0700j.m2711a(from, "LayoutInflater.from(view.context)");
        this.adapter = new ParkingBlockAdapter(from);
        bundle = this.bottomContainer;
        if (bundle == null) {
            C0700j.m2716b("bottomContainer");
        }
        ParkingBlockAdapter parkingBlockAdapter = this.adapter;
        if (parkingBlockAdapter == null) {
            C0700j.m2716b("adapter");
        }
        bundle.setAdapter(parkingBlockAdapter);
        bundle = this.adapter;
        if (bundle == null) {
            C0700j.m2716b("adapter");
        }
        bundle.getSellClickSubject().m17731c((C2482d) new C4212d(this));
        bundle = this.adapter;
        if (bundle == null) {
            C0700j.m2716b("adapter");
        }
        bundle.getBuyClickSubject().m17731c((C2482d) new C4213e(this));
        bundle = this.adapter;
        if (bundle == null) {
            C0700j.m2716b("adapter");
        }
        bundle.getBlockClickSubject().m17731c((C2482d) new C4214f(this));
        view.post((Runnable) new C2678g(this));
    }

    @OnClick
    public final void onMyLocationClick() {
        this.presenter.requestLocationUpdate(true);
        RecyclerView recyclerView = this.bottomContainer;
        if (recyclerView == null) {
            C0700j.m2716b("bottomContainer");
        }
        recyclerView.m20887c(0);
    }

    @OnClick
    public final void onSearchClick() {
        SearchAddressController searchAddressController = new SearchAddressController();
        searchAddressController.setTargetController(this);
        getRouter().m3151b(C0820k.m3183a((C0809d) searchAddressController).m3184a((C0814e) new MapHorizontalChangeHandler()).m3189b(new MapHorizontalChangeHandler()));
    }

    @OnClick
    public final void onProfileClick() {
        getRouter().m3151b(C0820k.m3183a((C0809d) new ProfileController()).m3184a((C0814e) new MapHorizontalChangeHandler()).m3189b(new MapHorizontalChangeHandler()));
    }

    public void onLocationEngineReady(C1742c c1742c) {
        C0700j.m2715b(c1742c, "locationEngine");
        enableLocationComponent();
    }

    @SuppressLint({"MissingPermission"})
    public final void enableLocationComponent() {
        if (getMap() != null && getMapView() != null && this.locationComponent == null) {
            Activity activity = getActivity();
            if (activity == null) {
                C0700j.m2709a();
            }
            C1873l a = C1873l.m7107a(activity).m7092b(true).m7088a();
            C0700j.m2711a((Object) a, "LocationComponentOptions…                 .build()");
            C1985l map = getMap();
            this.locationComponent = map != null ? map.m7619z() : null;
            C1870j c1870j = this.locationComponent;
            if (c1870j != null) {
                Activity activity2 = getActivity();
                if (activity2 == null) {
                    C0700j.m2709a();
                }
                Context context = activity2;
                C1985l map2 = getMap();
                if (map2 == null) {
                    C0700j.m2709a();
                }
                C2009y a2 = map2.m7564a();
                if (a2 == null) {
                    C0700j.m2709a();
                }
                c1870j.m7065a(context, a2);
            }
            c1870j = this.locationComponent;
            if (c1870j != null) {
                c1870j.m7068a(a);
            }
            C1870j c1870j2 = this.locationComponent;
            if (c1870j2 != null) {
                c1870j2.m7069a(true);
            }
            c1870j2 = this.locationComponent;
            if (c1870j2 != null) {
                c1870j2.m7063a(8);
            }
            c1870j2 = this.locationComponent;
            if (c1870j2 != null) {
                c1870j2.m7071b(4);
            }
        }
    }

    public final void onPageChanged(int i) {
        if (i != 0 && i > 0) {
            ParkingBlockAdapter parkingBlockAdapter = this.adapter;
            if (parkingBlockAdapter == null) {
                C0700j.m2716b("adapter");
            }
            ParkingAdvert parkingAdvert = (ParkingAdvert) parkingBlockAdapter.getItems().get(i - 1);
            C1985l map = getMap();
            if (map != null) {
                map.m7589b(C1859b.m6949a(new LatLng(parkingAdvert.getParking().getLat(), parkingAdvert.getParking().getLng())));
            }
        }
    }

    public final void initMarkerIcons() {
        C2009y a;
        C1985l map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7787a(MARKER_PIN_NOW, UIUtils.INSTANCE.getBitmapFromDrawableResource(R.drawable.ic_pin_now));
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7787a(MARKER_PIN_TRIP_TARGET, UIUtils.INSTANCE.getBitmapFromDrawableResource(R.drawable.ic_location_pin));
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7787a(MARKER_PIN_CAR, UIUtils.INSTANCE.getBitmapFromDrawableResource(R.drawable.ic_pin_car));
            }
        }
    }

    public final void initLayers() {
        C2009y a;
        C1985l map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7786a((Source) new GeoJsonSource(MARKER_SOURCE));
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7782a((Layer) new SymbolLayer(MARKER_LAYER, MARKER_SOURCE).m16154a(C2024c.m7882d(MARKER_PIN_NOW)));
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7786a((Source) new GeoJsonSource(MARKER_SOURCE_USER_LOCATION));
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7782a((Layer) new SymbolLayer(MARKER_LAYER_USER_LOCATION, MARKER_SOURCE_USER_LOCATION).m16154a(C2024c.m7882d(MARKER_PIN_CAR), C2024c.m7879c(Boolean.valueOf(true)), C2024c.m7873a(Boolean.valueOf(true))));
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7786a((Source) new GeoJsonSource(MARKER_SOURCE_TRIP_TARGET));
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                a.m7782a((Layer) new SymbolLayer(MARKER_LAYER_TRIP_TARGET, MARKER_SOURCE_TRIP_TARGET).m16154a(C2024c.m7882d(MARKER_PIN_TRIP_TARGET), C2024c.m7879c(Boolean.valueOf(true)), C2024c.m7873a(Boolean.valueOf(true))));
            }
        }
    }

    public void onCameraIdle() {
        this.presenter.onCameraIdle();
    }

    public void onCameraMove() {
        LatLng latLng;
        this.presenter.onCameraMove();
        C1985l map = getMap();
        if (map != null) {
            CameraPosition p = map.m7609p();
            if (p != null) {
                latLng = p.target;
                updateCurrentMapCenter(latLng);
            }
        }
        latLng = null;
        updateCurrentMapCenter(latLng);
    }

    public boolean onMapClick(LatLng latLng) {
        C0700j.m2715b(latLng, "point");
        removeSearchLocationMarker();
        C1985l map = getMap();
        if (map == null) {
            C0700j.m2709a();
        }
        PointF a = map.m7607n().m7760a(latLng);
        C0700j.m2711a((Object) a, "map!!.getProjection().toScreenLocation(point)");
        map = getMap();
        if (map == null) {
            C0700j.m2709a();
        }
        String[] strArr = new String[1];
        int i = 0;
        strArr[0] = MARKER_LAYER;
        Object a2 = map.m7565a(a, strArr);
        C0700j.m2711a(a2, "map!!.queryRenderedFeatu…creenPoint, MARKER_LAYER)");
        Feature feature = (Feature) C4774r.m22244d((List) a2);
        if (feature == null) {
            return false;
        }
        ParkingBlockAdapter parkingBlockAdapter = this.adapter;
        if (parkingBlockAdapter == null) {
            C0700j.m2716b("adapter");
        }
        for (ParkingAdvert parking : parkingBlockAdapter.getItems()) {
            if (C0700j.m2713a(String.valueOf(parking.getParking().getId()), feature.id())) {
                break;
            }
            i++;
        }
        i = -1;
        latLng = this.bottomContainer;
        if (latLng == null) {
            C0700j.m2716b("bottomContainer");
        }
        latLng.m20887c(i + 1);
        if (i >= 0) {
            latLng = this.adapter;
            if (latLng == null) {
                C0700j.m2716b("adapter");
            }
            ParkingAdvert parkingAdvert = (ParkingAdvert) latLng.getItems().get(i);
            map = getMap();
            if (map != null) {
                map.m7589b(C1859b.m6949a(new LatLng(parkingAdvert.getParking().getLat(), parkingAdvert.getParking().getLng())));
            }
        }
        return true;
    }

    public void updateParkings(List<ParkingAdvert> list) {
        Source a;
        GeoJsonSource geoJsonSource;
        ParkingBlockAdapter parkingBlockAdapter;
        C0700j.m2715b(list, "parkings");
        Iterable<ParkingAdvert> iterable = list;
        Collection arrayList = new ArrayList(C4381k.m18905a(iterable, 10));
        for (ParkingAdvert parkingAdvert : iterable) {
            arrayList.add(Feature.fromGeometry((Geometry) Point.fromLngLat(parkingAdvert.getParking().getLng(), parkingAdvert.getParking().getLat()), new JsonObject(), String.valueOf(parkingAdvert.getParking().getId())));
        }
        FeatureCollection fromFeatures = FeatureCollection.fromFeatures((List) arrayList);
        C1985l map = getMap();
        if (map != null) {
            C2009y a2 = map.m7564a();
            if (a2 != null) {
                a = a2.m7780a(MARKER_SOURCE);
                geoJsonSource = (GeoJsonSource) a;
                if (geoJsonSource != null) {
                    geoJsonSource.m16161a(fromFeatures);
                }
                parkingBlockAdapter = this.adapter;
                if (parkingBlockAdapter == null) {
                    C0700j.m2716b("adapter");
                }
                parkingBlockAdapter.updateItems(list);
            }
        }
        a = null;
        geoJsonSource = (GeoJsonSource) a;
        if (geoJsonSource != null) {
            geoJsonSource.m16161a(fromFeatures);
        }
        parkingBlockAdapter = this.adapter;
        if (parkingBlockAdapter == null) {
            C0700j.m2716b("adapter");
        }
        parkingBlockAdapter.updateItems(list);
    }

    public void onUserLocationChanged(Location location) {
        C0700j.m2715b(location, "location");
        ParkingBlockAdapter parkingBlockAdapter = this.adapter;
        if (parkingBlockAdapter == null) {
            C0700j.m2716b("adapter");
        }
        parkingBlockAdapter.setCurrentUserLocation(location);
        location = this.adapter;
        if (location == null) {
            C0700j.m2716b("adapter");
        }
        location.notifyDataSetChanged();
    }

    public void updateLocation(LatLng latLng, boolean z) {
        C0700j.m2715b(latLng, "location");
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("location = ");
        stringBuilder.append(latLng);
        stringBuilder.append(" animated = ");
        stringBuilder.append(z);
        log.dTrace(stringBuilder.toString());
        updateCurrentMapCenter(latLng);
        if (z) {
            z = getMap();
            if (z) {
                z.m7589b(C1859b.m6950a(latLng, 13.0d));
                return;
            }
            return;
        }
        z = getMap();
        if (z) {
            z.m7572a(C1859b.m6950a(latLng, 13.0d));
        }
    }

    protected void onDestroyView(View view) {
        C0700j.m2715b(view, "view");
        C1985l map = getMap();
        if (map != null) {
            map.m7592b((C1975n) this);
        }
        map = getMap();
        if (map != null) {
            map.m7591b((C1966e) this);
        }
        map = getMap();
        if (map != null) {
            map.m7590b((C1964c) this);
        }
        C1870j c1870j = this.locationComponent;
        if (c1870j != null) {
            c1870j.m7069a(false);
        }
        MapView mapView = getMapView();
        if (mapView != null) {
            mapView.m16025e();
        }
        this.presenter.destroy();
        super.onDestroyView(view);
    }

    protected void onChangeStarted(C0814e c0814e, C0815f c0815f) {
        C0700j.m2715b(c0814e, "changeHandler");
        C0700j.m2715b(c0815f, "changeType");
        super.onChangeStarted(c0814e, c0815f);
        if (c0815f == C0815f.POP_ENTER) {
            onVisibilityChanged(true);
        } else if (c0815f.isEnter == null) {
            onVisibilityChanged(null);
        }
    }

    public final void onVisibilityChanged(boolean z) {
        if (z) {
            updateAvatar();
            z = getView();
            if (z && z.getVisibility()) {
                z = getView();
                if (z) {
                    z.setVisibility(0);
                }
            }
        }
    }

    protected void onAttach(View view) {
        C0700j.m2715b(view, "view");
        MapView mapView = getMapView();
        if (mapView != null) {
            FrameLayout frameLayout = this.mapContainer;
            if (frameLayout == null) {
                C0700j.m2716b("mapContainer");
            }
            if (frameLayout.getChildCount() == 0) {
                View view2 = mapView;
                UIUtils.INSTANCE.removeFromSuperview(view2);
                mapView.setVisibility(0);
                FrameLayout frameLayout2 = this.mapContainer;
                if (frameLayout2 == null) {
                    C0700j.m2716b("mapContainer");
                }
                frameLayout2.addView(view2);
            }
        }
        super.onAttach(view);
        view = getMapView();
        if (view != null) {
            view.m16005a();
        }
        view = getMapView();
        if (view != null) {
            view.m16015b();
        }
        this.presenter.attach();
    }

    protected void onDetach(View view) {
        C0700j.m2715b(view, "view");
        super.onDetach(view);
        removeSearchLocationMarker();
        this.presenter.detach();
        view = getMapView();
        if (view != null) {
            view.setVisibility(4);
            view = view;
            UIUtils.INSTANCE.removeFromSuperview(view);
            Activity activity = getActivity();
            if (activity != null) {
                ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.root_map_container);
                if (viewGroup != null) {
                    viewGroup.addView(view);
                }
            }
        }
        view = getMapView();
        if (view != null) {
            view.m16023c();
        }
        view = getMapView();
        if (view != null) {
            view.m16024d();
        }
    }

    public void onAddressSelected(Address address) {
        C0700j.m2715b(address, "address");
        this.presenter.onAddressSelected(address);
        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
        C1985l map = getMap();
        if (map != null) {
            map.m7572a(C1859b.m6950a(latLng, 16.0d));
            UIUtils uIUtils = UIUtils.INSTANCE;
            Resources resources = getResources();
            if (resources == null) {
                C0700j.m2709a();
            }
            Object drawable = resources.getDrawable(R.drawable.ic_location_pin);
            C0700j.m2711a(drawable, "resources!!.getDrawable(…drawable.ic_location_pin)");
            Bitmap bitmapFromDrawable$default = UIUtils.getBitmapFromDrawable$default(uIUtils, drawable, 0, 0, 6, null);
            C3641h c3641h = new C3641h();
            drawable = getView();
            if (drawable == null) {
                C0700j.m2709a();
            }
            C0700j.m2711a(drawable, "view!!");
            this.searchLocationMarker = map.m7562a((C3641h) ((C3641h) ((C3641h) c3641h.m6900a(C1842f.m6918a(drawable.getContext()).m6921a(bitmapFromDrawable$default))).m6901a(latLng)).m6902a((String) address.getAddressLine(0)));
            address = this.searchLocationMarker;
            if (address == null) {
                C0700j.m2709a();
            }
            map.m7595c(address);
            updateCurrentMapCenter(latLng);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        C0700j.m2715b(bundle, "outState");
        super.onSaveInstanceState(bundle);
        MapView mapView = getMapView();
        if (mapView != null) {
            mapView.m16016b(bundle);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C0700j.m2715b(strArr, "permissions");
        C0700j.m2715b(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.presenter.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showPermissionDeniedSnackbar() {
        ControllerExKt.showPermissionDeniedSnackbar(this, R.string.please_provide_location);
    }

    public final void removeSearchLocationMarker() {
        Marker marker = this.searchLocationMarker;
        if (marker != null) {
            C1985l map = getMap();
            if (map != null) {
                map.m7588b(marker);
            }
            this.searchLocationMarker = (Marker) null;
        }
    }

    public void showPaymentScreen() {
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            String string;
            as a = PayFormActivity.m22169a(AcquiringCredentialsProvider.INSTANCE.getTERMINAL_KEY(), AcquiringCredentialsProvider.INSTANCE.getPASSWORD(), AcquiringCredentialsProvider.INSTANCE.getPUBLIC_KEY());
            String valueOf = String.valueOf(System.currentTimeMillis());
            an a2 = an.m11297a(activeParking.getParking().getPrice());
            Resources resources = getResources();
            if (resources != null) {
                string = resources.getString(R.string.parking_pay_title, new Object[]{PriceExKt.formatPriceWithOptionalDecimalPart(Double.valueOf(activeParking.getParking().getNormalizedPrice()))});
            } else {
                string = null;
            }
            Object a3 = a.m11317a(valueOf, a2, string, null, null, null, false, true).m11316a(AcquiringCredentialsProvider.INSTANCE.getCUSTOMER_ID()).m11319a((ab) new C4286a()).m11315a((int) R.style.CustomAcquiringTheme).m11318a(ad.m18901b(C0723j.m2744a("OpPayload_AdvId", String.valueOf(activeParking.getParking().getId())), C0723j.m2744a("OpPayload_Provider", "TCS"), C0723j.m2744a("OpPayload_Type", "buy")));
            C0700j.m2711a(a3, "PayFormActivity\n        …pPayload_Type\" to \"buy\"))");
            Intent a4 = a3.m11314a();
            a4.setClass(getActivity(), PayFormActivity.class);
            startActivityForResult(a4, 100);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("requestCode = ");
        stringBuilder.append(i);
        stringBuilder.append(" resultCode = ");
        stringBuilder.append(i2);
        stringBuilder.append(" data = ");
        stringBuilder.append(intent);
        log.m11183d(stringBuilder.toString());
        if (i == 100) {
            Object obj = null;
            if (i2 == -1) {
                showProgress();
                ParkingManager.refreshParkingStatus$default(ParkingManager.INSTANCE, 0, (C0689a) new C4634b(this), 1, null);
            } else if (i2 == BankKeyboard.KEYBOARD_SHOW_DELAY_MILLIS) {
                i = intent != null ? intent.getSerializableExtra("error") : 0;
                if ((i instanceof C2757d) == 0) {
                    i = 0;
                }
                C2757d c2757d = (C2757d) i;
                i = c2757d != null ? c2757d.getCause() : 0;
                if ((i instanceof C2751b) == 0) {
                    i = 0;
                }
                C2751b c2751b = (C2751b) i;
                i2 = Log.INSTANCE;
                intent = new StringBuilder();
                intent.append("apiError = ");
                intent.append(c2751b);
                i2.m11183d(intent.toString());
                Object obj2 = "1051";
                if (c2751b != null) {
                    i = c2751b.m11337a();
                    if (i != 0) {
                        obj = i.m11364b();
                    }
                }
                if (C0700j.m2713a(obj2, obj) != 0) {
                    ControllerExKt.showSnackbar$default(this, R.string.parking_pay_error_no_funds, 0, 0, 6, null);
                } else {
                    ControllerExKt.showSnackbar$default(this, R.string.parking_pay_error_common, 0, 0, 6, null);
                }
            }
        }
    }

    public void showParkingPosted() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        ParkingPostedController parkingPostedController = new ParkingPostedController();
        TripPanelChangeHandler tripPanelChangeHandler = new TripPanelChangeHandler(getMap(), this);
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        C0814e c0814e = tripPanelChangeHandler;
        getChildRouter().m3151b(C0820k.m3183a((C0809d) parkingPostedController).m3184a(c0814e).m3189b(c0814e));
    }

    public void showActiveTrip() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        ActiveTripController activeTripController = new ActiveTripController();
        TripPanelChangeHandler tripPanelChangeHandler = new TripPanelChangeHandler(getMap(), this);
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        C0814e c0814e = tripPanelChangeHandler;
        getChildRouter().m3151b(C0820k.m3183a((C0809d) activeTripController).m3184a(c0814e).m3189b(c0814e));
    }

    public void showSellPlace() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        removeSearchLocationMarker();
        C0814e sellPlacePanelChangeHandler = new SellPlacePanelChangeHandler(getMap(), this);
        getChildRouter().m3151b(C0820k.m3183a((C0809d) new SellPlacePanelController(0, 1, null)).m3184a(sellPlacePanelChangeHandler).m3189b(sellPlacePanelChangeHandler));
    }

    public void showBuyerFound() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        getRouter().m3151b(C0820k.m3183a((C0809d) new BuyerFoundController()).m3184a((C0814e) new BuyerFoundChangeHandler()).m3189b(new BuyerFoundChangeHandler()));
    }

    public void showTripCanceled(int i, ParkingStatus parkingStatus) {
        C0700j.m2715b(parkingStatus, "parkingStatus");
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type = ");
        stringBuilder.append(i);
        log.dTrace(stringBuilder.toString());
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        getRouter().m3151b(C0820k.m3183a((C0809d) new TripCanceledController(i, parkingStatus)).m3189b((C0814e) new MapHorizontalChangeHandler()).m3184a((C0814e) new MapHorizontalChangeHandler()));
    }

    public void showWaitingPayBuyer() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        TripPanelChangeHandler tripPanelChangeHandler = new TripPanelChangeHandler(getMap(), this);
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        C0814e c0814e = tripPanelChangeHandler;
        getChildRouter().m3151b(C0820k.m3183a((C0809d) new WaitingPayBuyerController()).m3184a(c0814e).m3189b(c0814e));
    }

    public void showWaitingPaySeller() {
        TripPanelChangeHandler tripPanelChangeHandler = new TripPanelChangeHandler(getMap(), this);
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        C0814e c0814e = tripPanelChangeHandler;
        getChildRouter().m3151b(C0820k.m3183a((C0809d) new WaitingPaySellerController()).m3184a(c0814e).m3189b(c0814e));
    }

    public void showWaitingConfirmFromMe() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        TripPanelChangeHandler tripPanelChangeHandler = new TripPanelChangeHandler(getMap(), this);
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        C0814e c0814e = tripPanelChangeHandler;
        getChildRouter().m3151b(C0820k.m3183a((C0809d) new WaitingConfirmFromMeController()).m3184a(c0814e).m3189b(c0814e));
    }

    public void showWaitingConfirmFromOtherSide() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        TripPanelChangeHandler tripPanelChangeHandler = new TripPanelChangeHandler(getMap(), this);
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        C0814e c0814e = tripPanelChangeHandler;
        getChildRouter().m3151b(C0820k.m3183a((C0809d) new WaitingConfirmOtherSideController()).m3184a(c0814e).m3189b(c0814e));
    }

    public void closeTripScreens() {
        Log.INSTANCE.dTrace(io.card.payment.BuildConfig.FLAVOR);
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
    }

    public void showDispute(int i, ParkingStatus parkingStatus) {
        C0700j.m2715b(parkingStatus, "parkingStatus");
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type = ");
        stringBuilder.append(i);
        stringBuilder.append(" parkingStatus = ");
        stringBuilder.append(parkingStatus);
        log.dTrace(stringBuilder.toString());
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        getRouter().m3151b(C0820k.m3183a((C0809d) new TripCanceledController(i, parkingStatus)).m3189b((C0814e) new MapHorizontalChangeHandler()).m3184a((C0814e) new MapHorizontalChangeHandler()));
    }

    public void showTripSuccess(int i, double d) {
        Object childRouter = getChildRouter();
        C0700j.m2711a(childRouter, "childRouter");
        C0819j.m3180a(childRouter);
        if (i == 1) {
            i = (BaseController) new SuccessSellController(d);
        } else {
            i = (BaseController) new SuccessBuyController();
        }
        getRouter().m3151b(C0820k.m3183a((C0809d) i).m3189b(new MapVerticalChangeHandler()).m3184a((C0814e) new MapVerticalChangeHandler()));
    }

    public void showProgress() {
        ControllerExKt.showProgress(this, getView());
    }

    public void hideProgress() {
        ControllerExKt.hideProgress(this, getView());
    }

    public void showSnackbarMessage(int i) {
        ControllerExKt.showSnackbar$default(this, i, 0, 0, 6, null);
    }

    public void updateUserMarkerLocation(double d, double d2) {
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(' ');
        stringBuilder.append(d2);
        stringBuilder.append(" map = ");
        stringBuilder.append(getMap());
        log.dTrace(stringBuilder.toString());
        if (getMap() != null) {
            Source a;
            GeoJsonSource geoJsonSource;
            Geometry fromLngLat = Point.fromLngLat(d2, d);
            JsonObject jsonObject = new JsonObject();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(d);
            stringBuilder2.append(4.7E-322d);
            stringBuilder2.append(d2);
            Feature fromGeometry = Feature.fromGeometry(fromLngLat, jsonObject, stringBuilder2.toString());
            C1985l map = getMap();
            if (map != null) {
                C2009y a2 = map.m7564a();
                if (a2 != null) {
                    a = a2.m7780a(MARKER_SOURCE_USER_LOCATION);
                    geoJsonSource = (GeoJsonSource) a;
                    if (geoJsonSource != null) {
                        geoJsonSource.m16160a(fromGeometry);
                    }
                }
            }
            a = null;
            geoJsonSource = (GeoJsonSource) a;
            if (geoJsonSource != null) {
                geoJsonSource.m16160a(fromGeometry);
            }
        }
    }

    public void updateParkingMarkerLocation(double d, double d2) {
        Log log = Log.INSTANCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(' ');
        stringBuilder.append(d2);
        stringBuilder.append(" map = ");
        stringBuilder.append(getMap());
        log.dTrace(stringBuilder.toString());
        if (getMap() != null) {
            Source a;
            GeoJsonSource geoJsonSource;
            Geometry fromLngLat = Point.fromLngLat(d2, d);
            JsonObject jsonObject = new JsonObject();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(d);
            stringBuilder2.append(4.7E-322d);
            stringBuilder2.append(d2);
            Feature fromGeometry = Feature.fromGeometry(fromLngLat, jsonObject, stringBuilder2.toString());
            C1985l map = getMap();
            if (map != null) {
                C2009y a2 = map.m7564a();
                if (a2 != null) {
                    a = a2.m7780a(MARKER_SOURCE_TRIP_TARGET);
                    geoJsonSource = (GeoJsonSource) a;
                    if (geoJsonSource != null) {
                        geoJsonSource.m16160a(fromGeometry);
                    }
                }
            }
            a = null;
            geoJsonSource = (GeoJsonSource) a;
            if (geoJsonSource != null) {
                geoJsonSource.m16160a(fromGeometry);
            }
        }
    }

    public void updateLayersVisibility() {
        Object obj;
        C1985l map;
        C2009y a;
        Layer c;
        C2025d[] c2025dArr;
        C1985l map2;
        C2009y a2;
        Layer c2;
        Object obj2 = ParkingManager.INSTANCE.getActiveParking() != null ? 1 : null;
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            Parking parking = activeParking.getParking();
            if (parking != null && parking.getStatus() == AdvStatus.ADV_PAID.getCode()) {
                obj = 1;
                map = getMap();
                if (map != null) {
                    a = map.m7564a();
                    if (a != null) {
                        c = a.m7792c(MARKER_LAYER);
                        if (c != null && ((obj2 != null && C0700j.m2713a((String) c.m7869c().f5711b, (Object) "visible")) || (obj2 == null && C0700j.m2713a((String) c.m7869c().f5711b, (Object) "none")))) {
                            c2025dArr = new C2025d[1];
                            c2025dArr[0] = C2024c.m7874a(obj2 == null ? "none" : "visible");
                            c.m7868b(c2025dArr);
                        }
                    }
                }
                map = getMap();
                if (map != null) {
                    a = map.m7564a();
                    if (a != null) {
                        c = a.m7792c(MARKER_LAYER_TRIP_TARGET);
                        if (c != null && ((obj2 != null && C0700j.m2713a((String) c.m7869c().f5711b, (Object) "none")) || (obj2 == null && C0700j.m2713a((String) c.m7869c().f5711b, (Object) "visible")))) {
                            c2025dArr = new C2025d[1];
                            c2025dArr[0] = C2024c.m7874a(obj2 == null ? "visible" : "none");
                            c.m7868b(c2025dArr);
                        }
                    }
                }
                map2 = getMap();
                if (map2 != null) {
                    a2 = map2.m7564a();
                    if (a2 != null) {
                        c2 = a2.m7792c(MARKER_LAYER_USER_LOCATION);
                        if (c2 == null) {
                        }
                        if ((obj == null && C0700j.m2713a((String) c2.m7869c().f5711b, (Object) "none")) || (obj == null && C0700j.m2713a((String) c2.m7869c().f5711b, (Object) "visible"))) {
                            C2025d[] c2025dArr2 = new C2025d[1];
                            c2025dArr2[0] = C2024c.m7874a(obj != null ? "visible" : "none");
                            c2.m7868b(c2025dArr2);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        obj = null;
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                c = a.m7792c(MARKER_LAYER);
                c2025dArr = new C2025d[1];
                if (obj2 == null) {
                }
                c2025dArr[0] = C2024c.m7874a(obj2 == null ? "none" : "visible");
                c.m7868b(c2025dArr);
            }
        }
        map = getMap();
        if (map != null) {
            a = map.m7564a();
            if (a != null) {
                c = a.m7792c(MARKER_LAYER_TRIP_TARGET);
                c2025dArr = new C2025d[1];
                if (obj2 == null) {
                }
                c2025dArr[0] = C2024c.m7874a(obj2 == null ? "visible" : "none");
                c.m7868b(c2025dArr);
            }
        }
        map2 = getMap();
        if (map2 != null) {
            a2 = map2.m7564a();
            if (a2 != null) {
                c2 = a2.m7792c(MARKER_LAYER_USER_LOCATION);
                if (c2 == null) {
                    if (obj == null) {
                    }
                }
            }
        }
    }

    public void updateAvatar() {
        String avatarUrl;
        AvatarImageView avatarImageView = this.imageAvatar;
        if (avatarImageView == null) {
            C0700j.m2716b("imageAvatar");
        }
        User user = UserManager.INSTANCE.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            if (profile != null) {
                avatarUrl = profile.getAvatarUrl();
                avatarImageView.setTargetImageUrl(avatarUrl);
            }
        }
        avatarUrl = null;
        avatarImageView.setTargetImageUrl(avatarUrl);
    }

    public boolean handleBack() {
        if (ParkingManager.INSTANCE.getActiveParking() != null) {
            return false;
        }
        return super.handleBack();
    }

    public final void showBuyConfirmation(ParkingAdvert parkingAdvert) {
        C0700j.m2715b(parkingAdvert, "parkingAdvert");
        Object view = getView();
        if (view == null) {
            C0700j.m2709a();
        }
        C0700j.m2711a(view, "view!!");
        new C0095a(view.getContext()).m294a((int) R.string.parking_buy_confirmation).m295a((int) R.string.yes, (OnClickListener) new C2679h(this, parkingAdvert)).m302b(R.string.no, null).m303b().show();
    }

    public final void updateCurrentMapCenter(LatLng latLng) {
        if (LocationUtilsKt.isValidLocation(latLng)) {
            setCurrentMapCenter(latLng);
        }
    }
}
