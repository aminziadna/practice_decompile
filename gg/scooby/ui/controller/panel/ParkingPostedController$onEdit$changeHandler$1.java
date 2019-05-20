package ru.gg.scooby.ui.controller.panel;

import com.mapbox.mapboxsdk.geometry.LatLng;
import ru.gg.scooby.manager.ParkingManager;
import ru.gg.scooby.model.Parking;
import ru.gg.scooby.model.ParkingAdvert;
import ru.gg.scooby.ui.map.MapCenterProvider;

/* compiled from: ParkingPostedController.kt */
public final class ParkingPostedController$onEdit$changeHandler$1 implements MapCenterProvider {
    ParkingPostedController$onEdit$changeHandler$1() {
    }

    public LatLng getCurrentMapCenter() {
        ParkingAdvert activeParking = ParkingManager.INSTANCE.getActiveParking();
        if (activeParking != null) {
            Parking parking = activeParking.getParking();
            if (parking != null) {
                return new LatLng(parking.getLat(), parking.getLng());
            }
        }
        return null;
    }
}
