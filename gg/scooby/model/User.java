package ru.gg.scooby.model;

import com.google.gson.p141a.C1687c;
import p042b.p047e.p049b.C0697g;
import p042b.p047e.p049b.C0700j;

/* compiled from: User.kt */
public final class User {
    private final ParkingAdvert advForBuy;
    private final ParkingAdvert advForSale;
    @C1687c(a = "car-default")
    private final Car defaultCar;
    private final Profile profile;

    public User(Profile profile, Car car, ParkingAdvert parkingAdvert, ParkingAdvert parkingAdvert2) {
        C0700j.m2715b(profile, "profile");
        C0700j.m2715b(car, "defaultCar");
        this.profile = profile;
        this.defaultCar = car;
        this.advForSale = parkingAdvert;
        this.advForBuy = parkingAdvert2;
    }

    public final Profile getProfile() {
        return this.profile;
    }

    public final Car getDefaultCar() {
        return this.defaultCar;
    }

    public /* synthetic */ User(Profile profile, Car car, ParkingAdvert parkingAdvert, ParkingAdvert parkingAdvert2, int i, C0697g c0697g) {
        if ((i & 4) != null) {
            parkingAdvert = null;
        }
        if ((i & 8) != 0) {
            parkingAdvert2 = null;
        }
        this(profile, car, parkingAdvert, parkingAdvert2);
    }

    public final ParkingAdvert getAdvForSale() {
        return this.advForSale;
    }

    public final ParkingAdvert getAdvForBuy() {
        return this.advForBuy;
    }
}
