package ru.gg.scooby.model;

import com.google.gson.p141a.C1687c;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;

/* compiled from: ParkingAdvert.kt */
public final class ParkingAdvert {
    public static final Companion Companion = new Companion();
    public static final int TYPE_BUY = 0;
    public static final int TYPE_SELL = 1;
    private final Car car;
    private final Car carOpposite;
    @C1687c(a = "adv")
    private final Parking parking;
    private final Profile profile;
    private final int type;

    /* compiled from: ParkingAdvert.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public ParkingAdvert(Profile profile, Car car, Car car2, Parking parking, int i) {
        C0700j.m2715b(car, "car");
        C0700j.m2715b(parking, "parking");
        this.profile = profile;
        this.car = car;
        this.carOpposite = car2;
        this.parking = parking;
        this.type = i;
    }

    public final Profile getProfile() {
        return this.profile;
    }

    public final Car getCar() {
        return this.car;
    }

    public final Car getCarOpposite() {
        return this.carOpposite;
    }

    public final Parking getParking() {
        return this.parking;
    }

    public /* synthetic */ ParkingAdvert(Profile profile, Car car, Car car2, Parking parking, int i, int i2, C0697g c0697g) {
        this(profile, car, car2, parking, (i2 & 16) != 0 ? -1 : i);
    }

    public final int getType() {
        return this.type;
    }

    public ParkingAdvert(ParkingAdvert parkingAdvert, int i) {
        C0700j.m2715b(parkingAdvert, "advert");
        this(parkingAdvert.profile, parkingAdvert.car, parkingAdvert.carOpposite, parkingAdvert.parking, i);
    }

    public final ParkingStatus toParkingStatus() {
        Long id = this.parking.getId();
        if (id == null) {
            C0700j.m2709a();
        }
        return new ParkingStatus(id.longValue(), this.parking.getStatus(), DealCompleteStatus.UNKNOWN, DealCompleteStatus.UNKNOWN);
    }
}
