package ru.gg.scooby.ui.controller;

import android.location.Location;
import com.mapbox.android.p149a.p150a.C1742c;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.C1985l;
import com.mapbox.mapboxsdk.maps.MapView;
import java.util.List;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.model.ParkingStatus;

/* compiled from: IMapView.kt */
public interface IMapView {

    /* compiled from: IMapView.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateLocation$default(IMapView iMapView, LatLng latLng, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                iMapView.updateLocation(latLng, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLocation");
        }
    }

    void closeTripScreens();

    C1985l getMap();

    MapView getMapView();

    LatLng getMyLocationCenter();

    void hideProgress();

    void onLocationEngineReady(C1742c c1742c);

    void onUserLocationChanged(Location location);

    void requestPermissions(String[] strArr, int i);

    void setMap(C1985l c1985l);

    void setMapView(MapView mapView);

    void setMyLocationCenter(LatLng latLng);

    void showActiveTrip();

    void showBuyerFound();

    void showDispute(int i, ParkingStatus parkingStatus);

    void showParkingPosted();

    void showPaymentScreen();

    void showPermissionDeniedSnackbar();

    void showProgress();

    void showSellPlace();

    void showSnackbarMessage(int i);

    void showTripCanceled(int i, ParkingStatus parkingStatus);

    void showTripSuccess(int i, double d);

    void showWaitingConfirmFromMe();

    void showWaitingConfirmFromOtherSide();

    void showWaitingPayBuyer();

    void showWaitingPaySeller();

    void updateAvatar();

    void updateLayersVisibility();

    void updateLocation(LatLng latLng, boolean z);

    void updateParkingMarkerLocation(double d, double d2);

    void updateParkings(List<ParkingAdvert> list);

    void updateUserMarkerLocation(double d, double d2);
}
