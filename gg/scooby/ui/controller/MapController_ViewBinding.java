package ru.gg.scooby.ui.controller;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.p054a.C0729a;
import butterknife.p054a.C0730b;
import com.mapbox.mapboxsdk.maps.MapView;
import ru.gg.scooby.ui.custom.AvatarImageView;
import ru.skooby.R;

public final class MapController_ViewBinding implements Unbinder {
    private MapController target;
    private View view7f090097;
    private View view7f09009c;
    private View view7f0900a0;

    public MapController_ViewBinding(final MapController mapController, View view) {
        this.target = mapController;
        mapController.imageAvatar = (AvatarImageView) C0730b.m2751a(view, R.id.image_avatar, "field 'imageAvatar'", AvatarImageView.class);
        mapController._mapView = (MapView) C0730b.m2751a(view, R.id.mapView, "field '_mapView'", MapView.class);
        mapController.bottomContainer = (RecyclerView) C0730b.m2751a(view, R.id.bottom_container, "field 'bottomContainer'", RecyclerView.class);
        mapController.childRouterContainer = (FrameLayout) C0730b.m2751a(view, R.id.map_child_router, "field 'childRouterContainer'", FrameLayout.class);
        mapController.mapContainer = (FrameLayout) C0730b.m2751a(view, R.id.map_container, "field 'mapContainer'", FrameLayout.class);
        View a = C0730b.m2750a(view, R.id.btn_my_location, "method 'onMyLocationClick'");
        this.view7f090097 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ MapController_ViewBinding f12753c;

            /* renamed from: a */
            public void mo1911a(View view) {
                mapController.onMyLocationClick();
            }
        });
        a = C0730b.m2750a(view, R.id.btn_search, "method 'onSearchClick'");
        this.view7f0900a0 = a;
        a.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ MapController_ViewBinding f12755c;

            /* renamed from: a */
            public void mo1911a(View view) {
                mapController.onSearchClick();
            }
        });
        view = C0730b.m2750a(view, R.id.btn_profile, "method 'onProfileClick'");
        this.view7f09009c = view;
        view.setOnClickListener(new C0729a(this) {
            /* renamed from: c */
            final /* synthetic */ MapController_ViewBinding f12757c;

            /* renamed from: a */
            public void mo1911a(View view) {
                mapController.onProfileClick();
            }
        });
    }

    public void unbind() {
        MapController mapController = this.target;
        if (mapController != null) {
            this.target = null;
            mapController.imageAvatar = null;
            mapController._mapView = null;
            mapController.bottomContainer = null;
            mapController.childRouterContainer = null;
            mapController.mapContainer = null;
            this.view7f090097.setOnClickListener(null);
            this.view7f090097 = null;
            this.view7f0900a0.setOnClickListener(null);
            this.view7f0900a0 = null;
            this.view7f09009c.setOnClickListener(null);
            this.view7f09009c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
